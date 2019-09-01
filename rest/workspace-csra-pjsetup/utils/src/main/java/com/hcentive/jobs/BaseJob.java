package com.hcentive.jobs;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.hcentive.jobs.domain.JobConfiguration;
import com.hcentive.jobs.domain.JobInstance;
import com.hcentive.jobs.domain.NotificationStatus;
import com.hcentive.utils.ext.HXUtility;
import com.hcentive.utils.job.service.JobService;
import com.hcentive.utils.orm.dao.GenericDAO;

/**
 * Abstract class that would be extended by all jobs
 * 
 * @author Anshu
 */
public abstract class BaseJob {

	private static Logger logger = Logger.getLogger(BaseJob.class);

	/**
	 * Job configuration stored in the database
	 */
	private String jobName;

	protected JobConfiguration jobConfiguration;
	protected JobInstance jobInstance;
	@Autowired
	protected JobService jobService;

	@SuppressWarnings("rawtypes")
	protected GenericDAO genericDAO;

	@SuppressWarnings("rawtypes")
	public GenericDAO getGenericDAO() {
		return genericDAO;
	}

	@SuppressWarnings("rawtypes")
	public void setGenericDAO(GenericDAO genericDAO) {
		this.genericDAO = genericDAO;
	}

	/**
	 * load job configuration from database, common implementation across all
	 * jobs
	 */
	protected void loadJobConfiguration() throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("jobName", this.jobName);
		try {
			this.jobConfiguration = (JobConfiguration) genericDAO.findObjectByNamedQuery("jobConfiguration.FindByJobName",
					new String[] { "jobName" }, this.jobName);
		} catch (Exception ex) {
			throw ex;
		}
	}

	protected void loadJobInstance() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("jobIdConfig", this.jobConfiguration.getId());
		this.jobInstance = (JobInstance) genericDAO.findObjectByNamedQuery("jobInstance.FindByJobConfigId",
				new String[] { "jobIdConfig" }, this.jobConfiguration.getId());
	}

	public BaseJob(String jobName) {
		this.jobName = jobName;
	}

	/**
	 * loads initital data for this job
	 * 
	 * @return
	 */
	public abstract List<Object> loadData();

	/**
	 * Whether the job needs execution or not
	 * 
	 * @param jobData
	 * @return
	 */
	public abstract Boolean requireExection(Object jobData);

	/**
	 * Executes the job
	 */
	public void execute() throws Exception {
		logger.info("Super.Execute Start()");
		loadJobConfiguration();

		logger.info("<<<<<<<<<<<< jobConfiguration Start >>>>>>>>>>>>>");
		if (jobConfiguration != null) {
			logger.info("Job Id : " + jobConfiguration.getId());
			logger.info("Job Name : " + jobConfiguration.getJobName());
			logger.info("Job Desc : " + jobConfiguration.getJobDescription());
			logger.info("Job Type : " + jobConfiguration.getJobType());
			logger.info("Job Active Status : " + jobConfiguration.getActive());
		}
		logger.info("<<<<<<<<<<<< jobConfiguration End >>>>>>>>>>>>>");

		if (this.jobConfiguration != null && this.jobConfiguration.getActive()) {
			updateJobInstance();
			int count = 1;
			while (true) {
				// debug 
				logger.debug("iteration: " + count + " started");				
				List<Object> loadData = loadData();
				if (HXUtility.isEmpty(loadData)) {
					logger.debug("Batch process Exiting...");				
					break;
				}
				List<Object> requiredLoadData = new ArrayList<Object>();
				for (Object object : loadData) {
					if (requireExection(object)) {
						requiredLoadData.add(object);
					}
				}
				logger.debug("loadData size: " + loadData.size() + " and filtered data size: "+requiredLoadData);				
				processJob(requiredLoadData, loadData);
				logger.debug("iteration: " + count + " end");				
			}
			auditJob();
		}
	}

	// Added originalData list also as an argument.Might be required in future
	public abstract void processJob(List<Object> verifiedData, List<Object> originalData);

	public String getJobName() {
		return jobName;
	}

	public void updateJobInstance() {
		loadJobInstance();
		if (this.jobInstance == null) {
			synchronized (this) {
				loadJobInstance();
				if (this.jobInstance == null) {
					this.jobInstance = new JobInstance();
					this.jobInstance.setCurrentCount(new Integer(1));
					this.jobInstance.setJobIdConfig(jobConfiguration.getId());
					this.jobInstance.setLastExecutionTime(new Date());
					jobService.createjobInstance(this.jobInstance);
				} else {
					this.jobInstance.setCurrentCount(this.jobInstance.getCurrentCount() + 1);
					this.jobInstance.setLastExecutionTime(new Date());
					jobService.updatejobInstance(this.jobInstance);
				}
			}
		} else {
			this.jobInstance.setCurrentCount(this.jobInstance.getCurrentCount() + 1);
			this.jobInstance.setLastExecutionTime(new Date());
			jobService.updatejobInstance(this.jobInstance);
		}
	}

	public void auditJob() {
	}

	public NotificationStatus saveUpdateNotificationStatus(Long jobIdConfig, Long userProfileId, String eventType, Long eventId,
			Date lastExecutionTime) {
		NotificationStatus notificationStatus = getNotificationStatus(jobIdConfig, userProfileId, eventType, eventId);
		if (notificationStatus == null) {
			notificationStatus = new NotificationStatus();
			notificationStatus.setEventID(eventId);
			notificationStatus.setEventType(eventType);
			notificationStatus.setExecutionCount(1);
			notificationStatus.setJobIdConfig(this.jobConfiguration.getId());
			notificationStatus.setUserProfileID(userProfileId);
			this.jobService.createNotificationStatus(notificationStatus);
		} else {
			notificationStatus.setLastExecutionTime(lastExecutionTime);
			notificationStatus.setExecutionCount(notificationStatus.getExecutionCount() + 1);
			this.jobService.updateNotificationStatus(notificationStatus);
		}
		return notificationStatus;
	}

	public NotificationStatus getNotificationStatus(Long jobIdConfig, Long userProfileId, String eventType, Long eventId) {
		return jobService.getNotificationStatus(jobIdConfig, userProfileId, eventType, eventId);
	}
}

package com.hcentive.utils.job.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.hcentive.jobs.domain.JobInstance;
import com.hcentive.jobs.domain.NotificationStatus;
import com.hcentive.utils.orm.dao.GenericDAO;

public class JobServiceImpl implements JobService {

	@Autowired
	@SuppressWarnings("rawtypes")
	private GenericDAO genericDAO;

	@Override
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = false)
	public JobInstance updatejobInstance(JobInstance jobinstance) {
		return (JobInstance) genericDAO.update(jobinstance);
	}

	@Override
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = false)
	public JobInstance createjobInstance(JobInstance jobinstance) {
		return (JobInstance) genericDAO.create(jobinstance);
	}

	@Override
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = false)
	public NotificationStatus updateNotificationStatus(NotificationStatus notificationStatus) {
		return (NotificationStatus) genericDAO.update(notificationStatus);
	}

	@Override
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = false)
	public NotificationStatus createNotificationStatus(NotificationStatus notificationStatus) {
		return (NotificationStatus) genericDAO.create(notificationStatus);
	}

	@Override
	public NotificationStatus getNotificationStatus(Long jobIdConfig, Long userProfileID, String eventType, Long eventID) {
		// TODO Auto-generated method stub
		return (NotificationStatus) genericDAO.findObjectByNamedQuery("notificationStatus.FindByJobConfigIdAndUserProfile",
				new String[] { "jobIdConfig", "userProfileID", "eventType", "eventID" }, jobIdConfig, userProfileID, eventType,
				eventID);
		// BatchConstants.APPEAL_USER_ACTION_REMINDER
	}
}

package com.hcentive.utils.job.service;

import com.hcentive.jobs.domain.JobInstance;
import com.hcentive.jobs.domain.NotificationStatus;

public interface JobService {

	public JobInstance updatejobInstance(JobInstance jobinstance);

	public JobInstance createjobInstance(JobInstance jobinstance);

	public NotificationStatus updateNotificationStatus(NotificationStatus notificationStatus);

	public NotificationStatus createNotificationStatus(NotificationStatus notificationStatus);

	public NotificationStatus getNotificationStatus(Long jobIdConfig, Long userProfileID, String eventType, Long eventID);

}

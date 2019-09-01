package com.hcentive.shop.activity.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.transaction.annotation.Transactional;

import com.hcentive.shop.activity.domain.ActivityMasterEnum;
import com.hcentive.shop.activity.domain.ActivitySourceEnum;
import com.hcentive.shop.activity.domain.ActivityTransaction;
import com.hcentive.shop.activity.domain.ActivityTransactionDetail;
import com.hcentive.utils.exception.ActivityLogException;

/**
 * 
 * @author arajaiah
 *
 */
public interface ActivityService {

	public List<ActivityTransaction> getActivityTransactionsByEmployerId ( Long employerId ) throws Exception;
	
	public List<ActivityTransaction> getActivityTransactionsByEligibilityId ( Long employerEligibilityId ) throws Exception;
	
	public List<ActivityTransaction> getActivityTransactionsByEmployeeId ( Long employeeId ) throws Exception;

	public ActivityTransaction createActivityTransaction( ActivityTransaction activityTransaction ) throws Exception;
	
	public ActivityTransaction createActivityTransaction(ActivityTransaction activityTransaction, List<ActivityTransactionDetail> activityTransactionDetails ) throws Exception;
	
	public void createActivityTransactions ( List<ActivityTransaction> activityTransactions ) throws Exception;

	public ActivityTransaction saveActivityTxn(ActivitySourceEnum srcEnum, ActivityMasterEnum masterEnum,
			String userType, String accountId, Long employerId, Long eligibilityId, Long employeeId, Long enrollmentId, Date ActivityDate ) throws Exception;
			
	public ActivityTransaction saveActivityTxn(ActivitySourceEnum srcEnum,
			ActivityMasterEnum masterEnum, String userType,
			String accountId, Long employerId, Long eligibilityId,
			Long employeeId, Long enrlId,Date ActivityDate,
			List<ActivityTransactionDetail> activityTransactionDetails) throws Exception;
	
	public ActivityTransaction saveActivityComments(String userType, String accountId, Long employerId, Long eligibilityId, Long employeeId,Long brokerId, String comments) throws Exception;
	
	public String getEmployerAccountId( Long employerId ) throws Exception;
	
	public String getEmployeeAccountId( Long employeeId ) throws Exception; 
	
	public Map<Long,String> getEmployerEligibilityWithEffectiveDate ( Long employerId ) throws Exception;
	
	public Map<Long,String> getEmployeeEligibilityWithEffectiveDate ( Long employeeId ) throws Exception;
	
	public String getPickListValue(String picklistName, String name) throws Exception;
	
	public ActivityTransaction getOldActivityForEmployee(Long employeeId, Long employerEligibilityId, Long activityMasterId) throws Exception;
	
	public List<ActivityTransaction> getActivityTransactionsByBrokerId ( Long brokerId ) throws Exception;
	
	@Transactional(readOnly = false)
	public ActivityTransaction saveActivityTxn(ActivitySourceEnum srcEnum, ActivityMasterEnum masterEnum,
			String userType, String accountId, Long employerId, Long eligibilityId, Long employeeId,Long enrollmentId, 
			Date activityDate, List<ActivityTransactionDetail> activityTransactionDetails,Long brokerId, Date planEffectiveDate )throws ActivityLogException;

}

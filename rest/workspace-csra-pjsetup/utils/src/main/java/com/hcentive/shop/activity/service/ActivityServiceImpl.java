package com.hcentive.shop.activity.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.hcentive.shop.activity.domain.ActivityFieldEnum;
import com.hcentive.shop.activity.domain.ActivityMasterEnum;
import com.hcentive.shop.activity.domain.ActivitySourceEnum;
import com.hcentive.shop.activity.domain.ActivityTransaction;
import com.hcentive.shop.activity.domain.ActivityTransactionDetail;
import com.hcentive.utils.exception.ActivityLogException;
import com.hcentive.utils.exception.MessageCode;
import com.hcentive.utils.ext.HXUtility;
import com.hcentive.utils.orm.dao.GenericDAO;
import com.hcentive.utils.picklist.domain.Picklist;

/**
 * 
 * @author arajaiah
 *
 */
@Service
public class ActivityServiceImpl implements ActivityService {
	
	protected static Logger logger = LoggerFactory.getLogger(ActivityServiceImpl.class);
	
	@SuppressWarnings("rawtypes") 
	private GenericDAO genericDAO;
	
	@SuppressWarnings("rawtypes")
	public GenericDAO getGenericDAO() {	return genericDAO;	}

	@SuppressWarnings("rawtypes")
	public void setGenericDAO(GenericDAO genericDAO) {	this.genericDAO = genericDAO;	}

	@Override
	@SuppressWarnings("unchecked")
	public List<ActivityTransaction> getActivityTransactionsByEmployerId ( Long employerId ) throws Exception {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("employerId", employerId);
		List<ActivityTransaction> activityTransactios = genericDAO.findByNamedQuery("activityTransaction.findByEmployerId", paramMap);
		return activityTransactios;
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<ActivityTransaction> getActivityTransactionsByEligibilityId ( Long employerEligibilityId ) throws Exception {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("employerEligibilityId", employerEligibilityId);
		List<ActivityTransaction> activityTransactios = genericDAO.findByNamedQuery("activityTransaction.findByEmployerEligibilityId", paramMap);
		return activityTransactios;
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<ActivityTransaction> getActivityTransactionsByEmployeeId ( Long employeeId ) throws Exception {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("employeeId", employeeId);
		List<ActivityTransaction> activityTransactios = genericDAO.findByNamedQuery("activityTransaction.findAllByEmployeeId", paramMap);
		return activityTransactios;
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<ActivityTransaction> getActivityTransactionsByBrokerId ( Long brokerId ) throws Exception{
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("brokerId", brokerId);
		List<ActivityTransaction> activityTransactions =  genericDAO.findByNamedQuery("activityTransaction.findByBrokerId", paramMap);
		return activityTransactions;
	}
	
	@Override
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = false)
	public ActivityTransaction createActivityTransaction(ActivityTransaction activityTransaction ) {
		if( activityTransaction.getId() != null ){
			activityTransaction = (ActivityTransaction)genericDAO.update( activityTransaction );
		}else{
			activityTransaction = (ActivityTransaction)genericDAO.create( activityTransaction );
		}
		return activityTransaction;
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	/*@Transactional(readOnly = false)*/
	public ActivityTransaction createActivityTransaction(ActivityTransaction activityTransaction, List<ActivityTransactionDetail> activityTransactionDetails ) {
//		createActivityTransaction(activityTransaction);//Update
		if (!HXUtility.isEmpty(activityTransactionDetails)){
			for( ActivityTransactionDetail txnDtl : activityTransactionDetails){
				txnDtl.setActivityTransaction(activityTransaction);
				txnDtl.setActivityTransactionId(activityTransaction.getId());
				txnDtl.setVisibilityStatus(true);
				activityTransaction.getActivityTransactionDetails().add(txnDtl);
			}
		}
		createActivityTransaction(activityTransaction);//Update
		return activityTransaction;
	}
	
	@Override
	@Transactional(readOnly = false)
	public void createActivityTransactions ( List<ActivityTransaction> activityTransactions ) throws Exception {
		if( !HXUtility.isEmpty( activityTransactions )){
			for (ActivityTransaction activityTransaction : activityTransactions) {
				createActivityTransaction(activityTransaction);
			}
		}	
	}
	@Override
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public ActivityTransaction saveActivityTxn(ActivitySourceEnum srcEnum, ActivityMasterEnum masterEnum,
			String userType, String accountId, Long employerId, Long eligibilityId, Long employeeId, Long enrollmentId, Date activityDate ) throws Exception
    {
		 try {
	        	//Prepares & inserts Activity Transaction
	        	ActivityTransaction activityTransaction = new ActivityTransaction();
	        	activityTransaction.setActivitySource(srcEnum);
	        	activityTransaction.setActivityMasterId(masterEnum.getActivityMasterId());
				activityTransaction.setUserType(userType);
				activityTransaction.setUserAccountId(accountId);
				activityTransaction.setEmployerId(employerId);
				activityTransaction.setEmployerEligibilityId(eligibilityId);
				activityTransaction.setEmployeeId(employeeId);
				activityTransaction.setEnrollmentId(enrollmentId);
				activityTransaction.setVisibilityStatus(true);
				if(null != activityDate) {
				   activityTransaction.setActivityDate(activityDate);
				} else {
					activityTransaction.setActivityDate(new Date());
				}
				activityTransaction = createActivityTransaction(activityTransaction);
				return activityTransaction;
			} catch (Exception e) {
				logger.error("EXCEPTION ", e);
				throw e;
			}
    }
	
	@Override
	@Transactional(readOnly = false)
	public ActivityTransaction saveActivityTxn(ActivitySourceEnum srcEnum, ActivityMasterEnum masterEnum,
			String userType, String accountId, Long employerId, Long eligibilityId, Long employeeId,Long enrollmentId, 
			Date activityDate, List<ActivityTransactionDetail> activityTransactionDetails )
	throws Exception
    {
        try {
        	//Prepares & inserts Activity Transaction
        	ActivityTransaction activityTransaction = saveActivityTxn(srcEnum, masterEnum, userType, accountId, employerId, eligibilityId, employeeId, enrollmentId,activityDate);
			//Inserts Activity Transaction Detail
			if(!HXUtility.isEmpty(activityTransactionDetails)){
				activityTransaction = createActivityTransaction(activityTransaction, activityTransactionDetails);
			}
			return activityTransaction;
		} catch (Exception e) {
			logger.error("EXCEPTION ", e);
			throw e;
		}
    }
	
	/** CR 1231 **/
	@Override
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public ActivityTransaction saveActivityTxn(ActivitySourceEnum srcEnum, ActivityMasterEnum masterEnum,
			String userType, String accountId, Long employerId, Long eligibilityId, Long employeeId, Long enrollmentId, 
			Date activityDate, List<ActivityTransactionDetail> activityTransactionDetails, Long brokerId, Date planEffectiveDate )
	throws ActivityLogException
    {
        	//Prepares & inserts Activity Transaction
        	ActivityTransaction activityTransaction = new ActivityTransaction();
        	activityTransaction.setActivitySource(srcEnum);
        	activityTransaction.setActivityMasterId(masterEnum.getActivityMasterId());
			activityTransaction.setUserType(userType);
			activityTransaction.setUserAccountId(accountId);
			activityTransaction.setEmployerId(employerId);
			activityTransaction.setEmployerEligibilityId(eligibilityId);
			activityTransaction.setEmployeeId(employeeId);
			activityTransaction.setEnrollmentId(enrollmentId);
			activityTransaction.setVisibilityStatus(true);
			activityTransaction.setBrokerId(brokerId);
			activityTransaction.setPlanEffectiveDate(planEffectiveDate);
			
			if(null != activityDate) {
			   activityTransaction.setActivityDate(activityDate);
			} else {
				activityTransaction.setActivityDate(new Date());
			}
			
			activityTransaction = createActivityTransaction(activityTransaction);
			createActivityTransaction( activityTransaction, activityTransactionDetails );
			
			return activityTransaction;
    }

	@Override
	@Transactional(readOnly = false)
	public ActivityTransaction saveActivityComments(String userType, String accountId, Long employerId, Long eligibilityId, Long employeeId,Long brokerId, String comments) throws Exception
    {
        try {
        	//Prepares & inserts Activity Transaction for comments
        	ActivityTransaction activityTransaction = new ActivityTransaction();
        	activityTransaction.setActivitySource(ActivitySourceEnum.APPLICATION);
        	activityTransaction.setActivityMasterId(ActivityMasterEnum.COMMENTS.getActivityMasterId());
			activityTransaction.setUserType(userType);
			activityTransaction.setUserAccountId(accountId);
			activityTransaction.setEmployerId(employerId);
			activityTransaction.setEmployerEligibilityId(eligibilityId);
			activityTransaction.setEmployeeId(employeeId);
			activityTransaction.setBrokerId(brokerId);
			activityTransaction.setVisibilityStatus(true);
			activityTransaction.setActivityDate(new Date());
			activityTransaction = createActivityTransaction(activityTransaction);
			
			ActivityTransactionDetail txnDtl = new ActivityTransactionDetail();
			txnDtl.setFieldName(ActivityFieldEnum.COMMENTS.name());
			txnDtl.setNewValue(StringUtils.trimToEmpty(comments));
			List<ActivityTransactionDetail> txnDtls = Arrays.asList(txnDtl);
			//Inserts Activity Transaction Detail
			if(!HXUtility.isEmpty(txnDtls)){
				activityTransaction = createActivityTransaction(activityTransaction, txnDtls);
			}
			return activityTransaction;
		} catch (Exception e) {
			logger.error("EXCEPTION ", e);
			throw e;
		}
    }
	
	@SuppressWarnings("unchecked")
	@Override
	public String getEmployerAccountId(Long employerId) throws Exception {
		String accountId = null;
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("employerId", employerId);
		accountId = (String)genericDAO.findObjectByNamedQuery("employer.findAccountByEmployerId", paramMap);
		return accountId;
	}

	@SuppressWarnings("unchecked")
	@Override
	public String getEmployeeAccountId(Long employeeId) throws Exception {
		String accountId = null;
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("employeeId", employeeId);
		Object actId = genericDAO.findObjectByNamedQuery("employee.findAccountByEmployeeId", paramMap);
		accountId=actId==null?null:""+actId;
		return accountId;
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public Map<Long,String> getEmployerEligibilityWithEffectiveDate ( Long employerId ) throws Exception {
		Map<Long,String> eligibilityWithEffectiveDateMap = new HashMap<Long, String>();
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("employerId", employerId);
		Object results = genericDAO.findByNamedQuery("activityTransaction.findEffectiveDatesForEmployer", paramMap);
		ArrayList<Object[]> resultsArray = (ArrayList<Object[]>) results;
		for (Object[] resultColumns: resultsArray) {
			eligibilityWithEffectiveDateMap.put( new Long((Integer) resultColumns[0]), (String) resultColumns[1] );
		}
		return eligibilityWithEffectiveDateMap;
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public Map<Long,String> getEmployeeEligibilityWithEffectiveDate ( Long employeeId ) throws Exception {
		Map<Long,String> eligibilityWithEffectiveDateMap = new HashMap<Long, String>();
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("employeeId", employeeId);
		Object results = genericDAO.findByNamedQuery("activityTransaction.findEffectiveDatesForEmployee", paramMap);
		ArrayList<Object[]> resultsArray = (ArrayList<Object[]>) results;
		for (Object[] resultColumns: resultsArray) {
			eligibilityWithEffectiveDateMap.put( new Long((Integer) resultColumns[0]), (String) resultColumns[1]);
		}
		return eligibilityWithEffectiveDateMap;
	}
	
	
	@SuppressWarnings("unchecked")
	public String getPickListValue(String picklistName, String name) throws Exception{
		String pickListValue = null;
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("picklistName", picklistName );
		paramMap.put("name", name);
		paramMap.put("locale", "en");
		List<Picklist> picklists = genericDAO.findByNamedQuery("picklist.getPicklistsByPicklistNameAndNameAndLocale", paramMap);
		if(!HXUtility.isEmpty(picklists)){
			pickListValue = picklists.get(0).getValue();
		}else{
			pickListValue = name;
		}
		return pickListValue;
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public ActivityTransaction getOldActivityForEmployee(Long employeeId, Long employerEligibilityId, Long activityMasterId) throws Exception {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("employeeId", employeeId);
		paramMap.put("activityMasterId", activityMasterId);
		List<ActivityTransaction> results = new ArrayList<ActivityTransaction>();
		try {
			results = genericDAO.findByNamedQuery("activityTransaction.findOldActivityForEmployee", paramMap);
		} catch (Exception e) {
			logger.error("EXCEPTION ", e);
			throw e;
		}
		return HXUtility.isEmpty(results) ? null : results.get(0);
	}
	
	//CR 1231
	@Deprecated
	@Transactional(readOnly = false)
	public ActivityTransaction saveActivityTxn(ActivitySourceEnum srcEnum, ActivityMasterEnum masterEnum,
			String userType, String accountId, Long employerId, Long eligibilityId, Long employeeId,Long enrollmentId, 
			Date activityDate, Long brokerId,Date planEffectiveDate )throws Exception{
	
		 try {
	        	//Prepares & inserts Activity Transaction
	        	ActivityTransaction activityTransaction = new ActivityTransaction();
	        	activityTransaction.setActivitySource(srcEnum);
	        	activityTransaction.setActivityMasterId(masterEnum.getActivityMasterId());
				activityTransaction.setUserType(userType);
				activityTransaction.setUserAccountId(accountId);
				activityTransaction.setEmployerId(employerId);
				activityTransaction.setEmployerEligibilityId(eligibilityId);
				activityTransaction.setEmployeeId(employeeId);
				activityTransaction.setEnrollmentId(enrollmentId);
				activityTransaction.setVisibilityStatus(true);
				activityTransaction.setBrokerId(brokerId);
				activityTransaction.setPlanEffectiveDate(planEffectiveDate);
				
				if(null != activityDate) {
				   activityTransaction.setActivityDate(activityDate);
				} else {
					activityTransaction.setActivityDate(new Date());
				}
				
				//activityTransaction = createActivityTransaction(activityTransaction);
				
				return activityTransaction;
			} catch (Exception e) {
				logger.error("EXCEPTION ", e);
				throw e;
			}
    }

}

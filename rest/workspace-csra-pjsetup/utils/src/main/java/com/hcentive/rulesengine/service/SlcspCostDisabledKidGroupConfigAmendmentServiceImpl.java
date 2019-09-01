/**
 * 
 */
package com.hcentive.rulesengine.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcentive.rulesengine.domain.ConfigCategoryEnum;
import com.hcentive.rulesengine.domain.ConfigGroupBean;
import com.hcentive.rulesengine.domain.RuleKey;
import com.hcentive.utils.exception.HCException;
import com.hcentive.utils.ext.HXUtility;

/**
 * @author jkadimi
 *
 */
@Service
public class SlcspCostDisabledKidGroupConfigAmendmentServiceImpl implements SlcspCostDisabledKidGroupConfigAmendmentService {

	@Autowired
	RuleConfigService ruleConfigService = null;

	@Override
	public boolean isSlcspEffective(Date effectiveDate) throws HCException {
		ConfigGroupBean cgBean = ruleConfigService.getRuleConfigBean(effectiveDate, ConfigCategoryEnum.INDIVIDUAL);
		if( cgBean!=null ){
			Date slcspEffDate = cgBean.getDateValueFor( RuleKey.SLCSP_EFFECTIVE_START_DATE );
			if( slcspEffDate!=null && !effectiveDate.before( slcspEffDate ) ){
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean isDisabledKidAllowedInGroupConfig(Date effectiveDate) throws HCException {
		ConfigGroupBean cgBean = ruleConfigService.getRuleConfigBean(effectiveDate, ConfigCategoryEnum.INDIVIDUAL);
		if( cgBean!=null ){
			Date slcspEffDate = cgBean.getDateValueFor( RuleKey.ALLOW_DISABLED_KID_IN_GROUP_EFFECTIVE_START_DATE );

			if( HXUtility.isDate2GreaterThanOrEqualToDate1(slcspEffDate, effectiveDate) ){
				return true;
			}
		}
		return false;
	}
	
}
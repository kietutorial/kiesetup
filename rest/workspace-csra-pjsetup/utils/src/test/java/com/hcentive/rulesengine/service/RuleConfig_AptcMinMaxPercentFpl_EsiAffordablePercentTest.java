/**
 * 
 */
package com.hcentive.rulesengine.service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.joda.time.DateTime;
import org.joda.time.DateTimeFieldType;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.hcentive.rulesengine.domain.ConfigCategoryEnum;
import com.hcentive.rulesengine.domain.ConfigGroupBean;
import com.hcentive.rulesengine.domain.RuleKey;
import com.hcentive.utils.exception.HCException;

/**
 * @author jkadimi
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:META-INF/spring/rule-config-context.xml" })
public class RuleConfig_AptcMinMaxPercentFpl_EsiAffordablePercentTest {

	private static Map<Integer, Double> esiAffordablePercentAptcEdiIncomPercentMapping = new HashMap<Integer, Double>();
	private static Map<Integer, Map<RuleKey, Double>> aptcMinMaxPercentFplValuesByYear = new HashMap<Integer, Map<RuleKey, Double>>();
	private static Map<Integer, Map<RuleKey, Integer>> defaultFplValuesByYear = new HashMap<Integer, Map<RuleKey, Integer>>();
	
	static{
		
		esiAffordablePercentAptcEdiIncomPercentMapping.put( 2000, 9.5d );
		esiAffordablePercentAptcEdiIncomPercentMapping.put( 2001, 9.5d );
		esiAffordablePercentAptcEdiIncomPercentMapping.put( 2002, 9.5d );
		esiAffordablePercentAptcEdiIncomPercentMapping.put( 2003, 9.5d );
		esiAffordablePercentAptcEdiIncomPercentMapping.put( 2004, 9.5d );
		esiAffordablePercentAptcEdiIncomPercentMapping.put( 2005, 9.5d );
		esiAffordablePercentAptcEdiIncomPercentMapping.put( 2006, 9.5d );
		esiAffordablePercentAptcEdiIncomPercentMapping.put( 2007, 9.5d );
		esiAffordablePercentAptcEdiIncomPercentMapping.put( 2008, 9.5d );
		esiAffordablePercentAptcEdiIncomPercentMapping.put( 2009, 9.5d );
		esiAffordablePercentAptcEdiIncomPercentMapping.put( 2010, 9.5d );
		esiAffordablePercentAptcEdiIncomPercentMapping.put( 2011, 9.5d );
		esiAffordablePercentAptcEdiIncomPercentMapping.put( 2012, 9.5d );
		esiAffordablePercentAptcEdiIncomPercentMapping.put( 2013, 9.5d );
		esiAffordablePercentAptcEdiIncomPercentMapping.put( 2014, 9.5d );
		esiAffordablePercentAptcEdiIncomPercentMapping.put( 2015, 9.56d );
		esiAffordablePercentAptcEdiIncomPercentMapping.put( 2016, 9.66d );
		
		
		Map<RuleKey, Double> previousYearValues = new HashMap<RuleKey, Double>();
		previousYearValues.put( RuleKey.APTC_FPL_LT_133_MIN, 2.01d );
		previousYearValues.put( RuleKey.APTC_FPL_LT_133_MAX, 2.01d );
		previousYearValues.put( RuleKey.APTC_FPL_133_150_MIN, 3.02d );
		previousYearValues.put( RuleKey.APTC_FPL_133_150_MAX, 4.02d );
		previousYearValues.put( RuleKey.APTC_FPL_150_200_MIN, 4.02d );
		previousYearValues.put( RuleKey.APTC_FPL_150_200_MAX, 6.34d );
		previousYearValues.put( RuleKey.APTC_FPL_200_250_MIN, 6.34d );
		previousYearValues.put( RuleKey.APTC_FPL_200_250_MAX, 8.10d );
		previousYearValues.put( RuleKey.APTC_FPL_250_300_MIN, 8.10d );
		previousYearValues.put( RuleKey.APTC_FPL_250_300_MAX, 9.56d );
		previousYearValues.put( RuleKey.APTC_FPL_300_400_MIN, 9.56d );
		previousYearValues.put( RuleKey.APTC_FPL_300_400_MAX, 9.56d );
		aptcMinMaxPercentFplValuesByYear.put( 2014, previousYearValues );
		
		Map<RuleKey, Double> currentYearValues = new HashMap<RuleKey, Double>();
		currentYearValues.put( RuleKey.APTC_FPL_LT_133_MIN, 2.01d );
		currentYearValues.put( RuleKey.APTC_FPL_LT_133_MAX, 2.01d );
		currentYearValues.put( RuleKey.APTC_FPL_133_150_MIN, 3.02d );
		currentYearValues.put( RuleKey.APTC_FPL_133_150_MAX, 4.02d );
		currentYearValues.put( RuleKey.APTC_FPL_150_200_MIN, 4.02d );
		currentYearValues.put( RuleKey.APTC_FPL_150_200_MAX, 6.34d );
		currentYearValues.put( RuleKey.APTC_FPL_200_250_MIN, 6.34d );
		currentYearValues.put( RuleKey.APTC_FPL_200_250_MAX, 8.10d );
		currentYearValues.put( RuleKey.APTC_FPL_250_300_MIN, 8.10d );
		currentYearValues.put( RuleKey.APTC_FPL_250_300_MAX, 9.56d );
		currentYearValues.put( RuleKey.APTC_FPL_300_400_MIN, 9.56d );
		currentYearValues.put( RuleKey.APTC_FPL_300_400_MAX, 9.56d );
		aptcMinMaxPercentFplValuesByYear.put( 2015, currentYearValues );
		
		Map<RuleKey, Double> nextYearValues = new HashMap<RuleKey, Double>();
		nextYearValues.put( RuleKey.APTC_FPL_LT_133_MIN, 2.03d );
		nextYearValues.put( RuleKey.APTC_FPL_LT_133_MAX, 2.03d );
		nextYearValues.put( RuleKey.APTC_FPL_133_150_MIN, 3.05d );
		nextYearValues.put( RuleKey.APTC_FPL_133_150_MAX, 4.07d );
		nextYearValues.put( RuleKey.APTC_FPL_150_200_MIN, 4.07d );
		nextYearValues.put( RuleKey.APTC_FPL_150_200_MAX, 6.41d );
		nextYearValues.put( RuleKey.APTC_FPL_200_250_MIN, 6.41d );
		nextYearValues.put( RuleKey.APTC_FPL_200_250_MAX, 8.18d );
		nextYearValues.put( RuleKey.APTC_FPL_250_300_MIN, 8.18d );
		nextYearValues.put( RuleKey.APTC_FPL_250_300_MAX, 9.66d );
		nextYearValues.put( RuleKey.APTC_FPL_300_400_MIN, 9.66d );
		nextYearValues.put( RuleKey.APTC_FPL_300_400_MAX, 9.66d );
		aptcMinMaxPercentFplValuesByYear.put( 2016, nextYearValues );
		
		
		Map<RuleKey, Integer> previousYearDefaultFplValues = new HashMap<RuleKey, Integer>();
		previousYearDefaultFplValues.put( RuleKey.FPL_100_HH_1, 11490 );
		previousYearDefaultFplValues.put( RuleKey.FPL_100_HH_2, 15510 );
		previousYearDefaultFplValues.put( RuleKey.FPL_100_HH_3, 19530 );
		previousYearDefaultFplValues.put( RuleKey.FPL_100_HH_4, 23550 );
		previousYearDefaultFplValues.put( RuleKey.FPL_100_HH_5, 27570 );
		previousYearDefaultFplValues.put( RuleKey.FPL_100_HH_6, 31590 );
		previousYearDefaultFplValues.put( RuleKey.FPL_100_HH_7, 35610 );
		previousYearDefaultFplValues.put( RuleKey.FPL_100_HH_8, 39630 );
		previousYearDefaultFplValues.put( RuleKey.FPL_100_HH_ADDNL, 4020 );
		defaultFplValuesByYear.put( 2014, previousYearDefaultFplValues );
		
		Map<RuleKey, Integer> currentYearDefaultFplValues = new HashMap<RuleKey, Integer>();
		currentYearDefaultFplValues.put( RuleKey.FPL_100_HH_1, 11670 );
		currentYearDefaultFplValues.put( RuleKey.FPL_100_HH_2, 15730 );
		currentYearDefaultFplValues.put( RuleKey.FPL_100_HH_3, 19790 );
		currentYearDefaultFplValues.put( RuleKey.FPL_100_HH_4, 23850 );
		currentYearDefaultFplValues.put( RuleKey.FPL_100_HH_5, 27910 );
		currentYearDefaultFplValues.put( RuleKey.FPL_100_HH_6, 31970 );
		currentYearDefaultFplValues.put( RuleKey.FPL_100_HH_7, 36030 );
		currentYearDefaultFplValues.put( RuleKey.FPL_100_HH_8, 40090 );
		currentYearDefaultFplValues.put( RuleKey.FPL_100_HH_ADDNL, 4060 );
		defaultFplValuesByYear.put( 2015, currentYearDefaultFplValues );
		
		Map<RuleKey, Integer> renewalYearDefaultFplValues = new HashMap<RuleKey, Integer>();
		renewalYearDefaultFplValues.put( RuleKey.FPL_100_HH_1, 11770 );
		renewalYearDefaultFplValues.put( RuleKey.FPL_100_HH_2, 15930 );
		renewalYearDefaultFplValues.put( RuleKey.FPL_100_HH_3, 20090 );
		renewalYearDefaultFplValues.put( RuleKey.FPL_100_HH_4, 24250 );
		renewalYearDefaultFplValues.put( RuleKey.FPL_100_HH_5, 28410 );
		renewalYearDefaultFplValues.put( RuleKey.FPL_100_HH_6, 32570 );
		renewalYearDefaultFplValues.put( RuleKey.FPL_100_HH_7, 36730 );
		renewalYearDefaultFplValues.put( RuleKey.FPL_100_HH_8, 40890 );
		renewalYearDefaultFplValues.put( RuleKey.FPL_100_HH_ADDNL, 4160 );
		defaultFplValuesByYear.put( 2016, renewalYearDefaultFplValues );
	}
	
	@Autowired
	private RuleConfigService ruleConfigService = null;
	
	@Test
	public void testDefaultFplValues() throws HCException{
		DateTime tmpDateTime = new DateTime();
		Date currentYear = tmpDateTime.toDate();
		Date previousYear = tmpDateTime.minusYears( 1 ).toDate();
		Date nextYear = tmpDateTime.plusYears( 1 ).toDate();
		
		Date[] runDates = { previousYear, currentYear, nextYear };
		
		RuleKey[] ruleKeys = { 	RuleKey.FPL_100_HH_1, RuleKey.FPL_100_HH_2, RuleKey.FPL_100_HH_3, RuleKey.FPL_100_HH_4, 
								RuleKey.FPL_100_HH_5, RuleKey.FPL_100_HH_6, RuleKey.FPL_100_HH_7, RuleKey.FPL_100_HH_8, 
								RuleKey.FPL_100_HH_ADDNL};
		
		for( Date runDate : runDates ){
			ConfigGroupBean cgBean = ruleConfigService.getRuleConfigBean(runDate, ConfigCategoryEnum.DEFAULT_FPL );
			Assert.assertNotNull( cgBean );
			
			Integer year = new DateTime( runDate.getTime() ).get( DateTimeFieldType.year() );
			Map<RuleKey, Integer> yearlyValues = defaultFplValuesByYear.get( year );
			for( RuleKey rKey : ruleKeys ){
				Assert.assertEquals( yearlyValues.get(rKey), cgBean.getIntegerValueFor(rKey) );
			}
		}
	}
	
	@Test
	public void testAptcMinMaxPercentFplValues() throws HCException{
		DateTime tmpDateTime = new DateTime();
		Date currentYear = tmpDateTime.toDate();
		Date previousYear = tmpDateTime.minusYears( 1 ).toDate();
		Date nextYear = tmpDateTime.plusYears( 1 ).toDate();
		
		Date[] runDates = { previousYear, currentYear, nextYear };
		
		RuleKey[] ruleKeys = { 	RuleKey.APTC_FPL_LT_133_MIN, RuleKey.APTC_FPL_LT_133_MAX, RuleKey.APTC_FPL_133_150_MIN, RuleKey.APTC_FPL_133_150_MAX, 
								RuleKey.APTC_FPL_150_200_MIN, RuleKey.APTC_FPL_150_200_MAX, RuleKey.APTC_FPL_200_250_MIN, RuleKey.APTC_FPL_200_250_MAX, 
								RuleKey.APTC_FPL_250_300_MIN, RuleKey.APTC_FPL_250_300_MAX,	RuleKey.APTC_FPL_300_400_MIN, RuleKey.APTC_FPL_300_400_MAX};
		
		for( Date runDate : runDates ){
			ConfigGroupBean cgBean = ruleConfigService.getRuleConfigBean(runDate, ConfigCategoryEnum.APTC_MIN_MAX_PERCENT );
			Assert.assertNotNull( cgBean );
			
			Integer year = new DateTime( runDate.getTime() ).get( DateTimeFieldType.year() );
			Map<RuleKey, Double> yearlyValues = aptcMinMaxPercentFplValuesByYear.get( year );
			for( RuleKey rKey : ruleKeys ){
				Assert.assertEquals( yearlyValues.get(rKey), cgBean.getDoubleValueFor(rKey) );
			}
		}
	}
	
	@Test
	public void testEsiAffordablePercentAptcEdiIncomPercentValues() throws HCException {
		
		Assert.assertNull( ruleConfigService.getRuleConfigBean( new DateTime().minusYears(20).toDate(), ConfigCategoryEnum.ESI_AFFORDABLE_PERCENT ) );
		
		RuleKey[] ruleKeys = { RuleKey.APTC_ESI_INCOME_PERCENT };
		
		for( int startYear = 1;startYear<=15;startYear++ ){
			Date runDate = new DateTime().minusYears( startYear ).toDate();
			ConfigGroupBean cgBean = ruleConfigService.getRuleConfigBean(runDate, ConfigCategoryEnum.ESI_AFFORDABLE_PERCENT );
			Assert.assertNotNull( cgBean );
			
			Integer year = new DateTime( runDate.getTime() ).get( DateTimeFieldType.year() );
			for( RuleKey rKey : ruleKeys ){
				Assert.assertEquals( esiAffordablePercentAptcEdiIncomPercentMapping.get( year ), cgBean.getDoubleValueFor(rKey) );
			}
		}
		
		Assert.assertNull( ruleConfigService.getRuleConfigBean( new DateTime().plusYears(1000).toDate(), ConfigCategoryEnum.ESI_AFFORDABLE_PERCENT ) );
	}
}
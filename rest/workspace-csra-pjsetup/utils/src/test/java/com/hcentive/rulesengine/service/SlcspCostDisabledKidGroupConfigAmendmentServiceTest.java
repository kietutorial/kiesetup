/**
 * 
 */
package com.hcentive.rulesengine.service;

import org.joda.time.DateTime;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.hcentive.utils.exception.HCException;

/**
 * @author jkadimi
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:META-INF/spring/rule-config-context.xml" })
public class SlcspCostDisabledKidGroupConfigAmendmentServiceTest {

	@Autowired
	private SlcspCostDisabledKidGroupConfigAmendmentService slcspCostDisabledKidGroupConfigAmendmentService = null;
	
	@Test
	public void testIsSlcspEffective() throws HCException{
		DateTime currentYear = new DateTime().withYear(2016);
		DateTime previousYear = new DateTime( currentYear.toDate().getTime() ).minusYears( 1 );
		DateTime nextYear = new DateTime( currentYear.toDate().getTime() ).plusYears( 1 );
		
		Assert.assertFalse( slcspCostDisabledKidGroupConfigAmendmentService.isSlcspEffective( previousYear.toDate() ) );
		Assert.assertFalse( slcspCostDisabledKidGroupConfigAmendmentService.isSlcspEffective( currentYear.toDate() ) );
		Assert.assertTrue( slcspCostDisabledKidGroupConfigAmendmentService.isSlcspEffective( nextYear.toDate() ) );
	}
	
	@Test
	public void testIsDisabledKidAllowedInGroupConfig() throws HCException{
		
		DateTime currentYear = new DateTime().withYear(2016);
		DateTime previousYear = new DateTime( currentYear.toDate().getTime() ).minusYears( 1 );
		DateTime nextYear = new DateTime( currentYear.toDate().getTime() ).plusYears( 1 );
		
		Assert.assertFalse( slcspCostDisabledKidGroupConfigAmendmentService.isDisabledKidAllowedInGroupConfig( previousYear.toDate() ) );
		Assert.assertFalse( slcspCostDisabledKidGroupConfigAmendmentService.isDisabledKidAllowedInGroupConfig( currentYear.toDate() ) );
		Assert.assertTrue( slcspCostDisabledKidGroupConfigAmendmentService.isDisabledKidAllowedInGroupConfig( nextYear.toDate() ) );
	}
}
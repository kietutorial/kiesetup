/*******************************************************************************
 * --------------------------------------------
 *  Copyright (c) 2012 hCentive Inc. All Right Reserved.
 * --------------------------------------------
 ******************************************************************************/
package com.hcentive.utils.ext;

import java.util.List;

import javax.sql.DataSource;

import org.dbunit.DataSourceDatabaseTester;
import org.dbunit.IDatabaseTester;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.TransactionStatus;

import com.hcentive.eligibility.individual.domain.EnrollmentPeriod;
import com.hcentive.utils.demographics.DemographicService;
import com.hcentive.utils.enrollment.period.service.EnrollmentPeriodService;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * This class will be used to write and perform of all test cases for
 * validations of residence addresses data capture for household.
 * 
 * @author bkumar
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:META-INF/spring/util-dbunit-beans.xml" })
public class HXDBUnitUtilTest {

	@Autowired
	private DataSource dataSource;

	private IDatabaseTester databaseTester;

	@Autowired
	private JpaTransactionManager txManager;

	TransactionStatus txStatus;

	@Autowired
	EnrollmentPeriodService enrollmentPeriodService;
	
	/**
	 * function will allow HXDEligibilityValidator to use only HouseholdDetail
	 * as target object in validate function.
	 */
	@Test
	public void supports() {
	}

	/**
	 * Initiate the transaction.
	 */
	@Before
	public void setup() throws Exception{		
		databaseTester = new DataSourceDatabaseTester(dataSource);
		IDataSet expectedDataSet = new FlatXmlDataSetBuilder().build(HXDBUnitUtilTest.class.getClassLoader()
				.getResourceAsStream("MasterDataUtilTest.xml"));
		databaseTester.setDataSet(expectedDataSet);
		databaseTester.onSetup();
		
		txStatus = txManager.getTransaction(new org.springframework.transaction.support.DefaultTransactionDefinition());
	}

	/**
	 * Rollback the transaction.
	 */
	@After
	public void teardown() throws Exception{
		
		databaseTester.onTearDown();
		
		txManager.rollback(txStatus);
	}

	/**
	 * Required test for Is Residential Address same for All.
	 */
	@Test
	public void testDBUnitSetup() {
		
		List<EnrollmentPeriod> enrlList = enrollmentPeriodService.getCurrentAndNextYearErollmentPeriodFor("INDIVIDUAL");
		
		assertNotNull(enrlList);
		//assertEquals();
	}

	/**
	 * main method is used to do adhoc testing of the data population logic.
	 * 
	 * @param String
	 *            [] args
	 */
	public static void main(String[] args) {
		// buildTestData();
	}

	private String resolveType(String str) {
		
			if (new Double(str).toString().equals(str)) {
				return "double";
			}
				
			if (new Integer(str).toString().equals(str)) {
				return "int";
			}
		
		return "varchar";
	}
}

package com.hcentive.utils.hxid.service;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.sql.DataSource;

import org.dbunit.DataSourceDatabaseTester;
import org.dbunit.IDatabaseTester;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.TransactionStatus;

import com.hcentive.utils.ext.HXDBUnitUtilTest;
import com.hcentive.utils.generator.impl.DummyIdGeneratorService;
import com.hcentive.utils.hxid.service.HIXIDResponse.CONFIDENCE_LEVEL;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"classpath:META-INF/spring/util-dbunit-beans.xml",
		"classpath*:META-INF/spring/encryption-test.xml" })
public class HXIDServiceImplTest {

	@Autowired
	private DataSource dataSource;

	private IDatabaseTester databaseTester;

	@Autowired
	private JpaTransactionManager txManager;

	@Autowired
	HXIDServiceImpl hxidServiceImpl;

	TransactionStatus txStatus;

	@Before
	public void setup() {
		try {
			databaseTester = new DataSourceDatabaseTester(dataSource);
			IDataSet expectedDataSet = new FlatXmlDataSetBuilder()
					.build(HXDBUnitUtilTest.class.getClassLoader()
							.getResourceAsStream("MasterDataUtilTest.xml"));
			databaseTester.setDataSet(expectedDataSet);
			databaseTester.onSetup();
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		}
		txStatus = txManager
				.getTransaction(new org.springframework.transaction.support.DefaultTransactionDefinition());
	}

	/**
	 * Rollback the transaction.
	 */
	@After
	public void teardown() {
		try {
			databaseTester.onTearDown();
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		}
		txManager.rollback(txStatus);
	}

	/**
	 * 
	 * Required test for Is Residential Address same for All.
	 * 
	 * @throws ParseException
	 */
	@Test
	public void testCL106() throws ParseException {

		// Date dob = new Date(2001, 01, 01);

		SimpleDateFormat format = new SimpleDateFormat("yyyy MMM dd");
		String dateString = "2001 JAN 01";
		Date dob = format.parse(dateString);
		Person person = new Person("rajneesh", "test", "bhandari", "M", dob,
				"123456789", null, "JR", PersonSource.EEHOUSEHOLD);
		HIXIDResponse hixidresponse = hxidServiceImpl.findOrCreate(person);
		assertNotNull(hixidresponse.isFound());
		assertNotNull(hixidresponse.getConLevel().compareTo(
				CONFIDENCE_LEVEL.CL_106));
		assertNull(hixidresponse.getPersonCreated());
		assertTrue(hixidresponse.getPersonsFound().size() == 1);
		assertTrue(hixidresponse.getPersonsFound().get(0).getHxid()
				.equals("RSD12321311455"));
		// assertEquals();
	}

	@Test
	@Ignore
	public void testCL104() throws Exception {

		SimpleDateFormat format = new SimpleDateFormat("yyyy MMM dd");
		String dateString = "2001 JAN 02";
		Date dob = format.parse(dateString);
		Person person = new Person("rajneesh", "test123123", "bhandari", "F",
				dob, "123456789", null, "TR", PersonSource.EEHOUSEHOLD);

		HIXIDResponse hixidresponse = hxidServiceImpl.findOrCreate(person);
		assertNotNull(hixidresponse.isFound());
		assertNotNull(hixidresponse.getConLevel().compareTo(
				CONFIDENCE_LEVEL.CL_104));
		assertNull(hixidresponse.getPersonCreated());
		assertTrue(hixidresponse.getPersonsFound().size() == 1);
		assertTrue(hixidresponse.getPersonsFound().get(0).getHxid()
				.equals("RSD12321311455"));

		// assertEquals();
	}

	@Test
	@Ignore
	public void testCL103() {

		Date dob = new Date(2001, 01, 01);
		Person person = new Person("rajneesh", "test", "bhandari", "M", dob,
				"123456789", null, "TR", PersonSource.EEHOUSEHOLD);
		HIXIDResponse hixidresponse = hxidServiceImpl.findOrCreate(person);

		assertNotNull(hixidresponse.isFound());
		assertNotNull(hixidresponse.getConLevel().compareTo(
				CONFIDENCE_LEVEL.CL_103));
		// assertEquals();
	}

	@Test
	@Ignore
	public void testCL102() throws Exception {

		SimpleDateFormat format = new SimpleDateFormat("yyyy MMM dd");
		String dateString = "2001 JAN 01";

		Date dob = format.parse(dateString);

		Person person = new Person("rajneeshsdfs", "test123123",
				"bhandarissdsdfsd", "F", dob, "123456789", null, "TR", PersonSource.EEHOUSEHOLD);

		HIXIDResponse hixidresponse = hxidServiceImpl.findOrCreate(person);

		assertNotNull(hixidresponse.isFound());
		assertNotNull(hixidresponse.getConLevel().compareTo(
				CONFIDENCE_LEVEL.CL_102));
		assertNull(hixidresponse.getPersonCreated());
		assertTrue(hixidresponse.getPersonsFound().size() == 1);
		assertTrue(hixidresponse.getPersonsFound().get(0).getHxid()
				.equals("RSD12321311455"));
		// assertEquals();
	}

	@Test
	public void testCL101() throws Exception {

		SimpleDateFormat format = new SimpleDateFormat("yyyy MMM dd");
		String dateString = "2001 JAN 01";
		Date dob = format.parse(dateString);
		Person person = new Person("rajneeshb", "testggg", "bhandarib", "M",
				dob, null, null, "JRB", PersonSource.EEHOUSEHOLD);
		HIXIDResponse hixidresponse = hxidServiceImpl.find(person);

		assertNotNull(hixidresponse.isFound());
		assertNotNull(hixidresponse.getConLevel().compareTo(
				CONFIDENCE_LEVEL.CL_101));
		assertNull(hixidresponse.getPersonCreated());
		assertTrue(hixidresponse.getPersonsFound().size() == 1);
		assertTrue(hixidresponse.getPersonsFound().get(0).getHxid()
				.equals("RSD12321311455"));
		// assertEquals();
		// assertEquals();
	}

	@Test
	public void testNotFoundAndCreate() throws Exception {

		SimpleDateFormat format = new SimpleDateFormat("yyyy MMM dd");
		String dateString = "2001 JAN 01";
		Date dob = format.parse(dateString);
		Person person = new Person("rajneeshbg", "testggg", "bhandaribhh", "F",
				dob, null, null, "JRB", PersonSource.EEHOUSEHOLD);
		hxidServiceImpl.setIdGeneratorService(new DummyIdGeneratorService());
		HIXIDResponse hixidresponse = hxidServiceImpl.findOrCreate(person);

		assertNotNull(hixidresponse.isFound() == false);
		assertNotNull(hixidresponse.getConLevel() == null);
		assertNotNull(hixidresponse.getPersonCreated());
		assertTrue(hixidresponse.getPersonsFound().size() == 0);
		assertTrue(hixidresponse.getPersonCreated().getHxid() != null);
		System.out.println(hixidresponse.getPersonCreated().getHxid());
		// assertEquals();
		// assertEquals();
	}
}

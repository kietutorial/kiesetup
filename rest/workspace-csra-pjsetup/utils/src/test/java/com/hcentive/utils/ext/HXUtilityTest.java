package com.hcentive.utils.ext;

import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.Date;

import junit.framework.TestCase;

import org.junit.Test;

 
 
public class HXUtilityTest {

	
	@Test
	public  void isNumericOrDecimal( )
	{
		
		TestCase.assertTrue(HXUtility.isNumericOrDecimal("00"));
		TestCase.assertTrue(HXUtility.isNumericOrDecimal(".00"));
		TestCase.assertTrue(HXUtility.isNumericOrDecimal("0000.0000000000"));
		TestCase.assertFalse(HXUtility.isNumericOrDecimal("0."));
		TestCase.assertFalse(HXUtility.isNumericOrDecimal("12."));
		TestCase.assertFalse(HXUtility.isNumericOrDecimal("0.d"));
		TestCase.assertFalse(HXUtility.isNumericOrDecimal("."));
		TestCase.assertTrue(HXUtility.isNumericOrDecimal(".234234234234"));
		TestCase.assertFalse(HXUtility.isNumericOrDecimal("-.234234234234"));
		
		
		
		TestCase.assertFalse(HXUtility.isNumericOrDecimal("-00"));
		TestCase.assertFalse(HXUtility.isNumericOrDecimal("-.00"));
		TestCase.assertFalse(HXUtility.isNumericOrDecimal("-0000.0000000000"));
		TestCase.assertFalse(HXUtility.isNumericOrDecimal("-0."));
		TestCase.assertFalse(HXUtility.isNumericOrDecimal("-12."));
		TestCase.assertFalse(HXUtility.isNumericOrDecimal("-0.d"));
		TestCase.assertFalse(HXUtility.isNumericOrDecimal("-."));
		TestCase.assertFalse(HXUtility.isNumericOrDecimal("-.234234234234"));
		TestCase.assertFalse(HXUtility.isNumericOrDecimal("-.234234234234"));
	
	
		TestCase.assertTrue(HXUtility.isNumericOrDecimal("-00",true));
		TestCase.assertTrue(HXUtility.isNumericOrDecimal("-.00",true));
		TestCase.assertTrue(HXUtility.isNumericOrDecimal("-0000.0000000000",true));
		TestCase.assertTrue(HXUtility.isNumericOrDecimal("-.234234234234",true));
		
		
	}
	
	@Test
	public  void testDateDifference() {
		Calendar c = Calendar.getInstance();
		c.set(Calendar.YEAR, 2013);
		c.set(Calendar.MONTH, 6);
		c.set(Calendar.DAY_OF_MONTH, 1);
		
		Calendar check1 = Calendar.getInstance();
		check1.set(Calendar.YEAR, 2013);
		check1.set(Calendar.MONTH, 9);
		check1.set(Calendar.DAY_OF_MONTH, 1);
		
		Calendar check2 = Calendar.getInstance();
		check2.set(Calendar.YEAR, 2013);
		check2.set(Calendar.MONTH, 3);
		check2.set(Calendar.DAY_OF_MONTH, 1);
		
		Calendar testResult1 = Calendar.getInstance();
		testResult1.setTime(HXUtility.computeDateDifferenceInMonths(c.getTime(), 3));
		
		Calendar testResult2 = Calendar.getInstance();
		testResult2.setTime(HXUtility.computeDateDifferenceInMonths(c.getTime(), -3));
		
		assertEquals(check1.get(Calendar.YEAR), testResult1.get(Calendar.YEAR));
		assertEquals(check1.get(Calendar.MONTH), testResult1.get(Calendar.MONTH));
		assertEquals(check1.get(Calendar.DAY_OF_MONTH), testResult1.get(Calendar.DAY_OF_MONTH));
		
		assertEquals(check2.get(Calendar.YEAR), testResult2.get(Calendar.YEAR));
		assertEquals(check2.get(Calendar.MONTH), testResult2.get(Calendar.MONTH));
		assertEquals(check2.get(Calendar.DAY_OF_MONTH), testResult2.get(Calendar.DAY_OF_MONTH));
		
	}
		
	
}

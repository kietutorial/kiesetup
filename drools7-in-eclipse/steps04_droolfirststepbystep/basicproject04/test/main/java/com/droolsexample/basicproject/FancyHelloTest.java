package com.droolsexample.basicproject;

import java.time.LocalDate;
import java.time.Month;
import java.time.ZoneId;
import java.util.Date;

import org.junit.Assert;
import org.junit.jupiter.api.Test;


class FancyHelloTest {

	@Test
	void getAge() {
		LocalDate date = LocalDate.of(1960, Month.JANUARY, 1);
		Date birthdate = Date.from(date.atStartOfDay(ZoneId.systemDefault()).toInstant());

		FancyHello hello = new FancyHello("user1", birthdate);
		
		Assert.assertEquals(hello.getAge(),59);
	}

}

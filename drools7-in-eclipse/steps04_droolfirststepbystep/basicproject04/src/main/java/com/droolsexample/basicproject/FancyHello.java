package com.droolsexample.basicproject;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;

public class FancyHello {
	private String name;
	private Date birthDate;
	private int age;

	public FancyHello() {
	}

	public FancyHello(String name, Date date) {
		this.name = name;
		this.birthDate = date;

		setAge();
	}

	public String getName() {
		return name;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	private void setAge() {
		if (birthDate != null) {
			try {
				// Get the birthDate to LocalDate
				Instant instant = Instant.ofEpochMilli(birthDate.getTime());
				LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
				LocalDate localDate = localDateTime.toLocalDate();

				// Get the passing years
				LocalDate today = LocalDate.now();
				Period p = Period.between(localDate, today);

				age = p.getYears();
			} catch (Exception e) {
			}
		}
	}

//	@Override
	public String toString() {
		return "FancyHello [name=" + name + ", birthDate=" + birthDate + ", age=" + age + "]";
	}

}

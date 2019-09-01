package com.sample;

public class Account {
	private long money;
	private String name;

	// getters and setters omitted for brevity

	@Override
	public String toString() {
		return "Account [money=" + money + ", name=" + name + "]";
	}

	public Account() {

	}

}
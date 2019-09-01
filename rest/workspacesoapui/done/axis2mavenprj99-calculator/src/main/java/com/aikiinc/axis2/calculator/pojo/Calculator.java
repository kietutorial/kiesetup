package com.aikiinc.axis2.calculator.pojo;

/**
 * A calculator POJO that adds number. This is what our app can do.
 * 
 * @author pchauvet Philip Jahmani Chauvet
 */
public class Calculator {
	private int num1 = 1;
	private int num2 = 2;
	private int sum = 0;

	public Calculator() {
	}

	public void setNum1(int d) {
		this.num1 = d;
	}

	public void setNum2(int d) {
		this.num2 = d;
	}

	public int getSum() {
		this.sum = this.num1 + this.num2;
		
		return this.sum;
	}
}

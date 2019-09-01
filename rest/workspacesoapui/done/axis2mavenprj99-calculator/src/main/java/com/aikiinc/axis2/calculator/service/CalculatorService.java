package com.aikiinc.axis2.calculator.service;

import com.aikiinc.axis2.calculator.pojo.Calculator;

/**
 * Create the calculator service to add numbers.
 * 
 * @author pchauvet Philip Jahmani Chauvet
 */
public class CalculatorService {
	Calculator cal;

	public CalculatorService() {
		cal = new Calculator();
	}

	public int getSum(int n1, int n2) {
		cal.setNum1(n1);
		cal.setNum2(n2);
		
		return cal.getSum();
	}
}
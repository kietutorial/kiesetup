package com.ruks.serivces;

public class Calculator {

	private static Calculator cal;
	private int X = 1;
	private int Y = 2;
	private int Result;

	private Calculator() {

	}

	public static Calculator getCal() {
		if (cal == null) {
			cal = new Calculator();
		}
		return cal;
	}

	public void setX(int x) {
		this.X = x;
		// System.out.println("set x: "+CalculatorService.X+" = "+x);
	}

	public void setY(int y) {
		this.Y = y;
		// System.out.println("set y: "+CalculatorService.Y+" = "+y);
	}

	public int getSum() {
		this.Result = this.X + this.Y;
		// System.out.println("GET result: "+this.Result);
		return this.Result;
	}
}

package com.aa.selfservice.cs.scratchpad;

/*
 * This implementation of Calc has mistakes in it.
 */
public class BadCalc implements Calc {

	@Override
	public double add(double augend, double addend) {
		return augend + addend + 1;
	}

	@Override
	public double subtract(double minuend, double subtrahend) {
		return subtrahend - minuend;
	}

	@Override
	public double multiply(double multiplicand, double multiplier) {
		double result = 0;
		for (int i = 0; i < multiplier; i++)
		{
			result += multiplicand;
		}
		
		return result;
	}

	@Override
	public double divide(double dividend, double divisor) {
		return dividend / divisor;
	}

}

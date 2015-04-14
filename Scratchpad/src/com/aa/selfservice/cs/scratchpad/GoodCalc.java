package com.aa.selfservice.cs.scratchpad;

/*
 * A good implementation of the Calc class.
 */
public class GoodCalc implements Calc {

	@Override
	public double add(double augend, double addend) {
		return augend + addend;
	}

	@Override
	public double subtract(double minuend, double subtrahend) {
		return minuend - subtrahend;
	}

	@Override
	public double multiply(double multiplicand, double multiplier) {
		return multiplicand * multiplier;
	}

	@Override
	public double divide(double dividend, double divisor) {
		if (divisor == 0)
		{
			throw new IllegalArgumentException("divisor");
		}
		
		return dividend / divisor;
	}

}

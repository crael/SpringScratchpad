package com.aa.selfservice.cs.scratchpad;

/*
 * A simple interface for a calculator.
 */
public interface Calc {
	double add(double augend, double addend);
	
	double subtract(double minuend, double subtrahend);
	
	double multiply(double multiplicand, double multiplier);
	
	double divide(double dividend, double divisor);
}

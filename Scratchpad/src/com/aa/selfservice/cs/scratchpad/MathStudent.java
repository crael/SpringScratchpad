package com.aa.selfservice.cs.scratchpad;

import java.util.ArrayList;

/*
 * An simple math student class that depends on the Calc interface to find all the factors of a specified
 * integer and returns those factors as an array.
 */
public class MathStudent {
	private Calc calc;
	
	/*
	 * This is an example of constructor injection.
	 */
	public MathStudent(Calc calc) {
		this.calc = calc;
	}
	
	public ArrayList<Integer> factor(int n) {
		int a = 2;
		int b = n - 1;
		int index = 0;
		ArrayList<Integer> results = new ArrayList<Integer>();
		while (a <= b) {
			double t = calc.multiply(a, b);			
			if (t == n) {
				if (a != b)
				{
					results.add(index, b);
				}
				
				results.add(index, a);				
				a++;
				b--;
				index++;
			}
			else if (t > n) {
				b--;
			}
			else {
				a++;
				b--;
			}
		}
		
		return results;
	}
}

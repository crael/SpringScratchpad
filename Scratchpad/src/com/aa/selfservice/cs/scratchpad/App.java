package com.aa.selfservice.cs.scratchpad;

import java.util.ArrayList;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

	/*
	 * Demonstrates the use of Spring Framework to retrieve registered classes from the Spring container.
	 */
	public static void main(String[] args) {
		ApplicationContext appContext = new ClassPathXmlApplicationContext(
				new String[] { "spring.xml" });
		
		// Get an implementation of the Calc interface
		Calc calculator = (Calc) appContext.getBean("calc");
		
		System.out.println("Calculator demo:");
		
		System.out.format("\t     Add:\t%f + %f = %f%n", 5f, 10f, calculator.add(5,  10));
		System.out.format("\tSubtract:\t%f + %f = %f%n", 5f, 10f, calculator.subtract(5, 10));
		System.out.format("\tMultiply:\t%f + %f = %f%n", 5f, 10f, calculator.multiply(5, 10));
		System.out.format("\t  Divide:\t%f + %f = %f%n", 5f, 10f, calculator.divide(5, 10));
		
		// Get an instance of the Math Student class with all dependencies resolved
		MathStudent student = (MathStudent) appContext.getBean("student");
		
		System.out.println("Student demo:");
		
		System.out.print("\t Factors of 12: ");
		ArrayList<Integer> factors = student.factor(12);
		for (Integer i : factors) {
			System.out.format("%d ", i);
		}
		System.out.println();
		
		System.out.print("\t Factors of 13: ");
		factors = student.factor(13);
		for (Integer i : factors) {
			System.out.format("%d ", i);
		}
		System.out.println();
		
		System.out.print("\t Factors of 24: ");
		factors = student.factor(24);
		for (Integer i : factors) {
			System.out.format("%d ", i);
		}
		System.out.println();		
	}
}

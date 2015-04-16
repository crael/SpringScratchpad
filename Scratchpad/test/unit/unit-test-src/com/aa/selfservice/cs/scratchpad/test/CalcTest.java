package com.aa.selfservice.cs.scratchpad.test;

import static org.junit.Assert.*;

import org.easymock.*;
import org.junit.*;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.aa.selfservice.cs.scratchpad.Calc;

/*
 * Test an implementation of the calc interface that is registered in the spring.xml file.
 * If the "good" calc implementation is registered, then all unit tests will pass.
 * If the "bad" calc implementation is registered, then the unit tests should fail.
 */
@RunWith(EasyMockRunner.class)
public class CalcTest {

	private static ApplicationContext appContext;
	private Calc subject;
	
	/*
	 * Configure the Spring app context using the spring.xml.
	 */
	@BeforeClass
	public static void setupClass()
	{
		appContext = new ClassPathXmlApplicationContext(
				new String[] { "spring.xml" });
	}
	
	/*
	 * Before each test, get an instance of the Calc interface from the app context.
	 */
	@Before
	public void setupTest()
	{
		this.subject = (Calc) appContext.getBean("calc");
	}
	
	@Test
	public void testAdd() {
		// arrange
		double augend = 2;
		double addend = 2;
		double expectedSum = augend + addend;
		
		// act
		double actualSum = subject.add(augend, addend);
		
		// assert
		assertEquals(expectedSum, actualSum, 0);
	}

	@Test
	public void testSubtract() {
		// arrange		
		double minuend = 10;
		double subtrahend = 5;
		double expectedDifference = minuend - subtrahend;
		
		// act
		double actualDifference = subject.subtract(minuend, subtrahend);
		
		// assert
		assertEquals(expectedDifference, actualDifference, 0);
	}

	@Test
	public void testMultiplyWhole() {
		// arrange		
		double multiplicand = 10;
		double multiplier = 5;
		double expectedProduct = multiplicand * multiplier;
		
		// act
		double actualProduct = subject.multiply(multiplicand, multiplier);
		
		// assert
		assertEquals(expectedProduct, actualProduct, 0);
	}
	
	@Test
	public void testMultiplyFractional() {
		// arrange		
		double multiplicand = 10.5;
		double multiplier = 5.5;
		double expectedProduct = multiplicand * multiplier;
		
		// act
		double actualProduct = subject.multiply(multiplicand, multiplier);
		
		// assert
		assertEquals(expectedProduct, actualProduct, 0);
	}

	@Test
	public void testDivide() {
		// arrange		
		double dividend = 10;
		double divisor = 5;
		double expectedQuotient = dividend / divisor;
		
		// act
		double actualQuotient = subject.divide(dividend, divisor);
		
		// assert
		assertEquals(expectedQuotient, actualQuotient, 0);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testDivideByZero() {
		// arrange		
		double dividend = 10;
		double divisor = 0;
		
		// act
		subject.divide(dividend, divisor);
	}

}

package com.aa.selfservice.cs.scratchpad.test;

import static org.easymock.EasyMock.*;
import static org.junit.Assert.*;

import java.util.ArrayList;

import org.easymock.EasyMockRunner;
import org.easymock.EasyMockSupport;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.aa.selfservice.cs.scratchpad.Calc;
import com.aa.selfservice.cs.scratchpad.MathStudent;

/*
 * Test the Math Student class using Easy Mock.
 */
@RunWith(EasyMockRunner.class)
public class MathStudentTest extends EasyMockSupport {
	private Calc calc;	
	private MathStudent student;
		
	/*
	 * Create a mock of the Calc interface that the Math Student class depends upon.
	 * This ensures that our Math Student class is being tested in isolation.
	 */
	@Before
	public void setupTest()
	{
		this.calc = createMock(Calc.class);
		this.student = new MathStudent(this.calc);
	}
	
	@Test
	public void FactorTwoTest()
	{
		// arrange
		int n = 2;
		ArrayList<Integer> results;
		
		// act
		results = this.student.factor(n);
		
		// assert
		assertNotNull(results);
		assertEquals(0, results.size());
	}
	
	@Test
	public void FactorThreeTest()
	{
		// arrange
		int n = 3;
		ArrayList<Integer> results;
		expect(this.calc.multiply(2, 2)).andReturn(4.0);
		replay(this.calc);
		
		// act
		results = this.student.factor(n);
		
		// assert
		assertNotNull(results);
		assertEquals(0, results.size());
		verify(this.calc);
	}
	
	@Test
	public void FactorFourTest()
	{
		// arrange
		int n = 4;
		ArrayList<Integer> results;
		expect(this.calc.multiply(2, 3)).andReturn(6.0);
		expect(this.calc.multiply(2, 2)).andReturn(4.0);
		replay(this.calc);		
		
		// act
		results = this.student.factor(n);
		
		// assert
		assertNotNull(results);
		assertEquals(1, results.size());
		assertEquals(2, (int)results.get(0));
	}		
}

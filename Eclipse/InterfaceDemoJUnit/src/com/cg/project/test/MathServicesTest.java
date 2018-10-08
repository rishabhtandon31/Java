package com.cg.project.test;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import com.cg.project.exceptions.InvalidNumberRangeException;
import com.cg.project.matservices.MathServices;
import com.cg.project.matservices.MathServicesImpl;
public class MathServicesTest {
	private static MathServices mathServices;
	@BeforeClass
	public static void setUPTestEnv() {
		mathServices = new MathServicesImpl();
	}
	@Before
	public void setUpMockDataForTest() {
	}
	
	@Test(expected=InvalidNumberRangeException.class)
	public void testAddNumbesrForFirstNOInvalid() throws InvalidNumberRangeException {
		mathServices.addNums(-100, 200);
	}
	
	@Test(expected=InvalidNumberRangeException.class)
	public void testAddNumbesrForSecondNOInvalid() throws InvalidNumberRangeException {
		mathServices.addNums(100, -200);
	}
	
	@Test()
	public void testAddNumbesrForBothValidNo() throws InvalidNumberRangeException {
		int expectedAns=300;
		int actualAns=	mathServices.addNums(100, 200);
		Assert.assertEquals(expectedAns, actualAns);
	}
	
	
	@After
	public void tearDownMockDataForTest() {
		System.out.println("tearDownMockDataForTest()");
	}
	
	
	@AfterClass
	public static void tearDownTestEnv() {
		mathServices=null;
	}
}
package com.wf.training.mavenserv.test;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.wf.training.mavenserv.business.BusinessResource;

public class BusinessResourceTest {

	BusinessResource resource;
	
	@BeforeClass  // Once before any of the test cases execute
	public void commonSetUpOnce() {
		// this.resource = new BusinessResource();
	}
	
	
	@Before  // execute before every test case in this class
	public void commonSetUp() {
		this.resource = new BusinessResource();
	}
	
	@Test
	public void testCalculateSum() {
		// SetUp
		//BusinessResource resource = new BusinessResource();
		
		// Invoke
		int actualResult = resource.calculateSum(new int[] {1, 2, 3});
		
		// Assert ( test )
		int expectedResult = 6;
		assertEquals(expectedResult, actualResult);
	}
	
	@Test
	public void testCalculateSum_Empty() {
		// SetUp
		//BusinessResource resource = new BusinessResource();
		
		// Invoke
		int actualResult = resource.calculateSum(new int[] {});
		
		// Assert ( test )
		int expectedResult = 0;
		assertEquals(expectedResult, actualResult);
	}

	@Test
	public void testCalculateSum_Single() {
		// SetUp
		//BusinessResource resource = new BusinessResource();
		
		// Invoke
		int actualResult = resource.calculateSum(new int[] {5});
		
		// Assert ( test )
		int expectedResult = 5;
		assertEquals(expectedResult, actualResult);
	}
	
	@After  // execute after every test case
	public void cleanCommon() {
		
	}
	
	@AfterClass // executes Once after all the test case
	public void cleanCommonOnce() {
		
	}
}

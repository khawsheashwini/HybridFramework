package com.jbk.listeners;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(ListenersDemo.class)
public class TestDemo {
	
//public Logger log=Logger.getLogger(TestDemo.class);

	@Test
	public void testCase01() {
		ScrrenshotTC.log.info("testcase01");
		Assert.assertEquals(true, true);
		System.out.println("TC Pass");
		//log.info("Print log of test01");
	}

	@Test
	public void testCase02() {
		ScrrenshotTC.log.info("testcase02");
		Assert.assertEquals(true, true);
		System.out.println("TC Fail");
		//log.info("Print log of test02");
	}

	@Test
	public void testCase03() {
		//ScrrenshotTC.logs.info("testcase03");
		throw new SkipException("TC skip");

	}
}

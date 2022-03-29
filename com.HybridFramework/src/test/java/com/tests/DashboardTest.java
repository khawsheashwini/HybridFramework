package com.tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.base.TestBase;
import com.pages.DashboardPage;
import com.pages.LoginPage;

public class DashboardTest extends TestBase{
	WebDriver driver=null;
	LoginPage lp=null;
	DashboardPage dp;
	@BeforeSuite
	public void setUp() {
		driver= initialization();
		dp=loadLoginpage().navigateToDashboard(driver);
	}
	
	@Test
	public void checkPageHeaderText() {
		
		testLogs().info("Dashboard test...........");
		Assert.assertTrue(dp.verifyHeader());
	}
	@Test
	public void checkTitleText() {
		dp.nevigateUserPage1S();
		testLogs().info("Dashboard test...........");
		Assert.assertEquals(driver.getTitle(), "JavaByKiran | Dashboard");
	}
}

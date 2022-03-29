package com.tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.base.TestBase;
import com.pages.DashboardPage;
import com.pages.LoginPage;
import com.pages.UserPage;

public class UserTest extends TestBase{
	WebDriver driver=null;
	//LoginPage lp=null;
//	DashboardPage dp;
	UserPage up;
	@BeforeSuite
	public void setUp() {
		driver= initialization();
		//lp= new LoginPage(driver);
		//up=lp.navigateToDashboard(driver).nevigateUserPage(driver);
		up=loadLoginpage().navigateToDashboard(driver).nevigateUserPage(driver);
	}
	
	@Test
	public void validateCounOfHeaderColumns(){
		testLogs().info("UserTest......");
		Assert.assertTrue(up.validateHeaderCount(driver));
		
	}

}

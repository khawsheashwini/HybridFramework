package com.tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.base.TestBase;
import com.pages.LoginPage;

public class LoginTest extends TestBase{
	WebDriver driver=null;
	LoginPage lp=null;
	
	@BeforeSuite
	public void setUp() {
		driver= initialization();
		 lp= new LoginPage(driver);
		 
	}
	
	@Test
	public void test01() {
		lp.validLogin();
		Assert.assertEquals(driver.getTitle(), "JavaByKiran | Dashboard");
	}
	
	@Test
	public void test02() {
		Assert.assertTrue(false);
	}
}

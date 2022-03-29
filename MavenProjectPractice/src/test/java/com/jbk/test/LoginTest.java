package com.jbk.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.jbk.pages.LoginPage;

public class LoginTest {
	WebDriver driver;
	LoginPage lp;
	@BeforeMethod
	public void openBrowser() {
		System.setProperty("webdriver.chrome.driver","chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("file:///C:/Admin/Offline%20website/Offline%20website/index.html");
		driver.manage().window().maximize();
		lp=new LoginPage(driver);
	}
	@Test
	public void verifyTitleOfHomePage() {
		lp.validLogin();
		System.out.println("LoginTest Cls..1");
		Assert.assertEquals(driver.getTitle(), "JavaByKiran | Dashboard");
	}

	@Test
	public void test02() {
		System.out.println("LoginTest Cls..2");
		Assert.assertTrue(true);
	}

}

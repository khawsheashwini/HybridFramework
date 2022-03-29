package com.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.pages.LoginPage;

public class LoginTest {
	WebDriver driver=null;
	LoginPage lp=null;
	

		@BeforeMethod
		public void setUp() {
			System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
			driver = new ChromeDriver();
			driver.get("file:///C:/Admin/Offline%20website/Offline%20website/index.html");
			driver.manage().window().maximize();
		}
		@Test
		public void test01() {
			LoginPage lp=new LoginPage(driver);
			lp.validLogin();
			Assert.assertEquals(driver.getTitle(), "JavaByKiran | Dashboard");
		}

}

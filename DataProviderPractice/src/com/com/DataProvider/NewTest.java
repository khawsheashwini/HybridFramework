package com.com.DataProvider;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

public class NewTest {
	public WebDriver driver;
	
	@BeforeTest
	public void browserOpen() {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("file:///C:/Admin/Offline%20website/Offline%20website/index.html");
		driver.manage().window().maximize();
	}

	@Test(dataProvider = "loginData")
	public void loginTest(String uname, String pswd,String title) {
		
		driver.findElement(By.id("email")).clear();
		driver.findElement(By.id("email")).sendKeys(uname);
		driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("password")).sendKeys(pswd);
		driver.findElement(By.xpath("//button")).click();
		if(driver.getTitle().equals("JavaByKiran | Dashboard"))
			driver.findElement(By.xpath("//a[text()='LOGOUT']")).click();
		Assert.assertEquals(driver.getTitle(), title);
	}

	@DataProvider
	public Object[][] loginData() {
		return new Object[][] { new Object[] { "kiran@gmail.com", "123456" ,"JavaByKiran | Dashboard"},
				new Object[] { "a@g.com", "123" ,"JavaByKiran | Log in122" },
				new Object[] { "g@g.com", "12345" ,"JavaByKiran | Log in"} };
	}
}

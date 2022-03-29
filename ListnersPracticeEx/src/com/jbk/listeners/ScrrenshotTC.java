package com.jbk.listeners;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(ListenersDemo.class)
public class ScrrenshotTC {
	 public static WebDriver driver;
	 public static Logger log=Logger.getLogger(ScrrenshotTC.class);
	
	@Test
	public void loginTitle() {
		log.info("print loginTitle logs1");
		System.setProperty("webdriver.chrome.driver","chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("file:///C:/Admin/Offline%20website/Offline%20website/index.html");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		log.info("print loginTitle logs2");
		String actTitle=driver.getTitle();
		String expTitle="JavaByKiran | Log in";
		log.info("print loginTitle logs3");
		Assert.assertEquals(actTitle, expTitle);
		
	}
	@Test
	public void login() {
		log.info("print login logs4");
		System.setProperty("webdriver.chrome.driver","chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("file:///C:/Admin/Offline%20website/Offline%20website/index.html");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		log.info("print login logs5");
		String actTitle=driver.getTitle();
		String expTitle="Dashboard";
		log.info("print login logs6");
		Assert.assertEquals(actTitle, expTitle);
		
	}

}

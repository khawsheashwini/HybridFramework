package com.jbk.demo;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.jbk.listeners.ScrrenshotTC;

public class Demo {
	WebDriver driver;
	@Test
	public void login() {
		System.setProperty("webdriver.chrome.driver","chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("file:///C:/Admin/Offline%20website/Offline%20website/index.html");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		screenShots();
		String actTitle=driver.getTitle();
		String expTitle="JavaByKiran | Log in1d";
		Assert.assertEquals(actTitle, expTitle);
		
	}
	public void screenShots() {
		TakesScreenshot ts=(TakesScreenshot)driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
		File destination=new File(System.getProperty("user.dir")+"/ScreenshotFolder/imageNew.jpg");
		try {
			FileUtils.copyFile(source, destination);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("TestCase name is Failed..");
	}
	
}

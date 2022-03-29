package com.jbk.pages;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginEx {
	WebDriver driver;
	@Test
	public void correctCred() {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("file:///C:/Admin/Offline%20website/Offline%20website/index.html");
		driver.manage().window().maximize();
		driver.findElement(By.id("email")).sendKeys("kiran@gmail.com");
		driver.findElement(By.id("password")).sendKeys("123456");
		driver.findElement(By.xpath("//button")).click();
		String actTitle=driver.getTitle();
		String expTitle="JavaByKiran | Dashboard";
		Assert.assertEquals(actTitle, expTitle);
		
	}
	@Test
	public void wrongCred() {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("file:///C:/Admin/Offline%20website/Offline%20website/index.html");
		driver.manage().window().maximize();
		driver.findElement(By.id("email")).sendKeys("k@gmail.com");
		driver.findElement(By.id("password")).sendKeys("12345");
		driver.findElement(By.xpath("//button")).click();
		String actTitle1=driver.getTitle();
		String expTitle="JavaByKiran | Log in";
		Assert.assertEquals(actTitle1, expTitle);
		
	}
	@Test
	public void errorMsgOfEmail() {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("file:///C:/Admin/Offline%20website/Offline%20website/index.html");
		driver.manage().window().maximize();
		driver.findElement(By.id("email")).sendKeys("");
		driver.findElement(By.xpath("//button")).click();
		String actErrorMsg=driver.findElement(By.xpath("//*[@id=\"email_error\"]")).getText();
		System.out.println("print actual error msg...."+actErrorMsg);
		String expErrorMsg="Please enter email.";
		Assert.assertEquals(actErrorMsg, expErrorMsg);
	}
	
	@Test
	public void alertMsg() {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("file:///C:/Admin/Offline%20website/Offline%20website/pages/examples/register.html");
		driver.manage().window().maximize();
		driver.findElement(By.id("name")).sendKeys("mhkh");
		driver.findElement(By.id("mobile")).sendKeys("123456");
		driver.findElement(By.id("email")).sendKeys("kiran@gmail.com");
		driver.findElement(By.id("password")).sendKeys("12345");
		driver.findElement(By.xpath("//button")).click();
		Alert alert=driver.switchTo().alert();
		String actAlertMsg=alert.getText();
		alert.accept();
		String expAlertMsg="User registered successfully.";
		Assert.assertEquals(actAlertMsg, expAlertMsg);
	}

	
	@Test
	public void checkLinks1()
	{
		//int count=0;
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("file:///C:/Admin/Offline%20website/Offline%20website/pages/examples/dashboard.html");
		List<WebElement> list = driver.findElements(By.xpath("//span[text()='Dashboard']//following::span"));
		System.out.println(list.size());
		for(WebElement list1:list)
		{
			 list1.click();
			 
			 System.out.println("click()");
	/*	//	WebDriverWait wait = new WebDriverWait(driver, 5);
	//	if((wait.until(ExpectedConditions.elementToBeClickable(list1))!=null))
		{
			
		//	 String actTitle = driver.getTitle();
			// String exptitle =  UtilityExcel.getCellData("Book1.xlsx","Links", count, 1);
			// count++;
			// Assert.assertEquals(actTitle, exptitle);
			   
		   } */
		}
	}

}

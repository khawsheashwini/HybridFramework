package com.jbk;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class ActionCls {
	Action action;
	Actions act;
	
	@Test
	public void test01() {
		System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://javabykiran.com/playground/");
		
		act = new Actions(driver);		
		List<WebElement> links = driver.findElements(By.partialLinkText("User"));//5 elements//..//a[contains(text(),'User')]
		for( WebElement link :links) {		
			act.moveToElement(link).pause(2000).click().build().perform();
			
		}
		driver.findElement(By.xpath("//a[text()='Drag and Drop']")).click();
		//WebElement on which drag and drop operation needs to be performed
		WebElement fromElement = driver.findElement(By.xpath("//div[text()='Home ']"));

		//WebElement to which the above object is dropped
		WebElement toElement = driver.findElement(By.xpath("//div[text()='Contact Us']"));

		//Creating object of Actions class to build composite actions
		Actions builder = new Actions(driver);
		//act.clickAndHold(fromElement).moveToElement(toElement).release(toElement).build().perform();
		
		//Building a drag and drop action
		Action dragAndDrop = builder.clickAndHold(fromElement)
		.moveToElement(toElement)
		.release(toElement)
		.build();

		//Performing the drag and drop action
		dragAndDrop.perform();
	}
	@Test
	public void test02() {
		System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("file:///C:/Admin/Offline%20website/Offline%20website/index.html");
		driver.manage().window().maximize();
		act=new Actions(driver);
		WebElement logo=driver.findElement(By.xpath("//img"));
		act.moveToElement(logo).contextClick().release().build().perform();
		WebElement email=driver.findElement(By.id("email"));
		WebElement pass=driver.findElement(By.id("password"));
		act.moveToElement(email).click().sendKeys("kiran@gmail.com").build().perform();
		act.moveToElement(pass).click().sendKeys("123456").build().perform();
		act.moveToElement(driver.findElement(By.xpath("//button"))).click().build().perform();
	}
}



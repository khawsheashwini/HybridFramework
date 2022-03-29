package com.jbk.ActionCls;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class ActionsExp {
	WebDriver driver;
	Actions act;
	Action action;

	@Test
	public void actionEx1() {
		System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("file:///C:/Admin/Offline%20website/Offline%20website/index.html");
		driver.manage().window().maximize();
		act = new Actions(driver);
		WebElement logo = driver.findElement(By.xpath("//img"));
		act.contextClick(logo).perform();
		WebElement email = driver.findElement(By.id("email"));
		WebElement pass = driver.findElement(By.id("password"));
		act.moveToElement(email).click().sendKeys("kiran@gmail.com").build().perform();
		act.click(pass).sendKeys("123456").build().perform();
		act.click(driver.findElement(By.xpath("//button"))).perform();

	}

	@Test
	public void actionEx2() {
		System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://javabykiran.com/playground/");
		driver.manage().window().maximize();
		act=new Actions(driver);
		List<WebElement> links=driver.findElements(By.partialLinkText("User"));
		for(WebElement link:links) {
			act.moveToElement(link).click().pause(2000).build().perform();
		}
		
		WebElement dragAndDrop=driver.findElement(By.xpath("//a[text()='Drag and Drop']"));
		dragAndDrop.click();
		
		WebElement homeFrm=driver.findElement(By.xpath("//div[text()='Home ']"));
		WebElement contactUsTo=driver.findElement(By.xpath("//div[text()='Contact Us']"));
		act.clickAndHold(homeFrm).moveToElement(contactUsTo).release(contactUsTo).build().perform();
	}
}

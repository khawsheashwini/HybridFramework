package com.jbk.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver;
	
	@FindBy(id="email")
	private WebElement email;
	@FindBy(id="password")
	private WebElement password;
	@FindBy(xpath="//button")
	private WebElement button;
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	

	public void validLogin() {
		
		//driver.findElement(By.id("email")).sendKeys("kiran@gmail.com");
		email.sendKeys("kiran@gmail.com");
		//driver.findElement(By.id("password")).sendKeys("123456");
		password.sendKeys("123456");
		//driver.findElement(By.xpath("//button")).click();
		button.click();
	}

}

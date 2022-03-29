package com.jbk.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginNewPage {
	WebDriver lpdriver;
	
	@FindBy(id="email")
	private WebElement email;
	@FindBy(id="password")
	private WebElement password;
	@FindBy(xpath="//button")
	private WebElement button;
	
	public LoginNewPage(WebDriver driver) {
		this.lpdriver=driver;
		PageFactory.initElements(driver, this);
	}
	public WebElement getUname() {
		return email;
	}
	public WebElement getPassword() {
		return password;
	}
	public WebElement getLoginButton() {
		return button;
	}
	
	public void loginToApplication() {
		getUname().sendKeys("kiran@gmail.com");
		//email.sendKeys("kiran@gmail.com");
		getPassword().sendKeys("123456");
		getLoginButton().click();
	}

}

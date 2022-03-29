package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver driver=null;
	
	@FindBy(id="email")
	private WebElement uname;
	@FindBy(id="password")
	private WebElement pass;
	@FindBy(xpath="//button")
	private WebElement loginBtn;
	
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	 public void validLogin() { 
	  uname.sendKeys("kiran@gmail.com");
	  //  sendkeys(email,"njgjhkl@gmail.com")
	  pass.sendKeys("123456");
	  loginBtn.click(); 
	  }
	
	
	public DashboardPage navigateToDashboard(WebDriver driver) {
		uname.sendKeys("kiran@gmail.com");
		pass.sendKeys("123456");
		loginBtn.click();
		return new DashboardPage(driver);
	}
	
	
}

package com.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.base.BasePage;



public class DashboardPage extends BasePage{
	WebDriver driver = null;
	LoginPage lp = null;
	DashboardPage dashPage = null;

	@FindBy(xpath = "//span[text()='Users']")
	public WebElement users;
	@FindBy(xpath = "//div//child::h1//small")
	public WebElement dashboardHeader;
	
	public DashboardPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public UserPage nevigateUserPage(WebDriver driver) {
		users.click();
		return new UserPage(driver);
	}
	public void nevigateUserPage1S() {
		users.click();
		
	}
	
	public boolean verifyHeader() {
		pageLogs().info("newLogs");
		pageLogs().info("Dashboard Page");
		String dashboardSubHeader = dashboardHeader.getText();
		try {
			if (dashboardSubHeader.equals("Courses Offered")) {
				pageLogs().info("Heading of Dashboard is match..");
				System.out.println("Heading of Dashboard is match..");
				return true;
			} else {
				pageLogs().info("Heading of Dashboard is not match..");
				System.out.println("Heading of Dashboard is match..");
				return false;
			}
		} catch (Throwable t) {
			return false;
		}
	}
	
	


}

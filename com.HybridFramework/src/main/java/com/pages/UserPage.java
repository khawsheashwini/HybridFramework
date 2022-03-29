package com.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BasePage;

public class UserPage extends BasePage{

	WebDriver driver = null;
	//LoginPage lp = null;
	//UserPage up = null;
	//DashboardPage dp = null;
	
	@FindBy(xpath = "//th")
	public List<WebElement> header;

	public UserPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	
	public boolean validateHeaderCount(WebDriver driver) {
		pageLogs().info("UserPage................");
		ArrayList<String> actualHeaders = new ArrayList<String>();
		pageLogs().info("Finding list of headers................");
		//System.out.println("Finding list of headers");
		List<WebElement> listOfHeader = header;
		for (WebElement wb : listOfHeader) {
			actualHeaders.add(wb.getText());
		}
		System.out.println("Header list finding completed " + actualHeaders.size());
		System.out.println("Total no of headers::" + listOfHeader.size());
		
		if (listOfHeader.size() == 8) {
			System.out.println("Header size is matched" + actualHeaders.size());
			return true;
		} else {
			System.out.println("Header size is not matched" + actualHeaders.size());
			return false;
		}

	}

}

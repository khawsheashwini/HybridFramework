package com.jbk;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class UtilityCls {

	public void enterTextData(String dataToEnter, String locName, String locValue, WebDriver driver) {
		if (locName.equals("id")) {
			driver.findElement(By.id(locValue)).sendKeys(dataToEnter);
		}
		if (locName.equals("xpath")) {
			driver.findElement(By.xpath(locValue)).sendKeys(dataToEnter);
		}

	}
	////////// use of this method//////////////
	// enterTextData("kiran@gmail.com","id","email",driver)

	public void clear(WebElement ele) {
		ele.clear();
	}

	public void click(WebElement ele) {
		ele.click();
	}

	public String getTextData(String locName, String locValue, WebDriver driver) {
		String data = null;
		if (locName.equals("id")) {
			data = driver.findElement(By.id(locValue)).getText();
		}
		if (locName.equals("xpath")) {
			data = driver.findElement(By.xpath(locValue)).getText();
		}
		return data;

	}
///String heading=getTextData("xpath","//p",driver);
	//sos(heading)
}

package com.utils;

import org.openqa.selenium.WebElement;

public class ActionUtility {
	
	public void sendkeys123(WebElement ele,String dataToEnter) {
		ele.sendKeys(dataToEnter);
	}
	
	//@FindBy(id=email)
	//public webElement email;
	
	//sendkeys123(email,"kiran@gmail.com");
	
	//email.sendkeys("assdsdfs");
	
	public void enterFirstName(WebElement ele,String dataToEnter) {
		sendkeys123(ele, dataToEnter);
	}
	 public void clear(WebElement ele) {
		 ele.clear();
	 }
	 
	 public String getTextMsg(WebElement ele) {
		String msg= ele.getText();
		return msg;
	 }

}

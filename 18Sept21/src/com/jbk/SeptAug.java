package com.jbk;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;



public class SeptAug {
WebDriver driver;
public static  Logger log = Logger.getLogger(SeptAug.class);
	@Test
	public void verifyCoursesName() {
		System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("file:///C:/Admin/Offline%20website/Offline%20website/pages/examples/dashboard.html");
		driver.manage().window().maximize();
		log.info("Open browser");
		ArrayList<String> actulList=new ArrayList<>();
		ArrayList<String> expList=new ArrayList<>();
		expList.add("Selenium");
		expList.add("Java / J2EE");
		expList.add("Python");
		expList.add("Php");
		log.info("Courses added");
		List<WebElement> listOfCourses=driver.findElements(By.xpath("//h3"));
		System.out.println(listOfCourses);
		for(WebElement list:listOfCourses) {
			String courseName=list.getText();
			actulList.add(courseName);
		}
		System.out.println(actulList);
		log.info("actual list");
		Assert.assertEquals(actulList, expList);
	}
	@Test
	public void selectCheckBoxRadio() throws Exception {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("file:///C:/Admin/Offline%20website/Offline%20website/pages/examples/add_user.html");
		driver.manage().window().maximize();
		
		Select state=new Select(driver.findElement(By.xpath("//select")));
		state.selectByVisibleText("Maharashtra");
		Thread.sleep(2000);
		state.selectByVisibleText("Delhi");
		Thread.sleep(1000);
		state.selectByValue("Punjab");
		List<WebElement> listOfState=state.getOptions();
		for(WebElement web:listOfState) {
			String nameOfState=web.getText();
			System.out.println(nameOfState);
		}
		WebElement male=driver.findElement(By.id("Male"));
		WebElement female=driver.findElement(By.id("Female"));
		boolean maleValue=male.isDisplayed();
		System.out.println("Is male radio button displayed...."+maleValue);
		boolean maleValue1=male.isEnabled();
		System.out.println("Is male radio button isEnabled...."+maleValue1);
		male.click();
		if(male.isSelected()) {
			System.out.println("male is selected..");
		}else {
			System.out.println("male is not selected..");
		}
		if(female.isSelected()) {
			System.out.println("female is selected..");
		}else {
			System.out.println("female is not selected..");
		}
	}
}

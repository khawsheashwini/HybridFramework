package com.jbk.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class OctOJT15Nov {
	WebDriver driver;
	@Test
	public void dashBoardCourse() {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("file:///C:/Admin/Offline%20website/Offline%20website/pages/examples/dashboard.html");
		driver.manage().window().maximize();
		ArrayList<String> expCourses=new ArrayList<String>();
		expCourses.add("Selenium");
		expCourses.add("Java / J2EE");
		expCourses.add("Python");
		expCourses.add("Php");
		List<WebElement> listOfCourses=driver.findElements(By.xpath("//h3"));//4
		ArrayList<String> actCourses=new ArrayList<>();
		for(WebElement courseName:listOfCourses) {
			actCourses.add(courseName.getText());
		}
		System.out.println("print actual list of courses.."+actCourses);
		Assert.assertEquals(actCourses, expCourses);
	}

}

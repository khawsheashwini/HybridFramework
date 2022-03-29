package com.jbk.Feb;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Feb02 {
	WebDriver driver;
	@Test
	public void windowHandlerUsefullLinks() throws Exception {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("file:///C:/Admin/Offline%20website/Offline%20website/pages/examples/links.html");
		driver.manage().window().maximize();

		String mainWindow = driver.getWindowHandle();
		List<WebElement> listOfGoLink = driver.findElements(By.xpath("//span[text()='Go !']"));
		for (WebElement link : listOfGoLink) {
			link.click();
		}
		Set<String> set = driver.getWindowHandles();
		Iterator<String> itr = set.iterator();
		while (itr.hasNext()) {
			String childWindow = itr.next();
			if (!mainWindow.equals(childWindow)) {
				String titleOfChildWindow = driver.switchTo().window(childWindow).getTitle();
				System.out.println("titleOfChildWindow  " + titleOfChildWindow);
				driver.close();
				
			}
		}
		System.out.println(driver.switchTo().window(mainWindow).getTitle());
		
	}
	@Test
	public void verifyCourses() throws Exception {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("file:///C:/Admin/Offline%20website/Offline%20website/pages/examples/dashboard.html");
		driver.manage().window().maximize();
		ArrayList<String> expectedCourses=new ArrayList<String>();
		ArrayList<String> actCourses=new ArrayList<String>();
		expectedCourses.add("Selenium");
		expectedCourses.add("Java / J2EE");
		expectedCourses.add("Python");
		expectedCourses.add("Php");
		List<WebElement> listOfCourses=driver.findElements(By.xpath("//h3"));
		for(WebElement courseName:listOfCourses) {
			String courseNameEach=courseName.getText();
			//actCourses.add(courseName.getText());
			actCourses.add(courseNameEach);
		}
		System.out.println(actCourses);
		Assert.assertEquals(actCourses, expectedCourses);
	}
}

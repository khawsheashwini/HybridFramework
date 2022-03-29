package com.jbk;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCasesPractice {
	WebDriver driver = null;

	@Test
	public void dashboardCourses() {

		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("file:///C:/Admin/Offline%20website/Offline%20website/pages/examples/dashboard.html");
		driver.manage().window().maximize();

		ArrayList<String> expListOfCourses = new ArrayList<>();
		expListOfCourses.add("Selenium");
		expListOfCourses.add("Java / J2EE");
		expListOfCourses.add("Python");
		expListOfCourses.add("Php");
		System.out.println("print ecpected list of courses::" + expListOfCourses);

		List<WebElement> listOfCourse = driver.findElements(By.xpath("//h3"));
		ArrayList<String> actListOfCourses = new ArrayList<>();
		for (WebElement courseName : listOfCourse) {
			String nameOfCourse = courseName.getText();
			actListOfCourses.add(nameOfCourse);
			System.out.println("print actual list of courses::" + actListOfCourses);
		}
		Assert.assertEquals(actListOfCourses, expListOfCourses);
	}

	@Test
	public void selectTest() throws Exception {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("file:///C:/Admin/Offline%20website/Offline%20website/pages/examples/add_user.html");
		driver.manage().window().maximize();

		Select state = new Select(driver.findElement(By.xpath("//select")));
		state.selectByVisibleText("Maharashtra");
		Thread.sleep(1000);
		state.selectByValue("Delhi");
		Thread.sleep(1000);
		state.selectByIndex(3);

		List<WebElement> listOfCheckbox = state.getOptions();
		for (WebElement itemOfCheckbox : listOfCheckbox) {
			String listOfCheckboxName = itemOfCheckbox.getText();
			System.out.println("print name of list::" + listOfCheckboxName);
		}
		WebElement male = driver.findElement(By.id("Male"));
		WebElement female = driver.findElement(By.id("Female"));
		boolean maleDisplay = male.isDisplayed();
		System.out.println(maleDisplay);
		boolean maleEnable = male.isEnabled();
		System.out.println(maleEnable);
		male.click();
		boolean maleSelected = male.isSelected();
		System.out.println(maleSelected);
		boolean femaleSelected = female.isSelected();
		System.out.println(femaleSelected);
	}

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
	public void preferdWay() {

		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("file:///C:/Admin/Offline%20website/Offline%20website/pages/examples/operators.html");
		driver.manage().window().maximize();

		List<WebElement> personList = driver.findElements(By.xpath("//td[2]"));
		List<WebElement> contactWay = driver.findElements(By.xpath("//td[4]"));
		for (int i = 0; i < contactWay.size(); i++) {
			String person = contactWay.get(i).getText();
			if (person.equals("Whats App Only")) {
				String personName = personList.get(i).getText();
				System.out.println(personName);
			}
		}
	}
}
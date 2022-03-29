package com.jbk.demo;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class WindowHandler {
	WebDriver driver;
	@Test
	public void link() {
		System.setProperty("webdriver.chrome.driver","chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("file:///C:/Admin/Offline%20website/Offline%20website/pages/examples/links.html");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		List<WebElement> listOfGoLink = driver.findElements(By.xpath("//span[text()='Go !']"));//  //a//div[@class='mTxt']
		for (WebElement web : listOfGoLink) {
			System.out.println("Go ! link" + web.getText());
			web.click();
			
		}
		String mainWindow = driver.getWindowHandle();
		Set<String> set = driver.getWindowHandles();
		Iterator<String> itr = set.iterator();
		while (itr.hasNext()) {
			String childWindow = itr.next();
			if (!mainWindow.equals(childWindow)) {
				driver.switchTo().window(childWindow);
				System.out.println(driver.switchTo().window(childWindow).getTitle());
				driver.close();
			}
		}
		driver.switchTo().window(mainWindow);		
	}
}

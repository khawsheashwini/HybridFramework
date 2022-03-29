package com.jbk;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FristTest {
	
	public static void main(String[] args) throws Exception {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("file:///C:/Admin/Offline%20website/Offline%20website/index.html");
		driver.manage().window().maximize();
		String heading=driver.findElement(By.xpath("/html/body/div/div[1]/a/b")).getText();
		System.out.println(heading);
		driver.findElement(By.id("email")).sendKeys("kiran@gmail.com");
		//driver.findElement(By.id("password")).sendKeys("123456");
		driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("123456");
		driver.findElement(By.xpath("//*[@id=\"form\"]/div[3]/div/button")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("/html/body/div/header/nav/div/ul/li/a")).click();
		
	}

}

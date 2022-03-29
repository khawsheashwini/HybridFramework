package com.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.pages.LoginPage;

public class TestBase {
	
	public static WebDriver driver=null;
	FileInputStream fis=null;
	public static  Logger log = Logger.getLogger(TestBase.class);
	
	public String readProperty(String key) {
		log.info("reading a property from property file");
		Properties prop= new Properties();
		try {
			fis = new FileInputStream(System.getProperty("user.dir")+"/src/main/resources/config.properties");
			prop.load(fis);		
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}
		log.info("value found in the property filr for the "+key);
		return prop.getProperty(key);
	}
	public void launchApplication() {
	log.info("launching an application");
		driver.get(readProperty("url"));
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	public WebDriver initialization() {
		log.info("initialising a browser with name"+readProperty("browser"));
		if (readProperty("browser").equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
			driver = new ChromeDriver();
			launchApplication();
		log.info("chorme browser initialised");
			return driver;
		} else {
			System.setProperty("webdriver.gecko.driver", "C:/geckodriver.exe");
			driver = new FirefoxDriver();
			log.info("firefox browser initialised");
			launchApplication();
			return driver;
		}
	}
	
	
////////////////////////////////////////////////////////////////////////////////////////////	
	public LoginPage loadLoginpage(){
		
		LoginPage lp=new LoginPage(driver);
		return lp;
	}
	
	
	public String getScreenshot(String name) {
		
		TakesScreenshot ts = (TakesScreenshot)driver;
		File src =ts.getScreenshotAs(OutputType.FILE);
		File dest = new File(System.getProperty("user.dir")+"/screenshots/"+name+".jpg");
		try {
			FileUtils.copyFile(src, dest);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "screenshot captured";
	}
	//////////////////////////////////////////////////////////////////////////////////////
	
	public Logger testLogs() {
		Logger logger=Logger.getLogger(this.getClass());
		String path=(System.getProperty("user.dir")+"/src/main/resources/log4jTest.properties");
		PropertyConfigurator.configure(path);
		return logger;
		
	}

	
}

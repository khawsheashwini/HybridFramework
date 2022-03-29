package com.jbk;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

public class ExcelColGenderData {
	public WebDriver driver;
	FileInputStream fis;
	Workbook wb;
	Sheet sh;
	String gender;
	String genderName;
	String userName;
	@Test
	public void gendarData() throws Exception {
	System.setProperty("webdriver.chrome.driver","chromedriver.exe");
	driver=new ChromeDriver();
	driver.get("file:///C:/Admin/Offline%20website/Offline%20website/pages/examples/users.html");
	driver.manage().window().maximize();
	
	ArrayList<String> expList=new ArrayList<>();
	ArrayList<String> actList=new ArrayList<>();
	fis=new FileInputStream("genderDataWrite.xls");
	wb=Workbook.getWorkbook(fis);
	sh=wb.getSheet("genderData");
	int rows=sh.getRows();
	int cols=sh.getColumns();
	System.out.println(rows+" "+cols);
	for(int i=1;i<rows;i++) {
		Cell cell=sh.getCell(0, i);
		 gender=cell.getContents();
		if(gender.contains("Male")) {
		expList.add(gender);
		System.out.println("print data of excel"+gender);
		}
		//System.out.println("print male list.."+expList.add(gender));
	}
	
	List<WebElement> genderList=driver.findElements(By.xpath("//td[6]"));
	List<WebElement> unameList=driver.findElements(By.xpath("//td[2]"));
	for(int i=0;i<genderList.size();i++) {
		 genderName=genderList.get(i).getText();
		if(genderName.equals("Male")) {
			userName=unameList.get(i).getText();
			actList.add(genderName);
			System.out.println("person name "+userName+"whose gender is "+genderName);
		}
	}
	//System.out.println("print actual list of gender..."+genderName);
	Assert.assertEquals(actList, expList);
}
	
	
}
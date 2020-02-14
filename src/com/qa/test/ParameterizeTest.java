package com.qa.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.qa.utility.Xls_Reader;

//using parameterization we can fetch multiple date from excel sheet.
public class ParameterizeTest {

	public static WebDriver driver;
	
	public static void main(String[] args) throws Exception {


		//get TestData from excel.
		Xls_Reader reader = new Xls_Reader("D:\\Test WorkSpace\\DateDrivenFrameworkUsingExcelSheet\\src\\com\\qa\\testdata\\YahooUserAccountDetails.xlsx");
		
		int rowCount=reader.getRowCount("RegAccountTestData");
		System.out.println("No of rows >>"+rowCount);
		
		
		//Parameterization.
		//Fetching data from 2nd row.
		for (int rowNum = 2; rowNum <= rowCount; rowNum++) {
		
			System.out.println("=============");
			
			String firstname=reader.getCellData("RegAccountTestData","Firstname", rowNum);
			System.out.println(firstname);
			
			String surname=reader.getCellData("RegAccountTestData","Surname", rowNum);
			System.out.println(surname);
			
			String email=reader.getCellData("RegAccountTestData","Email", rowNum);
			System.out.println(email);
			
			String password=reader.getCellData("RegAccountTestData","Password", rowNum);
			System.out.println(password);
			
			String birthMonth=reader.getCellData("RegAccountTestData","BirthMonth", rowNum);
			System.out.println(birthMonth);
			
			String day=reader.getCellData("RegAccountTestData","Day", rowNum);
			System.out.println(day);
			
			String year=reader.getCellData("RegAccountTestData","Year", rowNum);
			System.out.println(year);
			
			String gender=reader.getCellData("RegAccountTestData","Gender", rowNum);
			System.out.println(gender);
			
			
			//WebDriver code.
			System.setProperty("webdriver.chrome.driver", "D:\\Test WorkSpace\\TestNGConceptAndFeatures\\chromedriver.exe");
			driver= new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			
			driver.get("https://login.yahoo.com/account/create");
			
			driver.findElement(By.xpath("//input[contains(@id,'usernamereg-firstName')]")).clear();
			driver.findElement(By.xpath("//input[contains(@id,'usernamereg-firstName')]")).sendKeys(firstname);
			
			driver.findElement(By.xpath("//input[contains(@id,'usernamereg-lastName')]")).clear();
			driver.findElement(By.xpath("//input[contains(@id,'usernamereg-lastName')]")).sendKeys(surname);
			
			driver.findElement(By.xpath("//input[contains(@id,'usernamereg-yid')]")).clear();
			driver.findElement(By.xpath("//input[contains(@id,'usernamereg-yid')]")).sendKeys(email);
			
			driver.findElement(By.xpath("//input[contains(@id,'usernamereg-password')]")).clear();
			driver.findElement(By.xpath("//input[contains(@id,'usernamereg-password')]")).sendKeys(password);
			
			Select select = new Select(driver.findElement(By.xpath("//select[contains(@id,'usernamereg-month')]")));
			select.selectByVisibleText(birthMonth);
			
			driver.findElement(By.xpath("//input[contains(@id,'usernamereg-day')]")).clear();
			driver.findElement(By.xpath("//input[contains(@id,'usernamereg-day')]")).sendKeys(day);
			
			driver.findElement(By.xpath("//input[contains(@id,'usernamereg-year')]")).clear();
			driver.findElement(By.xpath("//input[contains(@id,'usernamereg-year')]")).sendKeys(year);
			
			driver.findElement(By.xpath("//input[contains(@id,'usernamereg-freeformGender')]")).clear();
			driver.findElement(By.xpath("//input[contains(@id,'usernamereg-freeformGender')]")).sendKeys(gender);
			
		
			
			driver.quit();
			
		}
		

	}

}

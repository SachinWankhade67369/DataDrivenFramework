package com.qa.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.qa.utility.Xls_Reader;

public class DataDrivenTest {
	
	public static WebDriver driver;
	
	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "D:\\Test WorkSpace\\TestNGConceptAndFeatures\\chromedriver.exe");
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.get("https://login.yahoo.com/account/create");
		
		
		//get the data from excel file:
		
		Xls_Reader reader = new Xls_Reader("D:\\Test WorkSpace\\DateDrivenFrameworkUsingExcelSheet\\src\\com\\qa\\testdata\\YahooUserAccountDetails.xlsx");
		
		int a=reader.getRowCount("RegAccountTestData");
		System.out.println(a);
		
		System.out.println(reader.isSheetExist("RegAccountTestData"));
		
		System.out.println("============================================");
		
		//only single row data can be fetch by following way:
		String firstname=reader.getCellData("RegAccountTestData","Firstname", 2);
		System.out.println(firstname);
		
		String surname=reader.getCellData("RegAccountTestData","Surname", 2);
		System.out.println(surname);
		
		String email=reader.getCellData("RegAccountTestData","Email", 2);
		System.out.println(email);
		
		String password=reader.getCellData("RegAccountTestData","Password", 2);
		System.out.println(password);
		
		String birthMonth=reader.getCellData("RegAccountTestData","BirthMonth", 2);
		System.out.println(birthMonth);
		
		String day=reader.getCellData("RegAccountTestData","Day", 2);
		System.out.println(day);
		
		String year=reader.getCellData("RegAccountTestData","Year", 2);
		System.out.println(year);
		
		String gender=reader.getCellData("RegAccountTestData","Gender", 2);
		System.out.println(gender);
		
		getRegisterData(firstname, surname, email, password, birthMonth, day, year, gender);
		
	}
	

	
	public static void getRegisterData(String Firstname,String Lastname,String Email,String Password,String BirthMonth,String Day,String Year,String Gender) {
		
		
		driver.findElement(By.xpath("//input[contains(@id,'usernamereg-firstName')]")).clear();
		driver.findElement(By.xpath("//input[contains(@id,'usernamereg-firstName')]")).sendKeys(Firstname);
		
		driver.findElement(By.xpath("//input[contains(@id,'usernamereg-lastName')]")).clear();
		driver.findElement(By.xpath("//input[contains(@id,'usernamereg-lastName')]")).sendKeys(Lastname);
		
		driver.findElement(By.xpath("//input[contains(@id,'usernamereg-yid')]")).clear();
		driver.findElement(By.xpath("//input[contains(@id,'usernamereg-yid')]")).sendKeys(Email);
		
		driver.findElement(By.xpath("//input[contains(@id,'usernamereg-password')]")).clear();
		driver.findElement(By.xpath("//input[contains(@id,'usernamereg-password')]")).sendKeys(Password);
		
		Select select = new Select(driver.findElement(By.xpath("//select[contains(@id,'usernamereg-month')]")));
		select.selectByVisibleText(BirthMonth);
		
		driver.findElement(By.xpath("//input[contains(@id,'usernamereg-day')]")).clear();
		driver.findElement(By.xpath("//input[contains(@id,'usernamereg-day')]")).sendKeys(Day);
		
		driver.findElement(By.xpath("//input[contains(@id,'usernamereg-year')]")).clear();
		driver.findElement(By.xpath("//input[contains(@id,'usernamereg-year')]")).sendKeys(Year);
		
		driver.findElement(By.xpath("//input[contains(@id,'usernamereg-freeformGender')]")).clear();
		driver.findElement(By.xpath("//input[contains(@id,'usernamereg-freeformGender')]")).sendKeys(Gender);
		
	}
	
	

}

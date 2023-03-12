package com.DearDoctor.Doctor;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.DearDoctor.genericuyility.ExcelUtility;
import com.DearDoctor.genericuyility.FileUtility;
import com.DearDoctor.genericuyility.JavaUtility;
import com.DearDoctor.genericuyility.WebDriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class G_editing_a_doctor_name {
public static void main(String[] args) throws Throwable {
	WebDriver driver=null;
	//create an object to Utility
		WebDriverUtility wlib=new WebDriverUtility();
		FileUtility flib=new FileUtility();
		JavaUtility jlib=new JavaUtility();
		ExcelUtility elib=new ExcelUtility();
		
		//Read all the Necessary common data
		String URL = flib.getPropertyKeyValue("url");
		String BROWSER = flib.getPropertyKeyValue("browser1");
		String USERNAME = flib.getPropertyKeyValue("Doctor_username");
		String PASSWORD = flib.getPropertyKeyValue("Doctor_password");
		
		//get randomnumber
		int intRanNum = jlib.getRanDomNumber();
		
		//read the test data from excel sheet
		
		String Drname = elib.getExcelData("Sheet1", 9, 2);
		
		//step 3: Launch the browser
		
		
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else if(BROWSER.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		else {
	           System.out.println("invalid browser name");
		}
		
		//step 4:login to app
		driver.get(URL);
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//a[@href='hms/doctor/']")).click();
		driver.findElement(By.name("username")).sendKeys(USERNAME);
		driver.findElement(By.name("password")).sendKeys(PASSWORD);
		driver.findElement(By.name("submit")).click();
		driver.findElement(By.xpath("//p[@class='links cl-effect-1']")).click();
		driver.findElement(By.name("docname")).sendKeys(Drname);
		driver.findElement(By.name("submit")).click();
		String actual = driver.switchTo().alert().getText();
		String excepted="Doctor Details updated Successfully";
		wlib.swithToAlertWindowAndAccpect(driver, "Doctor Details updated Successfully");
		 if(excepted.equals(actual)) {
			 System.out.println("Test case is pass");
		 }else {
			 System.out.println("Test case is fail");
		 }
		 driver.findElement(By.xpath("//i[@class='ti-angle-down']")).click();
		 driver.findElement(By.xpath("//a[@href='logout.php']")).click();
	
	
}
}

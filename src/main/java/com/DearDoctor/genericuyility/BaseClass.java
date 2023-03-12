package com.DearDoctor.genericuyility;

import java.sql.SQLException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public WebDriver driver=null;
	public static WebDriver sDriver=null; //for screenshot
	/*Object Creation for Lib */
	public JavaUtility jlib = new JavaUtility();
	public WebDriverUtility wlib = new WebDriverUtility();
	public FileUtility flib = new FileUtility();
	public ExcelUtility elib = new ExcelUtility();
	public DataBaseUtility dlib=new DataBaseUtility();
	@BeforeSuite
	public void configBS() throws SQLException {
		
   // dlib.connectDB();
		System.out.println("========================connect to DB========================");

	}
	//@Parameters("BROWSER")
	@BeforeClass
	public void configBC() throws Throwable {
		System.out.println("=============Launch the Browser=======");
	    String URL = flib.getPropertyKeyValue("url");
		String BROWSER = flib.getPropertyKeyValue("browser1");
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			System.out.println("Chrome Browser launched");
		}
		else if(BROWSER.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			System.out.println("firefox Browser launched");
		}
		else {
	           System.out.println("invalid browser name");
		}
		wlib.waitForElementInDOM(driver);
		 driver.get(URL);
		 driver.manage().window().maximize();
		 sDriver=driver; //for screenshot
	}
	
	
	@AfterClass
	public void configAC() {
		System.out.println("=============Close the Browser=======");
		driver.quit();
	}
	@AfterSuite
	public void configAS() throws SQLException {
		//dlib.closeDB();
		System.out.println("========================close DB========================");
	}

}


package com.DearDoctor.repositorylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.DearDoctor.genericuyility.ExcelUtility;
import com.DearDoctor.genericuyility.FileUtility;
import com.DearDoctor.genericuyility.JavaUtility;
import com.DearDoctor.genericuyility.WebDriverUtility;
import com.DearDoctor.pomrepositorylib.Add_Doctor;
import com.DearDoctor.pomrepositorylib.Admin_Home;
import com.DearDoctor.pomrepositorylib.Admin_Login;
import com.DearDoctor.pomrepositorylib.Delete_Doctor;

import io.github.bonigarcia.wdm.WebDriverManager;

public class verify_Deleted_Doctor_details {
public static void main(String[] args) throws Throwable {
//Create objects
	ExcelUtility elib=new ExcelUtility();
	FileUtility flib=new FileUtility();
	JavaUtility jlib=new JavaUtility();
	WebDriverUtility wlib=new WebDriverUtility();
	WebDriver driver=null;
	
	//read the common data
	 String BROWSER = flib.getPropertyKeyValue("browser1");
	String URL = flib.getPropertyKeyValue("url");
	String USERNAME = flib.getPropertyKeyValue("Admin_username");
	String PASSWORD = flib.getPropertyKeyValue("Admin_password");
	
	//get randomnumber
	int intRanNum = jlib.getRanDomNumber();
	
	//Read test Data
	String specilazation = elib.getExcelData("Sheet1", 1, 2);
	String Drname = elib.getExcelData("Sheet1", 2, 2);
	String address = elib.getExcelData("Sheet1", 3, 2);
	String fees = elib.getExcelData("Sheet1", 4, 2);
	String phoneno = elib.getExcelData("Sheet1", 5, 2);
	String email = elib.getExcelData("Sheet1", 6, 2)+intRanNum;
	String password = elib.getExcelData("Sheet1", 7, 2);
	String cpassword = elib.getExcelData("Sheet1", 8, 2);
	
	//launch the browser
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
	
	//login as Admin
	driver.manage().window().maximize();
	wlib.waitForElementInDOM(driver);
	driver.get(URL);
	Admin_Login lp=new Admin_Login(driver);
	lp.loginToApp(USERNAME, PASSWORD);
	
	//click dropdown
	Admin_Home home=new Admin_Home(driver);
	home.clickon_dropdown();

	//add doctor
	Add_Doctor add=new Add_Doctor(driver);
	add.addingdoctor(specilazation, Drname, address, fees, phoneno, email, password, cpassword);
	
	//remove doctor
	Delete_Doctor delete=new Delete_Doctor(driver);
	delete.remove_doctor();
	
	//logout as admin
	home.logout();
			
	
}
}

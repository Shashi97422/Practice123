package com.DearDoctor.repositorylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.DearDoctor.genericuyility.ExcelUtility;
import com.DearDoctor.genericuyility.FileUtility;
import com.DearDoctor.genericuyility.JavaUtility;
import com.DearDoctor.genericuyility.WebDriverUtility;
import com.DearDoctor.pomrepositorylib.Admin_Home;
import com.DearDoctor.pomrepositorylib.Admin_Login;
import com.DearDoctor.pomrepositorylib.Doctor_Home;
import com.DearDoctor.pomrepositorylib.Doctor_Login;
import com.DearDoctor.pomrepositorylib.Edit_Doctor_Profile;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Editing_Doctor_Name {
public static void main(String[] args) throws Throwable {
	ExcelUtility elib=new ExcelUtility();
	FileUtility flib=new FileUtility();
	JavaUtility jlib=new JavaUtility();
	WebDriverUtility wlib=new WebDriverUtility();
	WebDriver driver=null;
	
	//Read all the Necessary common data
			String URL = flib.getPropertyKeyValue("url");
			String BROWSER = flib.getPropertyKeyValue("browser1");
			String USERNAME = flib.getPropertyKeyValue("Doctor_username");
			String PASSWORD = flib.getPropertyKeyValue("Doctor_password");
			
			
			
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
			
			//login as Doctor
			driver.manage().window().maximize();
			wlib.waitForElementInDOM(driver);
			driver.get(URL);
			Doctor_Login lp=new Doctor_Login(driver);
			lp.loginToDoctor(USERNAME, PASSWORD);
			
			//click on my profile
			Doctor_Home home=new Doctor_Home(driver);
					home.clickon_MyPprofile();
					
		//Edit doctor name
	 Edit_Doctor_Profile edit=new Edit_Doctor_Profile(driver);
	 edit.editName(Drname);	
		edit.doctorNameValidation();
		
		//logout as Doctor
		Admin_Home home1=new Admin_Home(driver);
		home1.logout();
					
					
			
}
}

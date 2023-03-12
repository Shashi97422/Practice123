package com.DearDoctor.repositorylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.DearDoctor.genericuyility.ExcelUtility;
import com.DearDoctor.genericuyility.FileUtility;
import com.DearDoctor.genericuyility.JavaUtility;
import com.DearDoctor.genericuyility.WebDriverUtility;
import com.DearDoctor.pomrepositorylib.Admin_Login;
import com.DearDoctor.pomrepositorylib.AppointmentHistory_page;
import com.DearDoctor.pomrepositorylib.Patient_Home;
import com.DearDoctor.pomrepositorylib.Patient_Login;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Delete_Appointment {
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
		String USERNAME = flib.getPropertyKeyValue("Patient_username");
		String PASSWORD = flib.getPropertyKeyValue("Patient_password");
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
	   //login as Patient
				driver.manage().window().maximize();
				wlib.waitForElementInDOM(driver);
				driver.get(URL);
				Patient_Login lp=new Patient_Login(driver);
				lp.loginToPatient(USERNAME, PASSWORD);
				
	   //Click on view Appointment History
				Patient_Home home=new Patient_Home(driver);
				home.clickappointment();
				
	   //Click on cancel appointment
				AppointmentHistory_page cancel=new AppointmentHistory_page(driver);
						cancel.cancelAppointment();
				
				
						
				
		
}
}

package com.DearDoctor.Admin;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.DearDoctor.genericuyility.ExcelUtility;
import com.DearDoctor.genericuyility.FileUtility;
import com.DearDoctor.genericuyility.JavaUtility;
import com.DearDoctor.genericuyility.WebDriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class G_check_added_doctor_details {
public static void main(String[] args) throws Throwable {
		
	//WebDriver driver = null;
	//create an object to Utility
	WebDriverUtility wlib=new WebDriverUtility();
	FileUtility flib=new FileUtility();
	JavaUtility jlib=new JavaUtility();
	ExcelUtility elib=new ExcelUtility();
	
	//Read all the Necessary common data
	String URL = flib.getPropertyKeyValue("url");
	String BROWSER = flib.getPropertyKeyValue("browser1");
	String USERNAME = flib.getPropertyKeyValue("Admin_username");
	String PASSWORD = flib.getPropertyKeyValue("Admin_password");
	
	//get randomnumber
	int intRanNum = jlib.getRanDomNumber();
	
	//read the test data from excel sheet
	
	String specilazation = elib.getExcelData("Sheet1", 1, 2);
	String Drname = elib.getExcelData("Sheet1", 2, 2);
	String address = elib.getExcelData("Sheet1", 3, 2);
	String fees = elib.getExcelData("Sheet1", 4, 2);
	String phoneno = elib.getExcelData("Sheet1", 5, 2);
	String email = elib.getExcelData("Sheet1", 6, 2)+intRanNum;
	String password = elib.getExcelData("Sheet1", 7, 2);
	String cpassword = elib.getExcelData("Sheet1", 8, 2);
	
	//step 3: Launch the browser
	
	WebDriver driver = null;
	
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
	driver.manage().window().maximize();
	wlib.waitForElementInDOM(driver);
	driver.get(URL);
	driver.findElement(By.xpath("//a[@href='hms/admin']")).click();
	driver.findElement(By.name("username")).sendKeys(USERNAME);
	driver.findElement(By.name("password")).sendKeys(PASSWORD);
	driver.findElement(By.name("submit")).click();
	driver.findElement(By.xpath("//span[.=' Doctors ']")).click();
	driver.findElement(By.xpath("//span[.=' Add Doctor']")).click();
	driver.findElement(By.xpath("//select[@name='Doctorspecialization']")).sendKeys(specilazation);
	driver.findElement(By.xpath("//input[@name='docname']")).sendKeys(Drname);
	driver.findElement(By.name("clinicaddress")).sendKeys(address);
	driver.findElement(By.name("docfees")).sendKeys(fees);
	driver.findElement(By.name("doccontact")).sendKeys(phoneno);
	driver.findElement(By.name("docemail")).sendKeys(email);
	driver.findElement(By.name("npass")).sendKeys(password);
	driver.findElement(By.name("cfpass")).sendKeys(cpassword);
	driver.findElement(By.name("submit")).click();
	//varyfing aler message
	wlib.swithToAlertWindowAndAccpect(driver, "Doctor info added Successfully");
	String excepeted =Drname ;
	 String actual = driver.findElement(By.xpath("//table/tbody/tr[last()]/td[3]")).getText();
    if(actual.equals(excepeted)) {
    	System.out.println("Test case is pass ");
    }else {
    	System.out.println("Test case is fail");
    }
    driver.findElement(By.xpath("//i[@class='ti-angle-down']")).click();
	 driver.findElement(By.xpath("//a[@href='logout.php']")).click(); 

}
}

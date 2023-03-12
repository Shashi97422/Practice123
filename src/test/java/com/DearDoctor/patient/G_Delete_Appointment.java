package com.DearDoctor.patient;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.DearDoctor.genericuyility.ExcelUtility;
import com.DearDoctor.genericuyility.FileUtility;
import com.DearDoctor.genericuyility.JavaUtility;
import com.DearDoctor.genericuyility.WebDriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class G_Delete_Appointment {
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
		
		driver.manage().window().maximize();
		//step 4:login to app
		driver.get(URL);
		driver.findElement(By.xpath("//a[@href='hms/user-login.php']")).click();
		driver.findElement(By.name("username")).sendKeys(USERNAME);
		driver.findElement(By.name("password")).sendKeys(PASSWORD);
		driver.findElement(By.xpath("//button[@name='submit']")).click();
		
		//cancel appointment history
		
		driver.findElement(By.xpath("//p[@class='cl-effect-1']")).click();
		driver.findElement(By.xpath("//tbody/tr[last()]/td[8]")).click();
		wlib.swithToAlertWindowAndAccpect(driver, "Are you sure you want to cancel this appointment ?");
		//Alert a = driver.switchTo().alert();
		//a.accept();
		String excepted = "Your appointment canceled !!";
		 String actual = driver.findElement(By.xpath("//p[.='Your appointment canceled !!								']")).getText();
		if(actual.equals(excepted)) {
			System.out.println("Test case is pass");	
	}else {
		System.out.println("Test case is fail");
	}
		 driver.findElement(By.xpath("//i[@class='ti-angle-down']")).click();
		 driver.findElement(By.xpath("//a[@href='logout.php']")).click();

}
}

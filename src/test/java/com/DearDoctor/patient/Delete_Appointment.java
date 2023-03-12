package com.DearDoctor.patient;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Delete_Appointment {
public static void main(String[] args) throws IOException {
	
	WebDriver driver=null;
	//Read all the Necessary common data
	FileInputStream fis=new FileInputStream(".\\Data\\DearDoctor.properties");
	Properties prop=new Properties();
	prop.load(fis);
	String URL = prop.getProperty("url");
	String BROWSER = prop.getProperty("browser1");
	String USERNAME = prop.getProperty("Patient_username");
	String PASSWORD = prop.getProperty("Patient_password");
	
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
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	driver.get(URL);
	
	//step 4:login to app
	driver.findElement(By.xpath("//a[@href='hms/user-login.php']")).click();
	driver.findElement(By.name("username")).sendKeys(USERNAME);
	driver.findElement(By.name("password")).sendKeys(PASSWORD);
	driver.findElement(By.xpath("//button[@name='submit']")).click();
	
	//cancel appointment history
	
	driver.findElement(By.xpath("//p[@class='cl-effect-1']")).click();
	driver.findElement(By.xpath("//tbody/tr[last()]/td[8]")).click();
	Alert a = driver.switchTo().alert();
	a.accept();
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

package com.DearDoctor.Doctor;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
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

import io.github.bonigarcia.wdm.WebDriverManager;

public class editing_a_doctor_name {
public static void main(String[] args) throws IOException {
	WebDriver driver=null;
	//Read all the Necessary common data
	FileInputStream fis=new FileInputStream(".\\Data\\DearDoctor.properties");
	Properties prop=new Properties();
	prop.load(fis);
	String URL = prop.getProperty("url");
	String BROWSER = prop.getProperty("browser1");
	String USERNAME = prop.getProperty("Doctor_username");
	String PASSWORD = prop.getProperty("Doctor_password");
	
	Random r=new Random();
	int random=r.nextInt();
	
	//step  Read the test data from excel sheet
	FileInputStream fileexcel = new FileInputStream(".\\Data\\dear.xlsx");
	Workbook wb = WorkbookFactory.create(fileexcel);
	String Drname = wb.getSheet("Sheet1").getRow(9).getCell(2).toString();
	
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
	driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
	driver.get(URL);
	
	//step 4:login to app
	driver.findElement(By.xpath("//a[@href='hms/doctor/']")).click();
	driver.findElement(By.name("username")).sendKeys(USERNAME);
	driver.findElement(By.name("password")).sendKeys(PASSWORD);
	driver.findElement(By.name("submit")).click();
	driver.findElement(By.xpath("//p[@class='links cl-effect-1']")).click();
	driver.findElement(By.name("docname")).sendKeys(Drname);
	driver.findElement(By.name("submit")).click();
	String excepted="Doctor Details updated Successfully";
	  Alert a = driver.switchTo().alert();
	 String actual = a.getText();
	 a.accept();
	 
	 if(excepted.equals(actual)) {
		 System.out.println("Test case is pass");
	 }else {
		 System.out.println("Test case is fail");
	 }
	 driver.findElement(By.xpath("//i[@class='ti-angle-down']")).click();
	 driver.findElement(By.xpath("//a[@href='logout.php']")).click();
	
	
}
}

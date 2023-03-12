package com.DearDoctor.Admin;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class check_added_doctor_details {
	public static void main(String[] args) throws IOException {
		
		WebDriver driver=null;
		//Read all the Necessary common data
		FileInputStream fis=new FileInputStream(".\\Data\\DearDoctor.properties");
		Properties prop=new Properties();
		prop.load(fis);
		String URL = prop.getProperty("url");
		String BROWSER = prop.getProperty("browser1");
		String USERNAME = prop.getProperty("Admin_username");
		String PASSWORD = prop.getProperty("Admin_password");
		
		Random r=new Random();
		int random=r.nextInt();
		
		//step  Read the test data from excel sheet
		FileInputStream fileexcel = new FileInputStream(".\\Data\\dear.xlsx");
		Workbook wb = WorkbookFactory.create(fileexcel);
		String specilazation = wb.getSheet("Sheet1").getRow(1).getCell(2).getStringCellValue();
		String Drname = wb.getSheet("Sheet1").getRow(2).getCell(2).getStringCellValue();
		String address = wb.getSheet("Sheet1").getRow(3).getCell(2).getStringCellValue();
		String fees = wb.getSheet("Sheet1").getRow(4).getCell(2).toString();
		String phoneno = wb.getSheet("Sheet1").getRow(5).getCell(2).toString();
		String email = wb.getSheet("Sheet1").getRow(6).getCell(2).toString();
		String password = wb.getSheet("Sheet1").getRow(7).getCell(2).toString();
		String cpassword = wb.getSheet("Sheet1").getRow(8).getCell(2).toString();
		
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
		driver.findElement(By.name("docemail")).sendKeys(email+random);
		driver.findElement(By.name("npass")).sendKeys(password);
		driver.findElement(By.name("cfpass")).sendKeys(cpassword);
		driver.findElement(By.name("submit")).click();
		Alert a = driver.switchTo().alert();
		a.accept();
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

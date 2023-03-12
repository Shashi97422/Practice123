package com.DearDoctor.practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Edit_Doctor_Details {
public static void main(String[] args) throws IOException {
	WebDriver driver=null;
	FileInputStream fis=new FileInputStream(".\\Data\\\\commonDatadearDoctor.properties");
	Properties prop=new Properties();
	prop.load(fis);
	String URL = prop.getProperty("url");
	String UN = prop.getProperty("username1");
	String PWD = prop.getProperty("password1");
	String Browser = prop.getProperty("Browser");
	if(Browser.equalsIgnoreCase("chrome")) {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
	}
	else {
		System.out.println("INCORRECT BROWSER");
	}
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	driver.get(URL);
	driver.findElement(By.xpath("//a[@href='hms/admin']")).click();
	driver.findElement(By.xpath("//input[@type='text']")).sendKeys(UN);
	driver.findElement(By.xpath("//input[@type='password']")).sendKeys(PWD);
	driver.findElement(By.xpath("//button[@type='submit']")).click();
	driver.findElement(By.xpath("//a[@href='manage-doctors.php']")).click();
	driver.findElement(By.xpath("//i[@class='fa fa-pencil']")).click();
	//driver.findElement(By.xpath("//select[@name='Doctorspecialization']")).sendKeys("Dentist");
	//driver.findElement(By.xpath("//input[@type='text']")).sendKeys("Dr.Channaveer");
	//driver.findElement(By.xpath("//textarea[@name='clinicaddress']")).sendKeys("channaveer hospital,Shantinagar ,B'lore");
	//driver.findElement(By.xpath("//input[@value='700']")).sendKeys("800");
	//driver.findElement(By.xpath("//input[@value='25668888']")).sendKeys("9243100100");
	//driver.findElement(By.xpath("//button[@type='submit']")).click();
	
	//driver.findElement(By.xpath("//i[@class='ti-angle-down']")).click();
	 //driver.findElement(By.xpath("//a[@href='logout.php']")).click();
	
	
}
}

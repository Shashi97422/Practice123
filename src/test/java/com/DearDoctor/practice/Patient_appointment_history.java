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

public class Patient_appointment_history {
public static void main(String[] args) throws IOException {
	WebDriver driver=null;
	FileInputStream fis=new FileInputStream(".\\Data\\commonDatadearDoctor.properties");
	Properties prop=new Properties();
	prop.load(fis);
	String URL = prop.getProperty("url");
	String UN = prop.getProperty("username");
	String PWD = prop.getProperty("password");
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
	driver.findElement(By.xpath("//a[.='Click Here']")).click();
	driver.findElement(By.xpath("//input[@name='username']")).sendKeys(UN);
	driver.findElement(By.xpath("//input[@type='password']")).sendKeys(PWD);
	driver.findElement(By.xpath("//button[@type='submit']")).click();
	driver.findElement(By.xpath("//a[@href='appointment-history.php']")).click();
	
	driver.findElement(By.xpath("//i[@class='ti-angle-down']")).click();
	 driver.findElement(By.xpath("//a[@href='logout.php']")).click();
}
}

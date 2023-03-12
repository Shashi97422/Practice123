package com.DearDoctor.genericuyility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class DummyBaseClass {
	WebDriver driver;
//@Parameters("BROWSER")
@BeforeClass
public void configBC(String BROWSER) {

System.out.println("=============Launch the Browser=======");
if(BROWSER.equals("chrome")) {
 driver = new ChromeDriver();
 System.out.println("chrome browser launched");
}else if(BROWSER.equals("firefox")) {
driver = new FirefoxDriver();
System.out.println("firefox browser launched");
}else if(BROWSER.equals("ie")) {
driver = new InternetExplorerDriver();
System.out.println("ie browser launched");
}else {
driver = new ChromeDriver();
System.out.println("chrome browser launched");
}

}
@AfterClass
public void configAC() {
	System.out.println("=============Close the Browser=======");
	//driver.quit();
}
}
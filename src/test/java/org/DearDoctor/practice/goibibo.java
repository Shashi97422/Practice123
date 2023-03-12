package org.DearDoctor.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class goibibo {
public static void main(String[] args) {
	WebDriverManager.chromedriver().setup();
	WebDriver driver=new ChromeDriver();
	driver.get("https://www.goibibo.com/");
	driver.manage().window().maximize();
	driver.findElement(By.xpath("//a[@class='nav-link active']")).click();
	driver.findElement(By.xpath("//span[.='From']/../p[@class='sc-iJKOTD iipKRx fswWidgetPlaceholder']")).click();
	driver.findElement(By.xpath("//input[@type='text']")).sendKeys("bengaluru");
	driver.findElement(By.xpath("//ul[@id='autoSuggest-list']/../descendant::p[.='Biju Patnaik International Airport']")).click();
	//Actions act=new Actions(driver);
	//act.moveToElement(ele).doubleClick(ele);
	driver.findElement(By.xpath("//span[.='To']/../p[@class='sc-iJKOTD iipKRx fswWidgetPlaceholder']")).click();
	driver.findElement(By.xpath("//input[@type='text']")).sendKeys("hubli");
	driver.findElement(By.xpath("//span[@class='sc-kfPuZi dprjVP fswDownArrow']")).click();
	driver.findElement(By.xpath("//div[@class='sc-lbhJGD bHgpcs']/descendant::div[@aria-label='Thu Aug 11 2022']")).click();
	driver.findElement(By.xpath("//div[@class='sc-lbhJGD bHgpcs']/descendant::div[@aria-label='Fri Sep 16 2022']")).click();
	
}
}

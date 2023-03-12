package com.DearDoctor.pomrepositorylib;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.DearDoctor.genericuyility.WebDriverUtility;

public class Delete_Doctor {
	WebDriver driver;
public Delete_Doctor(WebDriver driver) {
	PageFactory.initElements(driver, this);
	this.driver=driver;
}

@FindBy(xpath = "//table/tbody/tr[24]/td[5]/descendant::a[@tooltip='Remove']")
private WebElement removebutton;

public WebElement getRemovebutton() {
	return removebutton;
}

public void remove_doctor()
{
	removebutton.click();
	WebDriverUtility wlib=new WebDriverUtility();
	wlib.swithToAlertWindowAndAccpect(driver, "Are you sure you want to delete?");
	String excepted="data deleted !!";
	 String actual = driver.findElement(By.xpath("//p[.='data deleted !!								']")).getText();
	Assert.assertEquals(excepted, actual);
}
}

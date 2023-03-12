package com.DearDoctor.pomrepositorylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Doctor_Home {
public Doctor_Home(WebDriver driver) {
	PageFactory.initElements(driver, this);
}
@FindBy(xpath = "//p[@class='links cl-effect-1']")
private WebElement myprofile;

@FindBy(xpath = "//i[@class='ti-angle-down']")
private WebElement logout;

@FindBy(xpath = "//a[@href='logout.php']")
private WebElement conlogout;

public WebElement getMyprofile() {
	return myprofile;
}

public WebElement getLogout() {
	return logout;
}

public WebElement getConlogout() {
	return conlogout;
}
public void clickon_Myprofile() {
	myprofile.click();
}
public void logout() {
	logout.click();
}
public void clickon_MyPprofile() {
	myprofile.click();
	
}
}

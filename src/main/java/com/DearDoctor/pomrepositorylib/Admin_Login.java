package com.DearDoctor.pomrepositorylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Admin_Login {     
public Admin_Login(WebDriver driver) {
	PageFactory.initElements(driver, this);
}
@FindBy(xpath = "//a[@href='hms/admin']")
private WebElement Adminmoduleclick;

@FindBy(name = "username")
private WebElement Admin_username;

@FindBy(name = "password")
private WebElement Admin_password;

@FindBy(name = "submit")
private WebElement Admin_LoginBtn;

public WebElement getAdminmoduleclick() {
	return Adminmoduleclick;
}

public WebElement getAdmin_username() {
	return Admin_username;
}

public WebElement getAdmin_password() {
	return Admin_password;
}

public WebElement getAdmin_LoginBtn() {
	return Admin_LoginBtn;
}

public void loginToApp(String USERNAME ,String PASSWORD) {
	Adminmoduleclick.click();
	Admin_username.sendKeys(USERNAME);
	Admin_password.sendKeys(PASSWORD);
	Admin_LoginBtn.click();
	
	
}
}
 
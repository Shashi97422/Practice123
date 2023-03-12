package com.DearDoctor.pomrepositorylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Doctor_Login {
	public Doctor_Login(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//a[@href='hms/doctor/']")
	private WebElement Doctormoduleclick;
	
	@FindBy(name = "username")
	private WebElement Doctor_username;

	@FindBy(name = "password")
	private WebElement Doctor_password;

	@FindBy(name = "submit")
	private WebElement Doctor_LoginBtn;

	public WebElement getDoctormoduleclick() {
		return Doctormoduleclick;
	}

	public WebElement getDoctor_username() {
		return Doctor_username;
	}

	public WebElement getDoctor_password() {
		return Doctor_password;
	}

	public WebElement getDoctor_LoginBtn() {
		return Doctor_LoginBtn;
	}
	public void loginToDoctor(String USERNAME ,String PASSWORD) {
		Doctormoduleclick.click();
		Doctor_username.sendKeys(USERNAME);
		Doctor_password.sendKeys(PASSWORD);
		Doctor_LoginBtn.click();
}
}

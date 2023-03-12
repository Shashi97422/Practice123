package com.DearDoctor.pomrepositorylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Patient_Login {
	public Patient_Login(WebDriver driver) {
		PageFactory.initElements(driver, this);
}
	@FindBy(xpath = "//a[@href='hms/user-login.php']")
	private WebElement patientmoduleclick;

	@FindBy(name = "username")
	private WebElement patient_username;

	@FindBy(name = "password")
	private WebElement patient_password;

	@FindBy(name = "submit")
	private WebElement patient_LoginBtn;

	public WebElement getPatientmoduleclick() {
		return patientmoduleclick;
	}

	public WebElement getPatient_username() {
		return patient_username;
	}

	public WebElement getPatient_password() {
		return patient_password;
	}

	public WebElement getPatient_LoginBtn() {
		return patient_LoginBtn;
	}
	public void loginToPatient(String USERNAME ,String PASSWORD) {
		patientmoduleclick.click();
		patient_username.sendKeys(USERNAME);
		patient_password.sendKeys(PASSWORD);
		patient_LoginBtn.click();
}
}
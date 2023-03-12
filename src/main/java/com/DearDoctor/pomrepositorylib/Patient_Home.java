package com.DearDoctor.pomrepositorylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Patient_Home {
	WebDriver driver;
	public Patient_Home(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver=driver;
	
	}
	@FindBy(xpath = "//p[@class='cl-effect-1']")
	private WebElement clickonAppointmentHistory;
	
	public WebElement getClickonAppointmentHistory() {
		return clickonAppointmentHistory;
	}
	public void clickappointment() {
		clickonAppointmentHistory.click();
}
}
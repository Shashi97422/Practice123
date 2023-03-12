package com.DearDoctor.pomrepositorylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.DearDoctor.genericuyility.WebDriverUtility;

public class Edit_Doctor_Profile {
	WebDriver driver;
	public Edit_Doctor_Profile(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver=driver;
}
	
	@FindBy(name = "docname")
	private WebElement DoctorName;
	
	@FindBy(name = "submit")
	private WebElement updateButton;
	
	@FindBy(xpath = "//h5[.='Edit Doctor']/ancestor::div[@class='panel panel-white']/descendant::h4")
	private WebElement updatedDoctorName;

	public WebElement getUpdatedDoctorName() {
		return updatedDoctorName;
	}

	public WebElement getDoctorName() {
		return DoctorName;
	}

	public WebElement getUpdateButton() {
		return updateButton;
	}
	
	public void editName(String Drname) {
		DoctorName.clear();
		DoctorName.sendKeys(Drname);
		updateButton.click();
		WebDriverUtility wlib=new WebDriverUtility();
		wlib.swithToAlertWindowAndAccpect(driver, "Doctor Details updated Successfully");
	}
	public void doctorNameValidation() {
		String excepted="Dr.Anil's Profile";
		String actual = updatedDoctorName.getText();
		System.out.println(actual);
		Assert.assertEquals(excepted, actual);
}
}
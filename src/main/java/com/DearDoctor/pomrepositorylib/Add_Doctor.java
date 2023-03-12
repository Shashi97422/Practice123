package com.DearDoctor.pomrepositorylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.DearDoctor.genericuyility.WebDriverUtility;

public class Add_Doctor {
	WebDriver driver;
public Add_Doctor(WebDriver driver) {
	PageFactory.initElements(driver, this);
	this.driver=driver;
}
	@FindBy(xpath = "//select[@name='Doctorspecialization']")
	private WebElement Doctorspecialization;
	
	@FindBy(xpath = "//input[@name='docname']")
	private WebElement DoctorName;
	
	@FindBy(name = "clinicaddress")
	private WebElement ClinicAddress;
	
	@FindBy(name = "docfees")
	private WebElement Fees;
	
	@FindBy(name = "doccontact")
	private WebElement DoctorContact;
	
	@FindBy(name = "docemail")
	private WebElement DoctorEmail;
	
	@FindBy(name = "npass")
	private WebElement Password;
	
	@FindBy(name = "cfpass")
	private WebElement ConformPassword;
	
	@FindBy(name = "submit")
	private WebElement Doctorsubmit;
	
	@FindBy(xpath = "//table/tbody/tr[last()]/td[3]")
	private WebElement actualname;

	public WebElement getVarifying_Doctor() {
		return actualname;
	}

	public WebElement getDoctorspecialization() {
		return Doctorspecialization;
	}

	public WebElement getDoctorName() {
		return DoctorName;
	}

	public WebElement getClinicAddress() {
		return ClinicAddress;
	}

	public WebElement getFees() {
		return Fees;
	}

	public WebElement getDoctorContact() {
		return DoctorContact;
	}

	public WebElement getDoctorEmail() {
		return DoctorEmail;
	}

	public WebElement getPassword() {
		return Password;
	}

	public WebElement getConformPassword() {
		return ConformPassword;
	}

	public WebElement getDoctorsubmit() {
		return Doctorsubmit;
	}
	
	public void addingdoctor(String specilazation ,String Drname , String address ,String fees ,String phoneno ,String email ,String password ,String cpassword)
	{
		Doctorspecialization.sendKeys(specilazation);
		DoctorName.sendKeys(Drname);
		ClinicAddress.sendKeys(address);
		Fees.sendKeys(fees);
		DoctorContact.sendKeys(phoneno);
		DoctorEmail.sendKeys(email);
		Password.sendKeys(password);
		ConformPassword.sendKeys(cpassword);
		Doctorsubmit.click();
		WebDriverUtility wlib=new WebDriverUtility();
		wlib.swithToAlertWindowAndAccpect(driver, "Doctor info added Successfully");
		String excepeted =Drname ;
		System.out.println(Drname);
		String actual = actualname.getText().trim();
		Assert.assertEquals(excepeted, actual);
		
		
		
	}
}


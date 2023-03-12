package com.DearDoctor.pomrepositorylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.DearDoctor.genericuyility.WebDriverUtility;

public class Admin_Home {
	WebDriver driver;
	public Admin_Home(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver=driver;
	
	}
	@FindBy(xpath = "//span[.=' Doctors ']")
	private WebElement Doctor_Dropdown;
	
    @FindBy(xpath = "//span[.=' Add Doctor']")
	private WebElement AdddDoctor;
    
	
	/* @FindBy(xpath = "//select[@name='Doctorspecialization']")
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
	
	@FindBy(xpath = "//table/tbody/tr[24]/td[5]/descendant::a[@tooltip='Remove']")
	private WebElement removebutton; */
	
	@FindBy(xpath = "//i[@class='ti-angle-down']")
	private WebElement log;
	
	@FindBy(xpath = "//a[@href='logout.php']")
	private WebElement out;

	public WebElement getLog() {
		return log;
	}

	public WebElement getOut() {
		return out;
	}

	public WebElement getDoctor_Dropdown() {
		return Doctor_Dropdown;
	}

	public WebElement getAddDoctorclick() {
		return AdddDoctor;
	}

   /* public WebElement getDoctorspecialization() {
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
	} */
	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getAdddDoctor() {
		return AdddDoctor;
	}

	//public WebElement getRemovebutton() {
	//	return removebutton;
	//}
	
	public void clickon_dropdown(/* String specilazation ,String Drname , String address ,String fees ,String phoneno ,String email ,String password ,String cpassword */) throws InterruptedException
	{
	Doctor_Dropdown.click();
	AdddDoctor.click();
	/* Doctorspecialization.sendKeys(specilazation);
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
	//removebutton.click();
	//wlib.swithToAlertWindowAndAccpect(driver, "Are you sure you want to delete?"); */
	//log.click();
	//out.click();
	}
	public void logout() {
		log.click();
		out.click();
	}
	
}

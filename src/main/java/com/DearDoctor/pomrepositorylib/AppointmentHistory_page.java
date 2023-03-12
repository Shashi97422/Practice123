package com.DearDoctor.pomrepositorylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.DearDoctor.genericuyility.WebDriverUtility;

public class AppointmentHistory_page {
	WebDriver driver;
	public AppointmentHistory_page(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver=driver;
}
	//cancel appointment
	@FindBy(xpath = "//tbody/tr[last()]/td[8]")
	private WebElement click_on_cancel_smbol;
	
	@FindBy(xpath = "//p[.='Your appointment canceled !!								']")
	private WebElement conformation;
	
	public WebElement getClick_on_cancel_smbol() {
		return click_on_cancel_smbol;
	}
	
	public WebElement getConformation() {
		return conformation;
	}


	public void cancelAppointment()
	{
		click_on_cancel_smbol.click();
		WebDriverUtility wlib=new WebDriverUtility();
			wlib.swithToAlertWindowAndAccpect(driver, "Your appointment canceled !!");	
			String excepted = "Your appointment canceled !!";
			String actual = conformation.getText();
			Assert.assertEquals(excepted, actual);
			
	}
	
}

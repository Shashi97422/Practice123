package com.TestNG.Base;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.DearDoctor.genericuyility.BaseClass;
import com.DearDoctor.pomrepositorylib.Add_Doctor;
import com.DearDoctor.pomrepositorylib.Admin_Home;
import com.DearDoctor.pomrepositorylib.Admin_Login;
@Listeners(com.DearDoctor.genericuyility.LisImpClass.class)
public class AddedDoctorDetailstest extends BaseClass {
	@Test(groups = "smokeTest")                                        //(retryAnalyzer = com.DearDoctor.genericuyility.ReTryImpclass.class)
	public void check_added_doctor_details() throws Throwable {
		//login as Admin
		String BROWSER = flib.getPropertyKeyValue("browser1");
		String USERNAME = flib.getPropertyKeyValue("Admin_username");
		String PASSWORD = flib.getPropertyKeyValue("Admin_password");
		Admin_Login alm=new Admin_Login(driver);
		alm.loginToApp(USERNAME, PASSWORD);

		//get randomnumber
		int intRanNum = jlib.getRanDomNumber();

		//read the test data from excel sheet

		String specilazation = elib.getExcelData("Sheet1", 1, 2);
		String Drname = elib.getExcelData("Sheet1", 2, 2);
		String address = elib.getExcelData("Sheet1", 3, 2);
		String fees = elib.getExcelData("Sheet1", 4, 2);
		String phoneno = elib.getExcelData("Sheet1", 5, 2);
		String email = elib.getExcelData("Sheet1", 6, 2)+intRanNum;
		String password = elib.getExcelData("Sheet1", 7, 2);
		String cpassword = elib.getExcelData("Sheet1", 8, 2);

		Admin_Home home=new Admin_Home(driver);
		home.clickon_dropdown();
		

		//click dropdown
		Admin_Home home1=new Admin_Home(driver);
		home1.clickon_dropdown();
	
		

		//add doctor
		Add_Doctor add=new Add_Doctor(driver);
		add.addingdoctor(specilazation, Drname, address, fees, phoneno, email, password, cpassword);

		//logout as Admin
		home.logout();
}
}

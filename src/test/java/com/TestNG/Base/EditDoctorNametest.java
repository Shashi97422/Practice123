package com.TestNG.Base;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.DearDoctor.genericuyility.BaseClass;
import com.DearDoctor.pomrepositorylib.Admin_Home;
import com.DearDoctor.pomrepositorylib.Doctor_Home;
import com.DearDoctor.pomrepositorylib.Doctor_Login;
import com.DearDoctor.pomrepositorylib.Edit_Doctor_Profile;
@Listeners(com.DearDoctor.genericuyility.LisImpClass.class)
public class EditDoctorNametest extends BaseClass {
	@Test(groups = "smokeTest")
	public void edit_Doctor_Name() throws Throwable {
		//Read all the Necessary common data
		//String URL = flib.getPropertyKeyValue("url");
		String BROWSER = flib.getPropertyKeyValue("browser1");
		String USERNAME = flib.getPropertyKeyValue("Doctor_username");
		String PASSWORD = flib.getPropertyKeyValue("Doctor_password");
		
		//get randomnumber
				int intRanNum = jlib.getRanDomNumber();


		//read the test data from excel sheet
		String Drname = elib.getExcelData("Sheet1", 9, 2);
		String email = elib.getExcelData("Sheet1", 6, 2)+intRanNum;

		//login as Doctor
		Doctor_Login lp=new Doctor_Login(driver);
		lp.loginToDoctor(USERNAME, PASSWORD);

		//click on my profile
		Doctor_Home home=new Doctor_Home(driver);
		home.clickon_MyPprofile();

		//Edit doctor name
		Edit_Doctor_Profile edit=new Edit_Doctor_Profile(driver);
		edit.editName(Drname);	
		edit.doctorNameValidation();

		//logout as Doctor
		Admin_Home home1=new Admin_Home(driver);
		home1.logout();

}
}

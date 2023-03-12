package com.TestNG.Base;

import org.testng.annotations.Test;

import com.DearDoctor.genericuyility.BaseClass;
import com.DearDoctor.pomrepositorylib.Add_Doctor;
import com.DearDoctor.pomrepositorylib.Admin_Home;
import com.DearDoctor.pomrepositorylib.Admin_Login;
import com.DearDoctor.pomrepositorylib.AppointmentHistory_page;
import com.DearDoctor.pomrepositorylib.Delete_Doctor;
import com.DearDoctor.pomrepositorylib.Doctor_Home;
import com.DearDoctor.pomrepositorylib.Doctor_Login;
import com.DearDoctor.pomrepositorylib.Edit_Doctor_Profile;
import com.DearDoctor.pomrepositorylib.Patient_Home;
import com.DearDoctor.pomrepositorylib.Patient_Login;

public class TestNgclasstest extends BaseClass {
	@Test
	public void Verify_deleted_doctor_details() throws Throwable {


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

		//add doctor
		Add_Doctor add=new Add_Doctor(driver);
		add.addingdoctor(specilazation, Drname, address, fees, phoneno, email, password, cpassword);

		//remove doctor
		Delete_Doctor delete=new Delete_Doctor(driver);
		delete.remove_doctor();

		//logout as admin
		home.logout();
	}	

	@Test
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
	@Test
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
  	@Test
	public void cancelAppointment() throws Throwable {
		String BROWSER = flib.getPropertyKeyValue("browser1");
		String USERNAME = flib.getPropertyKeyValue("Patient_username");   
		String PASSWORD = flib.getPropertyKeyValue("Patient_password");
         
	/*	 //login as Patient
		Patient_Login lp=new Patient_Login(driver);
		lp.loginToPatient(USERNAME, PASSWORD);
		
	/*	 //Click on view Appointment History
		Patient_Home home=new Patient_Home(driver);
		home.clickappointment();  */
		
	} 
}

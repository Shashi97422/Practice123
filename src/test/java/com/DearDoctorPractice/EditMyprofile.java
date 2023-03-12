package com.DearDoctorPractice;

import org.testng.annotations.Test;

public class EditMyprofile {
	@Test(groups = "regression testing")
	public void editName() {
		System.out.println("Profile Edeted sucessfully with name"+Thread.currentThread().getId());
	}
	@Test(groups = "smoke testing")
	public void editMobno() {
		System.out.println("Profile Edeted sucessfully with Mobno"+Thread.currentThread().getId());
	}
	@Test(groups = "regression testing")
	public void editemail() {
		System.out.println("Profile Edeted sucessfully with email"+Thread.currentThread().getId());
	}
	@Test(groups = "smoke testing")
	public void editaddress() {
		System.out.println("Profile Edeted sucessfully with address"+Thread.currentThread().getId());
	}
}
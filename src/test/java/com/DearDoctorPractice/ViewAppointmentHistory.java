package com.DearDoctorPractice;

import org.testng.annotations.Test;

public class ViewAppointmentHistory {
@Test(groups = "regression testing")
public void patientappointmentHistory() {
	System.out.println("Appointment History is viewed"+Thread.currentThread().getId());
	
}
@Test(groups = "smoke testing")
public void deleteappointment() {
	System.out.println("Appointment History is viewed and deleted"+Thread.currentThread().getId());
	
}
}

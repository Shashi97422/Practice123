package com.DearDoctorPractice;

import org.testng.annotations.Test;

import com.DearDoctor.genericuyility.DummyBaseClass;

public class BookAppointTest extends DummyBaseClass {
@Test(groups = "smoke")
public void BookAppointmentbyName() {
	System.out.println("Appointment is Booked using name"+Thread.currentThread().getId());
}
@Test(groups = "regression testing")
public void BookAppointmentbyMobno() {
	System.out.println("Appointment is Booked using mobno"+Thread.currentThread().getId());
}
@Test(groups = "smoke")
public void BookAppointmentbyemail() {
	System.out.println("Appointment is Booked using email"+Thread.currentThread().getId());
}
}

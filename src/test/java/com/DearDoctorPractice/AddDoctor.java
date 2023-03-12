package com.DearDoctorPractice;

import org.testng.annotations.Test;

import com.DearDoctor.genericuyility.DummyBaseClass;

public class AddDoctor extends DummyBaseClass {
@Test(groups = {"smoke testing","regression testing"})
public void addDoctorname() {
	System.out.println("Doctor name added successfully "+Thread.currentThread().getId());
}
@Test(groups = "smoke testing")
public void addDoctormobno() {
	System.out.println("Doctor mobno added successfully"+Thread.currentThread().getId());
}
@Test(groups = "regression testing")
public void addDoctoremail() {
	System.out.println("Doctor email added successfully"+Thread.currentThread().getId());
}
@Test
public void addDoctoraddress() {
	System.out.println("Doctor email added successfully"+Thread.currentThread().getId());
}
}

package com.DearDoctor.practice;

import java.util.Date;

public class practicedate {
public static void main(String[] args) {
	Date d=new Date();
	String currentdate = d.toString();
	System.out.println(currentdate);
	String[] arr = currentdate.split(" ");
	String yyyy = arr[5];
	String dd = arr[2];
	int mm = d.getMonth()+1;
	String formate = dd+"-"+mm+"-"+yyyy;
	System.out.println(formate);
}
}

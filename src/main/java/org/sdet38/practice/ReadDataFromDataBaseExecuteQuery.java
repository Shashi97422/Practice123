package org.sdet38.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class ReadDataFromDataBaseExecuteQuery {
public static void main(String[] args) throws SQLException {
	
	//step1: Create object ofDriver
	 Driver driverRef=new Driver();
	Connection con=null;
	
	//step2: regester driver
	DriverManager.registerDriver(driverRef);
	
	//step3 : establish the connection- provide database name
	con=DriverManager.getConnection("jdbc:mysql://localhost:3306/deardoctor", "root", "root");
	
	//step4: create statement
     Statement state = con.createStatement();
	
	//step5 : Execute query
	String query = "select * from patient;";
	String expData="shashi";
	ResultSet result = state.executeQuery(query);
	boolean flag=false;
	while(result.next())
	{
		String actData=result.getString(1);
		if(actData.equalsIgnoreCase(expData))
		{
			System.out.println(actData);
			flag=true; //flag rising
			break;
		}
	}
	if(flag)
	{
		System.out.println("data is present");
	}
	else {
		System.out.println("data is not present");
	}
	con.close();
}
}

package org.DearDoctor.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class ReadDataFromDBExecuteUpdate {
	public static void main(String[] args) throws SQLException {
		//Step1 : create object for Driver
		Driver driverref=new Driver();
		Connection con=null;

		//step2: Regester the driver
		DriverManager.registerDriver(driverref);

		//step3 : Establish the connection
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/deardoctor", "root", "root");

		//step4:create statement
		Statement state = con.createStatement();

		//step5 : execute query
		String query="insert into patient values('shashi',2,'Koodalsangam');";
		int result = state.executeUpdate(query);
		System.out.println("result");

		//step6:validate
		if(result==1)
		{
			System.out.println("data added successfully");
		}
		else {
			System.out.println("data not added");
		}

		//step 7 : closed connectin
		con.close();
	}
}

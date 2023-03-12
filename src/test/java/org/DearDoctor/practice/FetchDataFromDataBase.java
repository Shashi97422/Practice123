package org.DearDoctor.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class FetchDataFromDataBase {
	public static void main(String[] args) throws SQLException {
		Driver dbDriver=new Driver();

		DriverManager.registerDriver(dbDriver);
		Connection connection=null;
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sdeet38","root","root");
			Statement statement = connection.createStatement();
			statement.executeUpdate("create table employee(empId int(4) not null unique, empName varchar(30),phone_number int(10) not null unique, Address varchar(50));insert into employee values(3,'rachita',9243100100);");
			
			System.out.println("Data updated successfully");
		}
		finally {
			connection.close();
			System.out.println("connection closed");
		}
	}
}



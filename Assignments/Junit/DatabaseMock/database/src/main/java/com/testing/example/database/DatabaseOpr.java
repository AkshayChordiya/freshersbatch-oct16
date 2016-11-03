package com.testing.example.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DatabaseOpr {
	
	public List<Employee> getAllEmployees() throws Exception {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection dbcon = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "root");
		Statement stmt = dbcon.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM EMP");
		List<Employee> empList = new ArrayList<Employee>();
		while (rs.next()) {
			Employee e = new Employee(rs.getInt("ID"), rs.getString("NAME"), rs.getDouble("SALARY"));
			empList.add(e);
		}
		return empList;
	}

	public static void main(String args[]) throws Exception {
		DatabaseOpr dbo = new DatabaseOpr();
		List<Employee> empList = dbo.getAllEmployees();
		System.out.println(empList);
	}
}

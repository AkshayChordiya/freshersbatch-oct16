package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JdbcMain {
	public static void main(String[] args) throws Exception {
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "root");
		
		Statement statement = connection.createStatement();
		
		int update = statement.executeUpdate("UPDATE DEPT SET NAME = 'Research' WHERE ID = 3");
		System.out.println("Updated rows = " + update);
		
		update = statement.executeUpdate("DELETE FROM DEPT WHERE ID = 1");
		System.out.println("Delete rows = " + update);
		
		ResultSet resultSet = statement.executeQuery("SELECT * FROM DEPT");
		while (resultSet.next()) {
			System.out.println(resultSet.getInt("ID") + " - " + resultSet.getString("NAME"));
		}
		
		resultSet.close();
		statement.close();
		connection.close();
	}
}

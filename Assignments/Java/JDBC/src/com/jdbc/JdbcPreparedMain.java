package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class JdbcPreparedMain {
	public static void main(String[] args) throws Exception {
		
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "root");
		
		PreparedStatement statement = connection.prepareStatement("UPDATE DEPT SET NAME = ? WHERE ID = ?");
		statement.setString(1, "ResearchN");
		statement.setInt(2, 3);
		int update = statement.executeUpdate();
		System.out.println("Updated rows = " + update);
		
		PreparedStatement deleteStatement = connection.prepareStatement("DELETE FROM DEPT WHERE ID = ?");
		deleteStatement.setInt(1, 6);
		update = deleteStatement.executeUpdate();
		System.out.println("Deleted rows = " + update);
		
		ResultSet resultSet = connection.createStatement().executeQuery("SELECT * FROM DEPT");
		while (resultSet.next()) {
			System.out.println(resultSet.getInt("ID") + " - " + resultSet.getString("NAME"));
		}
		
		resultSet.close();
		deleteStatement.close();
		statement.close();
		connection.close();
	}
}

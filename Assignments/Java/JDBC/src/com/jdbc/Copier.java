package com.jdbc;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Copier {

	public static void main(String[] args) throws Exception {
		copyDataUsingBatch();
	}

	public static void copyDataUsingBatch() throws SQLException {
		Statement statement = null;
		Connection con = null;
		try {
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "root");
			con.setAutoCommit(false);

			statement = con.createStatement();
			PreparedStatement prepareStatement = con
					.prepareStatement("INSERT INTO "
							+ "EMP1(ID, NAME, SALARY, COMMISSION, ROLE, DEPT_NO, HIRED_DATE, MANAGER_ID) "
							+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?)");
			ResultSet resultSet = statement.executeQuery("SELECT * FROM EMP");
			while (resultSet.next()) {
				prepareStatement.setInt(1, resultSet.getInt("ID"));
				prepareStatement.setString(2, resultSet.getString("NAME"));
				prepareStatement.setInt(3, resultSet.getInt("SALARY"));
				prepareStatement.setInt(4, resultSet.getInt("COMMISSION"));
				prepareStatement.setString(5, resultSet.getString("ROLE"));
				prepareStatement.setInt(6, resultSet.getInt("DEPT_NO"));
				prepareStatement.setDate(7, resultSet.getDate("HIRED_DATE"));
				prepareStatement.setInt(8, resultSet.getInt("MANAGER_ID"));
				prepareStatement.addBatch();
				prepareStatement.clearParameters();
			}
			prepareStatement.executeBatch();
			System.out.println("Commiting now");
			con.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			con.setAutoCommit(true);
			statement.close();
			con.close();
		}
	}

	public static void copyData() throws Exception {
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "root");

		Statement statement = con.createStatement();
		int update = statement.executeUpdate("INSERT INTO EMP1 (SELECT * FROM EMP)");
		System.out.println("Added " + update + " rows");
		statement.close();
		con.close();
	}

	public static void storePhoto() throws Exception {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "root");

		PreparedStatement pstmt = con.prepareStatement("INSERT INTO PROFILE (NAME, PHOTO) VALUES (?, ?)");
		pstmt.setString(1, "Android");

		File file = new File("android.jpg");
		FileInputStream fis = new FileInputStream(file);
		pstmt.setBinaryStream(2, fis, file.length());
		int update = pstmt.executeUpdate();
		System.out.println("Added " + update + " rows");
		pstmt.close();
		con.close();
	}

	public static void getPhoto() throws Exception {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "root");
		Statement statement = con.createStatement();
		ResultSet resultSet = statement.executeQuery("SELECT NAME, PHOTO FROM PROFILE");
		resultSet.next();
		InputStream in = resultSet.getBinaryStream("photo");
		File file = new File("android2.jpg");
		FileOutputStream out = new FileOutputStream(file);
		byte[] buff = new byte[4096]; // how much of the blob to read/write at a
										// time
		int len = 0;

		while ((len = in.read(buff)) != -1) {
			out.write(buff, 0, len);
		}
		out.close();
		in.close();
		resultSet.close();
		statement.close();
		con.close();
		System.out.println("Blob retrieved");
	}

}

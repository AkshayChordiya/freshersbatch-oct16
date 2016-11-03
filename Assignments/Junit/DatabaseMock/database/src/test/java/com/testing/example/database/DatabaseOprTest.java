package com.testing.example.database;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
public class DatabaseOprTest {
	
	@Before
	public void before() throws SQLException {
		PowerMockito.mockStatic(DriverManager.class);
		Connection connection = PowerMockito.mock(Connection.class);
		Statement statement = PowerMockito.mock(Statement.class);
		ResultSet resultSet = PowerMockito.mock(ResultSet.class);
		
		when(DriverManager.getConnection(anyString(), anyString(), anyString())).thenReturn(connection);
		when(connection.createStatement()).thenReturn(statement);
		when(statement.executeQuery(anyString())).thenReturn(resultSet);
		when(resultSet.next()).thenReturn(false);
	}

	@Test
	public void test() throws Exception {
		DatabaseOpr opr = new DatabaseOpr();
		assertEquals(7, opr.getAllEmployees().size());
	}
	
}

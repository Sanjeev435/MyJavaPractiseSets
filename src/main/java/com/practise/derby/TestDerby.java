package com.practise.derby;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSetMetaData;

public class TestDerby {
	private static String dbURL = "jdbc:derby:C:\\Users\\Sanjeev\\MyDB;user=sanju;password=sanju";
	private static String tableName = "app.restaurants";
	// jdbc Connection
	private static Connection conn = null;
	private static Statement stmt = null;

	public static void main(String[] args) {
		createConnection();
		insertRestaurants(5, "LaVals", "Berkeley");
		selectRestaurants();
		shutdown();
	}

	/**
	 * Create a connection
	 */
	private static void createConnection() {
		try {
			Class.forName("org.apache.derby.jdbc.ClientDriver");
			// Get a connection
			conn = DriverManager.getConnection(dbURL);
		} catch (Exception except) {
			except.printStackTrace();
		}
	}

	/**
	 * Insert a record in DB
	 * 
	 * @param id
	 * @param restName
	 * @param cityName
	 */
	private static void insertRestaurants(int id, String restName,
			String cityName) {
		try {
			stmt = conn.createStatement();
			stmt.execute("insert into " + tableName + " values (" + id + ",'"
					+ restName + "','" + cityName + "')");
			stmt.close();
		} catch (SQLException sqlExcept) {
			sqlExcept.printStackTrace();
		}
	}

	/**
	 * Select all the details in Restaurants table and display in console
	 */
	private static void selectRestaurants() {
		try {
			stmt = conn.createStatement();
			ResultSet results = stmt.executeQuery("select * from " + tableName);
			ResultSetMetaData rsmd = results.getMetaData();
			int numberCols = rsmd.getColumnCount();
			for (int i = 1; i <= numberCols; i++) {
				// print Column Names
				System.out.print(rsmd.getColumnLabel(i) + "\t\t");
			}

			System.out
					.println("\n-------------------------------------------------");

			while (results.next()) {
				int id = results.getInt(1);
				String restName = results.getString(2);
				String cityName = results.getString(3);
				System.out.println(id + "\t\t" + restName + "\t\t" + cityName);
			}
			results.close();
			stmt.close();
		} catch (SQLException sqlExcept) {
			sqlExcept.printStackTrace();
		}
	}

	/**
	 * Close the connection
	 */
	private static void shutdown() {
		try {
			if (stmt != null) {
				stmt.close();
			}
			if (conn != null) {
				DriverManager.getConnection(dbURL + ";shutdown=true");
				conn.close();
			}
		} catch (SQLException sqlExcept) {

		}

	}
}

/*
 * 
 * DB TEST QUERY
 * 

CREATE table APP.EMPLOYES (EMP_ID INT PRIMARY KEY, EMP_NME VARCHAR(30), EMP_DEPT VARCHAR(100));
commit;

CREATE table APP.RESTAURANTS (ID INT PRIMARY KEY, REST_NAME VARCHAR(30), CITY_NAME VARCHAR(100));
commit;

INSERT INTO APP.EMPLOYES (EMP_ID, EMP_NME, EMP_DEPT) values
(11111111,'AMIT','MANAGER');

select * from APP.EMPLOYES;
 
 
 */
 

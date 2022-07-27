package beanDAO;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectToFP {
	private String jdbcURL = "jdbc:mysql://localhost:3306/finalproject?useSSL=false";
	private String jdbcUsername = "root";
	private String jdbcPassword ="12345678";
	
	public Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(jdbcURL,jdbcUsername,jdbcPassword);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("connection error!");
			e.printStackTrace();
		}
		return connection;
	}
}

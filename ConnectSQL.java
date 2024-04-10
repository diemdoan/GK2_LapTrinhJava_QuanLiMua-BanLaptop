package gk2_QuanLiMuaBanLaptop;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectSQL {
	private static final String DB_URL = "jdbc:mysql://localhost:3306/shoplaptop";
	private static final String DB_USER = "root";
	private static final String DB_PASSWORD = "nam19012005";
	//nam19012005
	//1234

	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
	}

}

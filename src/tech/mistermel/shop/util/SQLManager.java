package tech.mistermel.shop.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLManager {

	private String host, username, password, database;
	private int port;
	
	public SQLManager(String host, String username, String password, String database, int port) {
		this.host = host;
		this.username = username;
		this.password = password;
		this.database = database;
		this.port = port;
	}
	
	public Connection getConnection() {
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			return DriverManager.getConnection("jdbc:mysql://" + this.host + ":" + this.port + "/" + this.database, this.username, this.password);
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}
	
}

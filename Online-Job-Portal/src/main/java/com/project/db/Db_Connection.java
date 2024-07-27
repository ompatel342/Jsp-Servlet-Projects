package com.project.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Db_Connection {
	
	private static Connection con;
	
	
	public static Connection get_conn() throws SQLException
	{ 
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/online_job_portal","root","OmPatel@5656");
			
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}
		return con;
	}

}

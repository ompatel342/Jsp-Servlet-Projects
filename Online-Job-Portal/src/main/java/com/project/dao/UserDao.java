package com.project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.project.entity.User;

public class UserDao {
	
	private Connection con;

	public UserDao(Connection con) {
		super();
		this.con = con;
	}


	
	public  boolean  Register_User(User u)
	{
		boolean b=false;
		try {
		
			String query="insert into user(name,email,password,qualification,role) values(?,?,?,?,?)";
			PreparedStatement pstmt=con.prepareStatement(query);
			
			pstmt.setString(1, u.getName());
			pstmt.setString(2,u.getEmail());
			pstmt.setString(3, u.getPassword());
			pstmt.setString(4,u.getQualification());
			pstmt.setString(5, u.getRole());
			
			int temp=pstmt.executeUpdate();
			
			if(temp==1)
			{
				b=true;
			}
		
		
		
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return b;
	}
	
	public User Login_User(String email,String Password)
	{
		User u=null;
		try {
		String query="select * from user where email=? and password=?";
		PreparedStatement pstmt=con.prepareStatement(query);
		
		pstmt.setString(1, email);
		pstmt.setString(2, Password);
		
		ResultSet rs=pstmt.executeQuery();
		while(rs.next())
		{
			u=new User();
			u.setId(rs.getInt(1));
			u.setName(rs.getString(2));
			u.setEmail(rs.getString(3));
			u.setPassword(rs.getString(4));
			u.setQualification(rs.getString(5));
			u.setRole(rs.getString(6));
			
		}
	}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return u;
	}

}

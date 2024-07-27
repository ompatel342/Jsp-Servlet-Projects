package com.project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.project.entity.Jobs;

public class JobDao {
	
	private Connection con;

	public JobDao(Connection con) {
		super();
		this.con = con;
	}
	
	public boolean add_jobs(Jobs j)
	{
		boolean b=false;
		String Query="insert into jobs(title,description,category,status,location) values(?,?,?,?,?)";
		try {
			PreparedStatement pstmt =con.prepareStatement(Query);
			
			pstmt.setString(1,j.getTitle());
			pstmt.setString(2,j.getDecription());
			pstmt.setString(3,j.getCategory());
			pstmt.setString(4,j.getStatus());
			pstmt.setString(5,j.getLocation());
			
			int i=pstmt.executeUpdate();
			
			if(i==1)
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
	
	public List<Jobs> view_jobs() throws SQLException
	{
		List<Jobs> list=new ArrayList<Jobs>();
		String sql="select * from jobs order by id desc";
		Jobs j=null;
		PreparedStatement pstmt =con.prepareStatement(sql);
		ResultSet rs=pstmt.executeQuery();
		
		while(rs.next())
		{
			j=new Jobs();
			
			j.setId(rs.getInt(1));
			j.setTitle(rs.getString(2));
			j.setDecription(rs.getString(3));
			j.setCategory(rs.getString(4));
			j.setStatus(rs.getString(5));
			j.setLocation(rs.getString(6));
			j.setPdate(rs.getTimestamp(7)+"");
			
			list.add(j);
			
		}
		
		return list;
	}
	
	
	public List<Jobs> view_jobs_user() throws SQLException
	{
		List<Jobs> list=new ArrayList<Jobs>();
		String sql="select * from jobs where status=? order by id desc";
		Jobs j=null;
		PreparedStatement pstmt =con.prepareStatement(sql);
		pstmt.setString(1,"Active");
		ResultSet rs=pstmt.executeQuery();
		
		while(rs.next())
		{
			j=new Jobs();
			
			j.setId(rs.getInt(1));
			j.setTitle(rs.getString(2));
			j.setDecription(rs.getString(3));
			j.setCategory(rs.getString(4));
			j.setStatus(rs.getString(5));
			j.setLocation(rs.getString(6));
			j.setPdate(rs.getTimestamp(7)+"");
			
			list.add(j);
			
		}
		
		return list;
	}
	
	public Jobs view_jobs_by_id(int id) throws SQLException
	{
		String sql="select * from jobs where id=?";
		Jobs j=null;
		PreparedStatement pstmt =con.prepareStatement(sql);
		pstmt.setInt(1, id);
		ResultSet rs=pstmt.executeQuery();
		
		while(rs.next()) {
 		
			j=new Jobs();
			
			j.setId(rs.getInt(1));
			j.setTitle(rs.getString(2));
			j.setDecription(rs.getString(3));
			j.setCategory(rs.getString(4));
			j.setStatus(rs.getString(5));
			j.setLocation(rs.getString(6));
			j.setPdate(rs.getTimestamp(7)+"");
	}		
			
		
		return j;
	}
	
	public boolean update_jobs(Jobs j)
	{
		boolean b=false;
		String Query="update jobs set title=?,description=?,category=?,status=?,location=? where id=?";
		try {
			PreparedStatement pstmt =con.prepareStatement(Query);
			
			pstmt.setString(1,j.getTitle());
			pstmt.setString(2,j.getDecription());
			pstmt.setString(3,j.getCategory());
			pstmt.setString(4,j.getStatus());
			pstmt.setString(5,j.getLocation());
			pstmt.setInt(6,j.getId());
			
			int i=pstmt.executeUpdate();
			
			if(i==1)
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
	
	public boolean delete_jobs(int id)
	{
		boolean b=false;
		
		String Query="delete from jobs where id=?";
		try {
			PreparedStatement pstmt =con.prepareStatement(Query);
			pstmt.setInt(1, id);
			
			int i=pstmt.executeUpdate();
			
			if(i==1)
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

}

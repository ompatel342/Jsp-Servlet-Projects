package com.project.servlet;

import java.io.IOException;
import java.sql.SQLException;

import com.project.dao.JobDao;
import com.project.db.Db_Connection;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/deletejob")
public class DeletejobServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
		    
			int id=Integer.parseInt(req.getParameter("id"));
		 
			HttpSession session=req.getSession();
		
			JobDao jd =new JobDao(Db_Connection.get_conn());
			boolean b=jd.delete_jobs(id);
			
			if(b)
			{
				session.setAttribute("msg", "Job Deleted Successfully");
				resp.sendRedirect("view_jobs.jsp");
			}
			else
			{
				session.setAttribute("msg", "Job updated Successfully");
				resp.sendRedirect("view_jobs.jsp");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}

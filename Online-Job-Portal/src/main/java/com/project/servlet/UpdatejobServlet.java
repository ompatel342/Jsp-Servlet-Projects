package com.project.servlet;

import java.io.IOException;
import java.sql.Connection;

import com.project.dao.JobDao;
import com.project.db.Db_Connection;
import com.project.entity.Jobs;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/updatejob")
public class UpdatejobServlet extends HttpServlet {
   
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			
			int id=Integer.parseInt(req.getParameter("id"));
			String title=req.getParameter("title");
			String location=req.getParameter("location");
			String category=req.getParameter("category");
			String status=req.getParameter("status");
			String description=req.getParameter("desc"); 
			Connection con=Db_Connection.get_conn();
			
		    
			Jobs j=new Jobs();
			j.setId(id);
			j.setTitle(title);
			j.setLocation(location);
			j.setCategory(category);
			j.setStatus(status);
			j.setDecription(description);
			
			HttpSession session=req.getSession();
			
			JobDao jd=new JobDao(con);
			boolean b=jd.update_jobs(j);
			
			if(b)
			{
				session.setAttribute("msg", "Job updated Successfully");
				resp.sendRedirect("view_jobs.jsp");
			}
			else
			{
				session.setAttribute("msg", "Something Went Wrong");
				resp.sendRedirect("view_jobs.jsp");
			}
			}
			catch (Exception e) {
				e.printStackTrace();
			}
	}
}

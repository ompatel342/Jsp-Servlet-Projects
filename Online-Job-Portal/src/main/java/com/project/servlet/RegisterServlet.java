package com.project.servlet;

import java.io.IOException;

import com.project.dao.JobDao;
import com.project.dao.UserDao;
import com.project.db.Db_Connection;
import com.project.entity.Jobs;
import com.project.entity.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


@WebServlet("/signup")
public class RegisterServlet extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			String name=req.getParameter("name");
			String qualification=req.getParameter("qua");
			String email=req.getParameter("em");
			String password=req.getParameter("ps");
			
			User u=new User();
			
			u.setName(name);
			u.setQualification(qualification);
			u.setEmail(email);
			u.setPassword(password);
			u.setRole("user");
			
			HttpSession session =req.getSession();
			
			
			UserDao ud=new UserDao(Db_Connection.get_conn());
			boolean b=ud.Register_User(u);
			
			if(b)
			{
				session.setAttribute("msg", "User Registered Successfully");
				resp.sendRedirect("signup.jsp");
			}
			else
			{
				session.setAttribute("msg", "Something Went Wrong");
				resp.sendRedirect("signup.jsp");
			}
			
			
			
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}

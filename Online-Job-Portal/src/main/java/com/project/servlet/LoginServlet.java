package com.project.servlet;

import java.io.IOException;

import com.project.dao.UserDao;
import com.project.db.Db_Connection;
import com.project.entity.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		final String  admin_email="admin@gmail.com";
		final String admin_password="admin@123";
		
		try {
			String email=req.getParameter("email");
			String password=req.getParameter("password");
			User u=new User();
			HttpSession session=req.getSession();
			
			if(admin_email.equals(email) && admin_password.equals(password))
			{
				session.setAttribute("userobj", u);
				u.setRole("admin");
				resp.sendRedirect("admin.jsp");
			}
			else
			{
				UserDao udao=new UserDao(Db_Connection.get_conn());
			    User user=udao.Login_User(email, password);
				
				if(user!=null)
				{
					session.setAttribute("userobj",u);
					u.setRole("user");
					resp.sendRedirect("user.jsp");
				}
				else
				{
					session.setAttribute("msg","email or password incorrect");
					resp.sendRedirect("login.jsp");
				}
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}

package com.revature;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		String action = request.getParameter("action");
		validateLogin(request, response);
	}
	
	private void validateLogin(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		int id = Integer.parseInt(request.getParameter("id"));
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		try {
			EmployeeDao dao = EmployeeDAOFactory.getEmployeeDao();
			Employee existingEmp = dao.getEmployeeById(id);
			
			if (existingEmp == null) {
				out.println("<script type=\"text/javascript\">");
				out.println("alert('Sorry, no user exists with that ID.');");
				out.println("window.location.href='login.jsp';");
				out.println("</script>");
				
			} else {				
				if (!existingEmp.getUsername().equals(username) || 
						!existingEmp.getPassword().equals(password)) {
					out.println("<script type=\"text/javascript\">");
					out.println("alert('Invalid username or password.');");
					out.println("window.location.href='login.jsp';");
					out.println("</script>");
				} else {
					out.println("<script type=\"text/javascript\">");
					out.println("alert('Successfully logged in!');");
					out.println("window.location.href='employee-list.jsp';");
					out.println("</script>");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);	
	}
}

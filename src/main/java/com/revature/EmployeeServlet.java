package com.revature;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import com.google.gson.Gson;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EmployeeServlet
 */
@WebServlet("/EmployeeServlet")
public class EmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private Gson gson = new Gson();
    /**
     * Default constructor. 
     */
	
	
    public EmployeeServlet() 
    {
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		String action = request.getParameter("action");
		
        try {
            switch (action)
            {
            	case "getall":
            		GetAllEmployees(request, response);
            	break;          
                case "add":
                    addEmployee(request, response);
                    break;
                case "delete":
                    deleteEmployee(request, response);
                    break;
                case "update":
                    updateEmployee(request, response);
                    break;
                default:
                	GetAllEmployees(request, response);
                    break;
            }
        } 
        catch (Exception ex) {
            throw new ServletException(ex);
        }
		
		
		
		
	}

	private void updateEmployee(HttpServletRequest request, HttpServletResponse response) {
		response.setContentType("text/html");
		
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String type = request.getParameter("type");
		
		Employee employee = new Employee();
		employee.setId(id);
		employee.setName(name);
		employee.setEmail(email);
		employee.setUsername(username);
		employee.setPassword(password);
		employee.setType(type);

		
		try {
			EmployeeDao dao = EmployeeDAOFactory.getEmployeeDao();
			dao.updateEmployee(employee);
			response.sendRedirect("employee-list.jsp");
			System.out.println("employee record updated successfully");
		} catch (SQLException e) {
			System.out.println("something went wrong1");
			e.printStackTrace();
		}catch (ClassNotFoundException e1) {
			System.out.println("something went wrong2");
			e1.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}	
	}

	private void deleteEmployee(HttpServletRequest request, HttpServletResponse response) {
		
		response.setContentType("text/html");
		
		int id = Integer.parseInt(request.getParameter("id"));
		
		Employee employee = new Employee();
		employee.setId(id);
		
		try {
			EmployeeDao dao = EmployeeDAOFactory.getEmployeeDao();
			dao.deleteEmployee(employee);
			System.out.println("employee record deleted successfully");
		} catch (SQLException e) {
			System.out.println("something went wrong1");
			e.printStackTrace();
		}catch (ClassNotFoundException e1) {
			System.out.println("something went wrong2");
			e1.printStackTrace();
		}	
	}
	

	private void addEmployee(HttpServletRequest request, HttpServletResponse response) {
		response.setContentType("text/html");
		
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String type = request.getParameter("type");
		
		Employee employee = new Employee();
		employee.setName(name);
		employee.setEmail(email);
		employee.setUsername(username);
		employee.setPassword(password);
		employee.setType(type);
		
		
		try {
			EmployeeDao dao = EmployeeDAOFactory.getEmployeeDao();
			dao.addEmployee(employee);
			response.sendRedirect("employee-list.jsp");
			System.out.println("employee record inserted successfully");
		} catch (SQLException e) {
			System.out.println("something went wrong1");
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	
	}

	private void GetAllEmployees(HttpServletRequest request, HttpServletResponse response) throws Exception {
		try {
			EmployeeDao dao = EmployeeDAOFactory.getEmployeeDao();
			List<Employee> employees = dao.getAllEmployee();
			String jsonEmps = this.gson.toJson(employees);
			PrintWriter out = response.getWriter();
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			out.print(jsonEmps);
			out.flush();
		} catch (SQLException e) {
			System.out.println("something went wrong1");
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
		
	}

}

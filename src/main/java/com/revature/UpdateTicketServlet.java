package com.revature;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.google.gson.Gson;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/UpdateTicketServlet")
public class UpdateTicketServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		try {
			if (action.equals("updateTicket")) {
				updateTicket(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void updateTicket(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ClassNotFoundException {
		response.setContentType("text/html");
		ITicketDAO dao = TicketDAOFactory.getTicketDao();
		Ticket ticket = new Ticket();

		int id = Integer.parseInt(request.getParameter("id"));
		String status = request.getParameter("ticket_status");

		System.out.println(id);
		System.out.println(status);

		try {
			ticket = dao.getTicketById(id);
			ticket.setStatus(status);
			dao.updateTicket(ticket);
			response.sendRedirect("ticketList.jsp");
			System.out.println("Ticket updated!");
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		// get ticket values
		int ticketId = Integer.parseInt(request.getParameter("ticket_id").trim());
		int employeeId = Integer.parseInt(request.getParameter("employee_id"));
		String status = request.getParameter("ticket_status");
		String type = request.getParameter("ticket_type");
		double amt = Double.parseDouble(request.getParameter("reimbursement_amount"));
		String desc = request.getParameter("ticket_description");

		// get the ticket by Id
		//Ticket ticket = session.get(Ticket.class, ticketId);
		Ticket ticket = new Ticket();
		Employee employee = null;
		
		try {
			EmployeeDao empDao = EmployeeDAOFactory.getEmployeeDao();
			employee = empDao.getEmployeeById(employeeId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		// create new ticket values with values from request
		ticket.setEmployeeId(employee);
		ticket.setStatus(status);
		ticket.setType(type);
		ticket.setDescription(desc);
		ticket.setReimbursementAmount(amt);
		ticket.setTimestamp(new Date());

		try {
			ITicketDAO dao = TicketDAOFactory.getTicketDao();
			dao.updateTicket(ticket);
			response.sendRedirect("ticketList.jsp");
			System.out.println("Ticket updated!");
		} catch (Exception e) {
			System.out.println("Something went wrong");
			e.printStackTrace();
		}
	}
}

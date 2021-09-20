package com.revature;

import java.util.Date;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class AddTicketServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) {
		response.setContentType("text/html");

		// TODO: use this once user_id available via login
		//int employeeId = Integer.parseInt(request.getParameter("user_id"));
		int employeeId = 2; // placeholder
		double amt = Double.parseDouble(request.getParameter("reimbursement_amount"));
		String desc = request.getParameter("ticket_description");
		String type = request.getParameter("ticket_type");

		try {
			// create a new ticket
			Ticket ticket = new Ticket();
			EmployeeDao empDao = EmployeeDAOFactory.getEmployeeDao();
			Employee employee = empDao.getEmployeeById(employeeId);
			// update ticket values with values from request
			ticket.setEmployeeId(employee);
			ticket.setStatus("pending");
			ticket.setType(type);
			ticket.setDescription(desc);
			ticket.setReimbursementAmount(amt);
			ticket.setTimestamp(new Date());


			ITicketDAO dao = TicketDAOFactory.getTicketDao();
			dao.addTicket(ticket);
			response.sendRedirect("ticketList.jsp");
			System.out.println("Ticket updated!");
		} catch (Exception e) {
			System.out.println("Something went wrong");
			e.printStackTrace();
		}

	}
}

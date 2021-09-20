package com.revature;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class DeleteTicketServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		// get ticket values
		int ticketId = Integer.parseInt(request.getParameter("ticket_id").trim());
		int employeeId = Integer.parseInt(request.getParameter("user_id"));
		String status = request.getParameter("ticket_status");
		String type = request.getParameter("ticket_type");
		double amt = Double.parseDouble(request.getParameter("reimbursement_amount"));
		String desc = request.getParameter("ticket_description");

		try {
			// get the ticket by Id
			//Ticket ticket = session.get(Ticket.class, ticketId);
			Ticket ticket = new Ticket();
			EmployeeDao empDao = EmployeeDAOFactory.getEmployeeDao();
			Employee employee = empDao.getEmployeeById(employeeId);

			// create new ticket values with values from request
			ticket.setEmployeeId(employee);
			ticket.setStatus(status);
			ticket.setType(type);
			ticket.setDescription(desc);
			ticket.setReimbursementAmount(amt);
			ticket.setTimestamp(new Date());


			ITicketDAO dao = TicketDAOFactory.getTicketDao();
			dao.deleteTicket(ticket);
			System.out.println("Ticket updated!");
		} catch (Exception e) {
			System.out.println("Something went wrong");
			e.printStackTrace();
		}


		// send empty response
		//response.sendRedirect("");
	}
}

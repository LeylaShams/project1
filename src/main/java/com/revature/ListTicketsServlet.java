package com.revature;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import com.google.gson.Gson;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/ListTicketsServlet")
public class ListTicketsServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		String action = request.getParameter("action");
		try {
			if (action.equals("getTickets")) {
				getAllTickets(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	private void getAllTickets(HttpServletRequest request, HttpServletResponse response) throws Exception {
		try {
			ITicketDAO dao = TicketDAOFactory.getTicketDao();
			List<Ticket> tickets = dao.getTickets();
			
			String jsonStr = new Gson().toJson(tickets);
			PrintWriter out = response.getWriter();
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			
			out.print(jsonStr);
			out.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}	
}

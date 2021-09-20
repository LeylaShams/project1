package com.revature;

import java.sql.SQLException;
import java.util.List;

public interface ITicketDAO {
	void addTicket(Ticket ticket);
	void updateTicket(Ticket ticket) throws SQLException;
	void deleteTicket(Ticket ticket) throws SQLException;
	List<Ticket> getTickets() throws SQLException;
	Ticket getTicketById(int id) throws SQLException;
}

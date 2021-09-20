package com.revature;

public class TicketDAOFactory {
	private static TicketDAOImpl dao;
	
	private TicketDAOFactory() {}
	
	public static ITicketDAO getTicketDao() throws ClassNotFoundException {
		if (dao == null)
			dao = new TicketDAOImpl();
		return dao;
	}
}

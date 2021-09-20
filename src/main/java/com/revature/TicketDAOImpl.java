package com.revature;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class TicketDAOImpl implements ITicketDAO {	
	private Session session = null;
	private Transaction transaction = null;
	private Configuration cfg;
	private SessionFactory sessionFactory;
	
	public TicketDAOImpl() {
		this.session = HibernateSessionFactory.getFactory().openSession();
		cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		sessionFactory = cfg.buildSessionFactory();
	}
	
	public void addTicket(Ticket ticket) {
		// open a session
		Session session = sessionFactory.openSession();
		
		// being a transaction 
		Transaction transaction = session.beginTransaction();
		
		// save ticket
		session.save(ticket);
		
		// commit transaction
		transaction.commit();
		
		// close session
		session.close();
		
	}

	public void updateTicket(Ticket ticket) throws SQLException {
		// open a session
		Session session = sessionFactory.openSession();
		
		// being a transaction 
		Transaction transaction = session.beginTransaction();
		
		// save/update ticket
		session.saveOrUpdate(ticket);
		
		// commit transaction
		transaction.commit();
		
		// close session
		session.close();
		
	}

	public void deleteTicket(Ticket ticket) throws SQLException {
		// open a session
		Session session = sessionFactory.openSession();
		
		// being a transaction 
		Transaction transaction = session.beginTransaction();
		
		// delete ticket
		session.remove(ticket);
		
		// commit transaction
		transaction.commit();
		
		// close session
		session.close();
		
	}

	public List<Ticket> getTickets() throws SQLException {
		Session session = sessionFactory.openSession();
		Query<Ticket> ticket = session.createQuery("from Ticket");
		
		List<Ticket> tickets = ticket.list();
		return tickets;
	}
	
	public Ticket getTicketById(int id) throws SQLException {
		Session session = sessionFactory.openSession();
		Ticket ticket = (Ticket)session.get(Ticket.class, id);
		
		return ticket;
	}
}

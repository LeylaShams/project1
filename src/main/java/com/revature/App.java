package com.revature;

import java.sql.SQLException;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App {

	public static void main( String[] args )
	{
		
//		System.out.println("Project started...");
//		
//		// create a configuration object
//		Configuration cfg = new Configuration();
//
//		// read the configuration and load in the object
//		cfg.configure("hibernate.cfg.xml");
//
////		// create factory
//		SessionFactory factory = cfg.buildSessionFactory();
////		
////		// open the session
//		Session session = factory.openSession();
//		// begin the transaction
//		Transaction t = session.beginTransaction();
//
//		
//		
//		ITicketDAO ticketDao = new TicketDAOImpl();
//		
//		// create employee
//      Employee employee =new Employee();
//      employee.setId(3);
//      employee.setName("Lily");
//      employee.setEmail("s@gmail.com");
//      employee.setUsername("sara23");
//      employee.setPassword("123");
//      EmployeeDao eDao = new EmployeeDaoImpl();
//		
//		
//		// create ticket
//		Ticket ticket = new Ticket();
//		ticket.setEmployeeId(employee);
//		ticket.setStatus("pending");
//		ticket.setType("accepted"); //pending/approved/rejected
//		ticket.setReimbursementAmount(10);
//		ticket.setDescription("placeholder description");
//		ticket.setTimestamp(new Date());
//
//      	try {
////			eDao.addEmployee();
//      		ticketDao.addTicket(ticket);
//		} catch (Exception e) {
//			
//			e.printStackTrace();
//		}
//		// save the ticket
//		session.save(employee);
////
//		// commit the transaction/		
//		t.commit();
//		// close the session
//		
////        Query query = session.createQuery("from EMPLOYEE");
////        java.util.List list = query.list();
////        System.out.println(list);
//		
//		session.close();
//		
//		
//		
//		
//	}
}
}


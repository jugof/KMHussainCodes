package example.hibernate.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import example.hibernate.entity.Doctor;

public class RecordInsertionExampleMain {

	public static void main(String[] args) {
		// Configuring Hibernate
		Configuration hibernateConfig = 
				new Configuration();
		hibernateConfig = hibernateConfig.configure();
		
		//Obtaining SessionFactory
		SessionFactory hibernateFactory = 
		hibernateConfig.buildSessionFactory();
		
		//Obtaining Session
		Session hibernateSession = 
		hibernateFactory.openSession();
		
		//Creating Entity Class Object
		Doctor doctorRef = 
		new Doctor(102, "Rashmi Joshi", "Urologist");
		
		//Obtaining and Starting Transaction.
		Transaction hibernateTransaction = 
		hibernateSession.beginTransaction();
		
		//Storing the Entity Object
		hibernateSession.persist(doctorRef);
			
		//Committing the Transaction
		hibernateTransaction.commit();
		
		//Closing the Session
		hibernateSession.close();
		
		//Closing the SessionFactory
		hibernateFactory.close();
		
		System.out.println("Record added successfully.");
		
		

	}

}

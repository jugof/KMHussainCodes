package example.hibernate.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import example.hibernate.entity.Doctor;
import example.hibernate.utils.HibernateUtils;

public class RecordInsertionExampleMain2 {

	public static void main(String[] args) {
		try(
				SessionFactory factory = 
				HibernateUtils.getSessionFactory();
				Session hibSession = factory.openSession()
				){
			Doctor doctorRef = 
			new Doctor(106, "Amit Joshi", "Cardiologist");
			Transaction tx = hibSession.beginTransaction();
				hibSession.persist(doctorRef);
			tx.commit();
			System.out.println("Record Added.");
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		
		
		

	}

}

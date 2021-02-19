package in.edac;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateDemo {
	public static void main(String[] args) {
		
		// Making Your Progarm hibernate Aware
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		// new Configuration().configure().buildSessionFactory();
		
		System.out.println("HBM2DDL");
	}
	
	
}

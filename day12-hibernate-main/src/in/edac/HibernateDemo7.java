package in.edac;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class HibernateDemo7 {
	public static final SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

	public static void main(String[] args) {
		Session session =  sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		
		for(int i=0; i<10; i++) {
			User user = new User();
			user.setUsername("Test " + i);
			user.setEmail("test@gmail.com" + i);
			
			session.save(user);
		}
		
		
		tx.commit();
		session.close();
	}
	
	
	
}

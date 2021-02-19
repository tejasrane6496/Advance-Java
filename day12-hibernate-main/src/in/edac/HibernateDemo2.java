package in.edac;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class HibernateDemo2 {
	public static final SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

	public static void main(String[] args) {
		Transaction tx = null;
		try {
			Session session =  sessionFactory.openSession();
			
			// diabling the default nauter :: autocmmit;
			tx = session.beginTransaction();
			
			session.save("A");
			
			// ....more opetaion
			
			session.save("B");
			
			
			tx.commit();
			session.close();
		} catch(Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
		
	}

}

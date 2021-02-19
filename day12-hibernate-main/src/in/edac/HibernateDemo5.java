package in.edac;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

// DQL
public class HibernateDemo5 {
	public static final SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

	public static void main(String[] args) {
		Session session =  sessionFactory.openSession();
	
		// DQL
		List<Person> list = session.createQuery("FROM Person", Person.class).list();
		System.out.println(list);
		
		session.close();
	}
	
	
	
}

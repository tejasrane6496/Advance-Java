package in.edac;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class HibernateDemo4 {
	public static final SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

	public static void main(String[] args) {
		// create();
		// update();
		// delete();
		udpateSpecificColumn();
	}
	
	
	public static void udpateSpecificColumn() {
		Session session =  sessionFactory.openSession();
		Transaction tx =  session.beginTransaction();
		
		Person p = session.find(Person.class, 2);
		p.setFirstName("INDIA");
		
		session.update(p);
		
		tx.commit();
		session.close();
	}
	
	
	public static void delete() {
		Session session =  sessionFactory.openSession();
		Transaction tx =  session.beginTransaction();
		
		Person p = new Person();
		p.setId(1);
		
		session.delete(p);
		
		tx.commit();
		session.close();
	}
	
	
	public static void update() {
		Session session =  sessionFactory.openSession();
		Transaction tx =  session.beginTransaction();
		
		Person p = new Person();
		p.setId(2);
		p.setFirstName("india");
		p.setMiddleName("bharat");
		p.setLastName("hindustan");
		
		session.update(p);
		
		tx.commit();
		session.close();
	}
	
	
	public static void create() {
		
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();

		Person p = new Person();
		p.setFirstName("edac");
		p.setMiddleName("edac middle name");
		p.setLastName("edac lst name");
		
		// DML :: CREAET/INSERT
		session.save(p);
		
		tx.commit();
		session.close();
	}

}

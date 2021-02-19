package in.edac;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

// 
public class HibernateDemo6 {
	public static final SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

	public static void main(String[] args) {
		dqlSqlDemo3();
	}
	
	
	// DQL :: SELECT
	public static void dqlSqlDemo() {
		Session session = sessionFactory.openSession(); 
		
		String sql = "SELECT * FROM USER";
		List<User> list = session.createNativeQuery(sql, User.class).getResultList();
		
		list.stream().map(p -> p.getUsername()).forEach(System.out::println);
		
		session.close();
	}
	
	
	public static void dqlSqlDemo1() {
		Session session = sessionFactory.openSession(); 
		
		// ? => Positional Paramter
		String sql = "SELECT * FROM USER WHERE id=?";
		
		List<User> list =  session.createNativeQuery(sql, User.class)
									.setParameter(1, 10)
									.list();
		
		list.stream().map(p -> p.getUsername()).forEach(System.out::println);
		session.close();
	}
	
	
	public static void dqlSqlDemo2() {
		Session session = sessionFactory.openSession(); 
		
		// ? => :id => Named Parameter 
		String sql = "SELECT * FROM USER WHERE id=:id";
		
		List<User> list =  session.createNativeQuery(sql, User.class)
									.setParameter("id", 11)
									.list();
		
		list.stream().map(p -> p.getUsername()).forEach(System.out::println);
		session.close();
	}
	
	
	
	// DML :: INSERT
	public static void dqlSqlDemo3() {
		Session session = sessionFactory.openSession(); 
		Transaction tx = session.beginTransaction();
		
		String sql = "INSERT INTO USER (id, username, email) VALUES (:id, :username, :email)";
		session.createNativeQuery(sql, User.class)
			.setParameter("id", 999)
			.setParameter("username", "INDIA")
			.setParameter("email", "india@gmail.com")
			.executeUpdate();
		
		
		tx.commit();
		session.close();
	}
	
	
	
}

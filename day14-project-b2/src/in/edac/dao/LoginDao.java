package in.edac.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class LoginDao {
	private static final SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
	
	public boolean authenticateUser(User user) {
		Session session = sessionFactory.openSession();

		
		String sql = "SELECT * FROM user WHERE username=:username AND password=:password";
		User dbuser =  session.createNativeQuery(sql, User.class)
				.setParameter("username", user.getUsername())
				.setParameter("password", user.getPassword())
				.getSingleResult();
		session.close();
		
		if(dbuser != null) {
			return true;
		} else {
			return false;
		}
	}
}

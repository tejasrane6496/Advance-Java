package in.edac;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	public static final SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
}

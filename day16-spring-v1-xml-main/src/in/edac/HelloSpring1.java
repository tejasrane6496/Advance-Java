package in.edac;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloSpring1 {
	// Spring Aware
	private static final ApplicationContext context =  new ClassPathXmlApplicationContext("spring.xml");
	
	public static void main(String[] args) {
		System.out.println("Hello Spring!!!");
		
		UserDao userDao = (UserDao) context.getBean("obj1");
		System.out.println(userDao);
		
		
		UserDao userDao1 = (UserDao) context.getBean("obj1");
		System.out.println(userDao1);
		
		userDao.sayHi();
		
	}
}

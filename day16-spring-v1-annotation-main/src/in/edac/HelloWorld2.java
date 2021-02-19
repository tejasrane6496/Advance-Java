package in.edac;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloWorld2 {
	static final ApplicationContext context =  new ClassPathXmlApplicationContext("spring.xml");
	
	public static void main(String[] args) {
		System.out.println("Hello WOrld!!!");
		
		
		UserDao userDao = context.getBean("obj1", UserDao.class);
		System.out.println(userDao);
		
		UserDao userDao1 = context.getBean("obj1", UserDao.class);
		System.out.println(userDao1);
		
	}
}

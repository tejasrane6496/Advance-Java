package in.edac;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloSpring2 {
	// Spring Aware
	private static final ApplicationContext context =  new ClassPathXmlApplicationContext("spring.xml");
	
	public static void main(String[] args) {
		System.out.println("Hello Spring!!!");
		
		UserDao userDao = context.getBean("obj1", UserDao.class);
		System.out.println(userDao);
		
		userDao.sayHi();
		
	}
}

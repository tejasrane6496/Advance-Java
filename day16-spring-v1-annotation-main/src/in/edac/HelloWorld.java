package in.edac;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloWorld {
	static final ApplicationContext context =  new ClassPathXmlApplicationContext("spring.xml");
	
	@Autowired
	private UserDao userDao;
	
	public static void main(String[] args) {
		System.out.println("Hello WOrld!!!");
		
		
		// System.out.println(userDao);
	}
}

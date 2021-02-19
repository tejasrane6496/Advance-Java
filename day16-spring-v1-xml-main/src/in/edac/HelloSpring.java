package in.edac;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloSpring {
	// Spring Aware
	private static final ApplicationContext context =  new ClassPathXmlApplicationContext("spring.xml");
	
	public static void main(String[] args) {
		System.out.println("Hello Spring!!!");
		
		System.out.println(context);
	}
}

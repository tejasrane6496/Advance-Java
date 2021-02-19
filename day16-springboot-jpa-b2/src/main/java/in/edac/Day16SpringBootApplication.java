package in.edac;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Day16SpringBootApplication implements CommandLineRunner {
	
	@Autowired
	private UserRepository userRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(Day16SpringBootApplication.class, args);
	}

	
	@Override
	public void run(String... args) throws Exception {
		System.out.println("Hello Spring, this is run method");
		
		queryDemo();
	}
	
	
	public void queryDemo() {
		
		// List<User> list=  userRepository.findByUsername("mumbai");
		// list.stream().map(User::getUsername).forEach(System.out::println);
		
		
		// User user = userRepository.findByUsernameAndPassword("asdfa", "mumbai");
		// System.out.println(user);
		// System.out.println(user.getUsername());
		
		
		List<User> list = userRepository.findByUsernameOrEmail("adfadfas", "mumbai@gmail.com");
		list.stream().map(User::getUsername).forEach(System.out::println);
	}
	
	
	public void findAllDemo() {
		List<User> list =  userRepository.findAll();
		list.stream().map(User::getUsername).forEach(System.out::println);
	}
	
	public void delete() {
		userRepository.deleteById(1);
	}
	
	
	public void findAndUpdate() {
		User user = userRepository.findById(2).get();
		user.setUsername("MUMBAIIIIIIII");
		
		userRepository.save(user);
	}
	
	
	public void update() {
		User user = new User();
		user.setId(1);
		user.setUsername("mumbaiii-delhi");
		
		
		userRepository.save(user);
	}
	
	
	public void create() {
		User user = new User("mumbai", "mumbai", "mumbai@gmail.com", "212121212");
		userRepository.save(user);
	}

}

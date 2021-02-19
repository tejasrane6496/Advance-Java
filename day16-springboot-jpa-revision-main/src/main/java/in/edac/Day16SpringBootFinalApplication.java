package in.edac;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Day16SpringBootFinalApplication implements CommandLineRunner {
	
	@Autowired
	private UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(Day16SpringBootFinalApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		findAll();
	}
	
	public void findAll() {
		List<User> list =  userRepository.findAll();
		list.stream().map(User::getUsername).forEach(System.out::println);
		
	}
	
	
	public void deleteDemo() {
		userRepository.deleteById(1);
	}
	
	public void findAndUpdate() {
		 User user = userRepository.findById(1).get();
		 user.setPassword("fasdfafadsfdsafasdfadsf");
		 
		 userRepository.save(user);
	}
	
	public void createDemo() {
		User user = new User("india", "india", "inda@gmail.com", "12122121");
		userRepository.save(user);
	}

}

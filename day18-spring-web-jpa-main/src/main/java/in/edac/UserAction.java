package in.edac;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserAction {
	
	@Autowired
	UserRepository userRepository;
	
	@PostMapping("/")
	public void createUser(User user) {
		userRepository.save(user);
	}
	
	
	@GetMapping("/")
	public List<User> getUsers() {
		return userRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public User getUser(@PathVariable int id) {
		return userRepository.findById(id).get();
	}
	
	
	@PutMapping("/{id}")
	public void updateUser(@PathVariable int id, User user) {
		userRepository.save(user);
	}
	
	
	@DeleteMapping("/{id}")
	public void deleteUser(@PathVariable int id) {
		userRepository.deleteById(id);
	}
	
	

}

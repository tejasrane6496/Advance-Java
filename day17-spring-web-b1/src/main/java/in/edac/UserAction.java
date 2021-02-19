package in.edac;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class UserAction {

	@GetMapping("/")
	public String sayHi() {
		return "Hello World";
	}
	
	
	@GetMapping("/1")
	public String sayHello() {
		return "Helloooooo";
	}
	
	@GetMapping("/2")
	public String register(String username) {
		return "Helloooooo " + username;
	}
	
	
	@GetMapping("/3")
	public String registerV1(String username, String password) {
		return username + " " + password;
	}
	
	@GetMapping("/4")
	public String registerV2(String username, String password, String email, String mobile) {
		return username + " " + password + " " + email + " " + mobile;
	}
	
}

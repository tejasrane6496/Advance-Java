package in.edac;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/hello")
public class HelloAction {

	/**
	 * http://localhost:8080/hello/
	 * @return
	 */
	@GetMapping("/")
	public String sayHello() {
		// ...do some work
		// return "/views/hello.jsp";
		return "hello";
	}
	
	
	/**
	 * http://localhost:8080/hello/1
	 * @return
	 */
	@GetMapping("/1")
	public String sayHi() {
		// /views/hi.jsp
		return "hi";
	}
	
	
	@GetMapping("/2")
	public String hellooo() {
		
		// ...logical operation
		// request.getReqeustDispatcher().forward("/views/hi.jsp");
		// response.sendRedirect("/views/hi.jsp");
		// /views/hi.jsp
		
		return "hi";
	}
	
	
	
	
	
}







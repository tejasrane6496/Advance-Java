package in.edac;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/sample")
public class SampleAction {

	/**
	 * http://localhost:8080/sample/home-view
	 * @return
	 */
	@GetMapping("/home-view")
	public String homeView() {
		// ...logical operation
		// ...data
		// request.getRequestDispatcher("/views/home.jsp").forward(request, response);
		// /views/home.jsp
		return "home";
	}
	
	
	/**
	 * http://localhost:8080/sample/home-view-v1
	 * @return
	 */
	@GetMapping("/home-view-v1")
	public ModelAndView homeViewV1() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("home");
		
		return mv;
	}
	
	
	
	/**
	 * http://localhost:8080/sample/home-view-v2
	 * @return
	 */
	@GetMapping("/home-view-v2")
	public ModelAndView homeView2() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("home");
		
		// data 
		String title = "Hello Mumbai";
		mv.addObject("title", title);
		
		return mv;
	}
	
	
	
	/**
	 * http://localhost:8080/sample/home-view-v3
	 * @return
	 */
	@GetMapping("/home-view-v3")
	public ModelAndView homeView3() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("home");
		
		// data 
		String title = "Hello Mumbai";
		mv.addObject("title", title);
		
		List<String> cityList = Arrays.asList("Delhi", "Kolkata", "Mumbai", "Chennai");
		mv.addObject("cityList", cityList);
		
		return mv;
	}
	
	
	
	@GetMapping("/home-view-v4")
	public ModelAndView homeView4() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("home");
		
		// data 
		String title = "Hello Mumbai";
		mv.addObject("title", title);
		
		List<String> cityList = Arrays.asList("Delhi", "Kolkata", "Mumbai", "Chennai");
		mv.addObject("cityList", cityList);
		
		List<User> userList = new ArrayList<User>();
		userList.add(new User(1, "virat", "@#@#", "virat@gmail.com", "323232"));
		userList.add(new User(2, "rohit", "$#$#@#", "rohit@gmail.com", "323232"));
		userList.add(new User(3, "rahul", "$#$#@#", "rahul@gmail.com", "323232"));
		
		mv.addObject("userList", userList);
		
		return mv;
	}
	
	
	@GetMapping("/home-view-v5")
	public ModelAndView homeView5(String q) {
		ModelAndView mv = new ModelAndView("home");
		
		if("1".equals(q)) {
			mv.setViewName("hello");
		} 
		
		// data 
		String title = "Hello Mumbai" + q;
		mv.addObject("title", title);
		
		List<String> cityList = Arrays.asList("Delhi", "Kolkata", "Mumbai", "Chennai");
		mv.addObject("cityList", cityList);
		
		List<User> userList = new ArrayList<User>();
		userList.add(new User(1, "virat", "@#@#", "virat@gmail.com", "323232"));
		userList.add(new User(2, "rohit", "$#$#@#", "rohit@gmail.com", "323232"));
		userList.add(new User(3, "rahul", "$#$#@#", "rahul@gmail.com", "323232"));
		
		mv.addObject("userList", userList);
		
		return mv;
	}
	
	
	
	
}

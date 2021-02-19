package in.edac.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.edac.dao.User;
import in.edac.dao.UserDao;


@WebServlet("/user-read")
public class UserControllerRead extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			UserDao dao = new UserDao();
			
			// we calling dao logic here.
			List<User> userList =  dao.readAllUser();
			
			request.setAttribute("userList", userList);
			request.getRequestDispatcher("user-list.jsp").forward(request, response);
		} catch(Exception e) {
			e.printStackTrace();
			
			// in case of error
			request.getRequestDispatcher("error.jsp").forward(request, response);
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

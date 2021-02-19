package in.edac.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.edac.dao.User;
import in.edac.dao.UserDao;


@WebServlet("/user-delete")
public class UserControllerDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String idStr = request.getParameter("id");
			int id = Integer.parseInt(idStr);
			
			UserDao dao = new UserDao();
			User user = new User();
			user.setId(id);
			
			// we calling dao logic here.
			dao.deleteUser(user);
			
			// request.getRequestDispatcher("success.jsp").forward(request, response);
			// request.getRequestDispatcher("user-read").forward(request, response);
			response.sendRedirect("/day9/user-read");
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

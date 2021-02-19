package in.edac.action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.edac.dao.RegisterDao;
import in.edac.dao.User;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/register-action")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			String email = request.getParameter("email");
			String mobile = request.getParameter("mobile");
			
			
			User user = new User(username, password, email, mobile);
			RegisterDao dao =  new RegisterDao();
			dao.createUser(user);
			
			response.sendRedirect("/day14-project/register.jsp?q=1");
		} catch(Exception e) {
			e.printStackTrace();
			response.sendRedirect("/day14-project/register.jsp?q=0");
		}
	}

}

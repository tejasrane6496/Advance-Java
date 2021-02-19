package in.edac.action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.edac.dao.LoginDao;
import in.edac.dao.User;

/**
 * Servlet implementation class LoginAction
 */
@WebServlet("/login-action")
public class LoginAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			
			LoginDao dao = new LoginDao();
			User user = new User(username, password, null, null);
			boolean check =  dao.authenticateUser(user);
			
			if(check == true) {
				response.sendRedirect("/day14-project/home.jsp");
			} else {
				throw new Exception("Auth Fails");
			}
			
		} catch(Exception e) {
			e.printStackTrace();
			response.sendRedirect("/day14-project/login.jsp?q=0");
		}
	}

}

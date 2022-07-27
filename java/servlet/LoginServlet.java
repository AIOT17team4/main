package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import beanDAO.*;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDAO userDAO;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void init() {
		userDAO = new UserDAO();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			Login(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.print("login problem!");

		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	private void Login(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<UserBean> listuserBeans = userDAO.selectAllUser();
		String account = request.getParameter("account");
		String password = request.getParameter("password");
		boolean loginsuccessful = false;
		for (UserBean ub : listuserBeans) {
			if (ub.getAccount().equals(account) && ub.getPassword().equals(password)) {
				loginsuccessful = true;
				HttpSession session = request.getSession();
				session.setAttribute("userBean", ub);
				userDAO.loginfinal(ub);
			} else {

			}
		}
		if (loginsuccessful) {

			jakarta.servlet.RequestDispatcher rDispatcher = request.getRequestDispatcher("Home.jsp");
			rDispatcher.forward(request, response);
		} else {
			jakarta.servlet.RequestDispatcher rDispatcher = request.getRequestDispatcher("error1.jsp");
			rDispatcher.forward(request, response);
		}

	}

}
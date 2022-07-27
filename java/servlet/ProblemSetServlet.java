package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import beanDAO.ProblemDAO;

/**
 * Servlet implementation class ProblemSetServlet
 */
public class ProblemSetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private ProblemDAO problemDAO;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProblemSetServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    @Override
    public void init() throws ServletException {
    	// TODO Auto-generated method stub
    	super.init();
    	problemDAO = new ProblemDAO();
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name = request.getParameter("name");
		String state = request.getParameter("state");
		String solution = request.getParameter("solution");
		HttpSession session=request.getSession();
		String account="test1";
		try{
		account = (String)session.getAttribute("account");
		if(account==null){
			account="test1";
		}
		}catch(Exception e){}
		String author = account;
		problemDAO.insertData(name, state, solution, author);
		request.getRequestDispatcher("Home.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

package servlet;

import java.io.IOException;

import beanDAO.CarDataDAO;
import beanDAO.StorehouseDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ChangeCarDataServlet
 */
public class ChangeCarDataServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CarDataDAO carDataDAO;
	private StorehouseDAO storehouseDAO;

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		carDataDAO = new CarDataDAO();
		storehouseDAO = new StorehouseDAO();
	}

	public ChangeCarDataServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String carID = request.getParameter("carID");
		String cargo1 = request.getParameter("cargo1");
		String cargo2 = request.getParameter("cargo2");
		String cargo3 = request.getParameter("cargo3");
		String cargo4 = request.getParameter("cargo4");
		String note = request.getParameter("note");
		carDataDAO.ChangeCarData(note, cargo1, cargo2, cargo3, cargo4, carID);
		try {
			if(carID.equals("0")) {
				storehouseDAO.insertData("0", "-1", cargo1, cargo2, cargo3);
			}else {
				storehouseDAO.insertData(carID, "0", cargo1, cargo2, cargo3);
			}
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println("ccd servlet wrong");
		}
		request.getRequestDispatcher("Home.jsp").forward(request, response);
		
		
		
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

}

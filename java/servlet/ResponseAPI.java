package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import org.json.JSONArray;

import beanDAO.CarDataBean;
import beanDAO.CarDataDAO;

/**
 * Servlet implementation class ResponseAPI
 */
public class ResponseAPI extends HttpServlet {
	private static final long serialVersionUID = 1L;
	CarDataDAO carDataDAO;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
	}

	public ResponseAPI() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			if (request.getParameter("req").equals("cardata")) {
				response.getWriter().append(car_arr_produce());
			}
			if (request.getParameter("req").equals("update_cardata")) {
				String place = request.getParameter("place");
				String cargo1 = request.getParameter("cargo1");
				String cargo2 = request.getParameter("cargo2");
				String cargo3 = request.getParameter("cargo3");
				String cargo4 = request.getParameter("cargo4");
				carDataDAO.ChangeCarDataByPlace("aaa", cargo1, cargo2, cargo3, cargo4, place);
			}
			if (request.getParameter("req").equals("carInfo")) {
				String path = request.getParameter("path");
				String car = request.getParameter("car");
				String carID = "9";
				String place = "9";
				if (car.equals("黑車")) {
					carID = "1";
				} else if (car.equals("白車")) {
					carID = "2";
				}
				if(car.equals("A")) {
					place="1";
				}else if(car.equals("B")) {
					place="2";
				}else if(car.equals("H")) {
					place="0";
				}
				carDataDAO.ChangeCarNotePlace("大概到了", place, carID);
				
				Thread.currentThread();
				Thread.sleep(12000);	
			}
			if(request.getParameter("req").equals("insert")) {
				String red = request.getParameter("red");
				String blue = request.getParameter("blue");
				String yellow = request.getParameter("yellow");
				String green = request.getParameter("green");
				String warehouse= request.getParameter("warehouse");
				carDataDAO.ChangeCarDataByPlace("偵測到", red, green, blue, yellow, warehouse);
			}
		} catch (Exception e) {
			// TODO: handle exception
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

	public String car_arr_produce() {
		CarDataDAO carDataDAO = new CarDataDAO();
		List<CarDataBean> LCDB = carDataDAO.selectAllCarData();
		JSONArray jsonArray = new JSONArray(LCDB);
		return jsonArray.toString();
	}

}

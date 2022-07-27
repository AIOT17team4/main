package htmlLib;

import java.util.List;

import beanDAO.CarDataBean;
import beanDAO.CarDataDAO;
import beanDAO.ErrorBean;
import beanDAO.ErrorDAO;
import beanDAO.UserBean;
import beanDAO.UserDAO;
import jakarta.servlet.http.HttpSession;

public class HtmlLib {

	public  String SCRIPT_PRODUCE="<script src=\"https://code.jquery.com/jquery-3.4.1.min.js\"></script>\r\n"
			+ "<link rel=\"stylesheet\"\r\n"
			+ "	href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css\">\r\n"
			+ "<script\r\n"
			+ "	src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js\"></script>\r\n"
			+ "<script\r\n"
			+ "	src=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js\"></script>\r\n"
			+ "	<link rel=\"stylesheet\" href=\"style1.css?a=1\">"; 
	public String HEADER_UL_PRODUCE="   <div class=\"side\">\r\n"
			+ "        <ul class=\"out\">\r\n"
			+ "            <li> <span class=\"sideButton\"><img src=\"icon/menu.png\" alt=\"\"> </span>歡迎</li>\r\n"
			+ "            <li><img src=\"icon/home.png\" alt=\"\"><a href=\"Home.jsp\"> <span>首頁</span>\r\n"
			+ "                </a></li>\r\n"
			+ "            <li><img src=\"icon/introduction.png\" alt=\"\"><a href=\"Introduction.jsp\"><span>dicar介紹</span></a></li>\r\n"
			+ "            <li><img src=\"icon/car.png\" alt=\"\"><a href=\"CarData.jsp\"><span>貨櫃車系統</span></a></li>\r\n"
			+ "            <li><img src=\"icon/storehouse.png\" alt=\"\"><a href=\"Storehouse.jsp\"><span>倉儲系統</span></a></li>\r\n"
			+ "            <li><img src=\"icon/error.png\" alt=\"\"><a href=\"ErrorList.jsp\"><span>異常通報紀錄</span></a></li>\r\n"
			+ "            <li><img src=\"icon/camera.png\" alt=\"\"><a href=\"Camera.jsp\"><span>即時影線監控</span></a></li>\r\n"
			+ "            <li><a href=\"\"><span></span></a></li>\r\n"
			+ "            <li><a href=\"\"><span></span></a></li>\r\n"
			+ "            <li><a href=\"\"><span></span></a></li>\r\n"
			+ "            <li> _ </li>\r\n"
			+ "            <li> <span class=\"language\"> <img src=\"icon/language.png\" alt=\"\">\r\n"
			+ "                    <select name=\"language\" id=\"language\">\r\n"
			+ "                        <option value=\"default\">Language</option>\r\n"
			+ "                        <option value=\"Ch\">中文</option>\r\n"
			+ "                        <option value=\"En\">English</option>\r\n"
			+ "                    </select>\r\n"
			+ "                </span></li>\r\n"
			+ "            <li> <img src=\"icon/logout.png\" alt=\"\"><a href=\"\"> <span> 登出</span></a></li>\r\n"
			+ "        </ul>\r\n"
			+ "\r\n"
			+ "    </div>\r\n"
			+ "    <ul class=\"in\" style=\"display: none;\">\r\n"
			+ "        <li style=\"background-color: black; \"><img style=\"height: 20px;\" src=\"icon/menu.png\" alt=\"\"></li>\r\n"
			+ "    </ul>\r\n"
			+ "    <div class=\"div_header\">\r\n"
			+ "\r\n"
			+ "        <header>\r\n"
			+ "            <span class=\"title\">\r\n"
			+ "                <img class=\"img_dicar logo\" src=\"dicarimg/dicar001.png\" style=\"max-height: 95%; border-radius: 25px;\"\r\n"
			+ "                    alt=\"\">\r\n"
			+ "            </span>\r\n"
			+ "\r\n"
			+ "            <ul class=\"header_ul\">\r\n"
			+ "            </ul>\r\n"
			+ "\r\n"
			+ "        </header>";
	public final String COMMONJS_PRODCE="<script src=\"common1.js\"></script>";
	public String user_arr_produce() {
		UserDAO userDAO =new UserDAO();
		List<UserBean> LUB=userDAO.selectAllUser();
		String theString="<script>";
		theString+="let user_arr = [];";
		int i=0;
		for(UserBean UB : LUB) {
			theString+="user_arr["+i+"]=['"+"<img src=\""+UB.getImageURL()+"\" height=\"40px\" alt=\"\">','"+UB.getAccount()+"','"+UB.getLogString()+"'];";
			i++;
		}
		theString+="let total="+i+";";
		theString+="</script>";
		return theString;
	}
//	public String user_information_produce(HttpSession session) {
//		UserBean UB=
//		String theString="<script>";
//		theString+="let user_information=["+UB.getAccount()+",'2']";
//		theString+="</script>";
//		return theString;
//	}
	public String car_arr_produce() {
		String theString="<script>";
		CarDataDAO carDataDAO=new CarDataDAO();
		List<CarDataBean> LCDB=carDataDAO.selectAllCarData();
		theString+="let car_arr=[];";
		int i=0;
		for(CarDataBean CDB:LCDB) {
			theString+="car_arr["+i+"]=['"+CDB.getCarID()+"號車','"+CDB.getPlace()+"號位置','"+CDB.getCargo1()+"','"+CDB.getCargo2()+"','"+CDB.getCargo3()+"','"+CDB.getCargo4()+"'];";
			i++;
		}
		theString+="let car_arr_length="+i+";";
		theString+="</script>";
		return theString;
		
	}
	public String error_arr_produce() {
		String theString="<script>";
		ErrorDAO errorDAO=new ErrorDAO();
		List<ErrorBean> LEB=errorDAO.selectAllErrorData();
		theString +="let error_arr = [];";
		int i=0;
		for(ErrorBean EB:LEB) {
			theString+=" error_arr["+i+"] =['"+EB.getName()+"','"+EB.getTime()+"','"+EB.getStatus()+"']; ";
			i++;
		}
		theString+="let error_arr_length ="+i+";";
		theString+="</script>";
		return theString;
		
	}
	public String car_position_produce() {
		String theString="<script>";
		CarDataDAO carDataDAO=new CarDataDAO();
		List<CarDataBean> LCDB=carDataDAO.selectAllCarData();
		for(CarDataBean CDB:LCDB) {
			if(CDB.getCarID()>0) {
				theString+=" let car"+CDB.getCarID()+"_position = "+CDB.getPlace()+";";
			}
			
		}
		theString+="</script>";
		return theString;
		
	}
	public String user_information_produce(HttpSession session) {
		String theString="<script>";
		UserBean UB =new UserBean(); 
		try {
			UB=(UserBean) session.getAttribute("userBean");
			theString+="let user_information = [];"
					+ "        user_information = ['<img src=\" "+UB.getImageURL()+"\" >', '"+UB.getAccount()+"'];";
		}catch (Exception e) {
			// TODO: handle exception
			theString+="let user_information = [];"
					+ "        user_information = ['<img src=\"head/head01.png\" >', '無人登入'];";
		}
		theString+="</script>";
		return theString;
	}
	
	
	
}

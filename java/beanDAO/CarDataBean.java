package beanDAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class CarDataBean {
	private int id, carID, place, cargo1, cargo2, cargo3, cargo4 ;
	private String note;
	private Date timeDate;
	
	public int getCargo1() {
		return cargo1;
	}
	public void setCargo1(int cargo1) {
		this.cargo1 = cargo1;
	}
	public int getCargo2() {
		return cargo2;
	}
	public void setCargo2(int cargo2) {
		this.cargo2 = cargo2;
	}
	public int getCargo3() {
		return cargo3;
	}
	public void setCargo3(int cargo3) {
		this.cargo3 = cargo3;
	}
	
	
	public int getCargo4() {
		return cargo4;
	}
	public void setCargo4(int cargo4) {
		this.cargo4 = cargo4;
	}
	public Date getTimeDate() {
		return timeDate;
	}
	public void setTimeDate(Date timeDate) {
		this.timeDate = timeDate;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCarID() {
		return carID;
	}
	public void setCarID(int carID) {
		this.carID = carID;
	}
	public int getPlace() {
		return place;
	}
	public void setPlace(int place) {
		this.place = place;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public CarDataBean(ResultSet rs) throws SQLException {
		id= rs.getInt("id");
		carID= rs.getInt("carID");
		place= rs.getInt("place");
		note= rs.getString("note");
		timeDate=rs.getTimestamp("time");
		cargo1=rs.getInt("cargo1");
		cargo2=rs.getInt("cargo2");
		cargo3=rs.getInt("cargo3");
		cargo4=rs.getInt("cargo4");
	}
	
	public CarDataBean() {
		// TODO Auto-generated constructor stub
	}
	
}

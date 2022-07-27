package beanDAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class StorehouseBean {
	private  int id,goIn, cargo4, cargo1, cargo2, cargo3;
	private String time;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCargo4() {
		return cargo4;
	}
	public void setCargo4(int cargo4) {
		this.cargo4 = cargo4;
	}
	public int getGoIn() {
		return goIn;
	}
	public void setGoIn(int goIn) {
		this.goIn = goIn;
	}
	
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
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	
	public StorehouseBean(ResultSet rs) throws SQLException {
		this.id=rs.getInt("id");
		this.goIn=rs.getInt("goIn");
		this.cargo4=rs.getInt("cargo4");
		this.cargo1=rs.getInt("cargo1");
		this.cargo2=rs.getInt("cargo2");
		this.cargo3=rs.getInt("cargo3");
		this.time=rs.getString("time");
		
		
		
	}
	
	
	
}

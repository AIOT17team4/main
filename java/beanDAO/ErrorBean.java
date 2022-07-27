package beanDAO;

import java.sql.ResultSet;
import java.sql.SQLException;


public class ErrorBean {
	private int id;
	private String name, status;
	private String time;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getTime() {
		return time;
	}
	
	public ErrorBean(ResultSet rs) throws SQLException {
		this.name=rs.getString("name");
		this.status=rs.getString("status");
		this.id=rs.getInt("id");
		this.time=rs.getString("time");
	}
	
	
}

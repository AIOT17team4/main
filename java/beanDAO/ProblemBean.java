package beanDAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class ProblemBean {
	private int id;
	private String name, state, author, solution;
	private Date time;
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
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getSolution() {
		return solution;
	}
	public void setSolution(String solution) {
		this.solution = solution;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public ProblemBean(ResultSet rs) throws SQLException {
		this.id=rs.getInt("id");
		this.name=rs.getString("name");
		this.state=rs.getString("state");
		this.author=rs.getString("author");
		this.solution=rs.getString("solution");
		this.time=rs.getTime("time");
	}
	
	
}

package beanDAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class UserBean {
 protected int id;
 protected String account, imageURL;
 protected String password ,logString;
 
 
	
public int getId() {
	return id;
}

public String getAccount() {
	return account;
}

public void setAccount(String account) {
	this.account = account;
}

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}



public String getImageURL() {
	return imageURL;
}

public void setImageURL(String imageURL) {
	this.imageURL = imageURL;
}

public String getLogString() {
	return logString;
}

public void setLogString(String logString) {
	this.logString = logString;
}

public String getloginString(Date loginDate) {
	
	logString= String.format("%1$tY-%1$tm-%1$td", loginDate); 
	return  logString;
}


public void setId(int id) {
	this.id = id;
}
public UserBean(String account, String password,String login1) {
	super();
	this.account=account;
	this.password=password;
	this.logString=login1;
	
}
public UserBean(int id, String account, String password, String login1) {
	super();
	this.id=id;
	this.account=account;
	this.password=password;
	this.logString=login1;
}
public UserBean() {
	super();
}
public UserBean(ResultSet rs) throws SQLException {
	super();
	this.id=rs.getInt("id");
	this.account=rs.getString("account");
	this.password=rs.getString("password");
	this.logString=rs.getString("logintime");
	this.imageURL=rs.getString("imageURL");
}

}

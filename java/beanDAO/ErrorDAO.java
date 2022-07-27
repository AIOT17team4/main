package beanDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ErrorDAO {
	ConnectToFP connectToReading =new ConnectToFP();
	Connection connection=connectToReading.getConnection();
	private static final String SELECT_ALL_DATA = "select * from error";
	
	public List<ErrorBean> selectAllErrorData(){
		List<ErrorBean> listErrorBeans = new ArrayList<ErrorBean>();
		try (PreparedStatement preparedStatement=connection.prepareStatement(SELECT_ALL_DATA);){
			System.out.println(preparedStatement);
			ResultSet rs =preparedStatement.executeQuery();
			while(rs.next()) {
				listErrorBeans.add(new ErrorBean(rs));
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(this.toString()+" has something wrong.");
		}		
		return listErrorBeans;
	}
	
}

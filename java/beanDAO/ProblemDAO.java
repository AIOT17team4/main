package beanDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProblemDAO {
	ConnectToFP connectToFP =new ConnectToFP();
	Connection connection=connectToFP.getConnection();
	private static final String SELECT_ALL_DATA = "select * from problem";
	private static final String INSERT_DATA="INSERT INTO `problem` ( `name`, `state`, `author`, `solution`) VALUES ( ?, ?, ?, ?);";

	public List<ProblemBean> selectAllCarData(){
		List<ProblemBean> listProblemBeans = new ArrayList<ProblemBean>();
		try (PreparedStatement preparedStatement=connection.prepareStatement(SELECT_ALL_DATA);){
			System.out.println(preparedStatement);
			ResultSet rs =preparedStatement.executeQuery();
			while(rs.next()) {
				listProblemBeans.add(new ProblemBean(rs));
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(this.toString()+" has something wrong.");
		}		
		return listProblemBeans;
	}
	public void insertData(String name, String state, String solution, String author) {
		try (PreparedStatement preparedStatement=connection.prepareStatement(INSERT_DATA);){
			preparedStatement.setString(1, name);
			preparedStatement.setString(2, state);
			preparedStatement.setString(3, author);
			preparedStatement.setString(4, solution);
			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(this.toString()+" has something wrong.");
		}
	}
}

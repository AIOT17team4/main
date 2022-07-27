package beanDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StorehouseDAO {
	ConnectToFP connectToReading =new ConnectToFP();
	Connection connection=connectToReading.getConnection();
	private static final String SELECT_ALL_DATA = "select * from storehouse";
	private static final String INSERT_DATA="INSERT INTO `storehouse` (`goIn`, `cargo1`, `cargo2`, `cargo3`, `cargo4`) VALUES (?, ?, ?, ?, ?);";
	public List<StorehouseBean> selectAllData(){
		List<StorehouseBean> listsStorehouseBeans = new ArrayList<StorehouseBean>();
		try (PreparedStatement preparedStatement=connection.prepareStatement(SELECT_ALL_DATA);){
			System.out.println(preparedStatement);
			ResultSet rs =preparedStatement.executeQuery();
			while(rs.next()) {
				listsStorehouseBeans.add(new StorehouseBean(rs));
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(this.toString()+" has something wrong.");
		}		
		return listsStorehouseBeans;
	}
	public void insertData(String goIn, String goOut, String cargo1, String cargo2, String cargo3) throws SQLException {
		try (PreparedStatement preparedStatement=connection.prepareStatement(INSERT_DATA);){
			preparedStatement.setString(1, goIn);
			preparedStatement.setString(2, goOut);
			preparedStatement.setString(3, cargo1);
			preparedStatement.setString(4, cargo2);
			preparedStatement.setString(5, cargo3);
			System.out.print(preparedStatement);
			preparedStatement.executeUpdate();
			
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(this.toString()+"insert data has something wrong.");
		}
	}
}

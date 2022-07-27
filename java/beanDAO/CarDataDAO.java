package beanDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;



public class CarDataDAO {
	ConnectToFP connectToFP =new ConnectToFP();
	Connection connection=connectToFP.getConnection();
	private static final String SELECT_ALL_DATA = "select * from cardata";
	private static final String CHANGE_CAR_DATA="UPDATE `cardata` SET `note` = ?, `cargo1` = ?, `cargo2` = ?, `cargo3` = ?, `cargo4` = ? WHERE `cardata`.`carID` = ?;";
	private static final String CHANGE_CAR_DATA_BY_PLACE="UPDATE `cardata` SET `note` = ?, `cargo1` = ?, `cargo2` = ?, `cargo3` = ?, `cargo4` = ? WHERE `cardata`.`place` = ?;";
	private static final String CHANGE_CAR_NOTE_AND_PLACE="UPDATE `cardata` SET `note` = ?, `place` = ? WHERE `cardata`.`id` = ?;";
	private static final String SELECT_ONE_DATA_BY_ID = "select * from cardata  WHERE `cardata`.`id` = ?;";
	public List<CarDataBean> selectAllCarData(){
		List<CarDataBean> listCarDataBeans = new ArrayList<CarDataBean>();
		try (PreparedStatement preparedStatement=connection.prepareStatement(SELECT_ALL_DATA);){
			System.out.println(preparedStatement);
			ResultSet rs =preparedStatement.executeQuery();
			while(rs.next()) {
				listCarDataBeans.add(new CarDataBean(rs));
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(this.toString()+" has something wrong.");
		}		
		return listCarDataBeans;
	}
	public void ChangeCarData(String note,String cargo1, String cargo2, String cargo3, String cargo4,String id) {
		try(PreparedStatement preparedStatement=connection.prepareStatement(CHANGE_CAR_DATA)){
			preparedStatement.setString(1, note);
			preparedStatement.setString(2, cargo1);
			preparedStatement.setString(3, cargo2);
			preparedStatement.setString(4, cargo3);
			preparedStatement.setString(5, cargo4);
			preparedStatement.setString(6, id);
			System.out.print(preparedStatement);
			preparedStatement.execute();
		}catch (Exception e) {
			// TODO: handle exception
			System.out.print("change wrong!");
		}
		
	}
	public void ChangeCarDataByPlace(String note,String cargo1, String cargo2, String cargo3, String cargo4,String place) {
		try(PreparedStatement preparedStatement=connection.prepareStatement(CHANGE_CAR_DATA_BY_PLACE)){
			preparedStatement.setString(1, note);
			preparedStatement.setString(2, cargo1);
			preparedStatement.setString(3, cargo2);
			preparedStatement.setString(4, cargo3);
			preparedStatement.setString(5, cargo4);
			preparedStatement.setString(6, place);
			System.out.print(preparedStatement);
			preparedStatement.execute();
		}catch (Exception e) {
			// TODO: handle exception
			System.out.print("change  by place wrong!");
		}
		
	}
	public void ChangeCarNotePlace(String note,String position, String carID) {
		try(PreparedStatement preparedStatement=connection.prepareStatement(CHANGE_CAR_NOTE_AND_PLACE)){
			preparedStatement.setString(1, note);
			preparedStatement.setString(2, position);
			preparedStatement.setString(3, carID);
			
			System.out.print(preparedStatement);
			preparedStatement.execute();
		}catch (Exception e) {
			// TODO: handle exception
			System.out.print("change place note wrong!");
		} 
		
	}
	public CarDataBean selectOneDataByID(String ID) {
		CarDataBean carDataBean= new CarDataBean();
		try (PreparedStatement preparedStatement=connection.prepareStatement(SELECT_ONE_DATA_BY_ID);){
			preparedStatement.setString(1, ID);
			System.out.println(preparedStatement);
			ResultSet rs =preparedStatement.executeQuery();
			while(rs.next()) {
				carDataBean=new CarDataBean(rs);
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(this.toString()+" has something wrong.");
		}		
		return carDataBean;
	}
}

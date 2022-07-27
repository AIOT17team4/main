package beanDAO;




import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
public class UserDAO {
	ConnectToFP connectToFP =new ConnectToFP();
	Connection connection=connectToFP.getConnection();
	private static final String INSERT_USER_SQL = "INSERT INTO `user` (`id`, `account`, `password`, `rand`) VALUES (NULL, ?, ?, ?);";
	private static final String SELECT_ALL_USER= "select * from user";
    private static final String LOGINFINAL="UPDATE `user` SET `rand` = ? WHERE `user`.`id` = ?;";
public UserDAO() {
	
}

public void insertUser(UserBean userbean) throws SQLException {
//	帶修改
	System.out.println(INSERT_USER_SQL);
	// try-with-resource statement will auto close the connection.
	// "INSERT INTO users" + "  (name, email, country) VALUES " + " (?, ?, ?);"
	try (PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USER_SQL);) {
		preparedStatement.setString(2,userbean.getPassword());
		preparedStatement.setString(1,userbean.getAccount());
		preparedStatement.setString(3,"56");
		System.out.println(preparedStatement);
		preparedStatement.executeUpdate();
    } catch (SQLException e) {
		e.printStackTrace();
	}
}
public List<UserBean> selectAllUser() {
	
	// using try-with-resources to avoid closing resources (boiler plate code)
		List<UserBean> listUserBeans = new ArrayList<>();
	// Step 1: Establishing a Connection
	try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USER);) {
		System.out.println(preparedStatement);
		// Step 3: Execute the query or update query
		ResultSet rs = preparedStatement.executeQuery();
		
		// Step 4: Process the ResultSet object.
		
		while (rs.next()) {
		    listUserBeans.add(new UserBean(rs ));
		}
    } catch (SQLException e) {
	
    }
	return listUserBeans;
	
	}
public void loginfinal(UserBean userbean) throws SQLException {
	System.out.println(LOGINFINAL);
	// try-with-resource statement will auto close the connection.
	// "INSERT INTO users" + "  (name, email, country) VALUES " + " (?, ?, ?);"
	try (PreparedStatement preparedStatement = connection.prepareStatement(LOGINFINAL)) {
		preparedStatement.setString(2,Integer.toString(userbean.getId()));
		Random rand=new Random();
		int randint = rand.nextInt(500);
		preparedStatement.setString(1,Integer.toString(randint));
		System.out.println(preparedStatement);
		preparedStatement.executeUpdate();
    } catch (SQLException e) {
		e.printStackTrace();
	}
}
}
package in.edac.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * CRUD
 * 
 * createUser/addUser/insertUser
 */
public class UserDao {

	public static final String DB_DRIVER = "com.mysql.cj.jdbc.Driver";
	public static final String DB_URL = "jdbc:mysql://192.168.64.5:3306/edac";
	public static final String DB_USER = "mysql";
	public static final String DB_PASSWORD = "mysql";

	public void checkConnection()  {
		try (Connection con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);) {
			
			System.out.println("Success Try With Resource!!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public boolean cretateUser(User user) throws Exception {
		
		Class.forName(DB_DRIVER);
		try (Connection con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);) {
			
			String sql = "INSERT INTO USERS (USERNAME, EMAIL, PASSWORD, MOBILE) VALUES (?, ?, ?, ?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getEmail());
			ps.setString(3, user.getPassword());
			ps.setString(4, user.getMobile());
			
			ps.executeUpdate();
			System.out.println("Insert Success");
			
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			// return false;
			throw e;
		}
	}
	
	
	public boolean updateUser(User user) throws Exception {
		Class.forName(DB_DRIVER);
		
		try (Connection con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);) {
			String sql = "UPDATE USERS SET USERNAME=?, PASSWORD=?, MOBILE=? WHERE ID=?";
			PreparedStatement ps =  con.prepareStatement(sql);
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getPassword());
			ps.setString(3, user.getMobile());
			ps.setInt(4, user.getId());
			
			ps.executeUpdate();
			
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			//return false;
			throw e;
		}
	}

	
	public boolean deleteUser(User user) throws Exception {
		Class.forName(DB_DRIVER);
		try (Connection con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);){
		
			String sql = "DELETE FROM USERS WHERE ID=?";
			PreparedStatement ps =  con.prepareStatement(sql);
			ps.setInt(1, user.getId());
			
			ps.executeUpdate();
			
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	
	public List<User> readAllUser() throws Exception {
		Class.forName(DB_DRIVER);
		try (Connection con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
			String sql = "SELECT * FROM USERS";
			PreparedStatement ps =  con.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();
			List<User> list = new ArrayList<User>();
			while(rs.next()) {
				// ROW :: Reading columns of row
				int colId = rs.getInt("ID");
				String colUsername = rs.getString("USERNAME");
				String colEmail = rs.getString("EMAIL");
				String colMobile = rs.getString("MOBILE");
				
				// ROW :: User We are conveting the row into User object
				User user = new User();
				user.setId(colId);
				user.setUsername(colUsername);
				user.setEmail(colEmail);
				user.setMobile(colMobile);
				
				// Add row/user to list
				list.add(user);
			}
			
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	
	
	public static void main(String[] args) throws Exception {
		UserDao dao = new UserDao();
		
		// User user = new User("mumbai2", "mumbai2@gmail.com", "adsfa", "adsfa");
		// dao.cretateUser(user);
		
		// User user = new User("mumbai33", "mumbai33@gmail.com", "1234567", "adsfa");
		// user.setId(14);
		// dao.updateUser(user);
		
		// Delete User
		//User user = new User();
		//user.setId(14);
		//dao.deleteUser(user);
		
		List<User> list = dao.readAllUser();
		System.out.println(list);
		
	}

}

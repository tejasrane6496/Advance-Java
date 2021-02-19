package in.edac.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

/**
 * CRUD
 * 
 * createUser/addUser/insertUser
 */
public class SetupByStepDao {

	public static final String DB_DRIVER = "com.mysql.cj.jdbc.Driver";
	public static final String DB_URL = "jdbc:mysql://192.168.64.5:3306/edac";
	public static final String DB_USER = "mysql";
	public static final String DB_PASSWORD = "mysql";

	public void checkConnectionOld()  {
		try {
			Class.forName(DB_DRIVER);
			
			Connection con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
			
			// Explicitly Closing the connection.
			con.close();
			System.out.println("Success!!");
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
	
	public void checkConnection()  {
		try (Connection con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);) {
			Class.forName(DB_DRIVER);
			
			System.out.println("Success Try With Resource!!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public boolean cretateUserV1() {
		try (Connection con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);) {
			Class.forName(DB_DRIVER);
			
			String sql = "INSERT INTO USERS (USERNAME, EMAIL, PASSWORD, MOBILE) VALUES (?, ?, ?, ?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, "sahil121");
			ps.setString(2, "sahil@gmaill");
			ps.setString(3, "sahil12345");
			ps.setString(4, "121212121");
			
			ps.executeUpdate();
			System.out.println("Insert Success");
			
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	
	public boolean cretateUserV2(String username, String email, String password, String mobile) {
		try (Connection con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);) {
			Class.forName(DB_DRIVER);
			
			String sql = "INSERT INTO USERS (USERNAME, EMAIL, PASSWORD, MOBILE) VALUES (?, ?, ?, ?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, email);
			ps.setString(3, password);
			ps.setString(4, mobile);
			
			ps.executeUpdate();
			System.out.println("Insert Success");
			
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	
	public boolean cretateUser(User user) {
		try (Connection con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);) {
			Class.forName(DB_DRIVER);
			
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
			return false;
		}
	}
	
	
	
	public static void main(String[] args) {
		SetupByStepDao dao = new SetupByStepDao();
		
		// check connection
		// dao.checkConnection();
		
		// calling method
		// dao.cretateUserV1();
		
		// dao.cretateUser("abcdef", "abcdef@gmail.com", "asdfasdfa", "1212121");
		
		User user = new User("mumbai2", "mumbai2@gmail.com", "adsfa", "adsfa");
		dao.cretateUser(user);
	}

}

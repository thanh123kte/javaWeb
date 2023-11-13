package context;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;


public class DBcontext {
    
	private static String DB_URL = "jdbc:mysql://localhost:3306/javaweb";
    private static String USER_NAME = "root";
    private static String PASSWORD = "";
 
    public static Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL,USER_NAME,PASSWORD);
            System.out.println("connect successfully!");
        } catch (Exception ex) {
            System.out.println("connect failure!");
            ex.printStackTrace();
        }
        return conn;
    }
    
    public static void main(String[] args) {
		DBcontext db = new DBcontext();
		db.getConnection();
	}
}
 
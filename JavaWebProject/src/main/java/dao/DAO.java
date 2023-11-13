package dao;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import context.DBcontext;
import entity.Account;
import entity.Product;

public class DAO {
	public Connection conn = null;
	public PreparedStatement ps = null;
	public ResultSet rs = null;
	public Account login(String user, String pass) {
		String sql = "Select * from tbl_user where user_account=? and user_pass=?";
		DAO dao = new DAO();
		try {
			conn = new DBcontext().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, user);
			ps.setString(2, dao.toMD5(pass));
			rs = ps.executeQuery();
			while(rs.next()) {
				return new Account(rs.getInt("user_id"), rs.getString("user_account"), rs.getString("user_pass"), rs.getInt("user_permission"));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return new Account(0,"0","0",0);
	}
	
	public int register(String user, String pass) {
		int check = 0;
		String sql = "INSERT INTO tbl_user (user_account, user_pass, user_permission) VALUES (?, ?, ?);";
		try {
			DAO dao = new DAO();
			conn = new DBcontext().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, user);
			ps.setString(2, dao.toMD5(pass));
			ps.setInt(3, 2);
			
			int rowsAffected = ps.executeUpdate();
			 if (rowsAffected > 0) {
				 	check = 1;  
			    }		
		} catch (Exception e) {
			// TODO: handle exception
		}
		return check;
	}
	
	public String toMD5(String input) {       
	        try {
	            MessageDigest md = MessageDigest.getInstance("MD5");
	            
	            md.update(input.getBytes());
	            
	            byte[] digest = md.digest();
	            
	            StringBuilder hexString = new StringBuilder();
	            for (byte b : digest) {
	                hexString.append(String.format("%02x", b));
	            }
	            
	            String md5Hash = hexString.toString();
	            return md5Hash;

	        } catch (NoSuchAlgorithmException e) {
	            e.printStackTrace();
	        }
			return null;
	    }
	
	
	// Product DAO
	public List<Product> getAllProduct(){
		List<Product> list = new ArrayList<Product>();
		
		String sql = "SELECT * FROM tbl_product";
		
		try {
			conn = new DBcontext().getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				list.add(new Product(
						rs.getInt(1),
						rs.getString(2),
						rs.getString(3),
						rs.getInt(4),
						rs.getString(5),
						rs.getDouble(6)
						));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		
		
		return list;
	}
	
	public static void main(String[] args) {
		DAO dao = new DAO();
		System.out.println(dao.getAllProduct().size());
	}
}

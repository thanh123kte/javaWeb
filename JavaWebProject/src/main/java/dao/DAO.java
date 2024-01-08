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
import entity.Cart;
import entity.Order;
import entity.Order_details;
import entity.Product;

public class DAO {
	public Connection conn = null;
	public PreparedStatement ps = null;
	public ResultSet rs = null;
	
	public Account login(String user, String pass) {
		String sql = "Select * from tbl_user where user_account=? and user_pass=?";
		DAO dao = new DAO();
		try {
			System.out.println("usse:"+user);
			System.out.println("pass: "+pass+" "+dao.toMD5(pass));
			conn = new DBcontext().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, user);
			ps.setString(2, dao.toMD5(pass));
			rs = ps.executeQuery();
			while(rs.next()) {
				return new Account(rs.getInt("user_id"), 
						rs.getString("user_account"), 
						rs.getString("user_pass"), 
						rs.getInt("user_permission"),
						rs.getString("user_name"),
						rs.getString("user_email"),
						rs.getInt("user_phone"),
						rs.getString("user_address")
						);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return new Account(0,"0","0",0, "0", "0", 0, "0");
	}
	
	public boolean register(String user, String pass, String fullname, String email, int phone, String address) {
		String sql = "INSERT INTO tbl_user (user_account, user_pass, user_permission, user_name, user_email, user_phone, user_address) VALUES (?, ?, ?, ?, ?, ? , ?)";
		try {
			DAO dao = new DAO();
			conn = new DBcontext().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, user);
			ps.setString(2, dao.toMD5(pass));
			ps.setInt(3, 2);
			ps.setString(4, fullname);
			ps.setString(5, email);
			ps.setInt(6, phone);
			ps.setString(7, address);
			
			int rowsAffected = ps.executeUpdate();
			 if (rowsAffected > 0) {
				 	return true;
			    }		
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
	}
	
	public void changePass(String pass, int user_id) {
		String sql = "UPDATE tbl_user SET user_pass = ? WHERE user_id = ?";
		try {
			DAO dao = new DAO();
			conn = new DBcontext().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, dao.toMD5(pass));
			ps.setInt(2, user_id);
			ps.executeUpdate();
			System.out.println("ok");
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
	public void editProfile(String fullname, String email, int phone, String address, int uid) {
		String sql = "UPDATE tbl_user SET user_name = ?, user_email=?, user_phone=?, user_address=? WHERE user_id = ?";
		try {
			conn = new DBcontext().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, fullname);
			ps.setString(2, email);
			ps.setInt(3, phone);
			ps.setString(4, address);
			ps.setInt(5, uid);

			ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public Account getAccount(int userid) {
		
		String sql = "Select * from tbl_user where user_id=?";
		try {
			conn = new DBcontext().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, userid);
			rs = ps.executeQuery();
			while(rs.next()) {
				return new Account(rs.getInt("user_id"), 
						rs.getString("user_account"), 
						rs.getString("user_pass"), 
						rs.getInt("user_permission"),
						rs.getString("user_name"),
						rs.getString("user_email"),
						rs.getInt("user_phone"),
						rs.getString("user_address")
						);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
public Account getUserAccount(int userid) {
		Account a = new Account();
		String sql = "Select * from tbl_user where user_id=?";
		try {
			conn = new DBcontext().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, userid);
			rs = ps.executeQuery();
			while(rs.next()) {
				return new Account(rs.getInt("user_id"), 
						rs.getString("user_account"), 
						rs.getString("user_pass"), 
						rs.getInt("user_permission"),
						rs.getString("user_name"),
						rs.getString("user_email"),
						rs.getInt("user_phone"),
						rs.getString("user_address")
						);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return a;
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
	
	public Product getProductByID(int id){
		String sql = "SELECT * FROM tbl_product WHERE product_id = ?";
		try {
			conn = new DBcontext().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while(rs.next()) {
				return new Product(
						rs.getInt(1),
						rs.getString(2),
						rs.getString(3),
						rs.getInt(4),
						rs.getString(5),
						rs.getDouble(6)
						);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
	public boolean addToCart( int user_id, int product_id, int quantity) {
		String sql = "INSERT INTO tbl_cart (user_id, product_id, quantity) VALUES (?, ?, ?)";
		try {
			conn = new DBcontext().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, user_id);
			ps.setInt(2, product_id);
			ps.setInt(3, quantity);
			int rowsAffected = ps.executeUpdate();
			if(rowsAffected>0) {
				return true;
			}else {
				return false;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}
	
	
	public List<Cart> cartProduct(int user_id){
		List<Cart> list = new ArrayList<Cart>();
		String sql = "SELECT tbl_product.*, tbl_cart.quantity FROM tbl_product INNER JOIN tbl_cart ON tbl_product.product_id = tbl_cart.product_id WHERE tbl_cart.user_id = ?";
		try {
			conn = new DBcontext().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, user_id);
			rs = ps.executeQuery();
			while(rs.next()) {
				list.add(new Cart(
						rs.getInt(1),
						rs.getString(2),
						rs.getString(3),
						rs.getInt(4),
						rs.getString(5),
						rs.getDouble(6),
						rs.getInt(7)
						));
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}
	
	public boolean deleteCart(int user_id, int product_id) {
		String sql = "DELETE FROM tbl_cart WHERE user_id=? AND product_id=?";
		try {
			conn = new DBcontext().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, user_id);
			ps.setInt(2, product_id);
			int rowsAffected = ps.executeUpdate();
			if(rowsAffected>0) {
				return true;
			}else {
				return false;
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}
	
	public boolean deleteAllCart(int user_id) {
		String sql = "DELETE FROM tbl_cart WHERE user_id=?";
		try {
			conn = new DBcontext().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, user_id);
			int rowsAffected = ps.executeUpdate();
			if(rowsAffected>0) {
				return true;
			}else {
				return false;
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}
	// order DAO
	public boolean addOrder(int order_code, String order_date, String order_status) {
		String sql = "INSERT INTO tbl_order (order_code, order_date, order_status) VALUES (?, ?, ?)";
		try {
			conn = new DBcontext().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, order_code);
			ps.setString(2, order_date);
			ps.setString(3, order_status);
			int rowsAffected = ps.executeUpdate();
			if(rowsAffected>0) {
				return true;
			}else {
				return false;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}
	
	public boolean addOrderDetail(int order_code, int user_id, int product_id, int quantity) {
		String sql = "INSERT INTO tbl_order_details (order_code, user_id, product_id, quantity) VALUES (?, ?, ?, ?)";
		try {
			conn = new DBcontext().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, order_code);
			ps.setInt(2, user_id);
			ps.setInt(3, product_id);
			ps.setInt(4, quantity);
			int rowsAffected = ps.executeUpdate();
			if(rowsAffected>0) {
				return true;
			}else {
				return false;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}
	//search dao
	
	public List<Product> getProductByName(String name){
		List<Product> list = new ArrayList<Product>();
		
		String sql = "SELECT * FROM tbl_product WHERE product_name like ?";
		
		try {
			conn = new DBcontext().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1,"%"+ name +"%");
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
	
	public boolean addProduct(String name, String decs, String image, Double price) {
		String sql = "INSERT INTO tbl_product (product_name, product_decs, prduct_type, product_image, product_price) VALUES (?, ?, 1, ?, ?) ";
		
		try {
			conn = new DBcontext().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			ps.setString(2, decs);
			ps.setString(3, image);
			ps.setDouble(4, price);
			
			int rowsAffected = ps.executeUpdate();
			 if (rowsAffected > 0) {
				 	return true;
			    }		
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return false;
	}
	
	
	public static void main(String[] args) {
		DAO dao = new DAO();

	}

	public void deleteProduct(int id) {
		String sql = "DELETE FROM tbl_product WHERE product_id=?";
		try {
			conn = new DBcontext().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}

	public void updateProduct(int id, String name, String decs, String filename, double price) {
		// TODO Auto-generated method stub
		String sql = "UPDATE tbl_product SET product_name = ?, product_decs = ?, product_image = ?, product_price = ? WHERE product_id = ?";
		try {
			DAO dao = new DAO();
			conn = new DBcontext().getConnection();
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, name);
			ps.setString(2, decs);
			ps.setString(3, filename);
			ps.setDouble(4, price);
			ps.setInt(5, id);
			System.out.println(ps);
			ps.executeUpdate();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}

	public List<Order> getOrder() {
		
		List<Order> list = new ArrayList<Order>();
		
		String sql = "SELECT * FROM tbl_order";
		
		try {
			conn = new DBcontext().getConnection();
			ps = conn.prepareStatement(sql);	
			rs = ps.executeQuery();
			while(rs.next()) {
				list.add(new Order(
						rs.getInt(1),
						rs.getInt(2),
						rs.getString(3),
						rs.getString(4)
						));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
			
		return list;
	}

	public void acceptOrder(int id) {
		// TODO Auto-generated method stub

		String sql = "UPDATE tbl_order SET order_status = ? WHERE order_id = ?";
		
		try {
			DAO dao = new DAO();
			conn = new DBcontext().getConnection();
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, "Đã duyệt");
			ps.setInt(2, id);
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void deleteOrder(int id) {
		String sql = "DELETE FROM tbl_order WHERE order_id=?";
		
		try {
			conn = new DBcontext().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	public void deleteOrderDetails(int order_code) {
		String sql = "DELETE FROM tbl_order_details WHERE order_code=?";
		
		try {
			conn = new DBcontext().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, order_code);
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}

	public List<Order_details> getOrderDetails(int code) {
		List<Order_details> list = new ArrayList<Order_details>();
		String sql = "SELECT tbl_product.product_id, tbl_order_details.quantity, tbl_product.product_name, tbl_product.product_image, tbl_product.product_price, tbl_order_details.user_id FROM tbl_order_details INNER JOIN tbl_product ON tbl_order_details.product_id = tbl_product.product_id WHERE tbl_order_details.order_code = ?";
		
		try {
			conn = new DBcontext().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, code);
			rs = ps.executeQuery();
			while(rs.next()) {
				list.add(new Order_details(
						rs.getInt(1),
						rs.getInt(2),
						rs.getString(3),
						rs.getString(4),
						rs.getDouble(5),
						rs.getInt(6)
						));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
			
		return list;
		
	}
}

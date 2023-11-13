package entity;

public class Account {
	private int id;
	private String account;
	private String pass;
	private int permission;
	
	public Account() {
		// TODO Auto-generated constructor stub
	}
	public Account(int id, String account, String pass, int permission) {
		this.id = id;
		this.account = account;
		this.pass = pass;
		this.permission = permission;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public int getPermission() {
		return permission;
	}
	public void setPermission(int permission) {
		this.permission = permission;
	}
	@Override
	public String toString() {
		return "Account [id=" + id + ", account=" + account + ", pass=" + pass + ", permission=" + permission + "]";
	}
	
}

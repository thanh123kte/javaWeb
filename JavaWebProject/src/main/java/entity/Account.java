package entity;

public class Account {
	private int id;
	private String account;
	private String pass;
	private int permission;
	private String name;
	private String email;
	private int phone;
	private String address;
	
	public Account() {
		// TODO Auto-generated constructor stub
	}
	
	public Account(int id, String account, String pass, int permission, String name, String email, int phone,
			String address) {
		super();
		this.id = id;
		this.account = account;
		this.pass = pass;
		this.permission = permission;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.address = address;
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getPhone() {
		return phone;
	}
	public void setPhone(int phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public void setPermission(int permission) {
		this.permission = permission;
	}
	@Override
	public String toString() {
		return "Account [id=" + id + ", account=" + account + ", pass=" + pass + ", permission=" + permission
				+ ", name=" + name + ", email=" + email + ", phone=" + phone + ", address=" + address + "]";
	}
	
	
}

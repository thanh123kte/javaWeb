package entity;

public class Order_details {
	int id;
	int quantity;
	String name;
	String img;
	double price;
	int userid;
	
	public Order_details() {
		
	
	}

	public Order_details(int id, int quantity, String name, String img, double price, int userid) {
		super();
		this.id = id;
		this.quantity = quantity;
		this.name = name;
		this.img = img;
		this.price = price;
		this.userid = userid;
	}

	public int getId() {
		return id;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	
	
}

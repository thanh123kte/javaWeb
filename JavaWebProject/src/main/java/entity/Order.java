package entity;

public class Order {
	int id; 
	int code;
	String date;
	String status;
	
	public Order() {
		
	}

	public Order(int id, int code, String date, String status) {
		super();
		this.id = id;
		this.code = code;
		this.date = date;
		this.status = status;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
}

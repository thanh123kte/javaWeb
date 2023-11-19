package entity;

public class Cart {
	private int id;
	private String name;
	private String decs;
	private int type;
	private String image;
	private Double price;
	private int quantity;
	
	public Cart() {
		
	}
	
	public Cart(int id, String name, String decs, int type, String image, Double price, int quantity) {
		super();
		this.id = id;
		this.name = name;
		this.decs = decs;
		this.type = type;
		this.image = image;
		this.price = price;
		this.quantity = quantity;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDecs() {
		return decs;
	}

	public void setDecs(String decs) {
		this.decs = decs;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "Cart [id=" + id + ", name=" + name + ", decs=" + decs + ", type=" + type + ", image=" + image
				+ ", price=" + price + ", quantity=" + quantity + "]";
	}
	
	
	
	
}

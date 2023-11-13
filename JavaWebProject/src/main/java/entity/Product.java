package entity;

public class Product {
	private int id;
	private String name;
	private String decs;
	private int type;
	private String image;
	private Double price;
	
	public Product() {
		
	}

	public Product(int id, String name, String decs, int type, String image, Double price) {
		super();
		this.id = id;
		this.name = name;
		this.decs = decs;
		this.type = type;
		this.image = image;
		this.price = price;
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

	public double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", decs=" + decs + ", type=" + type + ", image=" + image
				+ ", price=" + price + "]";
	}
	
	
}





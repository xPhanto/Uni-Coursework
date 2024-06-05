package lab7;

public class Toy {
	
	private int id;
	private String name;
	private int quantity;
	private double price;

	public Toy(int id, String name, int quantity, double price) {
		this.id = id;
		this.name = name;
		this.quantity = quantity;
		this.price = price;

	}
	
	public Toy(Toy toyObj) {
		this.id = toyObj.id;
		this.name = toyObj.name;
		this.quantity = toyObj.quantity;
		this.price = toyObj.price;
	}

	public int getToyID() {
		return id;
	}

	public String getToyName() {
		return name;
	}

	public int getToyQuantity() {
		return quantity;
	}

	public double getToyPrice() {
		return price;
	}

	public String getToyInformation() {
		String temp = String.format("Toy(%d,%s), quantity(%d) with $( %.2f)/toy", id, name, quantity, price);
		return temp;
	}
	public void setToyID(int id) {
		this.id = id;
	}

	public void setToyName(String name) {
		this.name = name;
	}

	public void setToyQuantity(int quantity) {
		this.quantity = quantity;
	}

	public void setToyPrice(double price) {
		this.price = price;
	}

}

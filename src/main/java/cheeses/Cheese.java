package cheeses;

public class Cheese {
	private String name;
	private int price;

	public Cheese(String name, int price) {
		this.name = name;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public int getPrice() {
		return price;
	}
}

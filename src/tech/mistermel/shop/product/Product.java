package tech.mistermel.shop.product;

public class Product {

	private int id, stock;
	private String identifier, name, description;
	private double price;
	
	public Product(int id, String identifier, String name, String description, double price, int stock) {
		this.id = id;
		this.identifier = identifier;
		this.name = name;
		this.description = description;
		this.price = price;
		this.stock = stock;
	}
	
	public int getId() {
		return id;
	}
	
	public String getIdentifier() {
		return identifier;
	}
	
	public String getName() {
		return name;
	}
	
	public String getDescription() { 
		return description;
	}
	
	public double getPrice() {
		return price;
	}
	
	public int getStock() {
		return stock;
	}

	public String getFormattedStock() {
		return stock > 0 ? stock + " op voorraad" : "Uitverkocht";
	}

}

package tech.mistermel.shop.product;

import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import tech.mistermel.shop.Webshop;

public class ProductManager {
		
	private Webshop instance;
	private List<Product> products = new ArrayList<Product>();
	private File pictureFolder;
	
	public ProductManager(Webshop instance) {
		this.instance = instance;
		this.pictureFolder = new File("pictures");
		
		if(!pictureFolder.exists()) pictureFolder.mkdir();
	}
	
	public void load() {
		products.clear();
		try {
			Connection conn = instance.getSQLManager().getConnection();
			PreparedStatement query = conn.prepareStatement("SELECT * FROM products");
			ResultSet result = query.executeQuery();
			while(result.next()) {
				int id = result.getInt("id");
				int stock = result.getInt("stock");
				String identifier = result.getString("identifier");
				String name = result.getString("name");
				String desc = result.getString("description");
				double price = result.getDouble("price");
				products.add(new Product(id, identifier, name, desc, price, stock));
				System.out.println("Loaded product " + identifier + " (" + id + ")");
			}
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public Product getProduct(String identifier) {
		for(Product p : products) {
			if(p.getIdentifier().equals(identifier)) return p;
		}
		return null;
	}
	
	public List<Product> getProducts() {
		return products;
	}
	
}

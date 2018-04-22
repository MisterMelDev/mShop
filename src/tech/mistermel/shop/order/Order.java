package tech.mistermel.shop.order;

import java.util.ArrayList;
import java.util.List;

import tech.mistermel.shop.product.Product;
import tech.mistermel.shop.user.User;

public class Order {

	private int id;
	private List<Product> products = new ArrayList<Product>();
	private User user;
	private OrderState state;
	private long timePlaced;
	
	public Order(int id, List<Product> products, User user) {
		this.id = id;
		this.products = products;
		this.user = user;
		this.state = OrderState.AWAITING_PAYMENT;
		this.timePlaced = System.currentTimeMillis();
	}
	
	public Order(List<Product> products, User user, OrderState state) {
		this.products = products;
		this.user = user;
		this.state = state;
	}
	
	public int getId() {
		return id;
	}
	
	public List<Product> getProducts() {
		return products;
	}
	
	public User getUser() {
		return user;
	}
	
	public OrderState getState() {
		return state;
	}
	
	public long getTimePlaced() {
		return timePlaced;
	}
	
}

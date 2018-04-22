package tech.mistermel.shop.user;

import java.util.ArrayList;
import java.util.List;

import tech.mistermel.shop.order.Order;

public class User {

	private int id;
	private String firstName, lastName;
	private String email;
	private String password;
	private Address address;
	private List<Order> orders = new ArrayList<Order>();
	
	public User(int id, String firstName, String lastName, String email, String password, Address address, List<Order> orders) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.address = address;
		this.orders = orders;
	}
	
	public int getId() {
		return id;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public String getName() {
		return firstName + " " + lastName;
	}
	
	public String getEmail() {
		return email;
	}
	
	public String getPassword() {
		return password;
	}
	
	public Address getAddress() {
		return address;
	}
	
	public String getFormattedAddress() {
		Address address = this.getAddress();
		StringBuilder str = new StringBuilder();
		str.append(this.getName() + "\n");
		str.append(address.getStreet() + address.getNumber() + (address.getNumberExtra() != null ? address.getNumberExtra() : "") + "\n");
		str.append(address.getPostalCode() + "  " + address.getCity());
		return str.toString();
	}
	
	public List<Order> getOrders() {
		return orders;
	}

	public void sync() {
		// TODO: Synchronize with MySQL database
	}
	
}

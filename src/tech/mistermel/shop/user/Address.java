package tech.mistermel.shop.user;

public class Address {

	private String street;
	private int number;
	private String numberExtra;
	private String city;
	private String postalCode;
	
	public Address(String street, int number, String numberExtra, String city, String postalCode) {
		if(!validatePostalCode(postalCode)) {
			System.err.println("Reached address constructor with invalid postal code");
			return;
		}
		this.street = street;
		this.number = number;
		this.numberExtra = numberExtra;
		this.city = city;
		this.postalCode = postalCode;
	}
	
	public Address(String street, int number, String city, String postalCode) {
		this.street = street;
		this.number = number;
		this.numberExtra = null;
		this.city = city;
		this.postalCode = postalCode;
	}
	
	public String getStreet() {
		return street;
	}
	
	public int getNumber() {
		return number;
	}
	
	public String getNumberExtra() {
		return numberExtra;
	}
	
	public String getCity() {
		return city;
	}
	
	public String getPostalCode() {
		return postalCode;
	}
	
	public static boolean validatePostalCode(String postalCode) {
		return postalCode.matches("[0-9]{4} ?[a-z[A-Z]{2}");
	}
	
}

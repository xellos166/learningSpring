package com.myexamp.examp;

public class Address {
	private String city;
	private String street;
	public Address(String city, String street) {
		System.out.println("2 areg constructor called for Address");
		this.city = city;
		this.street = street;
	}
	@Override
	public String toString() {
		return "Address [city=" + city + ", street=" + street + "]";
	}
	
}

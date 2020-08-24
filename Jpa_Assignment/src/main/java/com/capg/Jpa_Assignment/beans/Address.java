package com.capg.Jpa_Assignment.beans;

import javax.persistence.Embeddable;

@Embeddable
public class Address {
	private String addressLine;
	private String city;
	private String state;
	
	public String getAddressLine() {
		return addressLine;
	}
	public void setAddressLine(String addressLine) {
		this.addressLine = addressLine;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Address(String addressLine, String city, String state) {
		super();
		this.addressLine = addressLine;
		this.city = city;
		this.state = state;
	}
	
	
}

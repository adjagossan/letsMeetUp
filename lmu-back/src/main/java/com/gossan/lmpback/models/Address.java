package com.gossan.lmpback.models;

import javax.persistence.*;

@Embeddable
@Access (AccessType.FIELD)
public class Address {
	
	private String street;
	private String city;
	private State state;
	@Column(name = "ZIP_CODE")
	private String zip;

	public Address(){}

	public Address(String street, String city, String zip){
		this.street = street;
		this.city = city;
		this.zip = zip;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}
}

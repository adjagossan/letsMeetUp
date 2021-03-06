package com.gossan.lmuback.models;

import lombok.Data;

import javax.persistence.*;

@Embeddable
@Access (AccessType.FIELD)
@Data
public class Address {
	
	private String street;
	private String city;
	@Column(name = "ZIP_CODE")
	private String zip;

	public Address(){}

	public Address(String street, String city, String zip){
		this.street = street;
		this.city = city;
		this.zip = zip;
	}
}

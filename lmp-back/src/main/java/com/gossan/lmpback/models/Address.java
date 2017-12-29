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
}

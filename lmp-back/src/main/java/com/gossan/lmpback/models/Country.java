package com.gossan.lmpback.models;

import javax.persistence.*;

@Entity
public class Country {
	
	@Id
	@GeneratedValue ()
	private int id;
	private String name;
	
	public Country() {
	}
}

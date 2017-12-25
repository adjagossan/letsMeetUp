package com.gossan.lmpback.models;

import javax.persistence.*;

@Entity
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private String firstName;
	private String name;
	private String mail;
	private Civility civility;
	private String town;
	private Country country;
	private long numberPhone;
	private String imagePath;
	
	public User() {
	}
	
}

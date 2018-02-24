package com.gossan.lmpback.models;

import javax.persistence.*;

public class Topic {
	
	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	private int id;
	private String value;
	
	public Topic() {
	}
	
	public Topic(String value) {
		this.value = value;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
}

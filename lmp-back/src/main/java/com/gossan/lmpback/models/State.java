package com.gossan.lmpback.models;

import javax.persistence.*;

@Entity
public class State {
	
	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	private int id;
	private String name;
	
	public State() {
	}
	
	public State(String name) {
		this.name = name;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}

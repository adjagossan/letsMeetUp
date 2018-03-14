package com.gossan.lmuback.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
public class State {
	
	@Id
	@Column(name = "STATE_ID")
	@GeneratedValue (strategy = GenerationType.AUTO)
	private int id;

	private String name;

	@OneToMany(mappedBy = "state")
	private Collection<Person> organizers = new ArrayList<>();

	@OneToMany(mappedBy = "state")
	private Collection<Event> events;
	
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

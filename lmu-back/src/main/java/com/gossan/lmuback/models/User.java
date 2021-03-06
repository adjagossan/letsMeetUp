package com.gossan.lmuback.models;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.util.*;

//@Entity
public class User {
	
	@Id
	@Column(name = "USER_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	/*
	@Enumerated(EnumType.STRING)
	private Civility civility;
	
	@Embedded
	private Address address;

	@NotEmpty
	private String firstName;

	@NotEmpty
	private String lastName;

	@Email
	private String mail;

	@NotEmpty
	private String numberPhone;
	
	private String imagePath;

	@OneToMany (mappedBy = "organizer")
	private Collection<Event> createdEvent;
	
	@ManyToMany
	@JoinTable(
			name = "USER_EVENT",
			joinColumns = { @JoinColumn(name = "USER_ID")},
			inverseJoinColumns = { @JoinColumn(name = "EVENT_ID")}
	)
	private Collection<Event> assistedEvent;
	*/

	public User() {
	}

	public User(int h){
	}

	@Override
	public String toString(){
		return String.format("Customer[id=%d, firstName='%s', lastName='%s']", id/*, firstName, lastName*/);
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	/*
	public Civility getCivility() {
		return civility;
	}

	public void setCivility(Civility civility) {
		this.civility = civility;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getNumberPhone() {
		return numberPhone;
	}

	public void setNumberPhone(String numberPhone) {
		this.numberPhone = numberPhone;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public Collection<Event> getCreatedEvent() {
		return createdEvent;
	}

	public void setCreatedEvent(Collection<Event> createdEvent) {
		this.createdEvent = createdEvent;
	}

	public Collection<Event> getAssistedEvent() {
		return assistedEvent;
	}

	public void setAssistedEvent(Collection<Event> assistedEvent) {
		this.assistedEvent = assistedEvent;
	}
	*/
}

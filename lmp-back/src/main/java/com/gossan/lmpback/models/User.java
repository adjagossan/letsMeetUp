package com.gossan.lmpback.models;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.util.*;

@Entity
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
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
	private Event assistedEvent;
	
	public User() {
	}

	@Override
	public String toString(){
		return String.format("Customer[id=%d, firstName='%s', lastName='%s']", id, firstName, lastName);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

	public Event getAssistedEvent() {
		return assistedEvent;
	}

	public void setAssistedEvent(Event assistedEvent) {
		this.assistedEvent = assistedEvent;
	}
	
}

package com.gossan.lmpback.models;

import javax.persistence.*;
import java.util.*;

@Entity
public class Event {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Temporal(TemporalType.DATE)
	private Date startDate;
	
	@Temporal(TemporalType.DATE)
	private Date endDate;
	
	@Embedded
	private Address address;
	
	private String name;
	
	private String description;
	
	private String image;
	
	@ManyToOne
	@JoinColumn(name="FK_USER")
	private User organizer;
	
	@ManyToMany
	private Collection<User> participants;
	
	private Topic topic;
	
	public Event() {
	}
}

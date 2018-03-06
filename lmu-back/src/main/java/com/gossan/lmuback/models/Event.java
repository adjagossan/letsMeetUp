package com.gossan.lmuback.models;

import javax.persistence.*;
import java.util.*;

@Entity
public class Event {
	
	@Id
	@Column(name = "EVENT_ID")
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

	@OneToOne
	@JoinColumn(name="TOPIC_ID")
	private Topic topic;

	@ManyToOne
	@JoinColumn(name="STATE_ID")
	private State state;
	
	@ManyToOne
	@JoinColumn(name="USER_ID")
	private User organizer;
	
	@ManyToMany( mappedBy = "assistedEvent")
	private Collection<User> participants;
	
	public Event() {
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public Topic getTopic() {
		return topic;
	}

	public void setTopic(Topic topic) {
		this.topic = topic;
	}
}

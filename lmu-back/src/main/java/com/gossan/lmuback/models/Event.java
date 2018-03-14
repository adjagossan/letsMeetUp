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
	@JoinColumn(name="PERSON_ID")
	private Person organizer;
	
	@ManyToMany( mappedBy = "assistedEvent")
	private Collection<Person> participants = new ArrayList<>();
	
	public Event() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Person getOrganizer() {
		return organizer;
	}

	public void setOrganizer(Person organizer) {
		this.organizer = organizer;
	}

	public Collection<Person> getParticipants() {
		return participants;
	}

	public void setParticipants(Collection<Person> participants) {
		this.participants = participants;
	}

	public void addParticipant(Person person){
	    this.participants.add(person);
    }

    public void addParticipantAll(Collection<Person> participants){
        this.participants.addAll(participants);
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

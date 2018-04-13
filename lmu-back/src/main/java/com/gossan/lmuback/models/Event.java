package com.gossan.lmuback.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.*;

@Entity
@Data
public class Event {
	
	@Id
	@Column(name = "EVENT_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
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
	@NotNull
	@JoinColumn(name="PERSON_ID")
	private Person organizer;
	
	@ManyToMany( mappedBy = "assistedEvent")
	private Collection<Person> participants = new ArrayList<>();

	@Version
	@JsonIgnore
	private Long version;
	
	public Event() {
	}

	public void addParticipant(Person person){
	    this.participants.add(person);
    }

    public void addParticipantAll(Collection<Person> participants){
        this.participants.addAll(participants);
    }

}

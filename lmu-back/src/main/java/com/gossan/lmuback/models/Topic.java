package com.gossan.lmuback.models;

import javax.persistence.*;

@Entity
public class Topic {

	@Id
	@Column(name = "TOPIC_ID")
	@GeneratedValue (strategy = GenerationType.AUTO)
	private long id;
	private String value;

	@OneToOne(mappedBy = "topic")
	private Event event;
	
	public Topic() {
	}
	
	public Topic(String value) {
		this.value = value;
	}

	public long getId() {
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

	public Event getEvent() {
		return event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}
}

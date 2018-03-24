package com.gossan.lmuback.models;

import lombok.Data;
import javax.persistence.*;

@Entity
@Data
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

}

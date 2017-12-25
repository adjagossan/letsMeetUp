package com.gossan.lmpback.models;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Event {
	
	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	private int id;
	private String name;
	private String description;
	private String address;
	private String image;
	private User organizer;
	private Date dateStart;
	private Date dateEnd;
	private Topic topic;
	
	public Event() {
	}
}

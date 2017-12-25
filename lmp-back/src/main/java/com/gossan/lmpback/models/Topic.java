package com.gossan.lmpback.models;

import javax.persistence.*;

public class Topic {
	
	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	private int id;
	private String value;
}

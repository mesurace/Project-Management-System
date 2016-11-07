package com.ea.project.model;

import javax.persistence.Entity;
import javax.persistence.Id;


/**
 * @author sureshadhikari
 *
 */
@Entity
public class Volunteer {
	public int getVolunteerId() {
		return volunteerId;
	}

	public void setVolunteerId(int volunteerId) {
		this.volunteerId = volunteerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Id
	private int volunteerId;
	private String name;
	
	public String toString(){
		return "Name : "+this.name;
	}

}

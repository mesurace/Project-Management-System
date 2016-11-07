package com.ea.project.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author sureshadhikari
 *
 */

@Entity
public class Task {

	public int getTaskId() {
		return taskId;
	}

	public List<Volunteer> getVolunteers() {
		return volunteers;
	}

	public void setVolunteers(List<Volunteer> volunteers) {
		this.volunteers = volunteers;
	}

	public void setTaskId(int taskId) {
		this.taskId = taskId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public List<Resource> getResources() {
		return resources;
	}

	public void setResources(List<Resource> resources) {
		this.resources = resources;
	}

	@Id
	@GeneratedValue
	private int taskId;
	private String name;

	@Temporal(TemporalType.DATE)
	private Date startDate;

	@Temporal(TemporalType.DATE)
	private Date endDate;
	private String description;

	@Enumerated(EnumType.STRING)
	private Status status;

	@OneToMany
	@JoinColumn(name = "taskId")
	private List<Resource> resources = new ArrayList<>();

	@OneToMany
	@JoinColumn(name = "taskId")
	private List<Volunteer> volunteers = new ArrayList<>();
	
	
	public String toString() {
		return "Name : " + this.name + "\nDescription : " + this.description + "\nStart Date : " + this.startDate
				+ "\nEnd Date : " + this.endDate + "\nStatus : " + this.status+ "\nVolunteers : " + this.volunteers.toString();
	}

}

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
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author sureshadhikari
 *
 */

@Entity
public class Project {

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getProjectId() {
		return projectId;
	}

	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public byte[] getDescriptionImage() {
		return descriptionImage;
	}

	public void setDescriptionImage(byte[] descriptionImage) {
		this.descriptionImage = descriptionImage;
	}

	public List<Task> getTasks() {
		return tasks;
	}

	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}

	public List<Beneficiary> getBeneficiaries() {
		return beneficiaries;
	}

	public void setBeneficiaries(List<Beneficiary> beneficiaries) {
		this.beneficiaries = beneficiaries;
	}

	@Id
	@GeneratedValue
	private int projectId;
	private String title;
	private String description;

	@Temporal(TemporalType.DATE)
	private Date startDate;

	@Temporal(TemporalType.DATE)
	private Date endDate;

	@Enumerated(EnumType.STRING)
	private Status status;

	@Lob
	private byte[] descriptionImage;

	@OneToMany
	@JoinColumn(name = "projectId")
	List<Task> tasks = new ArrayList<>();

	@OneToMany
	@JoinColumn(name = "projectId")
	List<Beneficiary> beneficiaries = new ArrayList<>();

	public String toString() {
		return "Projects:\nTitle : " + this.title + "\nDescription : " + this.description + "\nStart Date : "
				+ this.startDate + "\nEnd Date : " + this.endDate + "\nStatus : " + this.status + "\nTasks : "
				+ this.tasks + "\nBeneficiaries : "+ this.beneficiaries;
	}

}

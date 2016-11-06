package com.ea.project.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;

/**
 * @author sureshadhikari
 *
 */

@Entity
public class Beneficiary {
	public int getBeneficiaryId() {
		return beneficiaryId;
	}

	public void setBeneficiaryId(int beneficiaryId) {
		this.beneficiaryId = beneficiaryId;
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

	public byte[] getInfo() {
		return info;
	}

	public void setInfo(byte[] info) {
		this.info = info;
	}

	@Id
	@GeneratedValue
	private int beneficiaryId;
	private String name;
	private String description;

	@Lob
	private byte[] info;
	
	public String toString(){
		return "Name : "+this.name+"\nDescription : "+this.description;
	}
}

package com.ty.hospital_project.dto;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Person {
	
	@Id
	private int personId;
	private String personName;
	private long personPhone;
	private String personAddress;
	
	@OneToMany
	private List<Encounter> encounter;
	
	public int getPersonId() {
		return personId;
	}
	public void setPersonId(int personId) {
		this.personId = personId;
	}
	public String getPersonName() {
		return personName;
	}
	public void setPersonName(String personName) {
		this.personName = personName;
	}
	public long getPersonPhone() {
		return personPhone;
	}
	public void setPersonPhone(long personPhone) {
		this.personPhone = personPhone;
	}
	public String getPersonAddress() {
		return personAddress;
	}
	public void setPersonAddress(String personAddress) {
		this.personAddress = personAddress;
	}
	public List<Encounter> getEncounter() {
		return encounter;
	}
	public void setEncounter(List<Encounter> encounter) {
		this.encounter = encounter;
	}
	
	@Override
	public String toString() {
		return "Person [personId=" + personId + ", personName=" + personName + ", personPhone=" + personPhone
				+ ", personAddress=" + personAddress + ", encounter=" + encounter + "]";
	}
	
}
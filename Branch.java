package com.ty.hospital_project.dto;

import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Branch {
	
	@Id
	private int id;
	private String bname;
	private long phone;
	
//	@ManyToOne
//	private Encounter encounter;
//	
//	public Encounter getEncounter() {
//		return encounter;
//	}
//
//	public void setEncounter(Encounter encounter) {
//		this.encounter = encounter;
//	}

	@OneToOne
	private Address address;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBname() {
		return bname;
	}

	public void setBname(String bname) {
		this.bname = bname;
	}

	public long getPhone() {
		return phone;
	}

	public void setPhone(long phone) {
		this.phone = phone;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Branch [id=" + id + ", bname=" + bname + ", phone=" + phone + ", address=" + address + "]";
	}

//	@Override
//	public String toString() {
//		return "Branch [id=" + id + ", bname=" + bname + ", phone=" + phone + ", encounter=" + encounter + ", address="
//				+ address + "]";
//	}

	
	
	
	
}

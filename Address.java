package com.ty.hospital_project.dto;

import javax.persistence.Entity;

import javax.persistence.Id;

@Entity
public class Address {
	
	@Id
	private int id;
	private String name;
	private long pincode;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getPincode() {
		return pincode;
	}

	public void setPincode(long pincode) {
		this.pincode = pincode;
	}

	@Override
	public String toString() {
		return "Address [id=" + id + ", name=" + name + ", pincode=" + pincode + "]";
	}

	
}

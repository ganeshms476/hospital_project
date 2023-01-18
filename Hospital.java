package com.ty.hospital_project.dto;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class Hospital {
	@Id
	private int id;
	private String h_name;
	private String gst;
	
	@OneToMany
	private List<Branch> branches;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getH_name() {
		return h_name;
	}

	public void setH_name(String h_name) {
		this.h_name = h_name;
	}

	public String getGst() {
		return gst;
	}

	public void setGst(String gst) {
		this.gst = gst;
	}

	public List<Branch> getBranches() {
		return branches;
	}

	public void setBranches(List<Branch> branches) {
		this.branches = branches;
	}

	@Override
	public String toString() {
		return "Hospital [id=" + id + ", h_name=" + h_name + ", gst=" + gst + ", branches=" + branches + "]";
	}
	
	
	
	
}

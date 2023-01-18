package com.ty.hospital_project.dto;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Encounter {
	@Id
	private int id;
	private String name;
	private String place;
	
//	@OneToMany
//	private List<Branch> branchList;
//	
//	public List<Branch> getBranchList() {
//		return branchList;
//	}
//
//	public void setBranchList(List<Branch> branchList) {
//		this.branchList = branchList;
//	}


	@OneToMany
	private List<MedicineOrder> medicineOrder;


	public List<MedicineOrder> getMedicineOrder() {
		return medicineOrder;
	}

	public void setMedicineOrder(List<MedicineOrder> medicineOrder) {
		this.medicineOrder = medicineOrder;
	}

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

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	@Override
	public String toString() {
		return "Encounter [id=" + id + ", name=" + name + ", place=" + place + ", medicineOrder=" + medicineOrder + "]";
	}

	

}

package com.ty.hospital_project.dto;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Encounter {
	@Id
	private int id;
	private String cause;
	private String date;
//	
	@OneToMany
	private List<Branch> branchList;
	
	public List<Branch> getBranchList() {
		return branchList;
	}

	public void setBranchList(List<Branch> branchList) {
		this.branchList = branchList;
	}
//

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

	public String getCause() {
		return cause;
	}

	public void setCause(String cause) {
		this.cause = cause;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Encounter [id=" + id + ", cause=" + cause + ", date=" + date + ", branchList=" + branchList
				+ ", medicineOrder=" + medicineOrder + "]";
	}

	
	

}

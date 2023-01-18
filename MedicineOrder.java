package com.ty.hospital_project.dto;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class MedicineOrder {
	
	@Id
	private int medId;
	private String dname;
	private String disease;
	
	@OneToMany
	private List<MedicineItems> medicineItems;

	public int getMedId() {
		return medId;
	}

	public void setMedId(int medId) {
		this.medId = medId;
	}

	public String getDname() {
		return dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}

	public String getDisease() {
		return disease;
	}

	public void setDisease(String disease) {
		this.disease = disease;
	}

	public List<MedicineItems> getMedicineItems() {
		return medicineItems;
	}

	public void setMedicineItems(List<MedicineItems> medicineItems) {
		this.medicineItems = medicineItems;
	}

	@Override
	public String toString() {
		return "MedicineOrder [medId=" + medId + ", Dname=" + dname + ", disease=" + disease + ", medicineItems="
				+ medicineItems + "]";
	}

	
	
	
}

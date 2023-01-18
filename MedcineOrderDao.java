package com.ty.hospital_project.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ty.hospital_project.dto.Encounter;
import com.ty.hospital_project.dto.MedicineItems;
import com.ty.hospital_project.dto.MedicineOrder;

public class MedcineOrderDao {


	public EntityManager getEntityManager() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vinod");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		return entityManager;
	}

	
	public void saveMedicineOrder(MedicineOrder medicineOrder,int encounter_id) {


		EntityManager entityManager=getEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		
		Encounter encounter=entityManager.find(Encounter.class, encounter_id);
		
		List<MedicineOrder> medicineOrderList=encounter.getMedicineOrder(); 
		
		if(medicineOrderList!=null) {
			medicineOrderList.add(medicineOrder);
			encounter.setId(encounter_id);
			encounter.setMedicineOrder(medicineOrderList);
			
		entityTransaction.begin();

		entityManager.persist(medicineOrder);
		entityManager.merge(encounter);
		
		entityTransaction.commit();
		}else {
			medicineOrderList.add(medicineOrder);
			encounter.setId(encounter_id);
			encounter.setMedicineOrder(medicineOrderList);
			
			entityTransaction.begin();
	
			entityManager.persist(medicineOrder);
			entityManager.merge(encounter);
			
			entityTransaction.commit();
			
		}
	}
	
	public void updateMedicineOrder( MedicineOrder medicineOrder) {
		EntityManager entityManager=getEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		
		MedicineOrder medicineOrder1=entityManager.find(MedicineOrder.class,medicineOrder.getMedId());
		
		entityTransaction.begin();

		if(medicineOrder1!=null) {
			medicineOrder1.setMedId(medicineOrder.getMedId());
			medicineOrder1.setDname(medicineOrder.getDname());
	
						
			entityManager.merge(medicineOrder1);

			entityTransaction.commit();
			System.out.println("Updated successfully");
			
		}
		else {
			System.out.println("this MedicineOrder id is not present");
		}
//		
		
		}
	
	
	public void deleteMedicineOrder(int id) {
		EntityManager entityManager=getEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		
		MedicineOrder medicineOrder=entityManager.find(MedicineOrder.class,id);
		
		entityTransaction.begin();
		
		if(medicineOrder!=null) {
			medicineOrder.setMedId(id);
			medicineOrder.setMedicineItems(medicineOrder.getMedicineItems());
			
			entityManager.remove(medicineOrder.getMedicineItems());
			entityManager.remove(medicineOrder);
			

			entityTransaction.commit();
			
			System.out.println("Deleted successfully");
		}
		else {
			System.out.println("MedicineOrder id not present");
		}
			
	}
	
	
	public MedicineOrder getMedicineOrderById(int id) {
		EntityManager entityManager=getEntityManager();
		
		
		MedicineOrder medicineOrder=entityManager.find(MedicineOrder.class,id);
		return medicineOrder;
		
	}

	public List<MedicineOrder> getAllMedicineOrder() {
		EntityManager entityManager=getEntityManager();
		Query query=entityManager.createQuery("select m from MedicineOrder m");
		List<MedicineOrder> list=query.getResultList();
		return list;
		
		
	}
	
	
	
	
}

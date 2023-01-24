package com.ty.hospital_project.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.function.ToIntFunction;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ty.hospital_project.dto.Branch;
import com.ty.hospital_project.dto.Encounter;
import com.ty.hospital_project.dto.MedicineOrder;
import com.ty.hospital_project.dto.Person;

public class EncounterCrud {

	public EntityManager getEntityManager() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vinod");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		return entityManager;
	}

	public void saveEncounter(Encounter encounter, int person_id, int branch_id) {
		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		Person person = entityManager.find(Person.class, person_id);

		Branch branch = entityManager.find(Branch.class, branch_id);

		List<Encounter> encounterList = person.getEncounter();
		List<Branch> branchList=encounter.getBranchList();
		
		if (encounterList != null && branchList!=null) {

			encounterList.add(encounter);
			branchList.add(branch);
			//branch.setEncounter(encounter);
			person.setPersonId(person_id);
			person.setEncounter(encounterList);
			
			encounter.setBranchList(branchList);
			branch.setId(branch_id);
			
			entityTransaction.begin();

			entityManager.persist(encounter);
			entityManager.merge(person);
			entityManager.merge(branch);
			entityTransaction.commit();
		}
		else {
			List<Encounter> encounterList1 =new ArrayList<Encounter>();
			List<Branch> branchList1=new ArrayList<Branch>();
			encounterList1.add(encounter);
			branchList1.add(branch);
		//	branch.setEncounter(encounter);
			person.setPersonId(person_id);
			person.setEncounter(encounterList1);
			
			encounter.setBranchList(branchList1);
			branch.setId(branch_id);

			entityTransaction.begin();

			entityManager.persist(encounter);
			entityManager.merge(person);
			entityManager.merge(branch);
			entityTransaction.commit();

		}
	}

	public void updateEncounter(int id, Encounter encounter) {
		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		Encounter encounter1 = entityManager.find(Encounter.class, id);
		if (encounter1 != null) {
			encounter.setId(id);
			entityTransaction.begin();
			entityManager.merge(encounter);
			entityTransaction.commit();
			System.out.println("updated successfully");
		} else {
			System.out.println("not found");
		}


	}

	public void deleteEncounter(int id) {
		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		Encounter encounter = entityManager.find(Encounter.class, id);
		if (encounter != null) {
			entityTransaction.begin();
			entityManager.remove(encounter);
			entityTransaction.commit();
			System.out.println("deleted successfully");
		} else {
			System.out.println("not found");
		}
	}

	public void fetchById(int id) {
		EntityManager entityManager = getEntityManager();
		Encounter encounter = entityManager.find(Encounter.class, id);
		System.out.println(encounter);
		System.out.println("fetched successfully");
	}

	public void getAll() {
		EntityManager entityManager = getEntityManager();
		Query query = entityManager.createQuery("select e from Encounter e");
		List<Encounter> list = query.getResultList();
		System.out.println(list);
		System.out.println("fetched successfully");
	}

}

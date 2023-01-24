package com.ty.hospital_project.dao;

import java.util.List;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ty.hospital_project.dto.Branch;
import com.ty.hospital_project.dto.Hospital;

public class BranchDAO {
	public EntityManager getEntityManager() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vinod");
		return entityManagerFactory.createEntityManager();
	}
	
	public void saveBranch(Branch branch,int hospital_id) {
		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		
		Hospital hospital =entityManager.find(Hospital.class, hospital_id);
		
		List<Branch> branchList=hospital.getBranches();
	
		if(hospital!=null) {
		
		branchList.add(branch);
		hospital.setId(hospital_id);
		hospital.setBranches(branchList);
		
		entityTransaction.begin();
		
		entityManager.persist(branch);
		
		entityManager.merge(hospital);
		entityTransaction.commit();
		}
		
		
		
	}
	
	public void updateBranch(Branch branch) {
		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		Branch branch2=entityManager.find(Branch.class, branch.getId());
		branch2.setId(branch.getId());
		branch2.setBname(branch.getBname());
		entityTransaction.begin();
		entityManager.merge(branch2);
		entityTransaction.commit();
	}
	
	public void deleteBranch(int id) {
		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		Branch branch=entityManager.find(Branch.class,id);
		branch.setId(id);
		entityTransaction.begin();
		entityManager.remove(branch);
		entityTransaction.commit();
	}
	
	public void getBranchById(int id) {
		EntityManager entityManager = getEntityManager();
		Branch branch=entityManager.find(Branch.class, id);
		
		System.out.println(branch);
	}
	
	public void getAll() {
		EntityManager entityManager = getEntityManager();
		Query query=entityManager.createQuery("SELECT b from Branch b");
		List<Branch> list = query.getResultList();
		System.out.println(list);
	}
}








package com.ty.hospital_project.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ty.hospital_project.dto.Encounter;
import com.ty.hospital_project.dto.Person;

public class PersonDao {
	public EntityManager getEntityManager() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vinod");
		return entityManagerFactory.createEntityManager();
	}

	public void savePerson(Person person) {
		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		
		entityTransaction.begin();
		entityManager.persist(person);
		entityTransaction.commit();
		
		System.out.println("Person inserted successfully...!!");
	}

	public void updatePerson(int id, Person person) {
		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		Person fetchedPerson = entityManager.find(Person.class, id);
		if (fetchedPerson != null) {
			person.setPersonId(id);
			entityTransaction.begin();
			entityManager.merge(person);
			entityTransaction.commit();
			System.out.println("Person updated successfully...!!");
		} else {
			System.out.println("Person not available");
		}
	}

	public void deletePerson(int id) {
		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		Person person = entityManager.find(Person.class, id);
		if (person != null) {
			entityTransaction.begin();
			entityManager.remove(person);
			entityTransaction.commit();
			System.out.println("Person deleted successfully");
		} else {
			System.out.println("Person not available...!!");
		}
	}

	public void fetchPerson(int id) {
		EntityManager entityManager = getEntityManager();
		Person person = entityManager.find(Person.class, id);
		System.out.println(person);
	}

	public void fetchAllPersons() {
		EntityManager entityManager = getEntityManager();
		Query query = entityManager.createQuery("select p from Person p");
		List<Person> person = query.getResultList();
		System.out.println(person);
	}
}

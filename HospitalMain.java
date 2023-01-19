package com.ty.hospital_project.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder.Case;

import com.ty.hospital_project.dao.AddressDAO;
import com.ty.hospital_project.dao.BranchDAO;
import com.ty.hospital_project.dao.EncounterCrud;
import com.ty.hospital_project.dao.HospitalDAO;
import com.ty.hospital_project.dao.MedcineOrderDao;
import com.ty.hospital_project.dao.MedicineItemsDAO;
import com.ty.hospital_project.dao.PersonDao;
import com.ty.hospital_project.dto.Address;
import com.ty.hospital_project.dto.Branch;
import com.ty.hospital_project.dto.Encounter;
import com.ty.hospital_project.dto.Hospital;
import com.ty.hospital_project.dto.MedicineItems;
import com.ty.hospital_project.dto.MedicineOrder;
import com.ty.hospital_project.dto.Person;

public class HospitalMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vinod");

		Scanner scanner = new Scanner(System.in);
		
		Hospital hospital = new Hospital();
		
		HospitalDAO hospitalDAO = new HospitalDAO();
		BranchDAO branchDAO = new BranchDAO();
		AddressDAO addressDAO = new AddressDAO();
		PersonDao personDao = new PersonDao();
		EncounterCrud encounterCrud = new EncounterCrud();
		MedcineOrderDao medcineOrderDao = new MedcineOrderDao();
		MedicineItemsDAO medicineItemsDAO = new MedicineItemsDAO();
		
		boolean exit = true;
		do {
			System.out.println("=======To which one u want to perform actions======");
			System.out.println(" 1.Hospital \n 2.Branch \n 3.Address \n 4.Person \n 5.Encounter \n 6.MedicineOrder \n 7.MedicineItems \n 8.exit");
			System.out.println("Enter your choice");
			int choice = scanner.nextInt();

			switch (choice) {

			case 1: {
				boolean exit1 = true;
				do {
					System.out.println(" 1.Add hospital \n 2.Get hospital details by id \n 3.Get all hospital details \n 4.exit");
					System.out.println("Enter your choice");
					int choice1 = scanner.nextInt();
					switch (choice1) {
					case 1: {
						System.out.println("Enter the hospital id");
						int id = scanner.nextInt();

						System.out.println("Enter the hospital name");
						String name = scanner.next();

						System.out.println("Enter the gst");
						String gst = scanner.next();

						hospital.setId(id);
						hospital.setH_name(name);
						hospital.setGst(gst);

						hospitalDAO.saveHospital(hospital);
					}
						break;
					case 2: {
						System.out.println("Enter the hospital id to get the details");
						int id = scanner.nextInt();
						
						hospitalDAO.getHospitalById(id);
						System.out.println(" ===========hospitals details==========");

					}
						break;
					case 3: {
						hospitalDAO.getAllHospital();
						System.out.println(" ===========hospitals details==========");

					}
						break;
					case 4: {
						exit1 = false;
						System.out.println("======Thank you====");

					}
						break;
					default:
						System.out.println("Invalid choice");
					}

				} while (exit1);

			}
				break;

			case 2: {
			
				boolean exit2 = true;
				do {
					System.out.println(" 1.Add branch \n 2.Get branch details by id \n 3.Get all branch details \n 4.exit");
					System.out.println("Enter your choice");
					int choice1 = scanner.nextInt();
					switch (choice1) {
					case 1: {
						hospitalDAO.getAllHospital();
						System.out.println(" ===========hospitals details==========");
		
						System.out.println("====Enter the hospital id to add the branch to the hospital====");
		
						int hospital_id = scanner.nextInt();
		
						System.out.println("======Add branch details======");
		
						System.out.println("enter the branch id");
						int bid = scanner.nextInt();
						System.out.println("Enter the branch name");
						String bname = scanner.next();
						System.out.println("Enter the phone");
						long phone = scanner.nextLong();
		
						Branch branch = new Branch();
						branch.setId(bid);
						branch.setBname(bname);
						branch.setPhone(phone);
		
						branchDAO.saveBranch(branch, hospital_id);
					}
					break;
					case 2:{
						System.out.println("Enter the branch id to get the details");
						int id = scanner.nextInt();

						branchDAO.getBranchById(id);
						System.out.println(" ===========branch details==========");
					}
					break;
					case 3:{
						branchDAO.getAll();
						System.out.println(" ===========branch details==========");
					}
					break;
					case 4:{
						exit2 = false;
						System.out.println("======Thank you====");
						
					}
					break;
					default: System.out.println("Invalid choice");
					}
				}while(exit2);

			}
				break;

			case 3: {

				boolean exit3 = true;
				do {
					System.out.println(" 1.Add address \n 2.Get address details by id \n 3.Get all address details \n 4.exit");
					System.out.println("Enter your choice");
					int choice1 = scanner.nextInt();
					switch (choice1) {
					case 1: {
		
						branchDAO.getAll();
						System.out.println(" ===========branch details==========");
						
		
						System.out.println("===Enter the branch id to add address== ");
						int branch_id = scanner.nextInt();
						
						System.out.println("======Add Address=====");
		
						System.out.println("enter the Address id");
						int aid = scanner.nextInt();
						System.out.println("Enter the address");
						String loc_name = scanner.next();
						System.out.println("Enter the pincode");
						long pincode = scanner.nextLong();
		
						Address address = new Address();
						address.setId(aid);
						address.setName(loc_name);
						address.setPincode(pincode);
		
						Branch branch = new Branch();
						branch.setId(branch_id);
		
						addressDAO.saveAddress(address, branch_id);
					}
					break;
					case 2:{
						System.out.println("Enter the address id to get the details");
						int id = scanner.nextInt();
						
						addressDAO.getAddressById(id);
						System.out.println(" ===========address details==========");
					}
					break;
					case 3:{
						addressDAO.getAll();
						System.out.println(" ===========address details==========");
					}
					break;
					case 4:{
						exit3=false;
						System.out.println("======Thank you=====");
					}
					break;
					default:System.out.println("Invalid choice");
					
					}
				}while(exit3);

			}
				break;

			case 4: {
				boolean exit4 = true;
				do {
					System.out.println(" 1.Add person \n 2.Get person details by id \n 3.Get all person details \n 4.exit");
					System.out.println("Enter your choice");
					int choice1 = scanner.nextInt();
					switch (choice1) {
					case 1: {

						System.out.println(" ===add person====");
		
						System.out.println("Enter person id");
						int personId = scanner.nextInt();
		
						System.out.println("Enter person name");
						String name = scanner.next();
		
						System.out.println("Enter person phone");
						long phone = scanner.nextLong();
		
						System.out.println("Enter the person Address");
						String address = scanner.next();
		
						Person person = new Person();
						person.setPersonId(personId);
						person.setPersonName(name);
						person.setPersonPhone(phone);
						person.setPersonAddress(address);
		
						personDao.savePerson(person);
					}
					break;
					case 2:{
						System.out.println("Enter the person id to get the details");
						int id = scanner.nextInt();
						
						personDao.fetchPerson(id);
						System.out.println(" ===========person details==========");
					}
					break;
					case 3:{
						personDao.fetchAllPersons();
						System.out.println(" ===========person details==========");
					}
					break;
					case 4:{
						exit4=false;
						System.out.println("======Thank you=====");
					}
					break;
					default:System.out.println("Invalid choice");
					
					}
				}while(exit4);

			}
				break;

			case 5: {
				boolean exit5 = true;
				do {
					System.out.println(" 1.Add Encounter \n 2.Get Encounter details by id \n 3.Get all Encounter details \n 4.exit");
					System.out.println("Enter your choice");
					int choice1 = scanner.nextInt();
					switch (choice1) {
					case 1: {
	
						personDao.fetchAllPersons();
						System.out.println("=====Person details=====");
						
						System.out.println("======Enter person id to Encounter====");
						int personId = scanner.nextInt();
		
						
						hospitalDAO.getAllHospital();
						System.out.println(" ====the hospital details==== ");
						System.out.println("=============================");
						branchDAO.getAll();
						System.out.println("====Hopsital branchs====");
						System.out.println("==To which branch u want to encounter==");
		
		
						System.out.println("Enter the branch id u want to encounter");
						int bid = scanner.nextInt();
		
						System.out.println(" =======Add Encounter=======");
		
						System.out.println("enter the encounter id");
						int id = scanner.nextInt();
		
						System.out.println("Enter the cause to encounter");
						String cause = scanner.next();
						
						System.out.println("Enter the date of encounter");
						String date = scanner.next();
		
						Encounter encounter = new Encounter();
		
						encounter.setId(id);
						encounter.setCause(cause);
						encounter.setDate(date);
		
						Person person = new Person();
						person.setPersonId(personId);
		
						Branch branch = new Branch();
						branch.setId(bid);
		
						
						encounterCrud.saveEncounter(encounter, personId, bid);
					}
					break;
					case 2:{
						System.out.println("Enter the encounter id to get the details");
						int id = scanner.nextInt();
						
						encounterCrud.fetchById(id);
						System.out.println(" ===========encounter details==========");
						
					}
					break;
					case 3:{
						encounterCrud.getAll();
						System.out.println(" ===========encounter details==========");
					}
					break;
					case 4:{
						exit5=false;
						System.out.println("======Thank you=====");
					}
					break;
					default:System.out.println("Invalid choice");
					
					}
				}while(exit5);

			}
				break;

			case 6: {
				boolean exit6 = true;
				do {
					System.out.println(" 1.Add medicineOrder \n 2.Get medicineOrder details by id \n 3.Get all medicineOrder details \n 4.exit");
					System.out.println("Enter your choice");
					int choice1 = scanner.nextInt();
					switch (choice1) {
					case 1: {
	
						encounterCrud.getAll();
						
						System.out.println("====encounter details=====");
						
						System.out.println("enter the encounter id ");
						int eid = scanner.nextInt();
		
						System.out.println("======enter the medicineOrder==========");
		
						System.out.println("Enter the medicineOrder id");
						int id = scanner.nextInt();
		
						System.out.println("Enter the consulted doctor name");
						String name = scanner.next();
		
						System.out.println("Enter the disease");
						String disease = scanner.next();
		
						MedicineOrder medicineOrder = new MedicineOrder();
						medicineOrder.setMedId(id);
						medicineOrder.setDname(name);
						medicineOrder.setDisease(disease);
		
						
						Encounter encounter = new Encounter();
						encounter.setId(eid);
		
						medcineOrderDao.saveMedicineOrder(medicineOrder, eid);
					}
					break;
					case 2:{
						System.out.println("Enter the medicineOrder id to get the details");
						int id = scanner.nextInt();
						medcineOrderDao.getMedicineOrderById(id);
						System.out.println(" ===========medicineOrder details==========");
						
					}
					break;
					case 3:{
						medcineOrderDao.getAllMedicineOrder();
						System.out.println(" ===========medicineOrder details==========");
						
					}
					break;
					case 4:{
						exit6=false;
						System.out.println("======Thank you=====");
					}
					break;
					default:System.out.println("Invalid choice");
					
					}
				}while(exit6);


			}
				break;

			case 7: {
				boolean exit7 = true;
				do {
					System.out.println(" 1.Add medicineItems \n 2.Get medicineItems details by id \n 3.Get all medicineItems details \n 4.exit");
					System.out.println("Enter your choice");
					int choice1 = scanner.nextInt();
					switch (choice1) {
					case 1: {
						
						medcineOrderDao.getAllMedicineOrder();
						System.out.println("=======medicienOrder details============");
						
						System.out.println("Enter the medicineOrder id");
						int mid = scanner.nextInt();
						
						System.out.println("======enter the medicineItems==========");
		
						System.out.println("Enter the medicineItems id");
						int id = scanner.nextInt();
		
						System.out.println("Enter the medicineItem name");
						String name = scanner.next();
		
						System.out.println("Enter the medicineItem price");
						double price = scanner.nextDouble();
		
						System.out.println("Enter the medicine quantity");
						int quantity = scanner.nextInt();
		
						MedicineItems medicineItems = new MedicineItems();
						medicineItems.setId(id);
						medicineItems.setName(name);
						medicineItems.setPrice(price);
						medicineItems.setQuantity(quantity);
		
						
		
						MedicineOrder medicineOrder = new MedicineOrder();
						medicineOrder.setMedId(mid);
		
						
						medicineItemsDAO.saveMedicineItems(medicineItems, mid);
					}
					break;
					case 2:{
						System.out.println("Enter the medicineItems id to get the details");
						int id = scanner.nextInt();
						medicineItemsDAO.getMedicineItemsById(id);
						System.out.println(" ===========medicineItems details==========");
						
						
					}
					break;
					case 3:{
						medicineItemsDAO.getAllMedicineItems();
						System.out.println(" ===========medicineItems details==========");
						
					}
					break;
					case 4:{
						exit7=false;
						System.out.println("======Thank you=====");
					}
					break;
					default:System.out.println("Invalid choice");
					
					}
				}while(exit7);
		
					}
				break;

			case 8: {
				exit = false;
				System.out.println("Thank you");
			}

				break;

			default:
				System.out.println("Invalid choice");

			}

		} while (exit);
	}

}

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


		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vinod");
		
		Scanner scanner=new Scanner(System.in);
		Hospital hospital=new Hospital();
		HospitalDAO hospitalDAO=new HospitalDAO();
		
		boolean exit=true;
		do {
			System.out.println(" 1.Add hospital \n 2.Add branch \n 3. Add address \n 4. Add Person \n 5. Add Encounter \n 6.Add MedicineOrder \n 7.Add MedicineItems \n 8.exit");
			System.out.println("Enter your choice");
			int choice=scanner.nextInt();
			
			switch(choice) {
			
			case 1:{
				System.out.println("Enter the hospital id");
				int id=scanner.nextInt();
				
				System.out.println("Enter the hospital name");
				String name= scanner.next();
				
				System.out.println("Enter the gst");
				String gst=scanner.next();
				
				
				hospital.setId(id);
				hospital.setH_name(name);
				hospital.setGst(gst);
				
				hospitalDAO.saveHospital(hospital);
			}
			break;
				
			
			case 2: {
						System.out.println("======Add branch details======");
						
						System.out.println("enter the branch id");
						int bid=scanner.nextInt();
						System.out.println("Enter the branch name");
						String bname=scanner.next();
						System.out.println("Enter the phone");
						long phone=scanner.nextLong();
						
						Branch branch=new Branch();
						branch.setId(bid);
						branch.setBname(bname);
						branch.setPhone(phone);
						
						System.out.println(" ===========hospitals details==========");
						hospitalDAO.getAllHospital();
						System.out.println("Enter the hospital id");
						
						
						int hospital_id=scanner.nextInt();
						
						BranchDAO branchDAO=new BranchDAO();
						
						branchDAO.saveBranch(branch,hospital_id);	
						
			}
			break;
						
			case 3:{
						
						System.out.println("======Add Address=====");
						
						System.out.println("enter the Address id");
						int aid=scanner.nextInt();
						System.out.println("Enter the address");
						String loc_name=scanner.next();
						System.out.println("Enter the pincode");
						long pincode=scanner.nextLong();	
						
						Address address=new Address();
						address.setId(aid);
						address.setName(loc_name);
						address.setPincode(pincode);
						
						System.out.println("Enter the branch id");
						BranchDAO branchDAO=new BranchDAO();
						branchDAO.getAll();
						
						int branch_id=scanner.nextInt();
						
						Branch branch=new Branch();
						branch.setId(branch_id);
						
						AddressDAO addressDAO=new AddressDAO();
						addressDAO.saveAddress(address,branch_id);
					
								
				
			}break;
			
			case 4:{
			
				System.out.println(" ===add person====");
				
				System.out.println("Enter person id");
				int personId=scanner.nextInt();
				
				System.out.println("Enter person name");
				String name=scanner.next();
				
				System.out.println("Enter person phone");
				long phone=scanner.nextLong();
				
				System.out.println("Enter the person Address");
				String address=scanner.next();
				
				Person person=new Person();
				person.setPersonId(personId);
				person.setPersonName(name);
				person.setPersonPhone(phone);
				person.setPersonAddress(address);
				
				
				PersonDao personDao=new PersonDao();
				personDao.savePerson(person);
				
			}
			break;
			
			case 5:{
					System.out.println(" =======Add Encounter=======");
				
					System.out.println("enter the encounter id");
					int id=scanner.nextInt();
					
					System.out.println("Enter the cause to encounter");
					String name1=scanner.next();
					
					Encounter encounter=new Encounter();
					
					encounter.setId(id);
					encounter.setName(name1);
					
					System.out.println("======Enter person id to Encounter====");
					int personId=scanner.nextInt();
					
					Person person=new Person();
					person.setPersonId(personId);

					System.out.println(" ====the hospital details==== ");
					HospitalDAO hospitalDAO2=new HospitalDAO();
					
					hospitalDAO2.getAllHospital();
					System.out.println("====Hopsital branchs====");
					System.out.println("To which branch u want to encounter");

					BranchDAO branchDAO=new BranchDAO();
					branchDAO.getAll();
					
					System.out.println("Enter the branch id u want to encounter");
					int bid=scanner.nextInt();
					
					Branch branch=new Branch();
					branch.setId(bid);
					
					EncounterCrud encounterCrud=new EncounterCrud();
					encounterCrud.saveEncounter(encounter, personId, bid);
				
			}
			break;
			
			case 6:{
				System.out.println("======enter the medicineOrder==========");
				
				System.out.println("Enter the medicineOrder id");
				int id=scanner.nextInt();
				
				System.out.println("Enter the doctor name");
				String name=scanner.next();
				
				System.out.println("Enter the disease");
				String disease=scanner.next();
				
				MedicineOrder medicineOrder=new MedicineOrder();
				medicineOrder.setMedId(id);
				medicineOrder.setDname(name);
				medicineOrder.setDisease(disease);

				System.out.println("enter the encounter id");
				int eid=scanner.nextInt();
				
				Encounter encounter=new Encounter();
				encounter.setId(eid);
				
				MedcineOrderDao medcineOrderDao=new MedcineOrderDao();
				medcineOrderDao.saveMedicineOrder(medicineOrder, eid);
			
			}
			break;
			
			case 7:{
				System.out.println("======enter the medicineItems==========");
				
				System.out.println("Enter the medicineItems id");
				int id=scanner.nextInt();
				
				System.out.println("Enter the medicineItem name");
				String name=scanner.next();
				
				System.out.println("Enter the medicineItem price");
				double price=scanner.nextDouble();
				
				System.out.println("Enter the medicine quantity");
				int quantity=scanner.nextInt();
				
				MedicineItems medicineItems=new MedicineItems();
				medicineItems.setId(id);
				medicineItems.setName(name);
				medicineItems.setPrice(price);
				medicineItems.setQuantity(quantity);
				

				System.out.println("Enter the medicineOrder id");
				int mid=scanner.nextInt();
				
				MedicineOrder medicineOrder=new MedicineOrder();
				medicineOrder.setMedId(mid);
				
				MedicineItemsDAO medicineItemsDAO=new MedicineItemsDAO();
				medicineItemsDAO.saveMedicineItems(medicineItems, mid);
				
			}
			break;
			
			case 8:{
				exit=false;
				System.out.println("Thank you");
			}
			
			break;
			
			default: System.out.println("Invalid choice");
			
			}
		
		}while(exit);
	}

}





















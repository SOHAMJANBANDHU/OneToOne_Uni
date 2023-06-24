package oneToOne_Uni.Controller;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import oneToOne_Uni.DAO.PersonDAO;
import oneToOne_Uni.DTO.AdharCard;
import oneToOne_Uni.DTO.Person;

public class MainController {

	public static void main(String[] args) {
		
		AdharCard aadharCard = new AdharCard();
		Person person = new Person();
		PersonDAO dao = new PersonDAO();
		
//		dao.savePerson(person);
		
		
//		dao.deletePerson(2);
		
//		dao.findPerson(1);
		
//		dao.fetchAllPerson();
		
//		dao.updatePerson(person, 2);
		
//		dao.updatePerson(2, person);
		
//		dao.updatePerson(2, 2);
		
		Scanner scan = new Scanner(System.in);
		System.out.println("Select option for the task \n1.save details \n2. find person \n3.fetch all person \n4.update person \n5. update person with id \n6. delete person");
		int option = scan.nextInt();
		
		switch (option) {
		case 1:
		{
			System.out.println("enter person id");
			person.setId(scan.nextInt());
			
			System.out.println("enter name");
			person.setName(scan.next());
			
			System.out.println("enter phone");
			person.setPhone(scan.nextLong());
			
			person.setAdharcard(aadharCard);
			
			System.out.println("enter adhar id");
			aadharCard.setId(scan.nextInt());
			
			System.out.println("enter adhar name");
			aadharCard.setName(scan.next());
			
			System.out.println("enter address");
			aadharCard.setAddress(scan.next());
			
			dao.savePerson(person);
			break;
		}
		case 2:
		{
			System.out.println("Enter id");
			dao.findPerson(scan.nextInt());
			break;
		}
		case 3:
		{
			System.out.println("Here are the all details");
			dao.fetchAllPerson();
			break;
		}
		case 4:
		{
			dao.updatePerson(person, option);
			break;
		}
		case 5:
		{
			dao.updatePerson(option, option);
			break;
		}
		case 6:
		{
			System.out.println("Enter person ID");
			 int id = scan.nextInt();
			dao.deletePerson(id);
			break;
		}
			

		default:
			break;
		}
	}
}

package oneToOne_Uni.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import oneToOne_Uni.DTO.AdharCard;
import oneToOne_Uni.DTO.Person;

public class PersonDAO {


	public EntityManager getEntityManager()
	{
		return Persistence.createEntityManagerFactory("soham").createEntityManager();
	}
	
	public void savePerson(Person person)
	{
		
		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		
		AdharCard aadharCard = person.getAdharcard();
		
		entityTransaction.begin();
		entityManager.persist(aadharCard);
		entityManager.persist(person);
		entityTransaction.commit();
	}
	
	public void deleteAdharCard(Person person, int id)
	{
		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		
//		Person dbPerson = entityManager.find(Person.class, id);
		
//		if(dbPerson != null)
//		{
//			entityTransaction.begin();
//			entityManager.remove(dbPerson);
//			entityTransaction.commit();
//		}
//		else
//		{
//			System.out.println("id is not found");
//		}
		
		AdharCard aadharCard = entityManager.find(AdharCard.class, id);
		entityTransaction.begin();
		entityManager.remove(aadharCard);
		entityTransaction.commit();
	}
	
	public void findPerson(int id)
	{
		EntityManager entityManager = getEntityManager();
		Person person = entityManager.find(Person.class, id);
		System.out.println(person);
	}
	
	public void fetchAllPerson()
	{
		EntityManager entityManager = getEntityManager();
		
		Query query = (Query) entityManager.createQuery("SELECT a FROM Person a") ;
		List<Person> person = query.getResultList() ;
		
		
	}
	
	public void deletePerson(int id)
	{
		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		
		Person person = entityManager.find(Person.class, id);
		AdharCard aadharCard = person.getAdharcard();
		
		entityTransaction.begin();
		entityManager.remove(aadharCard);
		entityManager.remove(person);
		entityTransaction.commit();
	}
	
	public void updatePerson(Person person, int id)
	{
		EntityManager entityManager = getEntityManager() ;
		EntityTransaction entityTransaction = entityManager.getTransaction() ;
		
		AdharCard aadharCard = person.getAdharcard();
		
		entityTransaction.begin();
		entityManager.merge(aadharCard);
		entityManager.merge(person);
		entityTransaction.commit();
	}
	
	public void updatePerson(int id, Person person)
	{
		EntityManager entityManager = getEntityManager() ;
		EntityTransaction entityTransaction = entityManager.getTransaction() ;
		
		Person dbPerson = entityManager.find(Person.class, id) ;
		
		if(dbPerson != null)
		{
			person.setId(id);
			person.setAdharcard(dbPerson.getAdharcard());
			
			entityTransaction.begin();
			entityManager.merge(person) ;
			entityTransaction.commit();
		}
	}
	
	public void updatePerson(int pid, int aid)
	{
		EntityManager entityManager = getEntityManager() ;
		EntityTransaction entityTransaction = entityManager.getTransaction() ;
		
		Person person = entityManager.find(Person.class, pid);
		AdharCard aadharCard = entityManager.find(AdharCard.class, aid) ;
		
		person.setAdharcard(aadharCard);
		entityTransaction.begin();
		entityManager.merge(person);
		entityTransaction.commit();
	}
}

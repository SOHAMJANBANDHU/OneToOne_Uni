package oneToOne_Uni.Controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import oneToOne_Uni.DTO.Person;

public class Main1stLevelCatche {

	public static void main(String[] args) {
		
//		Catche is used to reduce load in Database ~ if we want to fetch data again and again then we use Catche
//		2nd level catche is not inbuild in hibernate if we want to achieve 2nd level catche we neew to call explicitly
		
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("soham");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		entityManager.find(Person.class, 1);
		entityManager.find(Person.class, 1);//this statement will not give load to Database
		
		EntityManager entityManager2 = entityManagerFactory.createEntityManager();
		entityManager2.find(Person.class, 1);
		entityManager2.find(Person.class, 1);
	
	}
}

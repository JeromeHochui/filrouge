package fr.dta.filrouge.user.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import fr.dta.filrouge.user.entity.User;

@RepositoryRestResource(collectionResourceRel = "user", path = "user")
@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	
	// All findBy methods
	List<User> findById(@Param("id") String id);
	
	@RestResource(path="findByLastName", rel="findByLastName")
	@Query("select u from User u where u.lastname = :lastname")
	List<User> findByLastName(@Param("lastname") String lastname);
	
	@RestResource(path="findByFirstName", rel="findByFirstName")
	@Query("select u from User u where u.firstname = :firstname")
	List<User> findByFirstName(@Param("firstname") String firstname);
	
	List<User> findByEmail(@Param("email") String email);
	
	@RestResource(path="findByFirstNameAndLastName", rel="findByFirstNameAndLastName")
	@Query("select u from User u where u.firstname = :firstname and u.lastname = :lastname")
	List<User> findByFirstnameAndLastname(@Param("firstname") String firstname, @Param("lastname") String lastname);
	
	@RestResource(path="findByAdress", rel="findByAdress")
	@Query("select u from User u where u.adress = :adress")
	List<User> findByAdress(@Param("adress") String adress);
	
	@RestResource(path="findByPhone", rel="findByPhone")
	@Query("select u from User u where u.phone = :phone")
	List<User> findByPhone(@Param("phone") String phone);
	
	//All modify methods
	
}

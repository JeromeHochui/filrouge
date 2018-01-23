package fr.dta.filrouge.user;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

@RepositoryRestResource(collectionResourceRel = "user", path = "user")
@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	// All findBy methods
	List<User> findById(@Param("id") String id);
	
	List<User> findByLastname(String lastname);
	
	List<User> findByFirstname(String firstname);
	
	@RestResource(path="findByFirstNameAndLastName", rel="findByFirstNameAndLastName")
	@Query("select u from User u where u.firstname = :firstname and u.lastname = :lastname")
	List<User> findByFirstnameAndLastname(@Param("firstname") String firstname, @Param("lastname") String lastname);
	
	@RestResource(path="findByAdress", rel="findByAdress")
	List<User> findByAdress(String adress);
	
	List<User> findByPhone(String phone);
	
	User findByEmail(String username);
	
	User findById(Long id);
}

package fr.dta.filrouge.orders;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import fr.dta.filrouge.orders.Orders;

@RepositoryRestResource(collectionResourceRel = "orders", path = "orders")
@Repository
public interface OrdersRepository extends JpaRepository<Orders, Long> {
	
	Orders findById(@Param("id") String id);
	
	
	Orders findByReference(@Param("reference") String reference);
	
	@RestResource(path="findByDateCommande", rel="findByDateCommande")
	@Query("select o from Orders o where o.commandDate = :commandDate")
	List<Orders> findByDateCommande(@Param("commandDate") String commandDate);
	
	@RestResource(path="findByUserId", rel="findByUserId")
	@Query("select o from Orders o where o.users.id = :id")
	Orders findByUsersId(@Param("id") Long id);
}

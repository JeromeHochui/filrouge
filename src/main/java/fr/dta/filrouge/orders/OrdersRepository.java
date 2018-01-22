package fr.dta.filrouge.orders;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;

import fr.dta.filrouge.orders.Orders;

public interface OrdersRepository extends JpaRepository<Orders, Long> {
	List<Orders> findById(@Param("id") String id);
	
	@RestResource(path="findByReference", rel="findByReference")
	@Query("select o from Orders o where o.reference = :reference")
	List<Orders> findByReference(@Param("reference") String reference);
	
	@RestResource(path="findByDateCommande", rel="findByDateCommande")
	@Query("select o from Orders o where o.commandDate = :commandDate")
	List<Orders> findByDateCommande(@Param("commandDate") String commandDate);
}

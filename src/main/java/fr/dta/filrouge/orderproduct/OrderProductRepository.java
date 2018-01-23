package fr.dta.filrouge.orderproduct;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@RepositoryRestResource(collectionResourceRel = "ordersProduct", path = "ordersProduct")
@Repository
public interface OrderProductRepository extends JpaRepository<OrderProduct, Long> {
	
	OrderProduct findById(Long id);
	
	List<OrderProduct> findByQuantity(Integer quantity);
	
	//@RestResource(path="findByOrdersId", rel="findByOrdersId")
	//@Query("select op from OrderProduct op where op.orders.id = :id")
	List<OrderProduct> findByOrdersId(Long id);
	
	List<OrderProduct> findByProductsId(Long id);
}

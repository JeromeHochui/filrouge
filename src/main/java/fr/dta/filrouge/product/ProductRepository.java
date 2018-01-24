package fr.dta.filrouge.product;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@RepositoryRestResource(collectionResourceRel = "product", path = "product")
@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{	
	
	List<Product> findByProductName(String productName);	
	
	List<Product> findByType(String type);	
	
	List<Product> findByPrice(String prix);
	
	Product findById (Long id);
	
	
}

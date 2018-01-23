package fr.dta.filrouge.product;

import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import fr.dta.filrouge.product.Product;

@RepositoryRestResource(collectionResourceRel = "product", path = "product")
@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{
	List<Product> findById(@Param("id") String id);
	
	@RestResource(path="findByName", rel="findByName")
	@Query("select p from Product p where p.productName = :productName")
	List<Product> findByProductName(@Param("productName") String productName);
	
	@RestResource(path="findByType", rel="findByType")
	@Query("select p from Product p where p.type = :type")
	List<Product> findByType(@Param("type") String type);
	
	@RestResource(path="findByPrice", rel="findByPrice")
	@Query("select p from Product p where p.price = :prix")
	List<Product> findByPrice(@Param("prix") String prix);
	
	Product findById (Long id);

	
}

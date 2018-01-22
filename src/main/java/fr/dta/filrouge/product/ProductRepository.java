package fr.dta.filrouge.product;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "product", path = "product")
public interface ProductRepository extends JpaRepository<Product, Long>, ProductRepositoryCustom{
	
	Product findByName(String productName);
	Product findById(Long id);
	List<Product> findByType(Type type);
}

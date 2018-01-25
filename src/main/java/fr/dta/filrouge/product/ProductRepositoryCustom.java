package fr.dta.filrouge.product;

import java.util.List;

public interface ProductRepositoryCustom {
	List<Product> findByCriteria(String productName, Long id, Type type);
}

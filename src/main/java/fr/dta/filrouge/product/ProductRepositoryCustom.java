package fr.dta.filrouge.product;

import java.util.List;

public interface ProductRepositoryCustom {
	List<Product> findByCriteria(String name, Long id, Type type);
}

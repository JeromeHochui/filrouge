package fr.dta.filrouge.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class ProductService {
	
	@Autowired
	private ProductRepositoryImpl repository;
	
	public ProductService() {
	}
	
	public List<Product> getByCriteria(String name, Long id, Type type) {
		return repository.findByCriteria(name, id, type);
	}
}

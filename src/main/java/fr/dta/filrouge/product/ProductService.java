package fr.dta.filrouge.product;

import java.util.List;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


@Service
public class ProductService {
	
	@Autowired
	private ProductRepository repository;
	
	@Autowired
	private ProductRepositoryImpl repositoryCustom;
	
	public ProductService() {
	}
	
	public List<Product> getByCriteria(String name, Long id, Type type) {
		return repositoryCustom.findByCriteria(name, id, type);
	}
	
	public Product getById(Long id) {
		Product p = repository.findById(id);
		Hibernate.initialize(p.getQuantities());
		return p;
	}
	
	public void create(Product product) {
		repository.saveAndFlush(product);
	}
	
	public void update(Product product) {
		repository.saveAndFlush(product);
	}
	
	public void desactivateActivate(Product product) {	
		product.setActive(!product.getActive());
		repository.saveAndFlush(product);
	}
	
	public void store(MultipartFile file, Product product) {
		product.setPathpicture(file.getOriginalFilename());
		repository.saveAndFlush(product);
	}
}


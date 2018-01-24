package fr.dta.filrouge.orders;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrdersService {
	@Autowired
	private OrdersRepository repository;
	
	
	public Orders getById(Long id) {
		return repository.findById(id);
	}
	
	public List<Orders> getAll () {
		return repository.findAll();
	}
	
	public void create (Orders order) {
		repository.saveAndFlush(order);
	}
	
	public void update (Orders order) {
		repository.saveAndFlush(order);
	}
	
	public void delete (Long id) {
		repository.delete(repository.findById(id));
	}
}

package fr.dta.filrouge.orders;

import java.util.List;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrdersService {
	@Autowired
	private OrdersRepository repository;
	
	
	public Orders getById(Long id) {
		Orders o = repository.findById(id);
		Hibernate.initialize(o.getQuantities());
		return o;
	}
	
	public List<Orders> getByUsersId(Long id) {
		List<Orders> lo = repository.findByUsersId(id);
		for (Orders o : lo) {
			Hibernate.initialize(o.getQuantities());
		}
		return lo;
	}
	
	public Orders getByReference(String ref) {
		Orders o = repository.findByReference(ref);
		Hibernate.initialize(o.getQuantities());
		return o;
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

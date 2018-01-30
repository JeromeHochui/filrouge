package fr.dta.filrouge.orderproduct;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderProductService {
	@Autowired
	private OrderProductRepository repository;
	
	public OrderProductService() {}
	
	public OrderProduct getById(Long id) {
		return repository.findById(id);
	}
	
	public List<OrderProduct> getAll () {
		return repository.findAll();
	}
	
	public void create (OrderProduct orderProduct) {
		repository.saveAndFlush(orderProduct);
	}
	
	public void update (OrderProduct orderProduct) {
		repository.saveAndFlush(orderProduct);
	}
	
	public void delete (Long id) {
		repository.delete(repository.findById(id));
	}
	
	public List<OrderProduct> getByOrdersId (Long id) {
		return repository.findByOrdersId(id);
	}
}

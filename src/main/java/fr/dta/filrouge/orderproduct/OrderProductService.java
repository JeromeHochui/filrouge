package fr.dta.filrouge.orderproduct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderProductService {
	@Autowired
	private OrderProductRepository repository;
	
	public OrderProductService() {}
	
	public void create (OrderProduct orderProduct) {
		repository.saveAndFlush(orderProduct);
	}
	
	public void update (OrderProduct orderProduct) {
		repository.saveAndFlush(orderProduct);
	}
}

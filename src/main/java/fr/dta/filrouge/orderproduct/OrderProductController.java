package fr.dta.filrouge.orderproduct;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import fr.dta.filrouge.exceptions.NotFoundException;

@RestController
@RequestMapping(value = "/api/order-product")
@Transactional
public class OrderProductController {
	@Autowired
	private OrderProductService service;
	
	@CrossOrigin
	@RequestMapping(value = "all", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<OrderProduct> get () {
		List<OrderProduct> opList = service.getAll();
		if(opList == null) {
			throw new NotFoundException();
		}
		return opList;
	}
	
	@CrossOrigin
	@RequestMapping(value = "{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public OrderProduct getOne (@PathVariable Long id) {
		OrderProduct op = service.getById(id);
		if (op == null) {
			throw new NotFoundException();
		}
		return op;
	}
	
	@CrossOrigin
	@RequestMapping(path = "create", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(value = HttpStatus.CREATED)
	public OrderProduct create (@RequestBody OrderProduct orderProduct) {
		service.create(orderProduct);
		return orderProduct;
	}
	
	@CrossOrigin
	@RequestMapping(path = "update", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(value = HttpStatus.OK)
	public OrderProduct update (@RequestBody OrderProduct orderProduct) {
		service.update(orderProduct);
		return orderProduct;
	}
	
	@CrossOrigin
	@RequestMapping(path = "delete/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(value = HttpStatus.OK)
	public void delete (@PathVariable Long id) {
		service.delete(id);
	}
	
	@CrossOrigin
	@RequestMapping(value = "by-order/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<OrderProduct> getByOrderId (@PathVariable Long id) {
		List<OrderProduct> opList = service.getByOrdersId(id);
		if(opList == null) {
			throw new NotFoundException();
		}
		return opList;
	}
	
	
}

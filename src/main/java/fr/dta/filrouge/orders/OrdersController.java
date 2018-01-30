package fr.dta.filrouge.orders;

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
@RequestMapping(value = "/api/orders")
@Transactional
public class OrdersController {
	@Autowired
	private OrdersService service;
	
	
	@CrossOrigin
	@RequestMapping(value = "all", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Orders> getAll () {
		List<Orders> orders = service.getAll();
		if(orders == null) {
			throw new NotFoundException();
		}
		return orders;
	}
	
	@CrossOrigin
	@RequestMapping(value = "{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Orders getOne (@PathVariable Long id) {
		Orders order = service.getById(id);
		if (order == null) {
			throw new NotFoundException();
		}
		return order;
	}
	
	@CrossOrigin
	@RequestMapping(value = "by-user/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Orders> getByUsersId (@PathVariable Long id) {
		List<Orders> orders = service.getByUsersId(id);
		if (orders == null) {
			throw new NotFoundException();
		}
		return orders;
	}
	
	@CrossOrigin
	@RequestMapping(value = "by-ref/{ref}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Orders getByReference (@PathVariable String ref) {
		Orders order = service.getByReference(ref);
		if (order == null) {
			throw new NotFoundException();
		}
		return order;
	}
	
	@CrossOrigin
	@RequestMapping(path = "create", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(value = HttpStatus.CREATED)
	public Orders create (@RequestBody Orders order) {
		service.create(order);
		return order;
	}
	
	@CrossOrigin
	@RequestMapping(path = "update", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(value = HttpStatus.OK)
	public Orders update (@RequestBody Orders order) {
		service.update(order);
		return order;
	}
	
	@CrossOrigin
	@RequestMapping(path = "delete/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(value = HttpStatus.OK)
	public void delete (@PathVariable Long id) {
		service.delete(id);
	}
}

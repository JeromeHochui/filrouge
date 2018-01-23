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

@RestController
@RequestMapping(value = "/api/order-product")
@Transactional
public class OrderProductController {
	@Autowired
	private OrderProductService service;
	
	
	public List<OrderProduct> get () {
		return null;
	}
	
	@CrossOrigin
	@RequestMapping(value = "{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public OrderProduct getOne (@PathVariable Long id) {
		return null;
	}
	
	@CrossOrigin
	@RequestMapping(path = "create", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(value = HttpStatus.CREATED)
	public void create (@RequestBody OrderProduct orderProduct) {
		
	}
	
	@CrossOrigin
	@RequestMapping(path = "update", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(value = HttpStatus.OK)
	public void update (@RequestBody OrderProduct orderProduct) {
		
	}
	
	@CrossOrigin
	@RequestMapping(path = "delete/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(value = HttpStatus.OK)
	public void delete (@PathVariable Long id) {
		
	}
	
	
}

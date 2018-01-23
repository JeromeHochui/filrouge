package fr.dta.filrouge.user;

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
import fr.dta.filrouge.security.SecurityService;


@RestController
@RequestMapping(value = "/api/users")
@Transactional
public class UserController {
	@Autowired
	private UserService service;
	@Autowired
	private SecurityService secuService;
	
	// example user 
	/*
{"adress":"XXX",
 "birthdate":NNN,
 "firstname":"XXX",
 "lastname":"XXX",
 "password":"XXX",
 "phone":NNN,
 "email":"XXX@XXX.XXX",
 "isAdmin":false }
	 */
	
	@CrossOrigin
	@RequestMapping(value = "{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public User get(@PathVariable Long id) {
		User user = service.getById(id);
		
		if(user == null) {
			throw new NotFoundException();
		}else {
			return user;
		}
	}
	
	@CrossOrigin
	@RequestMapping(value = "connected-user", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public User getConnectedUser() {
		return secuService.getConnectedUser();
	}
	
	@CrossOrigin
	@RequestMapping(path = "create", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(value = HttpStatus.CREATED)
	public Long create(@RequestBody User user) {
		service.create(user);
		
		if (user != null && user.getId() >= 0) {
			return user.getId();
		} else {
			return -1L;
		}
	}
	
	@CrossOrigin
	@RequestMapping(path = "update", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(value = HttpStatus.OK)
	public User update(@RequestBody User user) {
		service.update(user);
		return user;
	}
	
	@CrossOrigin
	@RequestMapping(path = "delete/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(value = HttpStatus.OK)
	public void delete(@PathVariable Long id) {
		service.delete(id);
	}
}

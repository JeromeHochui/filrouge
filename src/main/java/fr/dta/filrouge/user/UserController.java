package fr.dta.filrouge.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import fr.dta.filrouge.exceptions.NotFoundException;


@RestController
@RequestMapping(value = "/api/users")
public class UserController {
	@Autowired
	private UserService service;
	
	
	
	// example user {"id":0,"adress":"test adress","birthdate":1513334634449,"firstname":"Guillaume","lastname":"Allemand","password":"mdp123","phone":1051068051,"email":"uqt@sughj.zis","is_admin":true }
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
	@RequestMapping(path = "create", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(value = HttpStatus.CREATED)
	@PreAuthorize("hasAuthority('CUSTOMER')")
	public Long create(@RequestBody User user) {
		
		System.out.println("test create");
		service.create(user);
		
		if (user != null && user.getId() > 0) {
			return user.getId();
		} else {
			return -1L;
		}
	}
}

package fr.dta.filrouge.user;

import java.util.List;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class UserService {
	@Autowired
	private UserRepository repository;
	
	private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();;
	
	public UserService() {}
	
	
	public User getById(Long id) {
		User u = repository.findById(id);
		Hibernate.initialize(u.getOrders());
		return u;
	}
	
	public List<User> getAll() {
		return repository.findAll();
	}

	public void create(User user) {
		String encodedPass = passwordEncoder.encode(user.getPassword());
		user.setPassword(encodedPass);
		repository.saveAndFlush(user);
	}

	public void update(User user) {
		repository.saveAndFlush(user);
	}

	public void delete(Long id) {
		repository.delete(repository.findById(id));
	}

	public boolean contains(Long id) {
		return this.getById(id) != null;
	}
	
	public User getByEmail(String email) {
		User u = repository.findByEmail(email);
		Hibernate.initialize(u.getOrders());
		return u;
	}
	
}

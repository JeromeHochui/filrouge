package fr.dta.filrouge.util;

import javax.persistence.*;

import org.hibernate.Session;

public abstract class AbstractJpaRepository<T> {
	
	protected Class<T> entityClass;
	
	@PersistenceContext
	protected EntityManager em;
	
	protected void init() {
		entityClass = getEntityClass();
	}
	
	protected abstract Class<T> getEntityClass();
	
	protected Session getSession() {
		return em.unwrap(Session.class);
	}
}

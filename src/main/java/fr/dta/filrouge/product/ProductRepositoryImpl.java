package fr.dta.filrouge.product;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.util.StringUtils;

import fr.dta.filrouge.util.AbstractJpaRepository;

public class ProductRepositoryImpl extends AbstractJpaRepository<Product> implements ProductRepositoryCustom{

	protected Class<Product> getEntityClass(){
		return Product.class;
	}
	
	@Override
	public List<Product> findByCriteria(String name, Long id, Type type) {
		Criteria query = getSession().createCriteria(getEntityClass());
		if(!StringUtils.isEmpty(name)) {
			query.add(Restrictions.like("name", "%"+name+"%"));
		}
		
		if(id != null) {
			query.add(Restrictions.eq("id", id ));
		}
		
		if(type != null) {
			query.add(Restrictions.eq("type", type));
		}
		
		return query.list();
	}
}

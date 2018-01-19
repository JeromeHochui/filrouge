package fr.dta.filrouge.orders.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import fr.dta.filrouge.OrderProduct.OrderProduct;
import fr.dta.filrouge.user.entity.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "orders")
@SequenceGenerator(name = "item_id_seq", sequenceName = "item_id_seq", initialValue = 0, allocationSize = 1)
public class Orders {
	@Id
	@GeneratedValue(generator = "item_id_seq")
	@Column(name = "id")
	private Long id;
	
	@Column
	private String reference;
	
	@Column
	@Transient
	private Float total;
	
	@Column(name = "command_date")
	@Temporal(TemporalType.DATE)
	private Date commandDate;
	
	@ManyToOne()
	private User users;
	
	@OneToMany(mappedBy = "orders")
	private List<OrderProduct> quantities = new ArrayList<>();
	
	public Orders() {
		
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (id != null ? id.intValue() : 0);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Orders other = (Orders) obj;
		if (id != other.id)
			return false;
		return true;
	}
}

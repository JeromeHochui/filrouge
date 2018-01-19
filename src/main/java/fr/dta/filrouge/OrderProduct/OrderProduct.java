package fr.dta.filrouge.OrderProduct;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import fr.dta.filrouge.orders.entity.Orders;
import fr.dta.filrouge.product.entity.Product;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "numberCommanded")
@SequenceGenerator(name = "item_id_seq", sequenceName = "item_id_seq", initialValue = 0, allocationSize = 1)
public class OrderProduct {
	@Id
	@GeneratedValue(generator = "item_id_seq")
	@Column(name = "id")
	private Long id;
	
	@Column
	private Integer quantity;
	
	@ManyToOne
	private Orders orders;
	
	@ManyToOne
	private Product products;
	
	public OrderProduct() {
		
	}
}

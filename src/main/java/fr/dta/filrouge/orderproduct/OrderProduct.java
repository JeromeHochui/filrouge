package fr.dta.filrouge.orderproduct;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

import fr.dta.filrouge.orders.Orders;
import fr.dta.filrouge.product.Product;



@Entity
@Table(name = "numberCommanded")
@SequenceGenerator(name = "item_id_seq", sequenceName = "item_id_seq", initialValue = 0, allocationSize = 1)
public class OrderProduct implements Serializable {
	@Transient
	private static final long serialVersionUID = 5032047298311561253L;

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
	
	
	// Getters and Setters
	
	public Long getId() {return id;}
	public void setId(Long id) {this.id = id;}
	public Integer getQuantity() {return quantity;}
	public void setQuantity(Integer quantity) {this.quantity = quantity;}
	public Orders getOrders() {return orders;}
	public void setOrders(Orders orders) {this.orders = orders;}
	public Product getProducts() {return products;}
	public void setProducts(Product products) {this.products = products;}
	public static long getSerialversionuid() {return serialVersionUID;}
}

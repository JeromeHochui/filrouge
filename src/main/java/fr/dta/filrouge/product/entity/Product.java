package fr.dta.filrouge.product.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotBlank;

import fr.dta.filrouge.OrderProduct.OrderProduct;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "product")
@SequenceGenerator(name = "item_id_seq", sequenceName = "item_id_seq", initialValue = 0, allocationSize = 1)
public class Product {
	@Id
	@GeneratedValue(generator = "item_id_seq")
	@Column(name = "id")
	private Long id;
	
	@Column(name = "product_name")
	@NotBlank
	private String productName;
	
	@Column
	@NotBlank
	@Enumerated(EnumType.STRING)
	private Type type;
	
	@Column(name = "price")
	private Float price;
	
	@Column(name = "cl_volume")
	private Integer clVolume;
	
	@Column(name = "g_weight")
	private Integer gWeight;
	
	@Column(name = "alcohol_percentage")
	private Float alcoholPercentage;
	
	@Column(name = "container")
	@Enumerated(EnumType.STRING)
	private Container container;
	
	@OneToMany(mappedBy = "products")
	private List<OrderProduct> quantities = new ArrayList<>();
	
	public Product() {}
	
	public Product (String productName, Float price, Integer clVolume, Integer gWeight, Float alcoholPercentage, String container) {
		this.productName = productName;
		this.price = price;
		this.clVolume = clVolume;
		this.gWeight = gWeight;
		this.alcoholPercentage = alcoholPercentage;
	}
	
}

package fr.dta.filrouge.product;

import java.io.Serializable;
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
import javax.persistence.Transient;

import org.hibernate.validator.constraints.NotBlank;

import fr.dta.filrouge.orderproduct.OrderProduct;


@Entity
@Table(name = "product")
@SequenceGenerator(name = "item_id_seq", sequenceName = "item_id_seq", initialValue = 0, allocationSize = 1)
public class Product implements Serializable {
	@Transient
	private static final long serialVersionUID = 5791757405825170140L;

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
	
	@Column(name = "stock")
	private Integer stock;
	
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
	
	// Getters and Setters

	public Long getId() {return id;}
	public void setId(Long id) {this.id = id;}
	public String getProductName() {return productName;}
	public void setProductName(String productName) {this.productName = productName;}
	public Type getType() {return type;}
	public void setType(Type type) {this.type = type;}
	public Float getPrice() {return price;}
	public void setPrice(Float price) {this.price = price;}
	public Integer getClVolume() {return clVolume;}
	public void setClVolume(Integer clVolume) {this.clVolume = clVolume;}
	public Integer getgWeight() {return gWeight;}
	public void setgWeight(Integer gWeight) {this.gWeight = gWeight;}
	public Float getAlcoholPercentage() {return alcoholPercentage;}
	public void setAlcoholPercentage(Float alcoholPercentage) {this.alcoholPercentage = alcoholPercentage;}
	public Integer getStock() {return stock;}
	public void setStock(Integer stock) {this.stock = stock;}
	public Container getContainer() {return container;}
	public void setContainer(Container container) {this.container = container;}
	public List<OrderProduct> getQuantities() {return quantities;}
	public void setQuantities(List<OrderProduct> quantities) {this.quantities = quantities;}
	public static long getSerialversionuid() {return serialVersionUID;}
}

package fr.dta.filrouge.orders;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import fr.dta.filrouge.orderproduct.OrderProduct;
import fr.dta.filrouge.user.User;



@Entity
@Table(name = "orders")
@SequenceGenerator(name = "item_id_seq", sequenceName = "item_id_seq", initialValue = 0, allocationSize = 1)
public class Orders implements Serializable {
	@Transient
	private static final long serialVersionUID = -7957115776241044533L;

	@Id
	@GeneratedValue(generator = "item_id_seq")
	@Column(name = "id")
	private Long id;
	
	@Column
	private String reference;
	
	@Column
	private Float total;
	
	@Column(name = "command_date")
	@Temporal(TemporalType.DATE)
	private Date commandDate;
	
	@ManyToOne()
	@NotNull
	private User users;
	
	@OneToMany(mappedBy = "orders", fetch = FetchType.EAGER)
	@JsonIgnoreProperties("orders")
	private List<OrderProduct> quantities = new ArrayList<>();
	
	public Orders() {}
	
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
	
	// Getters and Setters

	public Long getId() {return id;}
	public void setId(Long id) {this.id = id;}
	public String getReference() {return reference;}
	public void setReference(String reference) {this.reference = reference;}
	public Float getTotal() {return total;}
	public void setTotal(Float total) {this.total = total;}
	public Date getCommandDate() {return commandDate;}
	public void setCommandDate(Date commandDate) {this.commandDate = commandDate;}
	public User getUsers() {return users;}
	public void setUsers(User users) {this.users = users;}
	public List<OrderProduct> getQuantities() {return quantities;}
	public void setQuantities(List<OrderProduct> quantities) {this.quantities = quantities;}
	public static long getSerialversionuid() {return serialVersionUID;}	
}

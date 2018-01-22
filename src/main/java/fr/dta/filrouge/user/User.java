package fr.dta.filrouge.user;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;

import fr.dta.filrouge.orders.Orders;


@Entity
@Table(name = "users")
@SequenceGenerator(name = "item_id_seq", sequenceName = "item_id_seq", initialValue = 0, allocationSize = 1)
public class User implements Serializable{
	@Transient
	private static final long serialVersionUID = 629092484508775744L;

	@Id
	@GeneratedValue(generator = "item_id_seq")
	@Column(name = "id")
	private Long id;

	@Column(name = "lastname")
	@NotBlank
	private String lastname;

	@Column(name = "firstname")
	@NotBlank
	private String firstname;

	@Column(name = "adress")
	@NotBlank
	private String adress;

	@Column(name = "phone")
	private String phone;

	@Column(name = "email", unique=true)
	@NotBlank
	private String email;
	
	@Column(name = "is_admin")
	@NotNull
	private boolean isAdmin;

	@Column(name = "birthdate")
	@Temporal(TemporalType.DATE)
	@NotNull
	private Date birthdate;

	@Column(name = "password")
	@NotBlank
	private String password;
	
	@OneToMany(mappedBy="users")
	@JsonIgnore
	private List<Orders> orders = new ArrayList<>();

	public User() {
	}

	public User(String lastname, String firstname, String adress, String phone, String email, Date birthdate, String password) {
		this.lastname = lastname;
		this.firstname = firstname;
		this.adress = adress;
		this.phone = phone;
		this.email = email;
		this.birthdate = birthdate;
		this.password = password;
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
		User other = (User) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
	public String toString() {
		return "{id: " + this.id + ", lastname:" + this.lastname + ", firstname:" + this.firstname + ", adress:" + this.adress + ", phone:" + this.phone + ", mail:" + this.email + ", birthdate:" + this.birthdate + "}";
	}
	
	// Getters and Setters
	
	public Long getId() {return id;}
	public void setId(Long id) {this.id = id;}
	public String getLastname() {return lastname;}
	public void setLastname(String lastname) {this.lastname = lastname;}
	public String getFirstname() {return firstname;}
	public void setFirstname(String firstname) {this.firstname = firstname;}
	public String getAdress() {return adress;}
	public void setAdress(String adress) {this.adress = adress;}
	public String getPhone() {return phone;}
	public void setPhone(String phone) {this.phone = phone;}
	public String getEmail() {return email;}
	public void setEmail(String email) {this.email = email;}

	public boolean isAdmin() {return isAdmin;}
	public void setAdmin(boolean admin) {this.isAdmin = admin;}

	public Date getBirthdate() {return birthdate;}
	public void setBirthdate(Date birthdate) {this.birthdate = birthdate;}
	public String getPassword() {return password;}
	public void setPassword(String password) {this.password = password;}
	public List<Orders> getOrders() {return orders;}
	public void setOrders(List<Orders> orders) {this.orders = orders;}
	public static long getSerialversionuid() {return serialVersionUID;}
	
}

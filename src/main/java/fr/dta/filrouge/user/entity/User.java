package fr.dta.filrouge.user.entity;

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
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

import fr.dta.filrouge.orders.entity.Orders;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "users")
@SequenceGenerator(name = "item_id_seq", sequenceName = "item_id_seq", initialValue = 0, allocationSize = 1)
public class User {
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

	@Column(name = "mail")
	@NotBlank
	private String mail;

	@Column(name = "birthdate")
	@Temporal(TemporalType.DATE)
	@NotNull
	private Date birthdate;

	@Column(name = "password")
	@NotBlank
	private String password;
	
	@OneToMany(mappedBy="users")
	private List<Orders> orders = new ArrayList<>();

	public User() {
	}

	public User(String lastname, String firstname, String adress, String phone, String mail, Date birthdate, String password) {
		this.lastname = lastname;
		this.firstname = firstname;
		this.adress = adress;
		this.phone = phone;
		this.mail = mail;
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
		return "{id: " + this.id + ", lastname:" + this.lastname + ", firstname:" + this.firstname + ", adress:" + this.adress + ", phone:" + this.phone + ", mail:" + this.mail + ", birthdate:" + this.birthdate + "}";
	}
}

package fr.dta.filrouge.user.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name = "user")
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
	public String getMail() {return mail;}
	public void setMail(String mail) {this.mail = mail;}
	public Date getBirthdate() {return birthdate;}
	public void setBirthdate(Date birthdate) {this.birthdate = birthdate;}
	public String getPassword() {return password;}
	public void setPassword(String password) {this.password = password;}
}

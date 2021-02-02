package org.canal.test.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="Subscriber")
public class SubscriberEntity {
	
	@Id
	@Column(name="Id", insertable = false, updatable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="FIRST_NAME")
	private String firstName;
	
	@Column(name="LAST_NAME")
	private String lastName;
	
	@Column(name="ADDRESS")
	private String address;
	
	@OneToMany(mappedBy = "subscriber", cascade  = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
	@JsonIgnore
	private List<ContractEntity>  contracts = new ArrayList<>();
	
	public SubscriberEntity(){
	}
	
	public SubscriberEntity(String firstName, String lastName, String address, List<ContractEntity> contracts) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.contracts = contracts;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public List<ContractEntity> getContracts() {
		return contracts;
	}
	
	public void setContracts(List<ContractEntity> contracts) {
		this.contracts = contracts;
	}
	
	@Override
	public String toString() {
		return "SubscriberDAO [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", Adresse="
				+ address + "]";
	}

}

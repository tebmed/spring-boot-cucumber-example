package org.canal.test.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="CONTRACT")
public class ContractEntity {
	
	@Id
	@Column(name="Id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="ADDRESS")
	private String address;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="SUBSCRIBER_Id")
	private SubscriberEntity subscriber;
	
	public ContractEntity() {
	}

	public ContractEntity(Long id, String address, SubscriberEntity subscriber) {
		super();
		this.id = id;
		this.address = address;
		this.subscriber = subscriber;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	public SubscriberEntity getSubscriber() {
		return subscriber;
	}

	public void setSubscriber(SubscriberEntity subscriber) {
		this.subscriber = subscriber;
	}
	
}

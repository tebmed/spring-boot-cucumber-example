package org.canal.test.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="HISTORY")
public class HistoryEntity {
	
	
	@Id
	@Column(name="ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private Long subscriberId;
	
	@Column
	private Long contractId;
	
	
	private String oldAddress;
	
	private String newAddress;

	@Column
	private String event;
	
	@Column
	LocalDate date;
	
	
	public HistoryEntity() {
		
	}
	
	public HistoryEntity(Long id, Long subscriberId, Long contractId, String event, LocalDate date) {
		this.id = id;
		this.subscriberId = subscriberId;
		this.contractId = contractId;
		this.event = event;
		this.date = date;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getsubscriberId() {
		return subscriberId;
	}

	public void setsubscriberId(Long subscriberId) {
		this.subscriberId = subscriberId;
	}

	public Long getcontractId() {
		return contractId;
	}

	public void setcontractId(Long contractId) {
		this.contractId = contractId;
	}

	public String getEvent() {
		return event;
	}

	public void setEvent(String event) {
		this.event = event;
	}
	
	public LocalDate getDate() {
		return this.date;
	}
	
	public void setDate(LocalDate date) {
		this.date = date;
	}
	
	public String getOldAddress() {
		return oldAddress;
	}

	public void setOldAddress(String oldAddress) {
		this.oldAddress = oldAddress;
	}

	public String getNewAddress() {
		return newAddress;
	}

	public void setNewAddress(String newAddress) {
		this.newAddress = newAddress;
	}

}

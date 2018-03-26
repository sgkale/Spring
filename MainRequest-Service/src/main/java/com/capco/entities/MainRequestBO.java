package com.capco.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.NaturalId;

@Entity
public class MainRequestBO extends DateBO{
	@Id
	@GeneratedValue
	private int id;
	
	@NaturalId
	@Column
	private int requestId;
	
	@Column
	private int requestedBy;
	
	@Column
	private String requestedFor;
	
	@Column
	private String location;
	
	@Column
	private int approverId;
	
	@Column
	private String currentStatus;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getRequestId() {
		return requestId;
	}

	public void setRequestId(int requestId) {
		this.requestId = requestId;
	}

	public int getRequestedBy() {
		return requestedBy;
	}

	public void setRequestedBy(int requestedBy) {
		this.requestedBy = requestedBy;
	}

	public String getRequestedFor() {
		return requestedFor;
	}

	public void setRequestedFor(String requestedFor) {
		this.requestedFor = requestedFor;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public int getApproverId() {
		return approverId;
	}

	public void setApproverId(int approverId) {
		this.approverId = approverId;
	}

	public String getCurrentStatus() {
		return currentStatus;
	}

	public void setCurrentStatus(String currentStatus) {
		this.currentStatus = currentStatus;
	}
	
}

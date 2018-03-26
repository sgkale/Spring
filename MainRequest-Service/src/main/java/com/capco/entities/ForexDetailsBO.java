package com.capco.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ForexDetailsBO {


	private int id;
	
	private int requestId;

	private Date forexToDate;

	private Date forexFromDate;

	private String forexCurrency;

	private String forexCountry;

	private int forexNoOfDays;

	private double forexAmount;

	private String forexRemarks;

	private String forexCollectionCenter;

	private String forexBankDesk;	
	
	private Boolean isActive;
	
	@Column
	//@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm a z")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
	private Date createdOn;
	
	@Column
	//@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm a z")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
	private Date modifiedOn;

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public Date getModifiedOn() {
		return modifiedOn;
	}

	public void setModifiedOn(Date modifiedOn) {
		this.modifiedOn = modifiedOn;
	}
	


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

	public Date getForexToDate() {
		return forexToDate;
	}

	public void setForexToDate(Date forexToDate) {
		this.forexToDate = forexToDate;
	}

	public Date getForexFromDate() {
		return forexFromDate;
	}

	public void setForexFromDate(Date forexFromDate) {
		this.forexFromDate = forexFromDate;
	}

	public String getForexCurrency() {
		return forexCurrency;
	}

	public void setForexCurrency(String forexCurrency) {
		this.forexCurrency = forexCurrency;
	}

	public String getForexCountry() {
		return forexCountry;
	}

	public void setForexCountry(String forexCountry) {
		this.forexCountry = forexCountry;
	}

	public int getForexNoOfDays() {
		return forexNoOfDays;
	}

	public void setForexNoOfDays(int forexNoOfDays) {
		this.forexNoOfDays = forexNoOfDays;
	}

	public double getForexAmount() {
		return forexAmount;
	}

	public void setForexAmount(double forexAmount) {
		this.forexAmount = forexAmount;
	}

	public String getForexRemarks() {
		return forexRemarks;
	}

	public void setForexRemarks(String forexRemarks) {
		this.forexRemarks = forexRemarks;
	}

	public String getForexCollectionCenter() {
		return forexCollectionCenter;
	}

	public void setForexCollectionCenter(String forexCollectionCenter) {
		this.forexCollectionCenter = forexCollectionCenter;
	}

	public String getForexBankDesk() {
		return forexBankDesk;
	}

	public void setForexBankDesk(String forexBankDesk) {
		this.forexBankDesk = forexBankDesk;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

		
}

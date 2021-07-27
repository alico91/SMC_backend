package com.smca.Company2.Dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CompanyCompareRequest {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String companyName;
	private String stockExchangeName;
	private String fromPeriod;
	private String toPeriod;
	private String periodicity;
	public CompanyCompareRequest(String companyCode, String stockExchangeName, String fromPeriod, String toPeriod,
			String periodicity) {
		super();
		this.companyName = companyCode;
		this.stockExchangeName = stockExchangeName;
		this.fromPeriod = fromPeriod;
		this.toPeriod = toPeriod;
		this.periodicity = periodicity;
	}
	public CompanyCompareRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getStockExchangeName() {
		return stockExchangeName;
	}
	public void setStockExchangeName(String stockExchangeName) {
		this.stockExchangeName = stockExchangeName;
	}
	public String getFromPeriod() {
		return fromPeriod;
	}
	public void setFromPeriod(String fromPeriod) {
		this.fromPeriod = fromPeriod;
	}
	public String getToPeriod() {
		return toPeriod;
	}
	public void setToPeriod(String toPeriod) {
		this.toPeriod = toPeriod;
	}
	public String getPeriodicity() {
		return periodicity;
	}
	public void setPeriodicity(String periodicity) {
		this.periodicity = periodicity;
	}
	
	
}

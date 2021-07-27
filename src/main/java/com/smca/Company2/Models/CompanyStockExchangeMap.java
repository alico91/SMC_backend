package com.smca.Company2.Models;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;



@Entity
@Table(name = "CompanyStockExchangeMap")
public class CompanyStockExchangeMap {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private String companyCode;
	
	private String companyName;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private Company company;
	
	private String stockExchangeName;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private StockExchange stockExchange;

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public StockExchange getStockexchange() {
		return stockExchange;
	}

	public void setStockexchange(StockExchange stockExchange) {
		this.stockExchange = stockExchange;
	}
	
	
	
	public String getStockExchangeName() {
		return stockExchangeName;
	}

	public void setStockExchangeName(String stockExchangeName) {
		this.stockExchangeName = stockExchangeName;
	}

	public StockExchange getStockExchange() {
		return stockExchange;
	}

	public void setStockExchange(StockExchange stockExchange) {
		this.stockExchange = stockExchange;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	public String getCompanyCode() {
		return companyCode;
	}

	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}
	
	public CompanyStockExchangeMap() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CompanyStockExchangeMap(String companyCode, String companyName, String stockExchangeName) {
		super();
		this.companyCode = companyCode;
		this.companyName = companyName;
		this.stockExchangeName = stockExchangeName;
	}
	
}

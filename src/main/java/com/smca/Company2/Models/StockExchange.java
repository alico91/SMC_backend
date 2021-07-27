package com.smca.Company2.Models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;





@Entity
@Table(name = "StockExchange")
public class StockExchange {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private String name;
	
	private String brief;
	
	private String address;
	
	private String remarks;
	
	@OneToMany(targetEntity = CompanyStockExchangeMap.class)
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private List<CompanyStockExchangeMap> compstockmap;
	
	public StockExchange() {
		super();
		
		// TODO Auto-generated constructor stub
	}
	
	public StockExchange(String name) {
		super();
		this.name = name;
	}
	
	public StockExchange(String name, String brief, String address, String remarks) {
		super();
		this.name = name;
		this.brief = brief;
		this.address = address;
		this.remarks = remarks;
	}



	public StockExchange(String name, List<CompanyStockExchangeMap> compstockmap) {
		super();
		this.name = name;
		this.compstockmap = compstockmap;
	}
	public List<CompanyStockExchangeMap> getCompstockmap() {
		return compstockmap;
	}

	public void setCompstockmap(List<CompanyStockExchangeMap> compstockmap) {
		this.compstockmap = compstockmap;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBrief() {
		return brief;
	}

	public void setBrief(String brief) {
		this.brief = brief;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	
	

}

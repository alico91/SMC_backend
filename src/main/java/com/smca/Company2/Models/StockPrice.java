package com.smca.Company2.Models;




import java.sql.Time;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="stock_price")
public class StockPrice {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int Id;

	private String companyCode;

	private String exchangeName;
	
	private float currentPrice;
	
	@JsonFormat(pattern="dd-MM-yyyy")
	private Date date;
	
	private Time time;
	
	@ManyToOne(fetch= FetchType.LAZY)
	@JsonIgnore
	private Company company;
	
	
	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public int getId() {
		return Id;
	}

	public void setId(int Id) {
		this.Id = Id;
	}

	public String getCompanyCode() {
		return companyCode;
	}

	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}

	public String getExchangeName() {
		return exchangeName;
	}

	public void setExchangeName(String exchangeName) {
		this.exchangeName = exchangeName;
	}

	public float getCurrentPrice() {
		return currentPrice;
	}

	public void setCurrentPrice(float currentPrice) {
		this.currentPrice = currentPrice;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Time getTime() {
		return time;
	}

	public void setTime(Time time) {
		this.time = time;
	}

	public StockPrice(String companyCode, String exchangeName, float currentPrice, Date date, Time time) {
		super();
		this.companyCode = companyCode;
		this.exchangeName = exchangeName;
		this.currentPrice = currentPrice;
		this.date = date;
		this.time = time;
	}

	public StockPrice() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
}

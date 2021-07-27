package com.smca.Company2.Models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

import com.fasterxml.jackson.annotation.JsonIgnore;



@NamedQuery(name = "Company.findByname", query = "SELECT c FROM Company c WHERE c.name = :name")
@Entity
@Table(name = "Company")
public class Company {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(nullable = false)
	private String name;

	@Column(nullable = false)
	private Double turnover;

	@Column(nullable = false)
	private String ceo;

	@Column(nullable = false)
	@Type(type = "text")
	private String boardOfDirectors;
	
	@Column(nullable = false)
	@Type(type = "text")
	private String companyBrief;
	
	@OneToMany(mappedBy = "company")
	@JsonIgnore
	private List<StockPrice> stockPrice = new ArrayList<>();
	
	@OneToOne(fetch = FetchType.LAZY, mappedBy="company", cascade = CascadeType.REMOVE)
	private Ipo ipo;
	
	@OneToMany(targetEntity = CompanyStockExchangeMap.class)
	@JsonIgnore
	private List<CompanyStockExchangeMap> compstockmap;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnore
	private Sector sector;
	
	private String sectorName;
	
	@ManyToMany
	private List<StockExchange> stockExchanges;
	
	public Company() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Company(String name) {
		super();
		this.name =name;
		// TODO Auto-generated constructor stub
	}

	public Company( String name, List<CompanyStockExchangeMap> compstockmap) {
		super();
		
		this.name = name;
		this.compstockmap = compstockmap;
	}

	public Company(String name, String companyBrief) {
		super();
		this.companyBrief = companyBrief;
		this.name = name;
		
	}
	
	
	
	public List<StockExchange> getStockExchanges() {
		return stockExchanges;
	}

	public void setStockExchanges(List<StockExchange> stockExchanges) {
		this.stockExchanges = stockExchanges;
	}

	public List<StockPrice> getStockPrice() {
		return stockPrice;
	}

	public void setStockPrice(List<StockPrice> stockPrice) {
		this.stockPrice = stockPrice;
	}

	public String getSectorName() {
		return sectorName;
	}

	public void setSectorName(String sectorName) {
		this.sectorName = sectorName;
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

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getTurnover() {
		return turnover;
	}

	public void setTurnover(Double turnover) {
		this.turnover = turnover;
	}

	public String getCeo() {
		return ceo;
	}

	public void setCeo(String ceo) {
		this.ceo = ceo;
	}

	public String getBoardOfDirectors() {
		return boardOfDirectors;
	}

	public void setBoardOfDirectors(String boardOfDirectors) {
		this.boardOfDirectors = boardOfDirectors;
	}

	public String getCompanyBrief() {
		return companyBrief;
	}

	public void setCompanyBrief(String companyBrief) {
		this.companyBrief = companyBrief;
	}

	public Ipo getIpo() {
		return ipo;
	}

	public void setIpo(Ipo ipo) {
		this.ipo = ipo;
	}

	public Sector getSector() {
		return sector;
	}

	public void setSector(Sector sector) {
		this.sector = sector;
	}
	
	

}

package com.smca.Company2.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.smca.Company2.Models.StockPrice;

public interface StockPriceRepository extends JpaRepository<StockPrice,Long> {
	public List<StockPrice> findByCompanyCodeAndExchangeName(String companyCode, String exchangeName); 
}

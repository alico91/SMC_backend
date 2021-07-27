package com.smca.Company2.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.smca.Company2.Models.StockExchange;


public interface StockExchangeRepository extends JpaRepository<StockExchange,Long> {
	StockExchange findByName(String Name);
}

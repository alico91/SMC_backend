package com.smca.Company2.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.smca.Company2.Models.CompanyStockExchangeMap;


@Repository
public interface CompanyStockExchangeMapRepository extends JpaRepository<CompanyStockExchangeMap,Long>{

	CompanyStockExchangeMap findByCompanyCode(String companyCode);
	
	CompanyStockExchangeMap findByCompanyNameAndStockExchangeName(String companyName, String stockExchangeName);
	
}

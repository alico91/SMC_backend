package com.smca.Company2.Services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smca.Company2.Models.Company;
import com.smca.Company2.Models.CompanyStockExchangeMap;
import com.smca.Company2.Models.StockExchange;
import com.smca.Company2.Repository.StockExchangeRepository;

@Service
public class StockExchangeService {
	
	@Autowired
	StockExchangeRepository stockexRepository;
	
	public List<StockExchange> getStockExchangesList() {
		List<StockExchange> stockExchanges = stockexRepository.findAll();
		return stockExchanges;
	}

	public StockExchange findById(Long id) {
		StockExchange stockExchange = stockexRepository.getById(id);
		return stockExchange;
	}

	public StockExchange addStockExchange(StockExchange stockExchange) {
		StockExchange newstockExchange = stockexRepository.save(stockExchange);
		return newstockExchange;
	}

	public StockExchange editStockExchange(StockExchange stockExchange) {
		
		if(findById(stockExchange.getId())==null) {
			return null;
		}
		StockExchange updatedstockExchange = stockexRepository.save(stockExchange);
		return updatedstockExchange;
	}

	public void deleteStockExchange(Long id) {
		stockexRepository.deleteById(id);
		
	}

	public List<Company> getAllCompanies(long id) {
		List<CompanyStockExchangeMap> compstockmap=stockexRepository.findById(id).get().getCompstockmap();
		List<Company> companies = new ArrayList<Company>();
		
		for(CompanyStockExchangeMap cmps:compstockmap){
			companies.add(cmps.getCompany());
		}
		
		return companies;
	}


	
	

}

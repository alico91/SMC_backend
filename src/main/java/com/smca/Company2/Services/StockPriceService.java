package com.smca.Company2.Services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smca.Company2.Dto.CompanyCompareRequest;
import com.smca.Company2.Models.Company;
import com.smca.Company2.Models.CompanyStockExchangeMap;
import com.smca.Company2.Models.StockPrice;
import com.smca.Company2.Repository.CompanyRepository;
import com.smca.Company2.Repository.CompanyStockExchangeMapRepository;
import com.smca.Company2.Repository.StockPriceRepository;

@Service
public class StockPriceService {
	
	@Autowired
	private StockPriceRepository stockPriceRepository;
	
	@Autowired
	private CompanyStockExchangeMapRepository csemrepo;
	
	@Autowired
	private CompanyRepository companyrepo;
	
	public List<StockPrice> save(List<StockPrice> stockPrices){
		List<StockPrice> updatedsp = new ArrayList();
		for(int i=0;i<stockPrices.size();i++) {
			StockPrice stockprice = stockPrices.get(i);
			CompanyStockExchangeMap csemap = csemrepo.findByCompanyCode(stockprice.getCompanyCode());
			Company company = companyrepo.findByName(csemap.getCompanyName());
			stockprice.setCompany(company);
		    StockPrice stkprice= stockPriceRepository.save(stockprice);
		    updatedsp.add(stkprice);	
		}
		
		return updatedsp;
	}
	
	public List<StockPrice> findAll() {
		List<StockPrice> stockPrices = stockPriceRepository.findAll();
		return stockPrices;
	}

	public StockPrice findById(Long id) {
		Optional<StockPrice> stockPrice = stockPriceRepository.findById(id);
		if(!stockPrice.isPresent())
			return null;
		return stockPrice.get();
	}
	
	public List<StockPrice> getStockPricesForCompanyComparison(CompanyCompareRequest compareRequest) throws ParseException{
		Date fromDate = new SimpleDateFormat("dd-MM-yyyy").parse(compareRequest.getFromPeriod());
		Date toDate = new SimpleDateFormat("dd-MM-yyyy").parse(compareRequest.getToPeriod());
		System.out.println(compareRequest.toString());
		System.out.println(compareRequest.getCompanyName());
		CompanyStockExchangeMap csemap=csemrepo.findByCompanyNameAndStockExchangeName
                (compareRequest.getCompanyName(), compareRequest.getStockExchangeName());
          System.out.println(csemap.toString());

        List<StockPrice> stockPrices = stockPriceRepository
                .findByCompanyCodeAndExchangeName(csemap.getCompanyCode(), csemap.getStockExchangeName());
        System.out.println(stockPrices.toString());
		List<StockPrice> filteredList = stockPrices.stream()
				.filter(stockPrice -> {
					Date date = null;
					date = stockPrice.getDate();
					
					
					return date.after(fromDate) && date.before(toDate);
				})
				.collect(Collectors.toList());
		return filteredList;
	}
}

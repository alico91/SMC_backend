package com.smca.Company2.Controller;

import java.io.IOException;
import java.net.URI;
import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.smca.Company2.Dto.CompanyCompareRequest;
import com.smca.Company2.Models.Company;
import com.smca.Company2.Models.CompanyStockExchangeMap;
import com.smca.Company2.Models.StockPrice;
import com.smca.Company2.Repository.CompanyRepository;
import com.smca.Company2.Repository.CompanyStockExchangeMapRepository;
import com.smca.Company2.Repository.StockPriceRepository;
import com.smca.Company2.Services.StockPriceService;

@RestController
@CrossOrigin(origins= "http://localhost:4200", exposedHeaders="Access-Control-Allow-Origin")
@RequestMapping("/stockPrices")
public class StockPriceController {

	@Autowired
	StockPriceRepository stkpricerepo;
	
	@Autowired
	CompanyRepository companyrepo;
	
	@Autowired
	CompanyStockExchangeMapRepository csemrepo; 
	
	@Autowired
	StockPriceService stockPriceService;
	
	@RequestMapping(value = "/addstockprices",method=RequestMethod.POST)
	public  ResponseEntity<Object> stockpriceapi(@RequestBody StockPrice stockprice) throws ClassNotFoundException, IOException {
		
		CompanyStockExchangeMap csemap = csemrepo.findByCompanyCode(stockprice.getCompanyCode());
		Company company = companyrepo.findByName(csemap.getCompanyName());
		stockprice.setCompany(company);
	    StockPrice stkprice= stkpricerepo.save(stockprice);
	    System.out.println(stkprice +"check this " +stkprice.getCompanyCode());

	    URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(stkprice.getId())
	            .toUri();
	    
	    return ResponseEntity.created(location).build();
	}

	@PostMapping(path = "")
	public ResponseEntity<?> save(@RequestBody List<StockPrice> stockPrices) {
		return ResponseEntity
				.status(HttpStatus.CREATED)
				.body(stockPriceService.save(stockPrices));
	}
	
	@RequestMapping(value = "/getstockprices",method=RequestMethod.GET, headers = "Accept=application/json"  )
	public List<StockPrice> getstockprice() throws ClassNotFoundException, IOException {

	    List<StockPrice> stkprice= stkpricerepo.findAll();
	    return stkprice;
	}
	
	@PostMapping(path = "/compareCompany")
	@CrossOrigin(origins ="http://localhost:4200")
	public ResponseEntity<?> companyComparison(@RequestBody CompanyCompareRequest compareRequest)
	{
		List<StockPrice> stockPrices = null;
		try {
			stockPrices = stockPriceService.getStockPricesForCompanyComparison(compareRequest);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			return ResponseEntity
					.status(HttpStatus.BAD_REQUEST)
					.body("Invalid Date Format");
		}
		HttpHeaders headers = new HttpHeaders();
		headers.add("Access-Control-Allow-Origin", "*");
		return ResponseEntity.ok(stockPrices);
	}
	

	    
}

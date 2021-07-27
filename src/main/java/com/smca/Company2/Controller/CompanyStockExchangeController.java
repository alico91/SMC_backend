package com.smca.Company2.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.smca.Company2.Models.Company;
import com.smca.Company2.Models.CompanyStockExchangeMap;
import com.smca.Company2.Models.StockExchange;
import com.smca.Company2.Repository.CompanyRepository;
import com.smca.Company2.Repository.CompanyStockExchangeMapRepository;
import com.smca.Company2.Repository.StockExchangeRepository;

@RestController
@CrossOrigin(origins = "http://localhost:4200", exposedHeaders="Access-Control-Allow-Origin")
@RequestMapping("/mapcompanycode")
public class CompanyStockExchangeController {
	
	@Autowired
	CompanyStockExchangeMapRepository compstkmaprepo;
	@Autowired
	CompanyRepository cmprepo;
	@Autowired
	StockExchangeRepository stkrepo;
	
	@PostMapping(path="")
	public CompanyStockExchangeMap mapcode(@RequestBody CompanyStockExchangeMap cmpstkmap) {
		
		Company company=cmprepo.findByName(cmpstkmap.getCompanyName());
		
		StockExchange stkexchg=stkrepo.findByName(cmpstkmap.getStockExchangeName());
		CompanyStockExchangeMap csemap = new CompanyStockExchangeMap();
		csemap.setCompanyCode(cmpstkmap.getCompanyCode());
		csemap.setCompany(company);
		csemap.setCompanyName(cmpstkmap.getCompanyName());
		csemap.setStockExchange(stkexchg);
		csemap.setStockExchangeName(cmpstkmap.getStockExchangeName());
		company.getStockExchanges().add(stkexchg);
		cmprepo.save(company);
		compstkmaprepo.save(csemap);
		return csemap;
	}
	
	@GetMapping(path = "")
	public ResponseEntity<List<CompanyStockExchangeMap>> getMappings(){
		List<CompanyStockExchangeMap> comstockexmaps = compstkmaprepo.findAll();
		return ResponseEntity
				.ok(comstockexmaps);
	}
}

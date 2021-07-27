package com.smca.Company2.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.smca.Company2.Models.Company;
import com.smca.Company2.Models.StockExchange;
import com.smca.Company2.Services.StockExchangeService;

@RestController
@CrossOrigin(origins= "http://localhost:4200")
@RequestMapping("/stockExchanges")
public class StockExchangeController {
	
	@Autowired
	StockExchangeService stockExchangeService;
	
	@GetMapping(path = "")
	public ResponseEntity<List<StockExchange>> getStockExchangesList() {
		return ResponseEntity.ok(stockExchangeService.getStockExchangesList());
	}
	
	@GetMapping(path = "/{id}")
	public ResponseEntity<StockExchange> getStockExchangeDetails(@PathVariable Long id){
		StockExchange stockExchange = stockExchangeService.findById(id);
		return ResponseEntity.ok(stockExchange);
	}
	
	@PostMapping(path = "", headers = "Accept=application/json")
	public ResponseEntity<StockExchange> addStockExchange(@RequestBody StockExchange stockExchange) {
		return ResponseEntity.ok(stockExchangeService.addStockExchange(stockExchange));
	}
	
	@PutMapping(path = "")
	public ResponseEntity<StockExchange> editStockExchange(@RequestBody StockExchange stockExchange){
		StockExchange updatedStockExchange = stockExchangeService.editStockExchange(stockExchange);
		if(updatedStockExchange == null) {
			return null;
		}
		return ResponseEntity.ok(updatedStockExchange);
	}
	
	@DeleteMapping(path = "/{id}")
	public void deleteStockExchange(@PathVariable Long id) {
		stockExchangeService.deleteStockExchange(id);
	}
	
	@GetMapping(path="/{id}/companies")
	public ResponseEntity<List<Company>> getAllCompanies( @PathVariable long id)
	{
		return ResponseEntity.ok(stockExchangeService.getAllCompanies(id));
	}


	
	
}

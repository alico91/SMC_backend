package com.smca.Company2.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
import com.smca.Company2.Models.Ipo;
import com.smca.Company2.Services.CompanyService;
import com.smca.Company2.Services.IpoService;


@RestController
@CrossOrigin(origins= "http://localhost:4200")
@RequestMapping("/ipos")
public class IpoController {
	
	@Autowired
	private IpoService ipoService;

	
	@GetMapping(path = "")
	public ResponseEntity<List<Ipo>> findAll() {
		return ResponseEntity.ok(ipoService.findAll());
	}
	
	@GetMapping(path = "/{id}")
	public ResponseEntity<Ipo> findById(@PathVariable Long id){
		Ipo ipoDetail = ipoService.findById(id);
		return ResponseEntity.ok(ipoDetail);
	}
	
	@PostMapping(path = "")
	public ResponseEntity<Ipo> save(@RequestBody Ipo ipo){
		Ipo addedIpo = ipoService.save(ipo);
		return ResponseEntity
				.status(HttpStatus.CREATED)
				.body(addedIpo);
	}
	
	@PutMapping(path = "")
	public ResponseEntity<Ipo> update(@RequestBody Ipo ipo){
		Ipo updatedIpo = ipoService.update(ipo);
		return ResponseEntity.ok(updatedIpo);
	}
	
	@DeleteMapping(path = "/{id}")
	public void deleteById(@PathVariable Long id) {
		ipoService.deleteById(id);
	}
	
	@GetMapping(path = "/{id}/company")
	public Company getCompany(@PathVariable Long id) {
		Company company = ipoService.getCompany(id);
		return company;
	}
}

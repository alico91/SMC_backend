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
import com.smca.Company2.Models.Ipo;
import com.smca.Company2.Services.CompanyService;

@RestController
@CrossOrigin(origins= "http://localhost:4200")
@RequestMapping("/company-service/companies")
public class CompanyController {
	
	@Autowired
	private CompanyService companyService;
	
	@GetMapping(path = "")
	public ResponseEntity<List<Company>> getCompanies(){
		return ResponseEntity
				.ok(companyService.getCompanies());
	}
	
	@GetMapping(path = "/{id}")
	public ResponseEntity<Company> getCompanyDetails(@PathVariable Long id) {
		Company company = companyService.findById(id);
		return ResponseEntity.ok(company);
	}
	
	@PostMapping(path = "")
	public ResponseEntity<?> addCompany(@RequestBody Company company) {
		return ResponseEntity.ok(companyService.addCompany(company));
	}
	
	@DeleteMapping(path = "/{id}")
	public void deleteCompany(@PathVariable Long id) {
		companyService.deleteCompany(id);
	}
	
	@PutMapping(path = "")
	public ResponseEntity<Company> editCompany(@RequestBody Company company){
		Company updatedCompany = companyService.editCompany(company);
		return ResponseEntity.ok(updatedCompany);
	}
	
	@GetMapping(path = "/{id}/ipos")
	public ResponseEntity<Ipo> getCompanyIpoDetails(@PathVariable Long id){
		Ipo ipoDetail = companyService.getCompanyIpoDetails(id);
		return ResponseEntity.ok(ipoDetail);
	}
	
	@PostMapping(path = "/{id}/ipos")
	public void addIpoToCompany(@PathVariable Long id, @RequestBody Ipo ipo){
		Company company = companyService.addIpoToCompany(id, ipo);
		/*if(company == null) {
			throw new CompanyException("Company not with name : " + companyName);
		}*/
	}
	
}

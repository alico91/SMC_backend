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
import com.smca.Company2.Models.Sector;
import com.smca.Company2.Services.SectorService;

@RestController
@CrossOrigin(origins= "http://localhost:4200")
@RequestMapping("/sectors")
public class SectorController {
	
	@Autowired
	private SectorService sectorService;
	
	@GetMapping(path = "")
	public ResponseEntity<List<Sector>> findAll(){
		return ResponseEntity
				.ok(sectorService.findAll());
	}
	
	@GetMapping(path = "/{id}")
	public ResponseEntity<Sector> findById(@PathVariable long id){
		Sector sector = sectorService.findById(id);
		return ResponseEntity.ok(sector);
	}
	
	@PostMapping(path = "")
	public ResponseEntity<Sector> save(@RequestBody Sector sector) {
		return ResponseEntity
				.status(HttpStatus.CREATED)
				.body(sectorService.save(sector));
	}
	
	@PutMapping(path = "")
	public ResponseEntity<Sector> update(@RequestBody Sector sector){
		Sector updatedSector = sectorService.update(sector);
		return ResponseEntity.ok(updatedSector);
	}
	
	@DeleteMapping(path = "/{id}")
	public void deleteById(@PathVariable long id) {
		sectorService.deleteById(id);
	}
	
	@GetMapping(path = "/{id}/companies")
	public ResponseEntity<List<Company>> getCompanies(@PathVariable long id){
		List<Company> companies = sectorService.getCompanies(id);
		return ResponseEntity.ok(companies);
	}
	
}

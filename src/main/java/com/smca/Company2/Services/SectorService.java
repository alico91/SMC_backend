package com.smca.Company2.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.smca.Company2.Models.Company;
import com.smca.Company2.Models.Sector;
import com.smca.Company2.Repository.CompanyRepository;
import com.smca.Company2.Repository.SectorRepository;

@Service
public class SectorService {
	
	@Autowired
	SectorRepository sectorRepository;
	
	@Autowired
	CompanyRepository companyRepository;

	public List<Sector> findAll() {
		List<Sector> sectors=sectorRepository.findAll();
		return sectors;
	}

	public Sector findById(long id) {
		// TODO Auto-generated method stub
		Optional<Sector>sector =sectorRepository.findById(id);
		if(!sector.isPresent())
		   return null;
		return sector.get();
	}

	public Sector save(Sector sector) {
		sectorRepository.save(sector);
		return sector;
	}
	
	public Sector update(Sector sector) {
		// TODO Auto-generated method stub
		if(findById(sector.getId())==null) {
			return null;
		}
		Sector updatedSector = sectorRepository.save(sector);
		return updatedSector;
	}
	
	public void deleteById(long id) {
		sectorRepository.deleteById(id);
		
	}

	public List<Company> getCompanies(long id) {
		Optional<Sector> sector = sectorRepository.findById(id);
		List<Company> companies = sector.get().getCompanies();
		return companies;
	}	
	
	
}

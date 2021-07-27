package com.smca.Company2.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smca.Company2.Models.Company;
import com.smca.Company2.Models.Ipo;
import com.smca.Company2.Repository.CompanyRepository;
import com.smca.Company2.Repository.IpoRepository;

@Service
public class IpoService {
	
	@Autowired
	IpoRepository ipoRepository;
	@Autowired
	CompanyRepository companyRepository;

	public List<Ipo> findAll() {
		List<Ipo> ipos = ipoRepository.findAll();
		return ipos;
	}

	
	public Ipo findById(Long id) {
		Ipo ipo = ipoRepository.getById(id);
		return ipo;
	}

	public Ipo save(Ipo ipo) {
		Company company = companyRepository.findByName(ipo.getCompanyName());
		if(company == null)
			return null;
		company.setIpo(ipo);
		ipo.setCompany(company);
		Ipo ipoDetail = ipoRepository.save(ipo);
		companyRepository.save(company);
		return ipoDetail;
	}

	public Ipo update(Ipo ipo) {
		if(findById(ipo.getId()) == null) {
			return null;
		}
		Ipo updatedIpo = ipoRepository.save(ipo);
		return updatedIpo;
	}

	public void deleteById(Long id) {
		ipoRepository.deleteById(id);
		
	}


	public Company getCompany(Long id) {
		if(id == null) {
			return null;
		}
		Ipo ipo = ipoRepository.findById(id).get();
		Company company = ipo.getCompany();
		return company;
	}
	
	
}

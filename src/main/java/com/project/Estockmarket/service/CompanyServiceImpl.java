package com.project.Estockmarket.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.Estockmarket.model.Company;
import com.project.Estockmarket.repository.CompanyRepository;

@Service
public class CompanyServiceImpl implements CompanyService{

	@Autowired
	CompanyRepository companyRepo;
	
	@Override
	public Company save(Company company) {
		return companyRepo.save(company);
	}

	@Override
	public List<Company> getallcompany() {
		return StreamSupport.stream(companyRepo.findAll().spliterator(), false).collect(Collectors.toList());
	}

	@Override
	public Company findByCode(String company_code) {
		return companyRepo.findByCode(company_code);
		
	}

	@Override
	public void deleteByCode(String code) {
		Company comp1=companyRepo.findByCode(code);
		Integer id=comp1.getId();
		companyRepo.deleteById(id);
	}

	@Override
	public Company get(Integer id) {
		Optional<Company> comp1=companyRepo.findById(id);
		return comp1.get();
	}

	
	
	
}

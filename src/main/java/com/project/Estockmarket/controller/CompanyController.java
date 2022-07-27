package com.project.Estockmarket.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.Estockmarket.model.Company;
import com.project.Estockmarket.model.Stock;
import com.project.Estockmarket.service.CompanyService;
import com.project.Estockmarket.service.StockService;

@RestController
@RequestMapping("/api/v1.0/market")
@CrossOrigin()
public class CompanyController {
	
	@Autowired
	private CompanyService companyService;
	
	@PostMapping("/company/register")
	public String register(@RequestBody Company company) {
		companyService.save(company);
		return "Company is addedd successfully";
	}
	
	 @GetMapping("/company/info/companycode/{code}")
	    public Company getCompanyById(@PathVariable String code){
	        return companyService.findByCode(code);
	    }
	

	@GetMapping("/company/getall")
	public List<Company> getdata(){
		return companyService.getallcompany();
	}
	
	@DeleteMapping("/company/delete/{code}")
	public void deletecompany(@PathVariable("code") String code) {
		companyService.deleteByCode(code);
	}
	
	@GetMapping("/company/get/{id}")
	public Company get(@PathVariable Integer id) {
			return companyService.get(id);
		
	}
	
	
	
	
}

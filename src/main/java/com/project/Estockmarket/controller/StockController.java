package com.project.Estockmarket.controller;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.Estockmarket.model.Company;
import com.project.Estockmarket.model.Stock;
import com.project.Estockmarket.repository.CompanyRepository;
import com.project.Estockmarket.repository.StockRepository;
import com.project.Estockmarket.service.StockService;

@RestController
@RequestMapping("/stock")
@CrossOrigin()
public class StockController {
	
	@Autowired
	StockService stockservice;
	
	@Autowired
	StockRepository stockRepo;
	
	@Autowired 
	CompanyRepository compRepo;
	
	@PostMapping("/add/{code}")
	public String add(@RequestBody Stock stock,@PathVariable String code) {
		stockservice.save(stock,code);
		return "succeddfully addedd new stock";
	}
	
//	@GetMapping("get/{code}/{date_time}/{date_time1}")
//	public List<Stock> get(@PathVariable String code,Date date_time,Date date_time1){
//		return stockservice.get(code,date_time,date_time1);
//	}
	
	
}

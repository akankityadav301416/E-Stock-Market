package com.project.Estockmarket.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.Estockmarket.model.Company;
import com.project.Estockmarket.model.Stock;
import com.project.Estockmarket.repository.CompanyRepository;
import com.project.Estockmarket.repository.StockRepository;

import antlr.collections.List;


@Service
public class StockServiceImpl implements StockService{

	@Autowired
	StockRepository stockRepo;
	
	@Autowired 
	CompanyRepository compRepo;
	

	@Override
	public void save(Stock stock1, String code) {
		Company comp=compRepo.findByCode(code);
		Company comp1=comp;
		java.util.List<Stock> stock2= comp.getStock();
		stock2.add(stock1);
		comp.setStock(stock2);
		compRepo.save(comp);
		stock1.setCompany(comp1);
		stockRepo.save(stock1);
	}


//	@Override
//	public java.util.List<Stock> get(String code, Date date_time, Date date_time1) {
//		Company comp=compRepo.findByCode(code);
//		java.util.List<Stock> stock1=comp.getStock();
//	    java.util.List<Stock> stock2=(java.util.List<Stock>) stockRepo.findBydate_timeAfterAndEndDateBefore(date_time,date_time1);
//	    return stock2;
//	}
	
	
	
	
	

}

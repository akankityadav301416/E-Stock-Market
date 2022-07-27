package com.project.Estockmarket.service;

import java.util.List;
import java.util.Optional;

import com.project.Estockmarket.model.Company;

public interface CompanyService {

	public Company save(Company company);

	public List<Company> getallcompany();

	public Company findByCode(String code);

	public void deleteByCode(String code);

	public Company get(Integer id);

}

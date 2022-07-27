package com.project.Estockmarket.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;


@Entity
//@Table(name="companies")
public class Company {

	@javax.persistence.Id
	@GeneratedValue
	private Integer id;
	
	@Column(nullable = false , unique = true)
	private String code;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@NotNull
	private String name;
	

	@NotNull
	private String ceo;
	
	@NotNull
	@Min(10000001)
	private Long turnover;
	
	@NotNull
	private String website;
	
	

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(referencedColumnName = "id")	
	private List<Stock> stocks = new ArrayList<Stock>();

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCeo() {
		return ceo;
	}

	public void setCeo(String ceo) {
		this.ceo = ceo;
	}

	public Long getTurnover() {
		return turnover;
	}

	public void setTurnover(Long turnover) {
		this.turnover = turnover;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	


	public void setStock(List<Stock> stock) {
		this.stocks = stock;
	}

	public List<Stock> getStock() {
		return stocks;
	}

	public Company() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	
	
}

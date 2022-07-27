package com.project.Estockmarket.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity(name="Stock")
public class Stock {

	@Id
	@GeneratedValue
	private Integer Sid;
	private double stockprice;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable = false)
	private Date date_time;
	
	@PrePersist
	public void onCreate() {
		date_time=new Date();
	}
	
	@ManyToOne
	private Company company;
	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public Integer getSid() {
		return Sid;
	}

	public void setSid(Integer sid) {
		Sid = sid;
	}


	public double getStockprice() {
		return stockprice;
	}

	public void setStockprice(double stockprice) {
		this.stockprice = stockprice;
	}

	public Date getDate_time() {
		return date_time;
	}


	public void setDate_time(Date date_time) {
		this.date_time = date_time;
	}


	

	public Stock(Integer sid, double stockprice, Date date_time, Company company) {
		super();
		Sid = sid;
		this.stockprice = stockprice;
		this.date_time = date_time;
		this.company = company;
	}

	public Stock() {}
	
	
	
	
}

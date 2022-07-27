package com.project.Estockmarket.repository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.project.Estockmarket.model.Stock;

@Repository
public interface StockRepository extends JpaRepository<Stock, Integer>{

//	@Query(nativeQuery = true, value="select c.stockprice from Stock c where ((c.date_time between :startDate and :endDate) and (c.company_id=id))")
//	List<Stock> getData_between(@Param("startDate") LocalDate date, @Param("endDate") LocalDate date2,@Param("id") Integer id);



}

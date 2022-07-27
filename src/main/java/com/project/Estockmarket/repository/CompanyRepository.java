package com.project.Estockmarket.repository;




import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.project.Estockmarket.model.Company;


@Repository
public interface CompanyRepository extends JpaRepository<Company,Integer>{
	

//	@Query("SELECT C FROM Company C where C.code=?1")
	Company findByCode(String company_code);

//	@Query("delete from Company C where C.code=?1")
	void deleteByCode(String code);
	
}

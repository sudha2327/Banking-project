package com.bank.bank.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bank.bank.entity.auditg;


public interface auditlogrepo extends JpaRepository <auditg, Long>{

			@Query("""
			        SELECT a FROM auditg a
			        WHERE a.accountId = :accountId
			        AND MONTH(a.timestamp) = :month
			        AND YEAR(a.timestamp) = :year
			        ORDER BY a.timestamp ASC
			    """)
			
			    List<auditg> findMonthlyAudit(
			            @Param("accountId") Long accountId,
			            @Param("month") int month,
			            @Param("year") int year
			    );
  
	
}
 
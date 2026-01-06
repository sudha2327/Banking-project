package com.bank.bank.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bank.bank.entity.auditg;

public interface auditlogrepo extends JpaRepository <auditg, Long>{

	
	@Query("""SELECT a FROM audit_log a WHERE a.account_id= :account_id and Month(a.timestamp)= :month and year(a.timestamp)= :year"""")

   List<auditg> findMonthlyaudit(@Param("account_id") Long account_id, @Param("month") int month,@Param("year") int year)
	
}
 
package com.poc.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.poc.excel.PRU;
@Repository
public interface PocRepo extends JpaRepository<PRU, Long> {
	public PRU findByEmployeeCodeAndProjectName(Long employeeCode, String projectName);
}

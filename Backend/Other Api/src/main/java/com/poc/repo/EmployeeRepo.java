package com.poc.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.poc.excel.Employee;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Long> {
	
	@Query(value="select * from employee_data  where  project_name='Not assigned'", nativeQuery=true)
	List<Employee> findBydepartmentNameAndprojectName();
	
	@Query(value="SELECT * FROM poc.employee_data WHERE DATEDIFF(CURDATE(), STR_TO_DATE(assignment_end_date, '%d-%b-%Y')) = -1 AND assignment_end_date IS NOT NULL ;", nativeQuery=true)
	List<Employee> findByassignmentEndDate();
	
	@Query(value="SELECT * FROM unassigned_two \r\n"
			+ "WHERE employee_code IN (\r\n"
			+ "  SELECT employee_code FROM employee_data \r\n"
			+ "  WHERE  project_name='Not Assigned'\r\n"
			+ ") AND DATEDIFF(NOW(), STR_TO_DATE(assignment_end_date, '%d-%b-%y')) >= 2;", nativeQuery=true)
	List<Employee> findByassignmentEnded();
	
	@Query(value="select * from employee_data  where depart_name='ERS T&S _SIE-SIE-OISV&FINTECH'", nativeQuery=true)
	List<Employee> findBydepartmentName();
	
	@Query(value="SELECT * FROM poc.employee_data Where project_name='ERS-T&S SIE OISV Fintech Bench'", nativeQuery=true)
	List<Employee> findByBenchEmployees();
	
}

package com.poc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.io.ByteArrayInputStream;
import java.util.*;

import com.poc.excel.Employee;
import com.poc.excel.UnassignedTwo;
import com.poc.helperClass.Helper;
import com.poc.repo.EmployeeRepo;
import com.poc.repo.UnassignedTwoRepository;

@Service
public class ExcelService {

	@Autowired
	private EmployeeRepo repository;

	@Autowired
	private UnassignedTwoRepository unassignedTwoRepository;

	public ByteArrayInputStream getData() {
		List<Employee> employees1 = repository.findBydepartmentNameAndprojectName();
		ByteArrayInputStream byteArrayInputStream = Helper.dataToExcel(employees1);
		return byteArrayInputStream;
	}

	public ByteArrayInputStream getActualData() {
		List<Employee> employees2 = repository.findByassignmentEndDate();
		ByteArrayInputStream byteArrayInputStream = Helper.dataToExcel(employees2);
		return byteArrayInputStream;
	}

	public ByteArrayInputStream getActualData2() {
		List<Employee> employees3 = repository.findByassignmentEnded();
		ByteArrayInputStream byteArrayInputStream = Helper.dataToExcel(employees3);
		return byteArrayInputStream;
	}

	public void saveList() {
		List<Employee> employees = repository.findByassignmentEndDate();
		List<UnassignedTwo> unassigneds = new ArrayList<>();
		for (Employee employee : employees) {
			UnassignedTwo unassigned = new UnassignedTwo();
			unassigned.setAllocation(employee.getAllocation());
			unassigned.setAssignmentEndDate(employee.getAssignmentEndDate());
			unassigned.setAssignmentStartDate(employee.getAssignmentStartDate());
			unassigned.setCWL(employee.getCWL());
			unassigned.setDateofJoining(employee.getDateofJoining());
			unassigned.setEmployeeCode(employee.getEmployeeCode());
			unassigned.setEmployeeName(employee.getEmployeeName());
			unassigned.setEmployeeSkillName(employee.getEmployeeSkillName());
			unassigned.setFresherFCLLateral(employee.getFresherFCLLateral());
			unassigned.setFTE(employee.getFTE());
			unassigned.setHRL4(employee.getHRL4());
			unassigned.setId(employee.getId());
			unassigned.setOnOffClassification(employee.getOnOffClassification());
			unassigned.setProjectCategory(employee.getProjectCategory());
			unassigned.setProjectL4(employee.getProjectL4());
			unassigned.setProjectName(employee.getProjectName());
			unassigned.setProjectCategory(employee.getProjectCategory());
			unassigned.setReportingManager(employee.getReportingManager());
			unassigned.setSkillGroup(employee.getSkillGroup());
			unassigned.setSubBand(employee.getSubBand());
			unassigneds.add(unassigned);

		}
		unassignedTwoRepository.saveAll(unassigneds);
	}

	public ByteArrayInputStream getDep() {
		List<Employee> employees1 = repository.findBydepartmentName();
		ByteArrayInputStream byteArrayInputStream = Helper.dataToExcel(employees1);
		return byteArrayInputStream;
	}

	public ByteArrayInputStream getActualData3() {

		List<Employee> employees3 = repository.findByBenchEmployees();

		ByteArrayInputStream byteArrayInputStream = Helper.dataToExcel(employees3);

		return byteArrayInputStream;

	}

}

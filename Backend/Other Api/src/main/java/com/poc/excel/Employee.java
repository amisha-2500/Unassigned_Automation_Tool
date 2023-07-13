package com.poc.excel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data

@Entity

@Table(name = "EmployeeData")

public class Employee {

	@Id
	@Column(name = "id")
	private Long id;

	@Column(name = "employeeCode")

	private Long EmployeeCode;

	@Column(name = "employeeName")

	private String EmployeeName;

	@Column(name = "CWL")

	private String CWL;

	@Column(name = "subBand")

	private String SubBand;

	@Column(name = "reportingManager")

	private String ReportingManager;

	@Column(name = "DOJ")

	private String DateofJoining;

	@Column(name = "projectName")

	private String ProjectName;

	@Column(name = "category")

	private String FresherFCLLateral;

	@Column(name = "onoffClassification")

	private String OnOffClassification;

	@Column(name = "lastProjectName")

	private String LastProjectName;

	@Column(name = "fte")

	private String FTE;

	@Column(name = "departName")

	private String HRL4;

	@Column(name = "allocation")

	private String Allocation;

	@Column(name = "skillGroup")

	private String SkillGroup;

	@Column(name = "employeeSkillName")

	private String EmployeeSkillName;

	@Column(name = "assignmentStartDate")

	private String AssignmentStartDate;

	@Column(name = "assignmentEndDate")

	private String AssignmentEndDate;

	@Column(name = "projectCategory")

	private String ProjectCategory;

	@Column(name = "projectL4")

	private String ProjectL4;

}
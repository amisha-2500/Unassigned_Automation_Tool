package com.poc.excel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.poiji.annotation.ExcelSheet;

import lombok.Data;
import lombok.ToString;

@Entity
@Data
@ToString
@ExcelSheet("PRU")
@Table(name = "UnassignedTwo")
public class UnassignedTwo {

	@Id
	private Long id;

	private Long EmployeeCode;

	private String EmployeeName;

	private String CWL;

	private String SubBand;

	private String ReportingManager;

	private String DateofJoining;

	private String ProjectName;

	private String FresherFCLLateral;

	private String OnOffClassification;

	private String FTE;

	private String HRL4;

	private String Allocation;

	private String SkillGroup;

	private String EmployeeSkillName;

	private String AssignmentStartDate;

	private String AssignmentEndDate;

	private String ProjectCategory;

	private String ProjectL4;


}

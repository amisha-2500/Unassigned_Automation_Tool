package com.poc.excel;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.poiji.annotation.ExcelCellName;
import com.poiji.annotation.ExcelSheet;

import lombok.Data;
import lombok.ToString;


@Entity
@Data
@ToString
@ExcelSheet("PRU")
@Table(name = "EmployeeData")
public class PRU {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@ExcelCellName("Employee Code")
	private Long employeeCode;
	@ExcelCellName("Employee Name")
	private String employeeName;
	@ExcelCellName("CWL")
	private String CWL;
	@ExcelCellName("Sub Band")
	private String subBand;
	@ExcelCellName("Reporting Manager")
	private String reportingManager;
	@ExcelCellName("Date of Joining")
	private String DOJ;
	@ExcelCellName("Project Name")
	private String projectName;
	@ExcelCellName("Fresher/FCL /Lateral")
	private String category;
	@ExcelCellName("OnOff Classification")
	private String onoffClassification;
	@ExcelCellName("Last Project Name")
	private String lastProjectName;
	@ExcelCellName("FTE")
	private String fte;
	@ExcelCellName("HR L4")
	private String departName;
	@ExcelCellName("Allocation %")
	private String allocation;
	@ExcelCellName("Skill Group  (SPS)")
	private String skillGroup;
	@ExcelCellName("Employee Skill Name")
	private String employeeSkillName;
	@ExcelCellName("Assignment Start Date")
	private String assignmentStartDate;
	@ExcelCellName("Assignment End Date")
	private String assignmentEndDate;
	@ExcelCellName("Project Category")
	private String projectCategory;
	@ExcelCellName("Project L4")
	private String projectL4;

}

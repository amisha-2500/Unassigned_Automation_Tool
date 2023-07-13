package com.poc.helperClass;

import java.io.ByteArrayInputStream;

import java.io.ByteArrayOutputStream;

import java.io.IOException;

import java.util.List;

import org.apache.poi.ss.usermodel.Cell;

import org.apache.poi.ss.usermodel.Row;

import org.apache.poi.ss.usermodel.Sheet;

import org.apache.poi.ss.usermodel.Workbook;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.poc.excel.Employee;

public class Helper {

	public static String[] HEADERS = {

			"EmployeeCode",

			"EmployeeName",

			"CWL",

			"SubBand",

			"ReportingManager",

			"DateofJoining",

			"ProjectName",

			"FresherFCLLateral",

			"OnOffClassification",

			"LastProjectName",

			"FTE",

			"HRL4",

			"Allocation",

			"SkillGroup",

			"EmployeeSkillName",

			"AssignmentStartDate",

			"AssignmentEndDate",

			"ProjectCategory",

			"ProjectL4"

	};

	public static String SHEET_NAME = "Details";

	public static ByteArrayInputStream dataToExcel(List<Employee> list) {

		Workbook book = new XSSFWorkbook();

		ByteArrayOutputStream out = new ByteArrayOutputStream();

		try {

			Sheet sheet = book.createSheet(SHEET_NAME);

			Row row = sheet.createRow(0);

			for (int i = 0; i < HEADERS.length; i++) {

				Cell cell = row.createCell(i);

				cell.setCellValue(HEADERS[i]);

			}

			int rowIndex = 1;

			for (Employee e : list) {

				Row dataRow = sheet.createRow(rowIndex);

				rowIndex++;

				dataRow.createCell(0).setCellValue(e.getEmployeeCode());

				dataRow.createCell(1).setCellValue(e.getEmployeeName());

				dataRow.createCell(2).setCellValue(e.getCWL());

				dataRow.createCell(3).setCellValue(e.getSubBand());

				dataRow.createCell(4).setCellValue(e.getReportingManager());

				dataRow.createCell(5).setCellValue(e.getDateofJoining());

				dataRow.createCell(6).setCellValue(e.getProjectName());

				dataRow.createCell(7).setCellValue(e.getFresherFCLLateral());

				dataRow.createCell(8).setCellValue(e.getOnOffClassification());

				dataRow.createCell(9).setCellValue(e.getLastProjectName());

				dataRow.createCell(10).setCellValue(e.getFTE());

				dataRow.createCell(11).setCellValue(e.getHRL4());

				dataRow.createCell(12).setCellValue(e.getAllocation());

				dataRow.createCell(13).setCellValue(e.getSkillGroup());

				dataRow.createCell(14).setCellValue(e.getEmployeeSkillName());

				dataRow.createCell(15).setCellValue(e.getAssignmentStartDate());

				dataRow.createCell(16).setCellValue(e.getAssignmentEndDate());

				dataRow.createCell(17).setCellValue(e.getProjectCategory());

				dataRow.createCell(18).setCellValue(e.getProjectL4());

			}

			book.write(out);

			return new ByteArrayInputStream(out.toByteArray());

		}

		catch (IOException e) {

			e.printStackTrace();

			return null;

		}

	}

}
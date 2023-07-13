package com.poc.helperClass;

import java.io.InputStream;
import java.util.List;
import java.util.stream.Collectors;

import com.poc.excel.PRU;
import com.poiji.bind.Poiji;
import com.poiji.exception.PoijiExcelType;

public class EmployeeExceltoList {
	
	
	public static List<PRU> convertExcelToList(InputStream inputStream) {
	    List<PRU> employeeList = Poiji.fromExcel(inputStream, PoijiExcelType.XLSX, PRU.class);
	    List<PRU> filteredList = employeeList.stream()
	            .filter(p -> p.getProjectL4().contains("OISV&FINTECH"))
	            .collect(Collectors.toList());
	    return filteredList;
	}

}


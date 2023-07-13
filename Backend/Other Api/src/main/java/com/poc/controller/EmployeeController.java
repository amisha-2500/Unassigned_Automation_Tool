package com.poc.controller;


import java.io.ByteArrayInputStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.core.io.InputStreamResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.poc.service.ExcelService;

@RestController
@RequestMapping("/Details")



public class EmployeeController { 
	
	
	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");  
	   LocalDateTime now = LocalDateTime.now();
	   String x=dtf.format(now);
	
	@Autowired
	private ExcelService service;

	@RequestMapping("/excel")
	public ResponseEntity<Resource> download() {
	    String filename = "DailyUnassignedCases "+x+".xlsx";
		
	    ByteArrayInputStream data = service.getData();
	    InputStreamResource file = new InputStreamResource(data);
			
	    ResponseEntity<Resource> body = ResponseEntity.ok()
	        .header(HttpHeaders.CONTENT_DISPOSITION,"attachment; filename=" +filename)
	        .contentType(MediaType.parseMediaType("application/vnd.ms-excel"))
	        .body(file);
	    return body;
	}
	
	
	@RequestMapping("/new")
	public ResponseEntity<Resource> download1(){
String filename = "OneDayBeforeExpiriation "+x+".xlsx";
		
	    ByteArrayInputStream data = service.getActualData();
	    InputStreamResource file = new InputStreamResource(data);
			
	    ResponseEntity<Resource> body = ResponseEntity.ok()
	        .header(HttpHeaders.CONTENT_DISPOSITION,"attachment; filename=" +filename)
	        .contentType(MediaType.parseMediaType("application/vnd.ms-excel"))
	        .body(file);
	    service.saveList();
	    return body;
	    
	}
	
	@RequestMapping("/new2")
	public ResponseEntity<Resource> download2(){
String filename = "TwoDayUnAssigned "+x+".xlsx";
		
	    ByteArrayInputStream data = service.getActualData2();
	    InputStreamResource file = new InputStreamResource(data);
			
	    ResponseEntity<Resource> body = ResponseEntity.ok()
	        .header(HttpHeaders.CONTENT_DISPOSITION,"attachment; filename=" +filename)
	        .contentType(MediaType.parseMediaType("application/vnd.ms-excel"))
	        .body(file);
	    return body;
	}
	
	@RequestMapping("/new3")

    public ResponseEntity<Resource> download3(){

String filename = "BenchCases "+x+".xlsx";

 

        ByteArrayInputStream data = service.getActualData3();

        InputStreamResource file = new InputStreamResource(data);

 

        ResponseEntity<Resource> body = ResponseEntity.ok()

            .header(HttpHeaders.CONTENT_DISPOSITION,"attachment; filename=" +filename)

            .contentType(MediaType.parseMediaType("application/vnd.ms-excel"))

            .body(file);

        return body;

    }
	
}





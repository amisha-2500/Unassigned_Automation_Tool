package com.poc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.poc.service.PocService;

@RestController
@RequestMapping("/pru")
public class PocController {

	@Autowired
	PocService pocService;

	@PostMapping("/save")
	public ResponseEntity<?> employeeNonTier1Uplaod(@RequestParam("file") MultipartFile file) {
		this.pocService.employeeNonTier1ListSave(file);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}

package com.poc.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.poc.excel.PRU;
import com.poc.helperClass.EmployeeExceltoList;
import com.poc.repo.PocRepo;

@Service
public class PocService {

    @Autowired
    PocRepo pocRepo;

    public void employeeNonTier1ListSave(MultipartFile file) {
        try {
            List<PRU> list = EmployeeExceltoList.convertExcelToList(file.getInputStream());
            List<PRU> filteredList=new ArrayList<>();
            		list.stream().forEach(e->{           	
            		PRU pru=pocRepo.findByEmployeeCodeAndProjectName(e.getEmployeeCode(), e.getProjectName());
            		if(pru==null) {
            			filteredList.add(e);
            		}
            		else { 
            			pru.setAllocation(e.getAllocation());
            			pru.setAssignmentEndDate(e.getAssignmentEndDate());
            			pru.setAssignmentStartDate(e.getAssignmentStartDate());
            			pru.setCategory(e.getCategory());
            			pru.setCWL(e.getCWL());
            			pru.setDepartName(e.getDepartName());
            			pru.setDOJ(e.getDOJ());
            			pru.setEmployeeCode(e.getEmployeeCode());
            			pru.setEmployeeName(e.getEmployeeName());
            			pru.setSubBand(e.getSubBand());
            			pru.setReportingManager(e.getReportingManager());
            			pru.setLastProjectName(e.getLastProjectName());
            			pru.setProjectName(e.getProjectName());
            			pru.setOnoffClassification(e.getOnoffClassification());
            			pru.setFte(e.getFte());
            			pru.setSkillGroup(e.getSkillGroup());
            			pru.setEmployeeSkillName(e.getEmployeeSkillName());
            			pru.setProjectCategory(e.getProjectCategory());
            			pru.setProjectL4(e.getProjectL4());
            			
            			
            			this.pocRepo.save(pru);
            		}
            		});
            this.pocRepo.saveAll(filteredList);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

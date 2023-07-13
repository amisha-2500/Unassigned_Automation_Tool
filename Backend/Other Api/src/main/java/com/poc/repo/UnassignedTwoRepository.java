package com.poc.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.poc.excel.UnassignedTwo;

@Repository
public interface UnassignedTwoRepository extends JpaRepository<UnassignedTwo, Long> {
    
}

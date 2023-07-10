package com.project.repository;



import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.entity.Report;

@Repository
public interface ReportRepository extends JpaRepository<Report, Long> {
	 Optional<Report> findById(Long id);
	 

	    List<Report> findByDate(LocalDate date);
	   

	}
//	    //--
//	    List<Report> findByDiagnosisInfoContaining(String diagnosis);


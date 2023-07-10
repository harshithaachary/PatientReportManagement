package com.project.services;
import java.util.Optional;
import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import com.project.entity.Patient;
import com.project.entity.Report;
import com.project.repository.ReportRepository;

@Service
public class ReportService {

    private final ReportRepository reportRepository;

    public ReportService(ReportRepository reportRepository) {
        this.reportRepository = reportRepository;
    }

    public Report createReport(Report report) {
        return reportRepository.save(report);
    }

    public Report updateReport(Long id, Report report) {
        Report existingReport = reportRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Report not found with id: " + id));

        // Update the existing report with the new information
        existingReport.setTest(report.getTest());
        existingReport.setResults(report.getResults());
        existingReport.setDiagnosisInfo(report.getDiagnosisInfo());
        existingReport.setDate(report.getDate());

        return reportRepository.save(existingReport);
    }

    public List<Report> getAllReports() {
        return reportRepository.findAll();
    }

    public void deleteReport(Long id) {
        reportRepository.deleteById(id);
    }
    public Report getReportById(Long id) {
        return reportRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Report not found with id: " + id));
    }

    public List<Report> getReportsByDate(LocalDate date) {
        return reportRepository.findByDate(date);
    }
    //--
//    public List<Report> getReportsByDiagnosis(String diagnosis) {
//        return reportRepository.findByDiagnosisInfoContaining(diagnosis);
//    }
   
    
    public List<Report> searchReportsByDate(LocalDate date) {
        return reportRepository.findByDate(date);
    }

            
    

}
package com.project.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "reports")
public class Report {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;

    private String test;

    private String results;

    @Column(name = "diagnosis_info")
    private String diagnosisInfo;

    private LocalDate date;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public String getTest() {
		return test;
	}

	public void setTest(String test) {
		this.test = test;
	}

	public String getResults() {
		return results;
	}

	public void setResults(String results) {
		this.results = results;
	}

	public String getDiagnosisInfo() {
		return diagnosisInfo;
	}

	public void setDiagnosisInfo(String diagnosisInfo) {
		this.diagnosisInfo = diagnosisInfo;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public Report(Long id, Patient patient, String test, String results, String diagnosisInfo, LocalDate date) {
		super();
		this.id = id;
		this.patient = patient;
		this.test = test;
		this.results = results;
		this.diagnosisInfo = diagnosisInfo;
		this.date = date;
	}

	public Report() {
		super();
		// TODO Auto-generated constructor stub
	}

    // Constructors, getters, and setters
}

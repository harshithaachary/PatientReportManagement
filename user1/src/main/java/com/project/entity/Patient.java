package com.project.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "patients")
public class Patient {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private int age;

    private String gender;

    @Column(name = "contact_details")
    private String contactDetails;

    @Column(name = "medical_history")
    private String medicalHistory;
    
    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL)
    private List<Report> reports;

    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getContactDetails() {
		return contactDetails;
	}

	public void setContactDetails(String contactDetails) {
		this.contactDetails = contactDetails;
	}

	public String getMedicalHistory() {
		return medicalHistory;
	}

	public void setMedicalHistory(String medicalHistory) {
		this.medicalHistory = medicalHistory;
	}

	

	public Patient(Long id, String name, int age, String gender, String contactDetails, String medicalHistory) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.contactDetails = contactDetails;
		this.medicalHistory = medicalHistory;
	}

	public Patient() {
		super();
		// TODO Auto-generated constructor stub
	}

    // Constructors, getters, and setters
}

package com.project.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.project.entity.Patient;
import com.project.repository.PatientRepository;

@Service
public class PatientService {

    private final PatientRepository patientRepository;

    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public Patient createPatient(Patient patient) {
        return patientRepository.save(patient);
    }

    public Patient updatePatient(Long id, Patient patient) {
        Patient existingPatient = patientRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Patient not found with id: " + id));

        existingPatient.setName(patient.getName());
        existingPatient.setAge(patient.getAge());
        existingPatient.setGender(patient.getGender());
        existingPatient.setContactDetails(patient.getContactDetails());
        existingPatient.setMedicalHistory(patient.getMedicalHistory());

        return patientRepository.save(existingPatient);
    }

    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    public Patient getPatientById(Long id) {
        return patientRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Patient not found with id: " + id));
    }

    public void deletePatient(Long id) {
        patientRepository.deleteById(id);
    }
    public List<Patient> searchPatientsByName(String name) {
        return patientRepository.findByNameContainingIgnoreCase(name);
    }

    public Patient searchPatientById(Long id) {
        return patientRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Patient not found with id: " + id));
    }
}

package com.example.hospitalmanagement.service;

import com.example.hospitalmanagement.entity.Patient;

import java.util.List;

public interface PatientService {
    List<Patient> getAllPatients(String state);
    List<Patient> getAllPatients();
    Patient getPatientById(Long id);
    Patient addPatient(Patient patient);
    Patient updatePatient(Long id, Patient patient);
    void deletePatient(Long id);
}

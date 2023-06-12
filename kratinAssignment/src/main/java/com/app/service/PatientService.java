package com.app.service;

import java.util.List;
import java.util.Optional;

import com.app.pojos.Doctor;
import com.app.pojos.Patient;

public interface PatientService {

	List<Patient> getAll(Doctor attribute);

	Patient addPatient(Patient newPatient);

	Patient getPatientById(Long patientId);

}

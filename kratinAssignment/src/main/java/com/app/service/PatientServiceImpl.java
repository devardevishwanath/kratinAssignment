package com.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.PatientDao;
import com.app.pojos.Doctor;
import com.app.pojos.Patient;

@Service
@Transactional
public class PatientServiceImpl implements PatientService {

	@Autowired
	private PatientDao patDao;

	@Override
	public List<Patient> getAll(Doctor doc) {
		List<Patient> patient = patDao.findByDoctor(doc);
		return patient;
	}

	@Override
	public Patient addPatient(Patient p) {
		return patDao.save(p);
	}

	@Override
	public Patient getPatientById(Long patientId) {
		return patDao.getById(patientId);
	}

	public List<Patient> getAllPatients() {
		return patDao.findAll();
	}
}

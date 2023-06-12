package com.app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.pojos.Doctor;
import com.app.pojos.Patient;

public interface PatientDao extends JpaRepository<Patient, Long> {

	List<Patient> findByDoctor(Doctor doc);

}

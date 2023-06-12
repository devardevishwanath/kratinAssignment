package com.app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.pojos.Patient;
import com.app.pojos.Prescription;

public interface PrescriptionDao extends JpaRepository<Prescription, Long> {

	List<Prescription> findByPatient(Patient p);

}

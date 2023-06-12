package com.app.service;

import java.util.List;

import com.app.pojos.Patient;
import com.app.pojos.Prescription;

public interface PrescriptionService {

	List<Prescription> getAll(Patient patient);

}

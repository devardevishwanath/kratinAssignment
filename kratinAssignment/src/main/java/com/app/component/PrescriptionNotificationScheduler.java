package com.app.component;

import java.util.List;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.app.pojos.Patient;
import com.app.service.PatientServiceImpl;
import com.app.service.PrescriptionServiceImpl;

@Component
public class PrescriptionNotificationScheduler {

	private final PrescriptionServiceImpl prescService;
	private final PatientServiceImpl patientService;

	public PrescriptionNotificationScheduler(PrescriptionServiceImpl prescService, PatientServiceImpl patientService) {
		this.prescService = prescService;
		this.patientService = patientService;
	}

	@Scheduled(cron = "0 0 * * * *") // Run every hour
	public void sendPrescriptionNotifications() {
		List<Patient> patients = patientService.getAllPatients();

		for (Patient patient : patients) {
			prescService.checkAndSendNotification(patient);
		}
	}
}

package com.app.service;

import java.time.LocalTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.PrescriptionDao;
import com.app.pojos.Patient;
import com.app.pojos.Prescription;
import com.messagebird.exceptions.MessageBirdException;

@Service
@Transactional
public class PrescriptionServiceImpl implements PrescriptionService {

	@Autowired
	private PrescriptionDao prescDao;

	private SMSService smsService;

	@Override
	public List<Prescription> getAll(Patient p) {
		List<Prescription> presc = prescDao.findByPatient(p);
		return presc;
	}

	public List<Prescription> getPrescriptionForPatient(Patient patient) {
		List<Prescription> presc = prescDao.findByPatient(patient);

		return presc;
	}

	public void checkAndSendNotification(Patient patient) {
		List<Prescription> prescList = getPrescriptionForPatient(patient);

		// Check if it's time to take the medicine

		LocalTime currentTime = LocalTime.now();

		for (Prescription presc : prescList) {

			LocalTime timeToTakeMedicine = presc.getTimeToTakeDosage();

			if (currentTime.equals(timeToTakeMedicine)) {
				// Send SMS notification to the patient
				String phoneNumber = patient.getPhoneNo();
				String message = "Dear " + patient.getFirstName() + ", it's time to take your medicine: "
						+ presc.getMedicineName();

				try {
					smsService.sendNotification(phoneNumber, message);
					System.out.println("SMS notification sent to: " + phoneNumber);
				} catch (MessageBirdException e) {
					System.out.println("Failed to send SMS notification: " + e.getMessage());
				}
			}
		}

	}
}

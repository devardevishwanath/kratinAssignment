package com.app.controller;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.pojos.Doctor;
import com.app.pojos.Patient;
import com.app.pojos.Prescription;
import com.app.service.PatientService;
import com.app.service.PrescriptionService;

@Controller
@RequestMapping("/prescription")
public class PrescriptionController {

	@Autowired
	private PrescriptionService prescService;

	@Autowired
	private PatientService patService;

	@GetMapping("/show/{patientId}")
	public String showPrescription(@PathVariable Long patientId, HttpSession session, Model map) {
		Patient pat = patService.getPatientById(patientId);
//		map.addAttribute("patient", pat);
		List<Prescription> presc = prescService.getAll(pat);
		pat.setPrescriptions(presc);
		session.setAttribute("patient", pat);
//		map.addAttribute("patient", pat);
		return "/prescription/show";
	}
}

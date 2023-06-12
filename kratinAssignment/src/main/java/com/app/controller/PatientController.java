package com.app.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.app.pojos.Doctor;
import com.app.pojos.Patient;
import com.app.service.PatientService;

@Controller
@RequestMapping("/patient")
public class PatientController {

	@Autowired
	private PatientService patService;

	@GetMapping("/all")
	public String showPatients(HttpSession session, Model map) {
		List<Patient> allPatients = patService.getAll((Doctor) session.getAttribute("doc_info"));
		map.addAttribute("patients", allPatients);
		return "/patient/all";
	}

	@GetMapping("/addPatient")
	public String showAddPatient() {
		return "/patient/addPatient";
	}

	@PostMapping("/addPatient")
	public String addStudent(@RequestParam String fname, @RequestParam String lname, @RequestParam String phone,
			HttpSession session, Model map, RedirectAttributes flashMap) {
		Patient newPatient = new Patient();
		newPatient.setDoctor((Doctor) session.getAttribute("doc_info"));
		newPatient.setFirstName(fname);
		newPatient.setLastName(lname);
		newPatient.setPhoneNo(phone);
		Patient addedPatient = patService.addPatient(newPatient);
		flashMap.addFlashAttribute("mesg", "Patient with name " + addedPatient.getFirstName() + " added");

		return "redirect:/patient/all";
	}

}

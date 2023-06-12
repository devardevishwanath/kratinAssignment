package com.app.controller;

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
import com.app.service.DoctorService;

@Controller
@RequestMapping("/doctor")
public class DoctorController {

	@Autowired
	private DoctorService docService;

	@GetMapping("/signup")
	public String showSignup() {
		return "/doctor/signup";
	}

	@PostMapping("/signup")
	public String addUser(RedirectAttributes flashMap, @RequestParam String name, @RequestParam String uname,
			@RequestParam String pwd) {
		Doctor newDoctor = new Doctor();
		newDoctor.setDocName(name);
		newDoctor.setDocUserName(uname);
		newDoctor.setDocPassword(pwd);

		Doctor addedDoc = docService.addDoctor(newDoctor);
		flashMap.addFlashAttribute("mesg",
				"Thank you for registering, " + addedDoc.getDocName() + ". Please login to continue.");
		return "redirect:/doctor/login";
	}

	@GetMapping("/login")
	public String showLogin() {
		return "/doctor/login";
	}

	@PostMapping("/login")
	public String checkLogin(@RequestParam String uname, @RequestParam String pwd, Model map, HttpSession session,
			RedirectAttributes flashMap) {
		System.out.println(uname + " " + pwd);
		try {
			Doctor validDoc = docService.authenticateDoc(uname, pwd);
			session.setAttribute("doc_info", validDoc);
			flashMap.addFlashAttribute("mesg", "Welcome, Dr. " + validDoc.getDocName());
			return "redirect:/patient/all";
		} catch (RuntimeException e) {
			System.out.println("login invalid: " + e);
			map.addAttribute("mesg", "Invalid Credentials");
			return "/doctor/login";
		}
	}

}

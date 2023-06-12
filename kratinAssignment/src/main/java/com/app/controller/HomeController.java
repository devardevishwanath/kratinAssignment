package com.app.controller;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	public HomeController() {
		System.out.println("in home cntrlr");
	}

	@RequestMapping("/")
	public String showHome(Model map) {
		System.out.println("in show home");
		map.addAttribute("date", new Date());
		return "/home"; // LVN
	}
}

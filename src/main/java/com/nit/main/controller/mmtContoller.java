package com.nit.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.nit.main.req.passenger;
import com.nit.main.res.ticket;
import com.nit.main.service.mmtService;

@Controller
public class mmtContoller {
	@Autowired
	mmtService mmtService;
	
	@GetMapping("/")
	public String frontForm(Model model) {
		passenger pass = new passenger();
		model.addAttribute("Passenger", pass);
		return "index";
	}
	
	@PostMapping("/bookTicket")
	public String frontForm(@ModelAttribute("Passenger") passenger pass,Model model) {
		ticket tkt = mmtService.addPass(pass);
		model.addAttribute("ticket", tkt);
		return "success";
	}
	
	@GetMapping("/search")
	public String search() {
		return "search";
	}
	
	@GetMapping("/searchTicket")
	public String byId(@RequestParam("ticketId") Integer tic,Model model) {
		ticket tkt = mmtService.getTicket(tic);
		model.addAttribute("ticket", tkt);
		return "search";
	}
}

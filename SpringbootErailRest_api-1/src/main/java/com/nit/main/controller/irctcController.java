package com.nit.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.nit.main.req.passenger;
import com.nit.main.response.ticket;
import com.nit.main.services.serImpl;

@RestController
public class irctcController {
	@Autowired
	serImpl smp;
	
	@PostMapping(value = "/ticket",consumes={"application/json"})
	public ticket newPass(@RequestBody passenger pass) {
		ticket t1 = smp.addPass(pass);
		return t1;
	}
	
	@GetMapping(value = "/ticket/{id}", produces = {"application/json"})
	public ticket tickDetails(@PathVariable Integer id) {
	    ticket result = smp.getTicket(id);
	    if (result == null) {
	        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Ticket not found");
	    }
	    return result;
	}
}

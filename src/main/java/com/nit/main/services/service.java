package com.nit.main.services;

import org.springframework.stereotype.Service;

import com.nit.main.req.passenger;
import com.nit.main.response.ticket;

public interface service {
	
	public ticket addPass(passenger pass);
	
	public ticket getTicket(Integer ticketId);
}

package com.nit.main.service;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.nit.main.req.passenger;
import com.nit.main.res.ticket;
@Service
public class mmtService {
	
	private String tkt_url = "http://localhost:8889/ticket";
	private String tkt_url_get = "http://localhost:8889/ticket/{ticketId}";
	public ticket addPass(passenger pass) {
		WebClient web =  WebClient.create();
		ticket tkt = web.post()
						.uri(tkt_url)
						.bodyValue(pass)
						.retrieve()
						.bodyToMono(ticket.class)
						.block();
		
		if(tkt!=null)
			return tkt;
		return null;
	}
	
	public ticket getTicket(Integer ticketId) {
		
		WebClient web = WebClient.create();
		
		ticket tkt = web.get()
						.uri(tkt_url_get,ticketId)
						.retrieve()
						.bodyToMono(ticket.class)
						.block();	
		
		if(tkt!=null)
			return tkt;
		return null;
	}
}

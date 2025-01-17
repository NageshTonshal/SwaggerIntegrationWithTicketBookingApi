package com.nit.main.services;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.nit.main.req.passenger;
import com.nit.main.response.ticket;

@Service
public class serImpl implements service{
	
	Map<Integer, ticket> mapped = new HashMap<>();
	Integer tnum = 1;
	@Override
	public ticket addPass(passenger pass) {
		ticket t = new ticket();
		t.setFrom(pass.getFrom());
		t.setTo(pass.getTo());
		t.setTrainNum(pass.getTrainNum());
		t.setTicketStatus("confirmed");
		t.setTktCost("500");
		t.setTicketId(tnum);
		mapped.put(tnum, t);
		tnum++;
		return t;
	}

	@Override
	public ticket getTicket(Integer ticketId) {
		if(mapped.containsKey(ticketId))
		return mapped.get(ticketId);
		
		return null;
	}

}

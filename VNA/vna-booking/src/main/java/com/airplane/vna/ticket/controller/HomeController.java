package com.airplane.vna.ticket.controller;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject; 
import org.json.simple.parser.*; 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.airplane.vna.schemas.ticket.AllTicketRequest;
import com.airplane.vna.schemas.ticket.AllTicketResponse;
import com.airplane.vna.schemas.ticket.CustomList;
import com.airplane.vna.schemas.ticket.OneWayTicketRequest;
import com.airplane.vna.schemas.ticket.OneWayTicketResponse;
import com.airplane.vna.schemas.ticket.Ticket;
import com.airplane.vna.schemas.ticket.TwoWayTicketRequest;
import com.airplane.vna.schemas.ticket.TwoWayTicketResponse;
import com.airplane.vna.ticket.SOAPConnector;
import com.airplane.vna.ticket.entity.Booking;
import com.airplane.vna.ticket.entity.Filter;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@RestController
@RequestMapping("/")
public class HomeController {
	
	
	@Autowired
	private SOAPConnector soapConnector;
	
	@Autowired
	private Environment env;
	
	@RequestMapping("/")
	public String home() {
		// This is useful for debugging
		// When having multiple instance of gallery service running at different ports.
		// We load balance among them, and display which instance received the request.
		return "Hello from Gallery Service running at port: " + env.getProperty("local.server.port");
	}
  
	@RequestMapping("/tickets")
	public Booking getGallery() {
		// create gallery object
		Booking gallery = new Booking();

		AllTicketRequest request = new AllTicketRequest();
		AllTicketResponse response = (AllTicketResponse) soapConnector.callWebService("http://localhost:8080/vna/tickets.wsdl", request);
		CustomList custom = response.getListTicket();
		List<Ticket> ticket = custom.getTicket();
	
		gallery.setTickets(ticket);
		
		return gallery;
	}
	@RequestMapping("/{ngaydi}/{ngayve}/{noidi}/{noiden}/{nguoilon}/{treem}/{embe}")
	public Filter getGallery(@PathVariable String ngaydi, @PathVariable String ngayve, @PathVariable String noidi, @PathVariable String noiden, @PathVariable String nguoilon,
			@PathVariable String treem, @PathVariable String embe) {
		Filter gallery = new Filter();
		TwoWayTicketRequest request = new TwoWayTicketRequest();
		request.setDateGo(ngaydi);
		request.setDateReturn(ngayve);
		request.setFrom(noidi);
		request.setTo(noiden);
		request.setAdult(nguoilon);
		request.setToddler(treem);
		request.setBaby(embe);
		TwoWayTicketResponse response = (TwoWayTicketResponse) soapConnector.callWebService("http://localhost:8080/vna/tickets.wsdl", request);
		CustomList listvedi = response.getVeDi();
		CustomList listveve = response.getVeVe();
		List<Ticket> vedi = listvedi.getTicket();
		List<Ticket> veve = listveve.getTicket();
		JSONObject obj = new JSONObject();
		obj.put("veDi", vedi);
		obj.put("veVe", veve);
		JSONArray kk = new JSONArray();
		kk.add(obj);
		List<Object> ve = (List<Object>) kk;
		gallery.setTickets(ve);
		return gallery;
		
	}
	@RequestMapping("/{ngaydi}/{noidi}/{noiden}/{nguoilon}/{treem}/{embe}")
	public Booking getGallery(@PathVariable String ngaydi, @PathVariable String noidi, @PathVariable String noiden, @PathVariable String nguoilon,
			@PathVariable String treem, @PathVariable String embe) {
		Booking gallery = new Booking();

		OneWayTicketRequest request = new OneWayTicketRequest();
		request.setDate(ngaydi);
		request.setFrom(noidi);
		request.setTo(noiden);
		request.setAdult(nguoilon);
		request.setToddler(treem);
		request.setBaby(embe);
		OneWayTicketResponse response = (OneWayTicketResponse) soapConnector.callWebService("http://localhost:8080/vna/tickets.wsdl", request);
		CustomList custom = response.getListTicket();
		List<Ticket> ticket = custom.getTicket();
		gallery.setTickets(ticket);
		
		return gallery;
		
	}
}
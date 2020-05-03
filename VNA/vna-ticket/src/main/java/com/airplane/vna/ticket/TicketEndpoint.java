package com.airplane.vna.ticket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.airplane.vna.ticket.entity.AllTicketRequest;
import com.airplane.vna.ticket.entity.AllTicketResponse;
import com.airplane.vna.ticket.entity.OneWayTicketRequest;
import com.airplane.vna.ticket.entity.OneWayTicketResponse;
import com.airplane.vna.ticket.entity.TicketDetailsRequest;
import com.airplane.vna.ticket.entity.TicketDetailsResponse;
import com.airplane.vna.ticket.entity.TwoWayTicketRequest;
import com.airplane.vna.ticket.entity.TwoWayTicketResponse;
@Endpoint
public class TicketEndpoint {
	private static final String NAMESPACE_URI = "entity.ticket.vna.airplane.com";

	private TicketRepository TicketRepository;

	@Autowired
	public TicketEndpoint(TicketRepository TicketRepository) {
		this.TicketRepository = TicketRepository;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "TicketDetailsRequest")
	@ResponsePayload
	public TicketDetailsResponse getTicket(@RequestPayload TicketDetailsRequest request) {
		TicketDetailsResponse response = new TicketDetailsResponse();
		response.setTicket(TicketRepository.findTicket(request.getId()));

		return response;
	}
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "AllTicketRequest")
	@ResponsePayload
	public AllTicketResponse getTicket(@RequestPayload AllTicketRequest request) {
		AllTicketResponse response = new AllTicketResponse();
		response.setListTicket(TicketRepository.allTicket());

		return response;
	}
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "OneWayTicketRequest")
	@ResponsePayload
	public OneWayTicketResponse getTicket(@RequestPayload OneWayTicketRequest request) {
		OneWayTicketResponse response = new OneWayTicketResponse();
		response.setListTicket(TicketRepository.filterOneWay(request.getDate(),request.getFrom(),request.getTo(),request.getAdult(),request.getToddler(),request.getBaby()));

		return response;
	}
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "TwoWayTicketRequest")
	@ResponsePayload
	public TwoWayTicketResponse getTicket(@RequestPayload TwoWayTicketRequest request) {
		TwoWayTicketResponse response = new TwoWayTicketResponse();
		response.setVeDi(TicketRepository.filterTwoWay_go(request.getDateGo(),request.getFrom(),request.getTo(),request.getAdult(),request.getToddler(),request.getBaby()));
		response.setVeVe(TicketRepository.filterTwoWay_return(request.getDateReturn(),request.getFrom(),request.getTo(),request.getAdult(),request.getToddler(),request.getBaby()));
		return response;
	}
}
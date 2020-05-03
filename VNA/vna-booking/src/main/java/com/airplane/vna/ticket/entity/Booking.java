package com.airplane.vna.ticket.entity;

import java.util.List;

import com.airplane.vna.schemas.ticket.Ticket;

public class Booking {
    private List<Ticket> tickets;
 
    public Booking( List<Ticket> tickets) {
        this.tickets = tickets;
    }

  
    public Booking() {
    	
    }
    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }
 
}

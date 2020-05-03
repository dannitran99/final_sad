package com.airplane.vna.ticket.entity;

import java.util.List;

public class Filter {
    private List<Object> tickets;
 
    public Filter( List<Object> tickets) {
        this.tickets = tickets;
    }

  
    public Filter() {
    	
    }
    public List<Object> getTickets() {
        return tickets;
    }

    public void setTickets(List<Object> tickets) {
        this.tickets = tickets;
    }
 
}

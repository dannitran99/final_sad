package com.airplanebooking.ticket.booking.controller;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject; 
import org.json.simple.parser.*; 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.airplanebooking.ticket.booking.entity.Booking;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@RestController
@RequestMapping("/")
public class HomeController {
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private Environment env;
	
	@RequestMapping("/")
	public String home() {
		// This is useful for debugging
		// When having multiple instance of gallery service running at different ports.
		// We load balance among them, and display which instance received the request.
		return "Hello from Gallery Service running at port: " + env.getProperty("local.server.port");
	}
	
	
	@RequestMapping("/tickets/{plane}")
	@HystrixCommand(fallbackMethod = "all_fallback", 
	   commandProperties = {
			   @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1000"),
			   @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "3")
			   })
	public Booking getTicket(@PathVariable String plane) throws ParseException, InterruptedException {
		// create gallery object
		Booking ticket = new Booking();
		JSONArray kk = new JSONArray();
		String[] hang = plane.split(",");
		String result;
		JSONArray arr;
		Object obj;
		JSONObject ob,newOb ;
		for (int i = 0; i < hang.length; i++) {
			switch(hang[i]) {
			case "vna":
				result = restTemplate.getForObject("http://app-gateway/vna", String.class);
				obj = new JSONParser().parse(result);
				ob = (JSONObject) obj;
				arr= (JSONArray) ob.get("tickets");
				newOb = new JSONObject();
				newOb.put("vna", arr);
				kk.add(newOb);
				break;
			case "vja":	
				result = restTemplate.getForObject("http://app-gateway/vja", String.class);
				obj = new JSONParser().parse(result);
				ob = (JSONObject) obj;
				arr= (JSONArray) ob.get("tickets");
				newOb = new JSONObject();
				newOb.put("vja", arr);
				kk.add(newOb);
				break;
			default: break;
			}
		}
	//
		ticket.setTickets((List<Object>) kk);
		return ticket;
	}
	
	
		
	@HystrixCommand(fallbackMethod = "fallback", 
			   commandProperties = {
					   @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1000"),
					   @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "3")
					   })  
	@RequestMapping("/{plane}/{ngaydi}/{ngayve}/{noidi}/{noiden}/{nguoilon}/{treem}/{embe}")
	public Booking getTicket(@PathVariable String plane, @PathVariable String ngaydi, @PathVariable String ngayve, @PathVariable String noidi, @PathVariable String noiden, @PathVariable String nguoilon,
			@PathVariable String treem, @PathVariable String embe ) throws ParseException {
		
		Booking gallery = new Booking();
		JSONArray kk = new JSONArray();
		String[] hang = plane.split(",");
		String result;
		JSONArray arr;
		Object obj;
		JSONObject ob,newOb ;
		for (int i = 0; i < hang.length; i++) {
			switch(hang[i]) {
			case "vna":
				result = restTemplate.getForObject("http://app-gateway/vna/vekhuhoi/"+ngaydi+"/"+ngayve+"/"+noidi+"/"+noiden+"/"+nguoilon+"/"+treem+"/"+embe, String.class);
				obj = new JSONParser().parse(result);
				ob = (JSONObject) obj;
				arr= (JSONArray) ob.get("tickets");
				newOb = new JSONObject();
				newOb.put("vna", arr);
				kk.add(newOb);
				break;
			case "vja":	
				result = restTemplate.getForObject("http://app-gateway/vja/vekhuhoi/"+ngaydi+"/"+ngayve+"/"+noidi+"/"+noiden+"/"+nguoilon+"/"+treem+"/"+embe, String.class);
				obj = new JSONParser().parse(result);
				ob = (JSONObject) obj;
				arr= (JSONArray) ob.get("tickets");
				newOb = new JSONObject();
				newOb.put("vja", arr);
				kk.add(newOb);
				break;
			default: break;
			}
		}
		gallery.setTickets((List<Object>) kk);
		return gallery;
		
	}
	
	@HystrixCommand(fallbackMethod = "fallback", 
			   commandProperties = {
					   @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1000"),
					   @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "3")
					   })  
	@RequestMapping("/{plane}/{ngaydi}/{noidi}/{noiden}/{nguoilon}/{treem}/{embe}")
	public Booking getTicket(@PathVariable String plane, @PathVariable String ngaydi, @PathVariable String noidi, @PathVariable String noiden, @PathVariable String nguoilon,
			@PathVariable String treem, @PathVariable String embe ) throws ParseException {
		
		Booking gallery = new Booking();
		JSONArray kk = new JSONArray();
		String[] hang = plane.split(",");
		String result;
		JSONArray arr;
		Object obj;
		JSONObject ob,newOb ;
		for (int i = 0; i < hang.length; i++) {
			switch(hang[i]) {
			case "vna":
				result = restTemplate.getForObject("http://app-gateway/vna/vemotchieu/"+ngaydi+"/"+noidi+"/"+noiden+"/"+nguoilon+"/"+treem+"/"+embe, String.class);
				obj = new JSONParser().parse(result);
				ob = (JSONObject) obj;
				arr= (JSONArray) ob.get("tickets");
				newOb = new JSONObject();
				newOb.put("vna", arr);
				kk.add(newOb);
				break;
			case "vja":	
				result = restTemplate.getForObject("http://app-gateway/vja/vemotchieu/"+ngaydi+"/"+noidi+"/"+noiden+"/"+nguoilon+"/"+treem+"/"+embe, String.class);
				obj = new JSONParser().parse(result);
				ob = (JSONObject) obj;
				arr= (JSONArray) ob.get("tickets");
				newOb = new JSONObject();
				newOb.put("vja", arr);
				kk.add(newOb);
				break;
			default: break;
			}
		}
		gallery.setTickets((List<Object>) kk);
		return gallery;
		
	}
	 
	
	@HystrixCommand(fallbackMethod = "fallback", 
			   commandProperties = {
					   @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1000"),
					   @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "3")
					   })  
	@RequestMapping("/vna")
	public Booking getVNATicket() throws ParseException{
		Booking ticket = new Booking();
		String result = restTemplate.getForObject("http://vna-gateway/vna/tickets", String.class);
		Object obj = new JSONParser().parse(result);
		JSONObject ob = (JSONObject) obj;
		JSONArray arr = (JSONArray) ob.get("tickets");
		ticket.setTickets((List<Object>) arr);
		return ticket;
	}
	
	@HystrixCommand(fallbackMethod = "fallback", 
			   commandProperties = {
					   @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1000"),
					   @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "3")
					   })  
	@RequestMapping("/vja")
	public Booking getVJATicket() throws ParseException{
		Booking ticket = new Booking();
		String result = restTemplate.getForObject("http://vja-gateway/vja/tickets", String.class);
		Object obj = new JSONParser().parse(result);
		JSONObject ob = (JSONObject) obj;
		JSONArray arr = (JSONArray) ob.get("tickets");
		ticket.setTickets((List<Object>) arr);
		return ticket;
	}
	
	@HystrixCommand(fallbackMethod = "fallback", 
			   commandProperties = {
					   @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1000"),
					   @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "3")
					   })  
	@RequestMapping("/vna/vekhuhoi/{ngaydi}/{ngayve}/{noidi}/{noiden}/{nguoilon}/{treem}/{embe}")
	public Booking getVNATicketKH(@PathVariable String ngaydi, @PathVariable String ngayve, @PathVariable String noidi, @PathVariable String noiden, @PathVariable String nguoilon,
			@PathVariable String treem, @PathVariable String embe) throws ParseException{
		Booking ticket = new Booking();
		String result = restTemplate.getForObject("http://vna-gateway/vna/"+ngaydi+"/"+ngayve+"/"+noidi+"/"+noiden+"/"+nguoilon+"/"+treem+"/"+embe, String.class);
		Object obj = new JSONParser().parse(result);
		JSONObject ob = (JSONObject) obj;
		JSONArray arr = (JSONArray) ob.get("tickets");
		ticket.setTickets((List<Object>) arr);
		return ticket;
	}
	
	@HystrixCommand(fallbackMethod = "fallback", 
			   commandProperties = {
					   @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1000"),
					   @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "3")
					   })  
	@RequestMapping("/vja/vekhuhoi/{ngaydi}/{ngayve}/{noidi}/{noiden}/{nguoilon}/{treem}/{embe}")
	public Booking getVJATicketKH( @PathVariable String ngaydi, @PathVariable String ngayve, @PathVariable String noidi, @PathVariable String noiden, @PathVariable String nguoilon,
			@PathVariable String treem, @PathVariable String embe) throws ParseException{
		Booking ticket = new Booking();
		String result = restTemplate.getForObject("http://vja-gateway/vja/"+ngaydi+"/"+ngayve+"/"+noidi+"/"+noiden+"/"+nguoilon+"/"+treem+"/"+embe, String.class);
		Object obj = new JSONParser().parse(result);
		JSONObject ob = (JSONObject) obj;
		JSONArray arr = (JSONArray) ob.get("tickets");
		ticket.setTickets((List<Object>) arr);
		return ticket;
	}
	
	@HystrixCommand(fallbackMethod = "fallback", 
			   commandProperties = {
					   @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1000"),
					   @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "3")
					   })  
	@RequestMapping("/vna/vemotchieu/{ngaydi}/{noidi}/{noiden}/{nguoilon}/{treem}/{embe}")
	public Booking getVNATicketMC(@PathVariable String ngaydi,  @PathVariable String noidi, @PathVariable String noiden, @PathVariable String nguoilon,
			@PathVariable String treem, @PathVariable String embe) throws ParseException{
		Booking ticket = new Booking();
		String result = restTemplate.getForObject("http://vna-gateway/vna/"+ngaydi+"/"+noidi+"/"+noiden+"/"+nguoilon+"/"+treem+"/"+embe, String.class);
		Object obj = new JSONParser().parse(result);
		JSONObject ob = (JSONObject) obj;
		JSONArray arr = (JSONArray) ob.get("tickets");
		ticket.setTickets((List<Object>) arr);
		return ticket;
	}
	
	@HystrixCommand(fallbackMethod = "fallback", 
			   commandProperties = {
					   @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1000"),
					   @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "3")
					   })  
	@RequestMapping("/vja/vemotchieu/{ngaydi}/{noidi}/{noiden}/{nguoilon}/{treem}/{embe}")
	public Booking getVJATicketMC( @PathVariable String ngaydi, @PathVariable String noidi, @PathVariable String noiden, @PathVariable String nguoilon,
			@PathVariable String treem, @PathVariable String embe) throws ParseException{
		Booking ticket = new Booking();
		String result = restTemplate.getForObject("http://vja-gateway/vja/"+ngaydi+"/"+noidi+"/"+noiden+"/"+nguoilon+"/"+treem+"/"+embe, String.class);
		Object obj = new JSONParser().parse(result);
		JSONObject ob = (JSONObject) obj;
		JSONArray arr = (JSONArray) ob.get("tickets");
		ticket.setTickets((List<Object>) arr);
		return ticket;
	}
	
	
	 public Booking fallback( String ngaydi,  String ngayve,  String noidi,  String noiden,  String nguoilon,
				 String treem,  String embe,Throwable hystrixCommand) {  
	      return new Booking() ;  
	  }  
	 public Booking fallback( String ngaydi,  String noidi,  String noiden,  String nguoilon,
			 String treem,  String embe,Throwable hystrixCommand) {  
      return new Booking() ;  
  }  
	 public Booking fallback(Throwable hystrixCommand) {  
      return new Booking() ;  
   }  
	 public Booking fallback( String plane,String ngaydi,  String ngayve,  String noidi,  String noiden,  String nguoilon,
				 String treem,  String embe,Throwable hystrixCommand) {  
	      return new Booking() ;  
	  }  
	 public Booking all_fallback(String plane) {  
		  return new Booking() ;  
	}  
	

}
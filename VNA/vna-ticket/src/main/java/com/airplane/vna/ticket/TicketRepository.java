package com.airplane.vna.ticket;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import com.airplane.vna.ticket.MySQLConnUtils;
import com.airplane.vna.ticket.entity.CustomList;
import com.airplane.vna.ticket.entity.Ticket;

@Component
public class TicketRepository {
	private static final Map<String, Ticket> tickets = new HashMap<>();
	ArrayList<Ticket> arrayList = new ArrayList<>();

	@PostConstruct
	public void initData() throws ClassNotFoundException, SQLException {
	   	 Connection conn = TicketRepository.getMyConnection();
		 Statement statement = conn.createStatement();
	     String sql = "Select * from `vna-ticket`.`ticket`";
	     
	     ResultSet rs = statement.executeQuery(sql);
	     
	     while (rs.next()) {// Di chuyển con trỏ xuống bản ghi kế tiếp.
	         Ticket all_ticket = new Ticket();
	         all_ticket.setId(rs.getInt(1)); 
	         all_ticket.setPrice(rs.getInt(2));
	         all_ticket.setFlightFrom(rs.getString(3));
	         all_ticket.setFlightTo(rs.getString(4));
	         all_ticket.setType(rs.getString(5));
	         all_ticket.setDate(Integer.parseInt(rs.getString(6)));
	         all_ticket.setAvailable(rs.getInt(7));
	         all_ticket.setClassType(rs.getString(8));
	         tickets.put(all_ticket.getId()+"", all_ticket);
	         arrayList.add(all_ticket);
	     }
	     // Đóng kết nối
	     conn.close();
	
	}
	
	public Ticket findTicket(String id) {
		Assert.notNull(id, "The ticket id must not be null");
		return tickets.get(id);
	}
	
	public CustomList allTicket() {
		CustomList custom = new CustomList();
		custom.setTicket(arrayList);
		return custom;
	}
	
	
	
	//connect MySQL
	public static Connection getMyConnection() throws SQLException,
	    ClassNotFoundException {
	return MySQLConnUtils.getMySQLConnection();
	}

	public CustomList filterOneWay(String date, String from, String to, String adult, String toddler, String baby) {
		CustomList custom = new CustomList();
		List<Ticket> filter = new ArrayList<>();
		for (int i = 0; i < arrayList.size(); i++) {
			int tong = Integer.parseInt(adult) + Integer.parseInt(toddler) ;
			String ngaydi = arrayList.get(i).getDate() +"";
			String noidi = arrayList.get(i).getFlightFrom() +"";
			String noiden = arrayList.get(i).getFlightTo() +"";
			if (ngaydi.equals(date) && noidi.equals(from) && noiden.equals(to) && arrayList.get(i).getAvailable() > tong) {
				filter.add(arrayList.get(i));
			}
		}
		custom.setTicket(filter);
		return custom;
	}


	public CustomList filterTwoWay_go(String dateGo, String from, String to, String adult, String toddler, String baby) {
		CustomList custom = new CustomList();
		List<Ticket> filter = new ArrayList<>();
		for (int i = 0; i < arrayList.size(); i++) {
			int tong = Integer.parseInt(adult) + Integer.parseInt(toddler);
			String ngaydi = arrayList.get(i).getDate() +"";
			String noidi = arrayList.get(i).getFlightFrom() +"";
			String noiden = arrayList.get(i).getFlightTo() +"";
			if (ngaydi.equals(dateGo) && noidi.equals(from) && noiden.equals(to) && arrayList.get(i).getAvailable() > tong) {
				filter.add(arrayList.get(i));
			}
		}
		custom.setTicket(filter);
		return custom;
	}

	public CustomList filterTwoWay_return(String dateReturn, String from, String to, String adult, String toddler,
			String baby) {
		CustomList custom = new CustomList();
		List<Ticket> filter = new ArrayList<>();
		for (int i = 0; i < arrayList.size(); i++) {
			int tong = Integer.parseInt(adult) + Integer.parseInt(toddler);
			String ngaydi = arrayList.get(i).getDate() +"";
			String noidi = arrayList.get(i).getFlightFrom() +"";
			String noiden = arrayList.get(i).getFlightTo() +"";
			if (ngaydi.equals(dateReturn) && noidi.equals(to) && noiden.equals(from) && arrayList.get(i).getAvailable() > tong) {
				filter.add(arrayList.get(i));
			}
		}
		custom.setTicket(filter);
		return custom;
	}

	
}
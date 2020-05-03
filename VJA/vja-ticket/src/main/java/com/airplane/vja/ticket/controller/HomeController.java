package com.airplane.vja.ticket.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.airplane.vja.ticket.entity.Ticket;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/")
public class HomeController {
	@Autowired
	private Environment env;

	@RequestMapping("/")
	public String home() {
		// This is useful for debugging
		// When having multiple instance of image service running at different ports.
		// We load balance among them, and display which instance received the request.
		return "Hello from Image Service running at port: " + env.getProperty("local.server.port");
	}
		
	@RequestMapping("/ticket")
	public List<Ticket> getTicket() throws ClassNotFoundException, SQLException {
		List<Ticket> ticket = getData();
		return ticket;
	}
	
	
	
	private List<Ticket> getData() throws ClassNotFoundException, SQLException {
		 Connection conn = HomeController.getMyConnection();
		 Statement statement = conn.createStatement();
	     String sql = "Select * from `vja-ticket`.`ticket`";
	     
	     ResultSet rs = statement.executeQuery(sql);
	     
	     List<Ticket> ticket = new ArrayList<>();
	     while (rs.next()) {// Di chuyển con trỏ xuống bản ghi kế tiếp.
	         int empId = rs.getInt(1);
	         int price = rs.getInt(2);
	         String di = rs.getString(3);
	         String den = rs.getString(4);
	         String kieuve = rs.getString(5);
	         int ngay = Integer.parseInt(rs.getString(6));
	         int conlai = rs.getInt(7);
	         String hang = rs.getString(8);
	         ticket.add(new Ticket(empId,price,di,den,kieuve,ngay,conlai,hang));

	     }
	     // Đóng kết nối
	     conn.close();
		return ticket;
		
	}
	public static Connection getMyConnection() throws SQLException,
	    ClassNotFoundException {
	return MySQLConnUtils.getMySQLConnection();
	}
}
package com.example.TicketOnline.controller;

import java.util.List;

import com.example.TicketOnline.DTO.TickeDTO;
import com.example.TicketOnline.service.serviceImp.ServiceTicket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.TicketOnline.Entities.Ticket;
import com.example.TicketOnline.service.IService;

@RestController
public class TicketController {

	@Autowired
	IService<Ticket> ticketService;

	@Autowired
	ServiceTicket serviceTicket;

	@GetMapping("/ticket")
	public List<Ticket> findAll() {

		return ticketService.getAll();
	}
	

	@PostMapping("/ticket")
	public TickeDTO addElement(@RequestBody Ticket ticket) {
		try {

			return serviceTicket.addTicketDTO(ticket);

		} catch (Exception e) {
			System.out.println(e.getMessage());

		}
		return null;
	}

	@DeleteMapping("/ticket/{id}")
	public void deleteElement(@PathVariable int id) {

		ticketService.remove(id);
	}
	
	
	@PutMapping("/ticket")
	public void updateElement(@RequestBody Ticket   ticket) {
		try {
			ticketService.update(ticket);

		} catch (Exception e) {
			System.out.println(e.getMessage());

		}
	}
	
}

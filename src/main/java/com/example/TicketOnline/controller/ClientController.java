package com.example.TicketOnline.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.TicketOnline.Entities.Booking;
import com.example.TicketOnline.Entities.Client;
import com.example.TicketOnline.service.IService;

@RestController
public class ClientController {

	@Autowired
	IService<Client> clientService;

	@GetMapping("/client")
	public List<Client> findAll() {
		return clientService.getAll();
	}
	

	@PostMapping("/client")
	public void addElement(@RequestBody Client client) {
		try {
			clientService.add(client);

		} catch (Exception e) {
			System.out.println(e.getMessage());

		}

	}

	@DeleteMapping("/client/{id}")
	public void deleteElement(@PathVariable int id) {

		clientService.remove(id);
	}
	
	
	@PutMapping("/client")
	public void updateElement(@RequestBody Client client) {
		try {
			clientService.update(client);

		} catch (Exception e) {
			System.out.println(e.getMessage());

		}
	}
	
}

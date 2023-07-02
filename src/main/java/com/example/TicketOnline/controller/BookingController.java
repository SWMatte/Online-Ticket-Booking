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
import com.example.TicketOnline.service.IService;

@RestController
public class BookingController {

	@Autowired
	IService<Booking> bookingService;

	@GetMapping("/booking")
	public List<Booking> findAll() {

		return bookingService.getAll();
	}
	

	@PostMapping("/booking")
	public void addElement(@RequestBody Booking booking) {

		bookingService.add(booking);
	}

	@DeleteMapping("/booking/{id}")
	public void deleteElement(@PathVariable int id) {

		bookingService.remove(id);
	}
	
	
	@PutMapping("/booking")
	public void updateElement(@RequestBody Booking booking) {

		bookingService.update(booking);
	}
	
}

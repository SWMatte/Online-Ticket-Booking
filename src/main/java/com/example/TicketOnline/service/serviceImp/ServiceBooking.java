package com.example.TicketOnline.service.serviceImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.TicketOnline.Entities.Booking;
import com.example.TicketOnline.repositories.BookingRepository;
import com.example.TicketOnline.service.IService;

@Service
public class ServiceBooking implements IService<Booking> {

	@Autowired
	BookingRepository bookingRepository;
	
	@Override
	public void add(Booking element) {
		 
		bookingRepository.save(element);
	}

	@Override
	public void remove(int id) {
 
		bookingRepository.deleteById(id);
	}

	@Override
	public void update(Booking element) {
		 

	}

	@Override
	public List<Booking> getAll() {
		// TODO Auto-generated method stub
		return bookingRepository.findAll();
	}

}

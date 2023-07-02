package com.example.TicketOnline.service.serviceImp;

 import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.TicketOnline.Entities.Cinema;
 import com.example.TicketOnline.repositories.CinemaRepository;
import com.example.TicketOnline.service.IService;


@Service
public class ServiceCinema implements IService<Cinema> {

	@Autowired
	CinemaRepository cinemaRepository;
	
	
	@Override
	public void add(Cinema element) {
		cinemaRepository.save(element);		
	}

	@Override
	public void remove(int id) {
		cinemaRepository.deleteById(id);		
	}

	@Override
	public void update(Cinema element) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Cinema> getAll() {
		// TODO Auto-generated method stub
		return cinemaRepository.findAll();
	}

}

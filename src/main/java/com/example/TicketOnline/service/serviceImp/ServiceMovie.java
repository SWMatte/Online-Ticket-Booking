package com.example.TicketOnline.service.serviceImp;

 import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.TicketOnline.Entities.Movie;
import com.example.TicketOnline.repositories.ClientRepository;
import com.example.TicketOnline.repositories.MovieRepository;
import com.example.TicketOnline.service.IService;


@Service
public class ServiceMovie  implements IService<Movie>{
	@Autowired
	MovieRepository movieRepository;
	
	
	@Override
	public void add(Movie element) {
		movieRepository.save(element);		
	}

	@Override
	public void remove(int id) {
		movieRepository.deleteById(id);		
	}

	@Override
	public void update(Movie element) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Movie> getAll() {
		// TODO Auto-generated method stub
		return movieRepository.findAll();
	}

}

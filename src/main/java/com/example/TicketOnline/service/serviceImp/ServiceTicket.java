package com.example.TicketOnline.service.serviceImp;

 import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.TicketOnline.Entities.Ticket;
 import com.example.TicketOnline.repositories.TicketRepository;
import com.example.TicketOnline.service.IService;


@Service
public class ServiceTicket  implements IService<Ticket>{

	@Autowired
	TicketRepository ticketRepository;
	
	@Override
	public void add(Ticket element) {
		ticketRepository.save(element);
	}

	@Override
	public void remove(int id) {
		ticketRepository.deleteById(id);		
	}

	@Override
	public void update(Ticket element) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Ticket> getAll() {
		// TODO Auto-generated method stub
		return ticketRepository.findAll();
	}

}

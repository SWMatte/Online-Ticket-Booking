package com.example.TicketOnline.service.serviceImp;

 import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.TicketOnline.Entities.Client;
 import com.example.TicketOnline.repositories.ClientRepository;
import com.example.TicketOnline.service.IService;


@Service
public class ServiceClient implements IService<Client> {

	@Autowired
	ClientRepository clientRepository;
	
	@Override
	public void add(Client element) {
		clientRepository.save(element);	
	}

	@Override
	public void remove(int id) {
		clientRepository.deleteById(id);		
	}

	@Override
	public void update(Client element) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Client> getAll() {
 		return clientRepository.findAll();
	}

}

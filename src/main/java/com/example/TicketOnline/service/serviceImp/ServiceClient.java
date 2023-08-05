package com.example.TicketOnline.service.serviceImp;

 import java.util.List;

 import com.example.TicketOnline.Entities.Ticket;
 import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.TicketOnline.Entities.Client;
 import com.example.TicketOnline.repositories.ClientRepository;
import com.example.TicketOnline.service.IService;


@Service
public class ServiceClient implements IService<Client>  {

	@Autowired
	ClientRepository clientRepository;
	
	@Override
	public void add(Client element) {
		if(clientRepository.findByNameAndLastName(element.getName(), element.getLastName())==null) {
			clientRepository.save(element);
		}
		else {
			throw new IllegalArgumentException();
		}
	}

	@Override
	public void remove(int id) {
		clientRepository.deleteById(id);		
	}

	@Override
	public void update(Client element) throws Exception {
		clientRepository.updateClient(element.getName(), element.getLastName(), element.getIdClient(),element.getAge(),element.getEmail(),element.isCommecialMessage());
		
	}

	@Override
	public List<Client> getAll() {
 		return clientRepository.findAll();
	}



	public Client findById(String name,String lastName) {
		return clientRepository.findByNameAndLastName(name,lastName);

	}



}

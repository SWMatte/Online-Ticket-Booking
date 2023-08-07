package com.example.TicketOnline.service.serviceImp;

 import java.util.HashSet;
 import java.util.List;
 import java.util.Set;

 import com.example.TicketOnline.Entities.Role;
 import com.example.TicketOnline.Entities.Ticket;
 import com.example.TicketOnline.repositories.RoleRepository;
 import jakarta.transaction.Transactional;
 import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.security.crypto.password.PasswordEncoder;
 import org.springframework.stereotype.Service;

import com.example.TicketOnline.Entities.Client;
 import com.example.TicketOnline.repositories.ClientRepository;
import com.example.TicketOnline.service.IService;

@Transactional
@Service
public class ServiceClient implements IService<Client>  {

	@Autowired
	ClientRepository clientRepository;
	@Autowired
	RoleRepository roleRepository;

	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Override
	public void add(Client element) {
		String encodedPassword = passwordEncoder.encode(element.getPassword());
		Role clientRole = roleRepository.findByAuthority("ADMIN");
		Set<Role> authorities = new HashSet<>();
		authorities.add(clientRole);

		if(clientRepository.findByNameAndLastName(element.getName(), element.getLastName())==null) {
			element.setAuthorities(authorities);
			element.setPassword(encodedPassword);
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

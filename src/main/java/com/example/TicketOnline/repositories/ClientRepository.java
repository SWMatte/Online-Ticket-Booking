package com.example.TicketOnline.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.TicketOnline.Entities.Booking;
import com.example.TicketOnline.Entities.Client;

public interface ClientRepository extends JpaRepository<Client,Integer> {

}

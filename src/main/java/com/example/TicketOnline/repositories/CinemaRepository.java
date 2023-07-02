package com.example.TicketOnline.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.TicketOnline.Entities.Booking;
import com.example.TicketOnline.Entities.Cinema;

public interface CinemaRepository extends JpaRepository<Cinema,Integer> {

 
}

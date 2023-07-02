package com.example.TicketOnline.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.TicketOnline.Entities.Booking;
import com.example.TicketOnline.Entities.Movie;

public interface MovieRepository extends JpaRepository<Movie,Integer> {

}

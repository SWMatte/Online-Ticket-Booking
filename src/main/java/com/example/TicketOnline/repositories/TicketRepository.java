package com.example.TicketOnline.repositories;

import com.example.TicketOnline.Entities.Client;
import com.example.TicketOnline.Entities.Movie;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.TicketOnline.Entities.Ticket;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;

public interface TicketRepository extends JpaRepository<Ticket,Integer> {


    @Modifying
    @Transactional
    @Query("UPDATE Ticket u SET u.price = ?1, u.timeMovie = ?2, u.stateTicket = ?3, u.movies = ?4, u.clients = ?5 WHERE u.idTicket = ?6")
    public void updateTicket(double price, LocalDate timeMovie, String stateTicket, Movie movies, Client clients, int idTicket);



}




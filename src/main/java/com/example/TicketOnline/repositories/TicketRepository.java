package com.example.TicketOnline.repositories;

import com.example.TicketOnline.Entities.Client;
import com.example.TicketOnline.Entities.Movie;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.TicketOnline.Entities.Ticket;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface TicketRepository extends JpaRepository<Ticket, Integer> {


    @Modifying
    @Transactional
    @Query("UPDATE Ticket u SET u.price = ?1, u.timeMovie = ?2, u.stateTicket = ?3, u.movies = ?4, u.clients = ?5 WHERE u.idTicket = ?6")
    public void updateTicket(double price, LocalDate timeMovie, String stateTicket, Movie movies, Client clients, int idTicket);


    @Modifying
    @Transactional
    @Query("UPDATE Ticket u SET u.qtaTicket = ?1,u.stateTicket=?2  WHERE idTicket=?3 ")
    public void ticketAfterDelete(int nuovaQtaTicket, String stateTicket, int idTicket);


    @Query("SELECT idTicket FROM Ticket u WHERE u.clients.idClient = ?1 and u.movies.idMovie=?2")
    public Integer idTicket(int idClient, int idMovie);




}




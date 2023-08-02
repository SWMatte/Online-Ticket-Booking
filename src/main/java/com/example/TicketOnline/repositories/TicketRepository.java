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
    @Query("UPDATE Ticket u SET u.qtaTicket = ?1 WHERE clients.idClient=?2 AND u.timeMovie=?3 ")
    public void updateQtaTicket(int nuovaQtaTicket, int idClient, LocalDate timeMovie);

    @Query(value = """
            select qta_ticket
                    from ticket
                      inner join client using(id_client)
                            where id_client=:idClient and time_movie =:date
            """, nativeQuery = true)
    public int qtaTicket(int idClient, LocalDate date);


    @Query(value = """
            select *
                    from ticket
                    inner join client using(id_client)
                      inner join cinema using(id_cinema)
                       inner join movie using(id_movie)
                            where id_client=:idClient and time_movie =:date
            """ ,nativeQuery = true)

    public Ticket ticketAgg(int idClient, LocalDate date);


    @Query("SELECT movies FROM Ticket u WHERE u.clients.idClient = ?1")
    public Movie moviesByClient(int idClient);

}




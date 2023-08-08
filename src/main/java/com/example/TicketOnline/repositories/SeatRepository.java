package com.example.TicketOnline.repositories;

import com.example.TicketOnline.Entities.Client;
import com.example.TicketOnline.Entities.Movie;
import com.example.TicketOnline.Entities.Seat;
import com.example.TicketOnline.Entities.Valutation;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface SeatRepository extends JpaRepository<Seat,Integer> {

    @Modifying
    @Transactional
    @Query("UPDATE Seat u SET u.available = ?1, u.ticket.idTicket = ?2  WHERE u.idSeat = ?3")
    public void updateSeat(boolean prenotato, Integer idTicket, int idSeat);


    @Query("SELECT s FROM Seat s WHERE s.ticket.idTicket = ?1")
    public List<Seat> findByTicketId(int idTicket);


}





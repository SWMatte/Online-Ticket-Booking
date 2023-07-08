package com.example.TicketOnline.repositories;

import com.example.TicketOnline.Entities.Movie;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.TicketOnline.Entities.Booking;
import com.example.TicketOnline.Entities.Cinema;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface CinemaRepository extends JpaRepository<Cinema,Integer> {

    @Modifying
    @Transactional
    @Query("UPDATE Cinema u SET u.city= ?1 , u.seatAvailable= ?2, u.movies=?3 WHERE u.idCinema= ?4")
    public void updateCinema(String city, int seatAvailable, Movie movies, int idCinema);
}

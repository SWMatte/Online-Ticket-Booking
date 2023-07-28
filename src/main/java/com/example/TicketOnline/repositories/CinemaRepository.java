package com.example.TicketOnline.repositories;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.TicketOnline.Entities.Cinema;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CinemaRepository extends JpaRepository<Cinema,Integer> {

    @Modifying
    @Transactional
    @Query("UPDATE Cinema u SET u.city= ?1 , u.seatAvailable= ?2  WHERE u.idCinema= ?3")
    public void updateCinema(String city, int seatAvailable, int idCinema);


    public List<Cinema> findBycity(String city);

    public Cinema findByCity(String city);

    @Modifying
    @Transactional
    @Query("UPDATE Cinema u SET   u.seatAvailable= ?1  WHERE u.idCinema= ?2")
    public void updateCinemaById(int seatAvailable, int idCinema);

}

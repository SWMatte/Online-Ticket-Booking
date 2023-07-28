package com.example.TicketOnline.repositories;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.TicketOnline.Entities.Movie;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;

public interface MovieRepository extends JpaRepository<Movie,Integer> {


    @Modifying
    @Transactional
    @Query("UPDATE Movie u SET u.titleMovie= ?1 , u.durationMovie= ?2 ,u.releaseMovie= ?3 , u.available= ?4 WHERE u.idMovie= ?5")
    public void updateMovie(String titleMovie, String durationMovie, LocalDate releaseMovie, boolean available , int idMovie);


        public Movie findByTitleMovie(String titleMovie);


}

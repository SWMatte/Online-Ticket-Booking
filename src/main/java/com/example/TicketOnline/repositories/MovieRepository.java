package com.example.TicketOnline.repositories;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.TicketOnline.Entities.Movie;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface MovieRepository extends JpaRepository<Movie,Integer> {


    @Modifying
    @Transactional
    @Query("UPDATE Movie u SET u.titleMovie= ?1 , u.durationMovie= ?2 ,u.releaseMovie= ?3 , u.available= ?4 WHERE u.idMovie= ?5")
    public void updateMovie(String titleMovie, String durationMovie, LocalDate releaseMovie, boolean available , int idMovie);


    @Modifying
    @Transactional
    @Query("UPDATE Movie u SET  u.available= ?1 WHERE u.idMovie= ?2")
    public void updateAvailable( boolean available , int idMovie);

    @Query("SELECT u FROM Movie u WHERE u.titleMovie=?1 AND u.cinema.idCinema=?2")
    public Movie movieByTitleAndCinema(String titleMovie,int idCinema);


    @Query("SELECT u FROM Movie u WHERE u.cinema.idCinema=?1")
    public List<Optional<Movie>> movieByIdCinema(int idCinema);



}

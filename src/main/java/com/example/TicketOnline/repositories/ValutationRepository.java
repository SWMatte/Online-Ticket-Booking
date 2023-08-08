package com.example.TicketOnline.repositories;

import com.example.TicketOnline.Entities.Client;
import com.example.TicketOnline.Entities.Movie;
import com.example.TicketOnline.Entities.Valutation;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;

public interface ValutationRepository extends JpaRepository<Valutation,Integer> {



    @Query("SELECT idValutation FROM Valutation v WHERE v.client = ?1 AND v.movie = ?2")
    public Integer findValutation (Client client, Movie movie);


    @Query(value = """
            SELECT AVG(vote) from valutation where id_movie=:idMovie
            """,nativeQuery = true)
    public double findAverage( int idMovie);
}

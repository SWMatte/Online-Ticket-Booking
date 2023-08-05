package com.example.TicketOnline.controller;

import java.util.List;

import com.example.TicketOnline.response.ResponseHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.TicketOnline.Entities.Movie;
import com.example.TicketOnline.service.IService;

@RestController
public class MovieController {

    @Autowired
    IService<Movie> movieService;

    @GetMapping("/movie")  // usati per riempire la vetrina
    public ResponseEntity<Object> findAll() throws Exception {

        try {
            return ResponseHandler.generateResponse("Movie add", HttpStatus.OK, movieService.getAll());
        } catch (Exception e) {
            return ResponseHandler.generateResponse("Nessun movie presente", HttpStatus.BAD_REQUEST, null);
        }
    }


    @PostMapping("/movie")   // usato dall amministratore per aggiungere un nuovo film
    public ResponseEntity<Object> addElement(@RequestBody Movie movie) {

        try {
            movieService.add(movie);
            return ResponseHandler.generateMessage("Movie aggiunto", HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return ResponseHandler.generateMessage("Movie gia' inserito", HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @DeleteMapping("/movie/{id}") // usato x rimuovere un film dall amministratore
    public void deleteElement(@PathVariable int id) {

        movieService.remove(id);
    }


    @PutMapping("/movie") // usato x aggiornare un film dall amministratore
    public ResponseEntity<Object> updateElement(@RequestBody Movie movie) {

        try {
            movieService.update(movie);
            return ResponseHandler.generateMessage("Movie add" , HttpStatus.OK);
        } catch (Exception e) {
            return ResponseHandler.generateMessage(e.getMessage() , HttpStatus.BAD_REQUEST);
        }
    }

}

package com.example.TicketOnline.controller;

import java.util.List;

import com.example.TicketOnline.Entities.Seat;
import com.example.TicketOnline.response.ResponseHandler;
import com.example.TicketOnline.service.IServiceSeat;
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

import com.example.TicketOnline.Entities.Cinema;
import com.example.TicketOnline.service.IService;

@RestController
public class CinemaController {

    @Autowired
    IService<Cinema> cinemaService;



    @GetMapping("/cinema")   // ti mostra i cinema presenti -> dentro dovrebbe poi mostrarti i film associati a quel cinema (RELAZIONE MANY TO MANY NON PRESENTE)
    public ResponseEntity<Object> findAll() {
        try {
            return ResponseHandler.generateResponse("lista" , HttpStatus.OK, cinemaService.getAll());
        } catch (Exception e) {
            return ResponseHandler.generateResponse("Nessun cinema presente" , HttpStatus.BAD_REQUEST,null);
        }
    }

    @PostMapping("/cinema") // aggiunge un cinema dall'amministratore
    public ResponseEntity<Object> addElement(@RequestBody Cinema cinema) {
        try {
            cinemaService.add(cinema);

           return ResponseHandler.generateMessage("Cinema add" , HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return ResponseHandler.generateMessage("Cinema gia' inserito" , HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @DeleteMapping("/cinema/{id}") // cancella un cinema specifico
    public void deleteElement(@PathVariable int id) {

        cinemaService.remove(id);
    }


    @PutMapping("/cinema") // aggiorna un cinema amministratore
    public ResponseEntity<Object> updateElement(@RequestBody Cinema cinema) {

        try {
            cinemaService.update(cinema);
            return ResponseHandler.generateMessage("Cinema add" , HttpStatus.OK);
        } catch (Exception e) {
            return ResponseHandler.generateMessage(e.getMessage() , HttpStatus.BAD_REQUEST);
        }


    }

}

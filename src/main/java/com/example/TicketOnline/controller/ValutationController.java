package com.example.TicketOnline.controller;

import com.example.TicketOnline.Entities.Cinema;
import com.example.TicketOnline.Entities.Valutation;
import com.example.TicketOnline.response.ResponseHandler;
import com.example.TicketOnline.service.IService;
import com.example.TicketOnline.service.IServiceValutation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ValutationController {

    @Autowired
    IServiceValutation<Valutation> serviceValutation;


    @GetMapping("/valutationAverage") // valutazione di un id film si vedra' a fianco del film specifico
    public ResponseEntity<Object> averageMovie(@RequestParam int id) {

        return ResponseHandler.generateMessage("Value average movie: " + serviceValutation.averageMovie(id), HttpStatus.OK);

    }



    @PostMapping("/valutation") // aggiunta valutazione dell'utente solo se ha visto il movie

    public ResponseEntity<Object> addElement(@RequestBody Valutation valutation) {
        try {
            serviceValutation.add(valutation);
            return ResponseHandler.generateMessage("valutazione add", HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return ResponseHandler.generateMessage("valutazione gia' inserito", HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return ResponseHandler.generateMessage("Non puoi recensire questo film", HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/valutation/{id}")  // cancella la valutazione
    public void deleteElement(@PathVariable int id) {

        serviceValutation.remove(id);
    }


}

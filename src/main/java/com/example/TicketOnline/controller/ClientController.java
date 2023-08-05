package com.example.TicketOnline.controller;

import java.util.List;

import com.example.TicketOnline.response.ResponseHandler;
import com.example.TicketOnline.service.serviceImp.ServiceClient;
import com.example.TicketOnline.service.serviceImp.ServiceTicket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.TicketOnline.Entities.Client;
import com.example.TicketOnline.service.IService;

@RestController
public class ClientController {

    @Autowired
    IService<Client> clientService;
    @Autowired
    ServiceClient serviceClient;

    @Autowired
    ServiceTicket serviceTicket;


    @GetMapping("/client")
    public ResponseEntity<Object> findAll() throws Exception { // usato poi dall'amministratore per avere traccia di tutti i clienti

        try {
            return ResponseHandler.generateResponse("Client add", HttpStatus.OK, clientService.getAll());
        } catch (Exception e) {
            return ResponseHandler.generateResponse("Nessun client presente", HttpStatus.BAD_REQUEST, null);
        }


    }


    @PostMapping("/client")  // usato per la registrazione in fornt-end
    public ResponseEntity<Object> addElement(@RequestBody Client client) {

        try {
            clientService.add(client);
            return ResponseHandler.generateMessage("Client aggiunto", HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return ResponseHandler.generateMessage("Client gia' inserito", HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    @DeleteMapping("/client/{id}")  // per eliminare un cliente specifico
    public void deleteElement(@PathVariable int id) {

        clientService.remove(id);
    }


    @PutMapping("/client")  // usato dal client per modificare la sua anagrafica

    public ResponseEntity<Object> updateElement(@RequestBody Client client) {

        try {
            clientService.update(client);
            return ResponseHandler.generateMessage("client add", HttpStatus.OK);
        } catch (Exception e) {
            return ResponseHandler.generateMessage(e.getMessage(), HttpStatus.BAD_REQUEST);
        }

    }

    @GetMapping("/clientid")   // usato dal client per far tornare la sua anagrafica dal DB
    public Client clientById(@RequestParam("name") String name, @RequestParam("lastName") String lastName) {

        try {
            return serviceClient.findById(name,lastName);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/clientticket")  // ritornano i ticket associati a quel utente
    public ResponseEntity<Object> findTicketByClient(@RequestParam("idClient") int idClient){
        try {

        return ResponseHandler.generateResponse("Ticket associati: ",HttpStatus.OK, serviceTicket.findTicketByClient(idClient));
        }catch (Exception e) {

            return ResponseHandler.generateMessage("NON hai nessun ticket a disposizione",HttpStatus.BAD_REQUEST);
        }
    }



}

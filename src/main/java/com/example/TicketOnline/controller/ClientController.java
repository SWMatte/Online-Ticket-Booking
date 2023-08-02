package com.example.TicketOnline.controller;

import java.util.List;

import com.example.TicketOnline.response.ResponseHandler;
import com.example.TicketOnline.service.serviceImp.ServiceClient;
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

import com.example.TicketOnline.Entities.Client;
import com.example.TicketOnline.service.IService;

@RestController
public class ClientController {

    @Autowired
    IService<Client> clientService;
    @Autowired
    ServiceClient serviceClient;


    @GetMapping("/client")
    public ResponseEntity<Object> findAll() throws Exception {

        try {
            return ResponseHandler.generateResponse("Client add", HttpStatus.OK, clientService.getAll());
        } catch (Exception e) {
            return ResponseHandler.generateResponse("Nessun client presente", HttpStatus.BAD_REQUEST, null);
        }


    }


    @PostMapping("/client")
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

    @DeleteMapping("/client/{id}")
    public void deleteElement(@PathVariable int id) {

        clientService.remove(id);
    }


    @PutMapping("/client")
    public ResponseEntity<Object> updateElement(@RequestBody Client client) {

        try {
            clientService.update(client);
            return ResponseHandler.generateMessage("client add", HttpStatus.OK);
        } catch (Exception e) {
            return ResponseHandler.generateMessage(e.getMessage(), HttpStatus.BAD_REQUEST);
        }

    }

    @GetMapping("/client/{id}")
    public Client clientById(@PathVariable int id) {

        try {
            return serviceClient.findById(id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


}

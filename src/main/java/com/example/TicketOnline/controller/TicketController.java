package com.example.TicketOnline.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.NoSuchElementException;

import com.example.TicketOnline.DTO.TickeDTO;
import com.example.TicketOnline.exceptions.ExceptionTicket;
import com.example.TicketOnline.response.ResponseHandler;
import com.example.TicketOnline.service.IServiceTicket;
import com.example.TicketOnline.service.serviceImp.ServiceTicket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.TicketOnline.Entities.Ticket;
import com.example.TicketOnline.service.IService;

@RestController
public class TicketController {



    @Autowired
    ServiceTicket serviceTicket;

    @Autowired
    IServiceTicket<Ticket> iServiceTicket;

    @GetMapping("/ticket")
    public ResponseEntity<Object> findAll() throws Exception {
        try {
            return ResponseHandler.generateResponse("Ticket add", HttpStatus.OK, iServiceTicket.getAll());
        } catch (Exception e) {
            return ResponseHandler.generateResponse("Nessun ticket presente", HttpStatus.BAD_REQUEST, null);
        }

    }


    @PostMapping("/ticket")
    public ResponseEntity<Object> addElement(@RequestBody Ticket ticket) {
        TickeDTO a = null;
        try {
            a = serviceTicket.addTicketDTO(ticket);
        } catch (Exception e) {
            System.out.println(e.getMessage());

        }
        return ResponseHandler.generateResponse("TicketNOdiscount", HttpStatus.OK, a);
    }

    @PostMapping("/ticketDiscount")
    public ResponseEntity<Object> addTicketDiscount(@RequestBody Ticket ticket) {
        TickeDTO a = null;
        try {
            a = serviceTicket.addTicketDTODiscount(ticket);
        } catch (Exception e) {
            System.out.println(e.getMessage());

        }
        return ResponseHandler.generateResponse("Ticket", HttpStatus.OK, a);
    }


    @PostMapping("/removesingleticket")
    public ResponseEntity<Object> ticketUpdated(@RequestParam("idTicket") int idTicket, @RequestParam("qtaRimossa") int qtaRimossa) throws ExceptionTicket {


            try {

                return ResponseHandler.generateResponse("Biglietti Rimossi", HttpStatus.OK, iServiceTicket.deleteSingleTicket(idTicket, qtaRimossa));

            } catch (ExceptionTicket e) {
                return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.BAD_REQUEST, null);

            } catch (NoSuchElementException e) {

                return ResponseHandler.generateResponse("Ticket not found", HttpStatus.BAD_REQUEST, null);

            }
        }

    }



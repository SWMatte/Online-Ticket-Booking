package com.example.TicketOnline.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

    @GetMapping("/cinema")
    public List<Cinema> findAll() {

        return cinemaService.getAll();
    }

    @PostMapping("/cinema")
    public void addElement(@RequestBody Cinema cinema) {
        try {
            cinemaService.add(cinema);
        } catch (Exception e) {
            System.out.printf(e.getMessage());
        }
    }

    @DeleteMapping("/cinema/{id}")
    public void deleteElement(@PathVariable int id) {

        cinemaService.remove(id);
    }


    @PutMapping("/cinema")
    public void updateElement(@RequestBody Cinema cinema) {

        try {
            cinemaService.update(cinema);
        } catch (Exception e) {
            System.out.printf(e.getMessage());
        }
    }


}

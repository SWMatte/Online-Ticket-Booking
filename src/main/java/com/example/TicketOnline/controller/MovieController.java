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

import com.example.TicketOnline.Entities.Movie;
import com.example.TicketOnline.service.IService;

@RestController
public class MovieController {

    @Autowired
    IService<Movie> movieService;

    @GetMapping("/movie")
    public List<Movie> findAll() {

        return movieService.getAll();
    }


    @PostMapping("/movie")
    public void addElement(@RequestBody Movie movie) {
        try {
            movieService.add(movie);

        } catch (Exception e) {
            System.out.println(e.getMessage());

        }
    }

    @DeleteMapping("/movie/{id}")
    public void deleteElement(@PathVariable int id) {

        movieService.remove(id);
    }


    @PutMapping("/movie")
    public void updateElement(@RequestBody Movie movie) {
        try {
            movieService.update(movie);

        } catch (Exception e) {
            System.out.println(e.getMessage());

        }
    }

}

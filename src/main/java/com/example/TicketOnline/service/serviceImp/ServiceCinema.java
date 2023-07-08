package com.example.TicketOnline.service.serviceImp;

import java.util.List;

import com.example.TicketOnline.Entities.Movie;
import com.example.TicketOnline.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.TicketOnline.Entities.Cinema;
import com.example.TicketOnline.repositories.CinemaRepository;
import com.example.TicketOnline.service.IService;


@Service
public class ServiceCinema implements IService<Cinema> {

    @Autowired
    CinemaRepository cinemaRepository;

    @Autowired
    MovieRepository movieRepository;

    @Override
    public void add(Cinema element) throws Exception {

        Movie m = movieRepository.findById(element.getMovies().getIdMovie()).get();
        if (m != null) {
            Cinema c = new Cinema();
            c.setCity(element.getCity());
            c.setSeatAvailable(element.getSeatAvailable());
            c.setMovies(m);
            cinemaRepository.save(c);
        } else {
            new Exception("Film not available");
        }

    }

    @Override
    public void remove(int id) {
        cinemaRepository.deleteById(id);
    }

    @Override
    public void update(Cinema element) throws Exception {

        Movie m = movieRepository.findById(element.getMovies().getIdMovie()).get();
        if (m != null) {

            cinemaRepository.updateCinema(element.getCity(), element.getSeatAvailable(), m, element.getIdCinema());
        } else {
            new Exception("Film not available");

        }
    }

    @Override
    public List<Cinema> getAll() {
        return cinemaRepository.findAll();
    }

}

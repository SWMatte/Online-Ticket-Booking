package com.example.TicketOnline.service.serviceImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.TicketOnline.Entities.Movie;
import com.example.TicketOnline.repositories.ClientRepository;
import com.example.TicketOnline.repositories.MovieRepository;
import com.example.TicketOnline.service.IService;


@Service
public class ServiceMovie implements IService<Movie> {
    @Autowired
    MovieRepository movieRepository;


    @Override
    public void add(Movie element) throws Exception {
        if (movieRepository.findByTitleMovie(element.getTitleMovie())==null) {
            movieRepository.save(element);

        } else {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public void remove(int id) {
        movieRepository.deleteById(id);
    }

    @Override
    public void update(Movie element) throws Exception {
        movieRepository.updateMovie(element.getTitleMovie(), element.getDurationMovie(), element.getReleaseMovie(), element.isAvailable(), element.getIdMovie());
    }

    @Override
    public List<Movie> getAll() {
        return movieRepository.findAll();
    }

}

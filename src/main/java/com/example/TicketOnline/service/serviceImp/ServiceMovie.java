package com.example.TicketOnline.service.serviceImp;

import java.util.List;
import java.util.stream.Collectors;

import com.example.TicketOnline.Entities.Cinema;
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

        if (movieRepository.movieByTitleAndCinema(element.getTitleMovie(), element.getCinema().getIdCinema()) == null) {

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
        return movieRepository.findAll().stream().filter(movie -> movie.isAvailable()).collect(Collectors.toList());
    }

    public List<Movie> getNotAvailableMovie() {  // usato dall'amministratore per visualizzare film non ancora disponibili
        return movieRepository.findAll().stream().filter(movie -> !movie.isAvailable()).collect(Collectors.toList());
    }

    public void updateAvailable(Movie element) throws Exception {  // usato per aggiornare il film non disponibile dall'amministratore
        movieRepository.updateAvailable(element.isAvailable(), element.getIdMovie());
    }

}

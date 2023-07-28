package com.example.TicketOnline.service.serviceImp;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.List;

import com.example.TicketOnline.Entities.Cinema;
import com.example.TicketOnline.Entities.Client;
import com.example.TicketOnline.Entities.Movie;
import com.example.TicketOnline.repositories.CinemaRepository;
import com.example.TicketOnline.repositories.ClientRepository;
import com.example.TicketOnline.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.TicketOnline.Entities.Ticket;
import com.example.TicketOnline.repositories.TicketRepository;
import com.example.TicketOnline.service.IService;


@Service
public class ServiceTicket implements IService<Ticket> {

    @Autowired
    TicketRepository ticketRepository;
    @Autowired
    ClientRepository clientRepository;

    @Autowired
    CinemaRepository cinemaRepository;
    @Autowired
    MovieRepository movieRepository;

    @Override
    public void add(Ticket element) throws Exception {
        Client c = clientRepository.findById(element.getClients().getIdClient()).get();
        Movie m = movieRepository.findById(element.getMovies().getIdMovie()).get();
        Cinema cinema = cinemaRepository.findById(element.getCinema().getIdCinema()).get();
        int newSeatAvailable = cinema.getSeatAvailable() - element.getQtaTicket();

        if (c != null && m != null && cinema != null && element.getQtaTicket() > 0) {

            if (element.getTimeMovie().isAfter(m.getReleaseMovie()) || element.getTimeMovie().isEqual(m.getReleaseMovie()) && m.isAvailable()) {


                if (cinema.getSeatAvailable() >= element.getQtaTicket()) {

                    Ticket t = new Ticket();
                    LocalDate timeMovie = element.getTimeMovie();

                    t.setPrice(element.getPrice());
                    t.setTimeMovie(timeMovie);
                    t.setStateTicket(element.getStateTicket());
                    t.setQtaTicket(element.getQtaTicket());
                    t.setMovies(m);
                    t.setClients(c);
                    t.setCinema(cinema);


                    ticketRepository.save(t);
                    cinemaRepository.updateCinemaById(newSeatAvailable, element.getCinema().getIdCinema());
                } else {
                    System.out.println("Capienza posti superata");
                }
            } else {
                System.out.println("il film non è ancora uscito");
            }

        } else {
            new Exception();
        }
    }

    @Override
    public void remove(int id) {
        ticketRepository.deleteById(id);
    }

    @Override
    public void update(Ticket element) throws Exception {
        Client c = clientRepository.findById(element.getClients().getIdClient()).orElse(null);
        Movie m = movieRepository.findById(element.getMovies().getIdMovie()).orElse(null);

        if (c != null && m != null) {


            ticketRepository.updateTicket(element.getPrice(), element.getTimeMovie(), element.getStateTicket(), m, c, element.getIdTicket());
        } else {
            throw new Exception("Client or Movie not found");
        }
    }


    @Override
    public List<Ticket> getAll() {
        return ticketRepository.findAll();
    }

}

package com.example.TicketOnline.service.serviceImp;

import java.time.*;
import java.util.List;
import java.util.NoSuchElementException;

import com.example.TicketOnline.DTO.TickeDTO;
import com.example.TicketOnline.Entities.*;
import com.example.TicketOnline.exceptions.ExceptionTicket;
import com.example.TicketOnline.repositories.CinemaRepository;
import com.example.TicketOnline.repositories.ClientRepository;
import com.example.TicketOnline.repositories.MovieRepository;
import com.example.TicketOnline.service.IServiceTicket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.TicketOnline.repositories.TicketRepository;
import com.example.TicketOnline.service.IService;


@Service
public class ServiceTicket implements IService<Ticket>, IServiceTicket<Ticket> {

    @Autowired
    TicketRepository ticketRepository;
    @Autowired
    ClientRepository clientRepository;

    @Autowired
    CinemaRepository cinemaRepository;
    @Autowired
    MovieRepository movieRepository;


    public TickeDTO addTicketDTO(Ticket element) {
        Client c = clientRepository.findById(element.getClients().getIdClient()).get();
        Movie m = movieRepository.findById(element.getMovies().getIdMovie()).get();
        Cinema cinema = cinemaRepository.findById(element.getCinema().getIdCinema()).get();
        int newSeatAvailable = cinema.getSeatAvailable() - element.getQtaTicket();

        TickeDTO ticket = null;
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

                    ticket = new TickeDTO(element.getPrice(), element.getTimeMovie(), element.getStateTicket(), element.getQtaTicket(), m, c, cinema, element.getQtaTicket() * element.getPrice());

                } else {
                    System.out.println("Capienza posti superata");
                }
            } else {
                System.out.println("il film non è ancora uscito");
            }

        } else {
            new Exception();
        }

        return ticket;
    }

    // TICKET WITH DISCOUNT
    public TickeDTO addTicketDTODiscount(Ticket element) {
        Client c = clientRepository.findById(element.getClients().getIdClient()).get();
        Movie m = movieRepository.findById(element.getMovies().getIdMovie()).get();
        Cinema cinema = cinemaRepository.findById(element.getCinema().getIdCinema()).get();
        int newSeatAvailable = cinema.getSeatAvailable() - element.getQtaTicket();
        TickeDTO ticket = null;

        if (c != null && m != null && cinema != null && element.getQtaTicket() > 0) {

            if (element.getTimeMovie().isAfter(m.getReleaseMovie()) || element.getTimeMovie().isEqual(m.getReleaseMovie()) && m.isAvailable()) {


                if (cinema.getSeatAvailable() >= element.getQtaTicket()) {

                    LocalDate timeMovie = element.getTimeMovie();
                    element.setTimeMovie(timeMovie);
                    element.setMovies(m);
                    element.setClients(c);
                    element.setCinema(cinema);

                    ticketRepository.save(element);
                    cinemaRepository.updateCinemaById(newSeatAvailable, element.getCinema().getIdCinema());

                    int ageClient = c.getAge();
                    double discount;
                    double priceTicket = 0;
                    if (c.getDiscount().equals(Discount.VIP)) {
                        discount = Discount.VIP.getValue();
                        priceTicket = element.getPrice() - (element.getPrice() * discount);

                    } else {


                        if (ageClient >= 18 && ageClient <= 50) {
                            discount = Discount.STUDENTE.getValue();
                            priceTicket = element.getPrice() - (element.getPrice() * discount);
                        } else {
                            discount = Discount.ANZIANO.getValue();
                            priceTicket = element.getPrice() - (element.getPrice() * discount);
                        }
                    }

                    ticket = new TickeDTO(element.getPrice(), element.getTimeMovie(), element.getStateTicket(), element.getQtaTicket(), m, c, cinema, priceTicket);

                } else {
                    System.out.println("Capienza posti superata");
                }
            } else {
                System.out.println("il film non è ancora uscito");
            }

        } else {
            new Exception();
        }

        return ticket;
    }


    // substitute of the above method
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


    @Override
    public Ticket deleteSingleTicket(int idClient, LocalDate date, int qtaRimossa, int idCinema, int idMovie) throws ExceptionTicket {
        Client c = clientRepository.findById(idClient).orElseThrow();
        if (c != null) {
            //recupero la qta di biglietti del cliente
            int qtaAttuale = ticketRepository.qtaTicket(idClient, date);

            if (qtaRimossa >= 1 && qtaRimossa <= qtaAttuale) {
                int nuovaQtaTicket = qtaAttuale - qtaRimossa;
                int cinemaCapienza = cinemaRepository.findById(idCinema).get().getSeatAvailable();
                int nuovaCapienza = cinemaCapienza + qtaRimossa;
                cinemaRepository.updateCinemaById(nuovaCapienza, idCinema);
                ticketRepository.updateQtaTicket(nuovaQtaTicket, idClient, date);

            } else {
                throw new ExceptionTicket("Non hai a disposizione tutti questi biglietti indicati", new IllegalArgumentException("Quantità di biglietti non valida"));

            }
        } else {
            throw new NoSuchElementException();

        }

        return ticketRepository.ticketAgg(idClient, date);
    }
}

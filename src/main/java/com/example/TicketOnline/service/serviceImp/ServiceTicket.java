package com.example.TicketOnline.service.serviceImp;

import java.time.*;
import java.util.List;
 import java.util.stream.Collectors;

import com.example.TicketOnline.DTO.TickeDTO;
import com.example.TicketOnline.Entities.*;
import com.example.TicketOnline.exceptions.ExceptionTicket;
import com.example.TicketOnline.repositories.*;
import com.example.TicketOnline.service.IServiceTicket;
import com.example.TicketOnline.service.SendEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class ServiceTicket implements IServiceTicket<Ticket> {

    @Autowired
    TicketRepository ticketRepository;
    @Autowired
    ClientRepository clientRepository;
    @Autowired
    CinemaRepository cinemaRepository;
    @Autowired
    MovieRepository movieRepository;
    @Autowired
    SeatRepository seatRepository;

    @Autowired
    SendEmailService sendEmailService;


    public TickeDTO addTicketDTO(Ticket element) {
        Client c = clientRepository.findById(element.getClients().getIdClient()).get();
        Movie m = movieRepository.findById(element.getMovies().getIdMovie()).get();
        Cinema cinema = cinemaRepository.findById(element.getCinema().getIdCinema()).get();
        TickeDTO ticket = null;

        List<Seat> seatList = element.getSeat().stream().map(seat -> seatRepository.findById(seat.getIdSeat()).orElseThrow()).collect(Collectors.toList()); // lista posti a sedere

        if (c != null && m != null && cinema != null && element.getQtaTicket() > 0) {

            if (element.getTimeMovie().isAfter(m.getReleaseMovie()) || element.getTimeMovie().isEqual(m.getReleaseMovie()) && m.isAvailable()) {

                if (seatList.size() == element.getQtaTicket()) {

                    LocalDate timeMovie = element.getTimeMovie();

                    element.setTimeMovie(timeMovie);
                    element.setMovies(m);
                    element.setClients(c);
                    element.setCinema(cinema);
                    ticketRepository.save(element);

                    int ticketId = element.getIdTicket();

                    seatList.forEach(seat -> seatRepository.updateSeat(false, ticketId, seat.getIdSeat()));

                    String nameSeat = seatList.stream().map(s -> s.getNameSeat()).collect(Collectors.toList()).toString();

                    ticket = new TickeDTO(element.getPrice(), element.getTimeMovie(), element.getStateTicket(), element.getQtaTicket(), m, c, cinema, nameSeat, element.getQtaTicket() * element.getPrice());


                } else {
                    throw new IllegalArgumentException("Il numero di posti riservati deve corrispondere alla quantità di biglietti acquistati.");
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
        Cinema cinema = cinemaRepository.findById(element.getCinema().getIdCinema()).get();   //trovo le entita'
        TickeDTO ticket = null;                                                                 // istanzio il DTO

        List<Seat> seatList = element.getSeat().stream().map(seat -> seatRepository.findById(seat.getIdSeat()).orElseThrow()).collect(Collectors.toList()); // lista posti a sedere

        if (c != null && m != null && cinema != null && element.getQtaTicket() > 0) {

            if (element.getTimeMovie().isAfter(m.getReleaseMovie()) || element.getTimeMovie().isEqual(m.getReleaseMovie()) && m.isAvailable()) {

                if (seatList.size() == element.getQtaTicket()) {

                    LocalDate timeMovie = element.getTimeMovie();

                    element.setTimeMovie(timeMovie);                    // riempio l'elemento che salvo nel DB
                    element.setMovies(m);
                    element.setClients(c);
                    element.setCinema(cinema);
                    ticketRepository.save(element);

                    int ageClient = c.getAge();                         // in base all'eta del client applico lo sconto
                    double discount;
                    double priceTicket = 0;
                    if (c.getDiscount().equals(Discount.VIP)) {
                        discount = Discount.VIP.getValue();

                    } else {


                        if (ageClient >= 18 && ageClient <= 50) {
                            discount = Discount.STUDENTE.getValue();
                        } else {
                            discount = Discount.ANZIANO.getValue();
                        }
                    }
                    priceTicket = element.getPrice() - (element.getPrice() * discount);

                    int ticketId = element.getIdTicket();

                    seatList.forEach(seat -> seatRepository.updateSeat(false, ticketId, seat.getIdSeat()));

                    String nameSeat = seatList.stream().map(s -> s.getNameSeat()).collect(Collectors.toList()).toString();

                    ticket = new TickeDTO(element.getPrice(), element.getTimeMovie(), element.getStateTicket(), element.getQtaTicket(), m, c, cinema, nameSeat, element.getQtaTicket() * priceTicket);


                } else {
                    throw new IllegalArgumentException("Il numero di posti riservati deve corrispondere alla quantità di biglietti acquistati.");
                }
            } else {
                System.out.println("il film non è ancora uscito");
            }

        } else {

            new Exception();
        }

        return ticket;
    }



    @Override
    public List<Ticket> getAll() throws Exception {
        return ticketRepository.findAll();
    }


    @Override
    public Ticket deleteSingleTicket(int idTicket, int qtaRimossa) throws ExceptionTicket {
        Ticket t = ticketRepository.findById(idTicket).orElseThrow();

        int databaseQta = t.getQtaTicket();

        Ticket ticketReturn = null;
        List<Seat> seatList = seatRepository.findByTicketId(idTicket);

        if (t.getQtaTicket() == qtaRimossa) {
            for (int i = 0; i < qtaRimossa; i++) {
                Seat seat = seatList.get(i);
                seatRepository.updateSeat(true, null, seat.getIdSeat());

            }
            ticketRepository.deleteById(t.getIdTicket());
        } else{


            if (qtaRimossa >= 1 && qtaRimossa <= databaseQta) {

                int newQta = databaseQta - qtaRimossa;
                String newStateTicket = "Modified";

                ticketRepository.ticketAfterDelete(newQta, newStateTicket, idTicket);

                for (int i = 0; i < qtaRimossa; i++) {
                    Seat seat = seatList.get(i);

                    seatRepository.updateSeat(true, null, seat.getIdSeat());
                }
                ticketReturn = ticketRepository.findById(idTicket).orElseThrow();

            } else {
                throw new ExceptionTicket("Non hai a disposizione tutti questi biglietti indicati", new IllegalArgumentException("Quantità di biglietti non valida"));

            }
        }

        return ticketReturn;
    }



    public void sendEmail() {
        List<Client> listClient = clientRepository.findAll()
                .stream()
                .filter(client->client.isCommecialMessage()==true).collect(Collectors.toList());


       List<String> email = listClient.stream()
                .map(client -> client.getEmail()).collect(Collectors.toList());

       sendEmailService.sendEmail(email,"Promo per te - Cinema X","Oggi solo per te un'offerta speciale ...");

    }
    public List<Ticket> findTicketByClient(int idClient){
        return ticketRepository.ticketByClient(idClient);
    }


}




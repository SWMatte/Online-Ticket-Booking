package com.example.TicketOnline.service.serviceImp;

import com.example.TicketOnline.DTO.TickeDTO;
import com.example.TicketOnline.Entities.*;
import com.example.TicketOnline.exceptions.ExceptionTicket;
import com.example.TicketOnline.repositories.*;
import com.example.TicketOnline.service.IService;
import com.example.TicketOnline.service.IServiceTicket;
import com.example.TicketOnline.service.IServiceValutation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.NoSuchElementException;


@Service
public class ServiceValutation implements IServiceValutation<Valutation> {

    @Autowired
    ValutationRepository valutationRepository;
    @Autowired
    ClientRepository clientRepository;
    @Autowired
    MovieRepository movieRepository;
    @Autowired
    TicketRepository ticketRepository;

    @Override
    public void add(Valutation element) throws Exception {
        Client c = clientRepository.findById(element.getClient().getIdClient()).orElseThrow();
        Movie m = movieRepository.findById(element.getMovie().getIdMovie()).orElseThrow();
        Integer idTicket = ticketRepository.idTicket(c.getIdClient(),m.getIdMovie());

        element.setClient(c);
        element.setMovie(m);

        if (idTicket !=null) {

            if (valutationRepository.findValutation(c, m) == null) {
                valutationRepository.save(element);

            } else {
                throw new IllegalArgumentException();
            }
        } else {
            throw new Exception();
        }

        /*
        QUESTO METODO è IDENTICO, STESSA FUNZIONALITA' MA ITERA SU TUTTI I RECORD DEL DB, QUINDI è MENO EFFICIENTE
        boolean isValutationExists = valutationRepository.findAll().stream()
                .anyMatch(valutazioni -> valutazioni.getClient().getIdClient() == element.getMovie().getIdMovie() &&
                        valutazioni.getMovie().getIdMovie() == element.getMovie().getIdMovie());

        if (!isValutationExists) {
            valutationRepository.save(element);
        } else {
            System.out.println("VVV");
        }
*/
    }

    @Override
    public void remove(int id) {
        valutationRepository.deleteById(id);

    }

    @Override
    public double averageMovie(int idMovie) {
        return valutationRepository.findAverage(idMovie);

    }


}

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



    @Override
    public void add(Cinema element) throws Exception {
       if(cinemaRepository.findByCity(element.getCity())==null){

            cinemaRepository.save(element);
       } else{
           System.out.println("Cinema gia esistente");
       }


    }

    @Override
    public void remove(int id) {
        cinemaRepository.deleteById(id);
    }

    @Override
    public void update(Cinema element) throws Exception {

            cinemaRepository.updateCinema(element.getCity(), element.getSeatAvailable(), element.getIdCinema());

    }

    @Override
    public List<Cinema> getAll() {
        return cinemaRepository.findAll();
    }

}

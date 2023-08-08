package com.example.TicketOnline.DTO;

import com.example.TicketOnline.Entities.Cinema;
import com.example.TicketOnline.Entities.Client;
import com.example.TicketOnline.Entities.Movie;

import java.time.LocalDate;

public class TickeDTO {

    private double price;


    private LocalDate timeMovie;

    private String stateTicket;

    private int qtaTicket;


    private Movie movies;


    private Client clients;


    private Cinema cinema;

    private Double totaleTicket;

    private String seatName;


    public TickeDTO(double price, LocalDate timeMovie, String stateTicket, int qtaTicket, Movie movies, Client clients, Cinema cinema,String seatName, Double totaleTicket) {
        this.price = price;
        this.timeMovie = timeMovie;
        this.stateTicket = stateTicket;
        this.qtaTicket = qtaTicket;
        this.movies = movies;
        this.clients = clients;
        this.cinema = cinema;
        this.seatName= seatName;
        this.totaleTicket = totaleTicket;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public LocalDate getTimeMovie() {
        return timeMovie;
    }

    public void setTimeMovie(LocalDate timeMovie) {
        this.timeMovie = timeMovie;
    }

    public String getStateTicket() {
        return stateTicket;
    }

    public void setStateTicket(String stateTicket) {
        this.stateTicket = stateTicket;
    }

    public int getQtaTicket() {
        return qtaTicket;
    }

    public void setQtaTicket(int qtaTicket) {
        this.qtaTicket = qtaTicket;
    }

    public Movie getMovies() {
        return movies;
    }

    public void setMovies(Movie movies) {
        this.movies = movies;
    }

    public Client getClients() {
        return clients;
    }

    public void setClients(Client clients) {
        this.clients = clients;
    }

    public Cinema getCinema() {
        return cinema;
    }

    public void setCinema(Cinema cinema) {
        this.cinema = cinema;
    }

    public Double getTotaleTicket() {
        return totaleTicket;
    }

    public void setTotaleTicket(Double totaleTicket) {
        this.totaleTicket = totaleTicket;
    }

    public String getSeatName() {
        return seatName;
    }

    public void setSeatName(String seatName) {
        this.seatName = seatName;
    }
}

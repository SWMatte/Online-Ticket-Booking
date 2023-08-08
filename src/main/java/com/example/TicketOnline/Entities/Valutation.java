package com.example.TicketOnline.Entities;

import jakarta.persistence.*;

@Entity
public class Valutation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idValutation;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idClient")
    private Client client;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idMovie")
    private Movie movie;

    private int vote;

    public int getIdValutation() {
        return idValutation;
    }

    public void setIdValutation(int idValutation) {
        this.idValutation = idValutation;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public int getVote() {
        return vote;
    }

    public void setVote(int vote) {
        this.vote = vote;
    }
}

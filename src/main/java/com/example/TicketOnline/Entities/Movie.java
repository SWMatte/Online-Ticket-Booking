package com.example.TicketOnline.Entities;

import java.time.LocalDate;
import java.util.List;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idMovie;
    private String titleMovie;
    private String durationMovie;
    private LocalDate releaseMovie;
    private boolean available;

    @JsonIgnore
    @OneToMany(mappedBy = "movies")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<Ticket> tickets;

    @JsonIgnore
    @OneToMany(mappedBy = "movie")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<Valutation> valutazioni;

    public int getIdMovie() {
        return idMovie;
    }

    public void setIdMovie(int idMovie) {
        this.idMovie = idMovie;
    }

    public String getTitleMovie() {
        return titleMovie;
    }

    public void setTitleMovie(String titleMovie) {
        this.titleMovie = titleMovie;
    }

    public String getDurationMovie() {
        return durationMovie;
    }

    public void setDurationMovie(String durationMovie) {
        this.durationMovie = durationMovie;
    }


    public LocalDate getReleaseMovie() {
        return releaseMovie;
    }

    public void setReleaseMovie(LocalDate releaseMovie) {
        this.releaseMovie = releaseMovie;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }

    public List<Valutation> getValutazioni() {
        return valutazioni;
    }

    public void setValutazioni(List<Valutation> valutazioni) {
        this.valutazioni = valutazioni;
    }
}

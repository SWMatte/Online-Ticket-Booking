package com.example.TicketOnline.Entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
public class Seat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idSeat;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idTicket")
    @JsonBackReference
    private Ticket ticket;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idCinema")
    private Cinema cinemaSeat;

    private String nameSeat;
    private boolean available=true;

    public int getIdSeat() {
        return idSeat;
    }

    public void setIdSeat(int idSeat) {
        this.idSeat = idSeat;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public Cinema getCinemaSeat() {
        return cinemaSeat;
    }

    public void setCinemaSeat(Cinema cinemaSeat) {
        this.cinemaSeat = cinemaSeat;
    }

    public String getNameSeat() {
        return nameSeat;
    }

    public void setNameSeat(String nameSeat) {
        this.nameSeat = nameSeat;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
}

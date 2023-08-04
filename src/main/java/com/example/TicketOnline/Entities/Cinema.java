package com.example.TicketOnline.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.List;

@Entity
public class Cinema {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idCinema;
	private String city;
	private int seatAvailable;

	@JsonIgnore
	@OneToMany(mappedBy = "cinemaSeat")
	@OnDelete(action = OnDeleteAction.CASCADE )
	private List<Seat> seat;

	@JsonIgnore
	@OneToMany(mappedBy = "cinema")
	@OnDelete(action = OnDeleteAction.CASCADE )
	private List<Ticket> ticket;

	public int getIdCinema() {
		return idCinema;
	}

	public void setIdCinema(int idCinema) {
		this.idCinema = idCinema;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getSeatAvailable() {
		return seatAvailable;
	}

	public void setSeatAvailable(int seatAvailable) {
		this.seatAvailable = seatAvailable;
	}


	public List<Ticket> getTicket() {
		return ticket;
	}

	public void setTicket(List<Ticket> ticket) {
		this.ticket = ticket;
	}
}

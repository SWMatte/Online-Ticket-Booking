package com.example.TicketOnline.Entities;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
public class Ticket {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idTicket;
	private double price;


	private LocalDate timeMovie;

	private String stateTicket;

	private int qtaTicket;


	@OneToMany(mappedBy = "ticket")
		@JsonManagedReference
	private List<Seat> seat;


	
	@ManyToOne(fetch = FetchType.EAGER)
	 @JoinColumn(name = "idMovie")
	private Movie movies;
	
	@ManyToOne(fetch = FetchType.EAGER)
	 @JoinColumn(name = "idClient")
	private Client clients;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "idCinema")
	private Cinema cinema;

	public int getQtaTicket() {
		return qtaTicket;
	}

	public void setQtaTicket(int qtaTicket) {
		this.qtaTicket = qtaTicket;
	}

	public int getIdTicket() {
		return idTicket;
	}


	public void setIdTicket(int idTicket) {
		this.idTicket = idTicket;
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

	public List<Seat> getSeat() {
		return seat;
	}

	public void setSeat(List<Seat> seat) {
		this.seat = seat;
	}

	public Cinema getCinema() {
		return cinema;
	}

	public void setCinema(Cinema cinema) {
		this.cinema = cinema;
	}
}

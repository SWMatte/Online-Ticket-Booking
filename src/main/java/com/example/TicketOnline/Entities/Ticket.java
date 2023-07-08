package com.example.TicketOnline.Entities;

import java.time.LocalDateTime;
import java.time.LocalTime;
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
public class Ticket {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idTicket;
	private double price;


	private LocalTime timeMovie;

	private String stateTicket;
	
	
	@ManyToOne(cascade = {CascadeType.REMOVE, CascadeType.MERGE, CascadeType.PERSIST},fetch = FetchType.EAGER)
	 @JoinColumn(name = "idMovie")
	private Movie movies;
	
	@ManyToOne(cascade = {CascadeType.REMOVE, CascadeType.MERGE, CascadeType.PERSIST},fetch = FetchType.EAGER)
	 @JoinColumn(name = "idClient")
	private Client clients;

	
	 @JsonIgnore
	  @OneToMany(mappedBy = "ticket",cascade = {CascadeType.REMOVE,CascadeType.MERGE,CascadeType.PERSIST})
	@OnDelete(action = OnDeleteAction.CASCADE)
	 private List<Booking> bookings;


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

	public LocalTime getTimeMovie() {
		return timeMovie;
	}

	public void setTimeMovie(LocalTime timeMovie) {
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


	public List<Booking> getBookings() {
		return bookings;
	}


	public void setBookings(List<Booking> bookings) {
		this.bookings = bookings;
	}
	 
	 
	 
	 
	 
}

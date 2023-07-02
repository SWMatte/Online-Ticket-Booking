package com.example.TicketOnline.Entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Cinema {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idCinema;
	private String city;
	private int SeatAvailable;

	
	@ManyToOne(cascade = {CascadeType.REMOVE, CascadeType.MERGE, CascadeType.PERSIST},fetch = FetchType.EAGER)
	 @JoinColumn(name = "idMovie")
	private Movie movies;


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
		return SeatAvailable;
	}


	public void setSeatAvailable(int seatAvailable) {
		SeatAvailable = seatAvailable;
	}


	public Movie getMovies() {
		return movies;
	}


	public void setMovies(Movie movies) {
		this.movies = movies;
	}
	
	
	
	
}

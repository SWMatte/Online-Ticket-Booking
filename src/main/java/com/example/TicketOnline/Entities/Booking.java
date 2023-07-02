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
public class Booking {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idBooking;
	
	
	@ManyToOne(cascade = {CascadeType.REMOVE, CascadeType.MERGE, CascadeType.PERSIST},fetch = FetchType.EAGER)
	 @JoinColumn(name = "idClient")
	private Client client;
	
	
	@ManyToOne(cascade = {CascadeType.REMOVE, CascadeType.MERGE, CascadeType.PERSIST},fetch = FetchType.EAGER)
	 @JoinColumn(name = "idTicket")
	private Ticket ticket;


	public int getIdBooking() {
		return idBooking;
	}


	public void setIdBooking(int idBooking) {
		this.idBooking = idBooking;
	}


	public Client getClient() {
		return client;
	}


	public void setClient(Client client) {
		this.client = client;
	}


	public Ticket getTicket() {
		return ticket;
	}


	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}
	

	
	
}

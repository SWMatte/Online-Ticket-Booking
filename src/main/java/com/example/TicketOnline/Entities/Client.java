package com.example.TicketOnline.Entities;

import java.util.List;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
@Entity
public class Client {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idClient;
	private String name;
	private String lastName;
	
	
	
	 
	 @JsonIgnore
	  @OneToMany(mappedBy = "clients",cascade = {CascadeType.REMOVE,CascadeType.MERGE,CascadeType.PERSIST})
	@OnDelete(action = OnDeleteAction.CASCADE)
	 private List<Ticket> tickets;


	 

	 public int getIdClient() {
		return idClient;
	}




	public void setIdClient(int idClient) {
		this.idClient = idClient;
	}




	public String getName() {
		return name;
	}




	public void setName(String name) {
		this.name = name;
	}




	public String getLastName() {
		return lastName;
	}




	public void setLastName(String lastName) {
		this.lastName = lastName;
	}




	public List<Ticket> getTickets() {
		return tickets;
	}




	public void setTickets(List<Ticket> tickets) {
		this.tickets = tickets;
	}










	 
	 
	
}

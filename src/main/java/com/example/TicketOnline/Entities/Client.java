package com.example.TicketOnline.Entities;

import java.util.List;

import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idClient;
    private String name;
    private String lastName;
    private int age;

    @Enumerated(EnumType.STRING)
    private Discount discount = Discount.NESSUNO;

    @JsonIgnore
    @OneToMany(mappedBy = "clients", cascade = {CascadeType.REMOVE, CascadeType.MERGE, CascadeType.PERSIST})
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<Ticket> tickets;

	@JsonIgnore
	@OneToMany(mappedBy = "client")
	@OnDelete(action = OnDeleteAction.CASCADE)
	private List<Valutation> valutazioni;

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

    public List<Valutation> getValutazioni() {
        return valutazioni;
    }

    public void setValutazioni(List<Valutation> valutazioni) {
        this.valutazioni = valutazioni;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Discount getDiscount() {
        return discount;
    }

    public void setDiscount(Discount discount) {
        this.discount = discount;
    }
}

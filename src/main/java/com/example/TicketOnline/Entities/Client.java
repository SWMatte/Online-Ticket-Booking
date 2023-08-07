package com.example.TicketOnline.Entities;

import java.util.Collection;
import java.util.List;
import java.util.Set;

import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
public class Client implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idClient;
    private String name;
    private String lastName;
    private int age;

    private String email;

    private boolean commecialMessage;


    @Enumerated(EnumType.STRING)
    private Discount discount = Discount.NESSUNO;
    private String username;
    private String password;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_role",
    joinColumns = {@JoinColumn(name = "idClient")},
    inverseJoinColumns = {@JoinColumn(name = "idRole")})
    private Set<Role> authorities;


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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isCommecialMessage() {
        return commecialMessage;
    }

    public void setCommecialMessage(boolean commecialMessage) {
        this.commecialMessage = commecialMessage;
    }


    public void setAuthorities(Set<Role> authorities) {
        this.authorities = authorities;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}

package com.example.TicketOnline.repositories;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

 import com.example.TicketOnline.Entities.Client;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface ClientRepository extends JpaRepository<Client,Integer> {

    @Modifying
    @Transactional
    @Query("UPDATE Client u SET u.name= ?1, u.lastName =?2 , u.age =?3, u.email =?4, u.commecialMessage =?5 where u.idClient =?6")
    public void updateClient(String name,String lastName,int idClient,int age, String email, boolean commercialMessage);


    @Query("SELECT s from Client s WHERE s.name=?1 AND s.lastName=?2")
    public Client findByNameAndLastName(String name,String lastName);


    Optional<Client> findByUsername(String username);

}

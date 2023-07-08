package com.example.TicketOnline.repositories;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

 import com.example.TicketOnline.Entities.Client;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface ClientRepository extends JpaRepository<Client,Integer> {

    @Modifying
    @Transactional
    @Query("UPDATE Client u SET u.name= ?1, u.lastName =?2 where u.idClient =?3")
    public void updateClient(String name,String lastName,int idClient);


}

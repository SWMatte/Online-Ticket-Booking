package com.example.TicketOnline.repositories;

import com.example.TicketOnline.Entities.Client;
import com.example.TicketOnline.Entities.Movie;
import com.example.TicketOnline.Entities.Role;
import com.example.TicketOnline.Entities.Valutation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RoleRepository extends JpaRepository<Role,Integer> {

    Role findByAuthority(String authority);

 @Query("SELECT r FROM Role r WHERE r.authority=?1" )
    Role findByAuthorities(String authority);

}



package com.example.TicketOnline;

import com.example.TicketOnline.Entities.Role;
import com.example.TicketOnline.repositories.RoleRepository;
import com.example.TicketOnline.service.SendEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TicketOnlineApplication implements CommandLineRunner {
    @Autowired
    private Role roleAdmin;

    @Autowired
    private Role roleUser;

    @Autowired
    RoleRepository roleRepository;

    public static void main(String[] args) {
        SpringApplication.run(TicketOnlineApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("ESEGUITO COMMAND LINE RUNNER TO ADD USER && ADMIN CHECK ON DB");
        if (roleRepository.findByAuthorities(roleAdmin.getAuthority()) == null) {
            roleRepository.save(roleAdmin);

        }
        if (roleRepository.findByAuthorities(roleUser.getAuthority()) == null) {

            roleRepository.save(roleUser);

        }

    }
}

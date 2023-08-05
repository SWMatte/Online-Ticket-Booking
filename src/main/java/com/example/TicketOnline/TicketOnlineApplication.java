package com.example.TicketOnline;

import com.example.TicketOnline.service.SendEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TicketOnlineApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(TicketOnlineApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
 	}
}

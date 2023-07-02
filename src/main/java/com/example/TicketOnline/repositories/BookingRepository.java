package com.example.TicketOnline.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.TicketOnline.Entities.Booking;

public interface BookingRepository extends JpaRepository<Booking,Integer> {

}

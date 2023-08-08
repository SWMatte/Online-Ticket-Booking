package com.example.TicketOnline.service;

import com.example.TicketOnline.exceptions.ExceptionTicket;

import java.time.LocalDate;
import java.util.List;

public interface IServiceValutation<T>{



    public double averageMovie(int idMovie);



    public void add(T element) throws Exception;

    public void remove(int id);




}

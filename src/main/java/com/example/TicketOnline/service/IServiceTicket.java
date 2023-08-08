package com.example.TicketOnline.service;

import com.example.TicketOnline.exceptions.ExceptionTicket;

import java.time.LocalDate;
import java.util.List;

public interface IServiceTicket<T>{


    public T deleteSingleTicket(int idticket,int qta) throws ExceptionTicket;



    public List<T> getAll() throws Exception;
}

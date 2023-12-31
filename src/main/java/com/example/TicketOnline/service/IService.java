package com.example.TicketOnline.service;

import java.util.List;

public interface IService <T>{		  
	
	public void add(T element) throws Exception;

	public void remove(int id);
	
	public void update(T element) throws Exception;
	
	 public List<T> getAll() throws Exception;
 
}

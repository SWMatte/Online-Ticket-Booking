package com.example.TicketOnline.service;

import java.util.List;

public interface IService <T>{		  
	
	public void add(T element);

	public void remove(int id);
	
	public void update(T element);
	
	 public List<T> getAll(); 
 
}

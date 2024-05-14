package it.meteo.dao;

import org.springframework.data.repository.CrudRepository;

import it.meteo.model.Utente;

public interface UtenteDao extends CrudRepository<Utente, Integer> 
{
	Utente findByEmail(String email);
	
	Utente findByEmailAndPassword(String email, String password);
	
	boolean existsByEmail(String email);
}

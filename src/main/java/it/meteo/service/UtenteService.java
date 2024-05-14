package it.meteo.service;


import org.springframework.stereotype.Service;

import it.meteo.dto.UtenteRegisterDTO;
import it.meteo.dto.UtenteLoginRequestDTO;
import it.meteo.model.Utente;

@Service
public interface UtenteService {
	// inserimento utente
	void utenteRegistration(UtenteRegisterDTO user);
	
	boolean existByEmail(String email);
	
	Utente getUserByEmail(String email);
	
	boolean loginUtente(UtenteLoginRequestDTO utenteLoginRequestDTO);
	


}

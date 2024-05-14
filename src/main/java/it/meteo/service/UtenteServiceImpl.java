package it.meteo.service;


import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.meteo.dao.UtenteDao;
import it.meteo.dto.UtenteLoginRequestDTO;
import it.meteo.model.Utente;
import it.meteo.dto.UtenteRegisterDTO;

@Service
public class UtenteServiceImpl implements UtenteService
{
	@Autowired
	private UtenteDao utenteDao;
	
	
	@Override
	public void utenteRegistration(UtenteRegisterDTO utenteRegistrazioneDto) 
	{
		Utente utente = new Utente();
		
		utente.setNome(utenteRegistrazioneDto.getNome());
		utente.setCognome(utenteRegistrazioneDto.getCognome());
		utente.setEmail(utenteRegistrazioneDto.getEmail());
		
		String sha256hex = DigestUtils.sha3_256Hex(utenteRegistrazioneDto.getPassword());
		utente.setPassword(sha256hex);;
		
		utenteDao.save(utente);	
	}


	@Override
	public Utente getUserByEmail(String email) 
	{
		return utenteDao.findByEmail(email);
	}
	
	@Override
	public boolean existByEmail(String email) 
	{
		return utenteDao.existsByEmail(email);
	}
	
	@Override
	public boolean loginUtente(UtenteLoginRequestDTO utenteLoginRequestDto) 
	{
		Utente utente = new Utente();
		
		utente.setEmail(utenteLoginRequestDto.getEmail());
	
		
		Utente credenzialiUtente = utenteDao.findByEmail(utente.getEmail()); 
		
		//operatore ternario dato dalla condizione ? a (vero) : b (falso)
		return credenzialiUtente != null ? true : false;
	}
	
}

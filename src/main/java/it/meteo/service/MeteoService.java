package it.meteo.service;

import org.springframework.stereotype.Service;

import it.meteo.dto.MeteoDTO;

@Service
public interface MeteoService 
{
    void salvaMeteo(MeteoDTO meteo);
}


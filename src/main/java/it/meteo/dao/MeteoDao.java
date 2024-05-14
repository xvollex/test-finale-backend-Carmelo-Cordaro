package it.meteo.dao;

import org.springframework.data.repository.CrudRepository;

import it.meteo.model.Meteo;

public interface MeteoDao extends CrudRepository<Meteo, Integer> 
{


}

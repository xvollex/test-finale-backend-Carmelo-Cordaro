package it.meteo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.meteo.dao.MeteoDao;
import it.meteo.dto.MeteoDTO;
import it.meteo.model.Meteo;

@Service
public class MeteoServiceImpl implements MeteoService
{
	@Autowired
	MeteoDao meteoDao;


	@Override
	public void salvaMeteo(MeteoDTO meteo) 
	{
		Meteo meteoM = new Meteo();
		
		meteoM.setTemperatura(meteo.getTemperatura());
		meteoM.setDescrizione(meteo.getDescrizione());
		meteoM.setCitta(meteo.getCitta());
		meteoM.setTemperaturaMin(meteo.getTemperaturaMin());
		meteoM.setTemperaturaMax(meteo.getTemperaturaMax());
		meteoM.setUmidita(meteo.getUmidita());
		
		meteoDao.save(meteoM);
	}


}

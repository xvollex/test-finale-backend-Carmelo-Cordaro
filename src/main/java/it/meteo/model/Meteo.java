package it.meteo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "meteo")
public class Meteo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_M")
	private int id;
	
	@Column(name = "temperatura")
	private double temperatura;
	
	@Column(name = "descrizione")
	private String descrizione;
	
	@Column(name = "citta")
	private String citta;
	
	@Column(name = "temperatura_max")
	private double temperaturaMax;
	
	@Column(name = "temperatura_min")
	private double temperaturaMin;
	
	@Column(name = "umidita")
	private int umidita;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getTemperatura() {
		return temperatura;
	}
	public void setTemperatura(double temperatura) {
		this.temperatura = temperatura;
	}
	public double getTemperaturaMax() {
		return temperaturaMax;
	}
	public void setTemperaturaMax(double temperaturaMax) {
		this.temperaturaMax = temperaturaMax;
	}
	public double getTemperaturaMin() {
		return temperaturaMin;
	}
	public void setTemperaturaMin(double temperaturaMin) {
		this.temperaturaMin = temperaturaMin;
	}

	public String getCitta() {
		return citta;
	}
	public void setCitta(String citta) {
		this.citta = citta;
	}
	public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	public int getUmidita() {
		return umidita;
	}
	public void setUmidita(int umidita) {
		this.umidita = umidita;
	}

	

}

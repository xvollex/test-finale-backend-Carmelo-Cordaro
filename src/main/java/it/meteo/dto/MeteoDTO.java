package it.meteo.dto;

public class MeteoDTO 
{
	private double temperatura;
	private String descrizione;
	private String citta;
	private double temperaturaMax;
	private double temperaturaMin;
	private int umidita;
	
	public String getCitta() {
		return citta;
	}
	public void setCitta(String citta) {
		this.citta = citta;
	}
	public double getTemperatura() {
		return temperatura;
	}
	public void setTemperatura(double temperatura) {
		this.temperatura = temperatura;
	}
	public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
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
	public int getUmidita() {
		return umidita;
	}
	public void setUmidita(int umidita) {
		this.umidita = umidita;
	}
	
	
}

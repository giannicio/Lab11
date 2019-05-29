package it.polito.tdp.bar.model;

import java.time.Duration;

public class Evento implements Comparable<Evento> {
	
	private Duration minuto; // in minuti, quando si verifica l'evento
	private Duration durata; // tra 60 e 120 minuti
	private int num_Persone; // num persone del gruppo che vogliono sedersi da 1 a 10
	private float tolleranza;
	private Tipo tipo;
	
	public Evento(Duration minuto, Duration durata, int num_Persone, float tolleranza, Tipo tipo) {
		super();
		this.minuto = minuto;
		this.durata = durata;
		this.num_Persone = num_Persone;
		this.tolleranza = tolleranza;
		this.tipo = tipo;
	}

	public enum Tipo {
		GRUPPO_ARRIVA,
		GRUPPO_ABBANDONA
	}
	public Duration getminuto() {
		return minuto;
	}

	public void setminuto(Duration minuto) {
		this.minuto = minuto;
	}

	public Tipo getTipo() {
		return tipo;
	}

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}

	public Duration getDurata() {
		return durata;
	}

	public void setDurata(Duration durata) {
		this.durata = durata;
	}

	public int getNum_Persone() {
		return num_Persone;
	}

	public void setNum_Persone(int num_Persone) {
		this.num_Persone = num_Persone;
	}

	public float getTolleranza() {
		return tolleranza;
	}

	public void setTolleranza(float tolleranza) {
		this.tolleranza = tolleranza;
	}

	@Override
	public int compareTo(Evento o) {
		// TODO Auto-generated method stub
		return this.minuto.compareTo(o.getminuto());
	}
	
	
}

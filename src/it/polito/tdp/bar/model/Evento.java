package it.polito.tdp.bar.model;

import java.time.Duration;
import java.time.LocalTime;

public class Evento {
	
	private LocalTime time; // in minuti, quando si verifica l'evento
	private Duration durata; // tra 60 e 120 minuti
	private int num_Persone; // num persone del gruppo che vogliono sedersi da 1 a 10
	private float tolleranza;
	
}

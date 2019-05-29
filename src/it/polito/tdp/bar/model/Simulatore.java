package it.polito.tdp.bar.model;

import java.time.Duration;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Random;

import it.polito.tdp.bar.model.Evento.Tipo;

public class Simulatore {
	
	public Simulatore() {

	}
	// PRIORITY QUEUE
	private PriorityQueue<Evento> queue = new PriorityQueue<>();
	
	// STATO DEL MONDO
	private Duration minutoInizio;
	private Duration intervalloArrivo; // OGNI QUANTO ARRIVA UN NUOVO GRUPPO
	private Duration minuto; // A CHE MINUTO ARRIVA UN NUOVO GRUPPO
	private Duration durata;
	private int numPersone; // QUANTE PERSONE CI SONO NEL GRUPPO
	private Float tolleranza;
	private HashMap<Integer, Integer> tMap;
	private Random random = new Random();
	
	// STATISTICHE
	private int TOT_CLIENTI;
	private int TOT_SODDISFATTI;
	private int TOT_INSODDISFATTI;
	
	private int NUM_TAVOLI_10;
	private int NUM_TAVOLI_8;
	private int NUM_TAVOLI_6;
	private int NUM_TAVOLI_4;
	private int NUM_EVENTI;
	
	// VARIABILI INTERNE
	private int i;
	
	public void init() {
		this.NUM_TAVOLI_10 = 2;
		this.NUM_TAVOLI_8 = 4;
		this.NUM_TAVOLI_6 = 4;
		this.NUM_TAVOLI_4 = 5;
		
		this.TOT_SODDISFATTI = 0;
		this.TOT_INSODDISFATTI = 0;
		this.TOT_CLIENTI = 0;
		
		this.NUM_EVENTI = 2000;
		
		tMap = new HashMap<Integer, Integer>();
		this.tMap.put(NUM_TAVOLI_10, 2);
		this.tMap.put(NUM_TAVOLI_8, 4);
		this.tMap.put(NUM_TAVOLI_6, 4);
		this.tMap.put(NUM_TAVOLI_4, 5);
		
		this.minutoInizio = Duration.ofMinutes(0);

		// INSERISCO NELLA CODA 2000 EVENTI
		for(int i = 1; i <= NUM_EVENTI; i++) {
			// OGNI VOLTA CHE AGGIUNGO UN VENTO TENGO TRACCIA DEL MINUTO A CUI SONO ARRIVATO
			minutoInizio = minutoInizio.plus(Duration.ofMinutes(1 + random.nextInt(10)));
			// TUTTI I RANDOM VANNO GENERATI NEL FOR
			this.durata =  Duration.ofMinutes(60 + random.nextInt(61));
			this.numPersone = 1 + random.nextInt(10);
			this.tolleranza = random.nextFloat();
			Evento e = new Evento(minutoInizio, durata, numPersone, tolleranza, Evento.Tipo.GRUPPO_ARRIVA);
			queue.add(e);
			System.out.println(i+" "+e.getTipo()+" "+minutoInizio+" "+durata+" "+numPersone+" "+tolleranza);
		}
		
	}
	
	public void run() {
		while(!queue.isEmpty()) {
			Evento e = queue.poll();
			switch(e.getTipo()) {
			
			case GRUPPO_ARRIVA:
				int numerositaGruppo = e.getNum_Persone();
				float tolleranza = e.getTolleranza();
				float prob = random.nextFloat();
				for(int i = 4; i <= 10; i++) {
					if() { // SE C'E' POSTO 
						
					}
					else {  // SE NON C'E' POSTO
						if(tolleranza >= prob) { // GRUPPO TOLLERANTE --> BANCONE
							TOT_SODDISFATTI++;
						}
						else { // GRUPPO NON TOLLERANTE --> INSODDISFATTI
							TOT_INSODDISFATTI++;
						}
					}
				}
				
			break;
			
			case GRUPPO_ABBANDONA:
				
			break;
			
			}
		}
	}
	
	public void simula() {
		
	}
	
}

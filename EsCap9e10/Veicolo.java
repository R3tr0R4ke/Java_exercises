package EsCap9e10;

import java.util.Calendar;

public abstract class Veicolo {

	private String modello;
	private int annoProduzione;
	private final int annoCorrente = Calendar.getInstance().get(Calendar.YEAR);
	
	//Costruttore
	public Veicolo (String modello, int annoProduzione) {
		if (annoProduzione < 1950 || annoProduzione > annoCorrente) {
			throw new IllegalArgumentException("Anno produzione deve essere > 1950 o <= anno corrente");
		}
		this.modello = modello;
		this.annoProduzione = annoProduzione;
	}
	
	//Restituisce il nome del modello in formato stringa
	public String getModello() {
		return modello;
	}
	
	//Imposta il modello
	public void setModello(String modello) {
		this.modello = modello;
	}
	
	//Restituisce l'anno di produzione
	public int getAnnoProduzione() {
		return annoProduzione;
	}
	
	//Imposta l'anno di produzione
	public void setAnnoProduzione(int annoProduzione) {
		if (annoProduzione < 1950 || annoProduzione > annoCorrente) {
			throw new IllegalArgumentException("Anno produzione deve essere > 1950 o <= anno corrente");
		}
		this.annoProduzione = annoProduzione;
	}
	
	@Override
	public String toString() {
		return String.format("%s : %s%n%s : %s%n", "Modello", getModello(), "Anno produzione", getAnnoProduzione());
	}
	
	//Metodo astratto da implementare nelle sottoclassi concrete
	public abstract String suonaClacson();	//Nessuna implementazione
}
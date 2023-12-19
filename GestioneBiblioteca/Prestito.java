package GestioneBiblioteca;

import java.time.LocalDate;

public class Prestito{
	private Utente utente;
	private Libro libro;
	private LocalDate dataPrestito;
	private LocalDate dataRiconsegna;
	
	//Costruttore di default
	public Prestito() {
		
	}

	//Costruttore con parametri
	public Prestito(Utente utente, Libro libro, LocalDate dataPrestito, LocalDate dataRiconsegna) {
		this.utente = utente;
		this.libro = libro;
		this.dataPrestito = dataPrestito;
		this.dataRiconsegna = dataRiconsegna;
	}
	
	//Getters:
	public LocalDate getDataPrestito() {
		return dataPrestito;
	}
	
	public LocalDate getDataRiconsegna() {
		return dataRiconsegna;
	}
	
	//Setters:
	public void setUtente(Utente utente) {
		this.utente = utente;
	}
	
	public void setLibro(Libro libro) {
		this.libro = libro;
	}
	
	public void setDataPrestito(LocalDate dataPrestito) {
		this.dataPrestito = dataPrestito;
	}
	
	public void setDataRiconsegna(LocalDate dataRiconsegna) {
		this.dataRiconsegna = dataRiconsegna;
	}
	
	//Validators:
	public boolean isValidDataPrestito(String dataPrestito) {
		return dataPrestito.matches("\\d{2}-\\d{2}-\\d{4}");
	}
	
	public boolean isValidDataRiconsegna(String dataRiconsegna) {
		return dataRiconsegna.matches("\\d{2}-\\d{2}-\\d{4}");
	}

	//Controlla la disponibilità del libro
	public boolean isLibroDisponibile() {
		return libro.getStato() == Libro.Stato.DISPONIBILE;
	}		//Omesso in quanto ho usato enum e non delle stringhe	
}
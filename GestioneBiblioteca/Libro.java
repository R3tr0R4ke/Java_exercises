package GestioneBiblioteca;

import java.io.Serializable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Libro implements Serializable{
	private String titolo;
	private String autore;
	private String isbn;
	private static final long serialVersionUID = 1L;
	
	public enum Stato {
		IN_PRESTITO,
		DISPONIBILE;
	}
	
	private Stato stato;
	
	//Costruttore vuoto
	public Libro() {
		this("", "", "", Stato.DISPONIBILE);
	}
	
	//Costruttore libro
	public Libro(String titolo, String autore, String isbn, Stato stato) {
		this.titolo = titolo;
		this.autore = autore;
		this.isbn = isbn;
		this.stato = stato;
	}
	
	//Getters:
	public String getTitolo() {
		return titolo;
	}
		
	public String getAutore() {
		return autore;
	}
		
	public String getIsbn() {
		return isbn;
	}
	
	public Stato getStato() {
		return stato;
	}
	
	//Setters:
	public void setTitolo(String titolo) {
		Pattern expression = Pattern.compile("^[A-Za-z0-9\\s\\.,!?'-]+$");
		Matcher matcher = expression.matcher(titolo);	//Confronta la stringa con espressione regolare
		
		if(matcher.matches()) {
			this.titolo = titolo;
		}
		else {
			System.err.println("Errore inserimento; Si prega di inserire una stringa corretta%n"
					+ "Es.: Alberelli Rotti (occhio alle maiuscole e ai caratteri speciali)%n");
		}
	}
	
	public void setAutore(String autore) {
		Pattern expression = Pattern.compile("^[A-Z]\\w{1}[a-zA-Z]*\\s[a-zA-Z]\\w*+$");
		Matcher matcher = expression.matcher(autore);
		
		if(matcher.matches()) {
			this.autore = autore;
		}
		else {
			System.err.println("Errore inserimento; Si prega di inserire una stringa corretta%n"
					+ "Es.: Arturo Bagliocchi (occhio alle maiuscole e ai caratteri speciali)%n");
		}
	}
	
	public void setISBN(String isbn) {
		Pattern expression = Pattern.compile("[1-9]\\\\d{3}-[1-9]\\\\d{1}-[1-9]\\\\d{2}-[1-9]\\\\d{6}-[1-9]\\\\d{1}");
		Matcher matcher = expression.matcher(isbn);
		
		if(matcher.matches()) {
			this.isbn = isbn;
		}
		else {
			System.err.println("Errore inserimento; Si prega di inserire una stringa corretta%n"
					+ "Es.: 978-3-16-148410-0 (Inserire num caratteri come nell'esempio)%n");
		}
	}
	
	public void setStato(Stato stato) {
		this.stato = stato;
	}
	
	//Validators:
	public static boolean isValidTitolo(String titolo) {
		return titolo.matches("^[A-Za-z0-9\s\\.,'\\-]+$");
	}
		
	public static boolean isValidAutore(String autore) {
		return autore.matches("[A-Z][a-zA-Z]*");
	}
		
	public static boolean isValidISBN(String isbn) {
		return isbn.matches("^\\d{3}-\\d-\\d{2}-\\d{6}-\\d$");
	}
	
	//Altri metodi
	public void modificaTitolo(String titolo) {
		Pattern expression = Pattern.compile("^[A-Za-z0-9\\s\\.,!?'-]+$");
		Matcher matcher = expression.matcher(titolo);	//Confronta la stringa con espressione regolare
		
		if(matcher.matches()) {
			this.titolo.replace(this.titolo, titolo);
		}
		else {
			System.err.println("Errore inserimento; Si prega di inserire una stringa corretta%n"
					+ "Es.: Titolo Libro (occhio alle maiuscole e ai caratteri speciali)%n");
		}
	}
	
	@Override
    public String toString() {
        return "Titolo: " + titolo + ", Autore: " + autore + ", ISBN: " + isbn;
    }
	
}

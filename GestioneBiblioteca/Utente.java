package GestioneBiblioteca;

import java.util.ArrayList;
import java.util.List;

public class Utente {
	private String nome;
	private String email;
	private String idUtente;
	private ArrayList<Libro> libriInPrestito;
	
	//Costruttore con valori di default
	public Utente() {
		this("", "", "", new ArrayList<Libro>());
	}
	
	public Utente(String nome, String email, String idUtente, ArrayList<Libro> libriInPrestito) {
		this.nome = nome;
		this.idUtente = idUtente;
		this.email = email;
		this.libriInPrestito = new ArrayList<>();
	}
	
	//Metodo aggiungiLibro
	public void addLibroInPrestito(Libro libroInPrestito) {
		libriInPrestito.add(libroInPrestito);
	}
	
	//Metodo rimuoviLibro
	public void removeLibroInPrestito(Libro liboInPrestito) {
		libriInPrestito.remove(liboInPrestito);
	}
	
	//Getters:
	public String getNome() {
		return nome;
	}
	
	public String getEmail() {
		return email;
	}
	
	public String getIdUtente() {
		return idUtente;
	}
	
	public ArrayList<Libro> getLibriInPrestito(){
		return libriInPrestito;
	}
		
	//Setters:
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public void setIdUtente(String idUtente) {
		this.idUtente = idUtente;
	}
	
	//Validators:
	public boolean isValidNome(String nome) {
		return nome.matches("^[A-Z]{1}[a-z]+\\s*[a-zA-Z]?[a-z]*");
	}
	
	public static boolean isValidEmail(String email) {
		return email.matches("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Z|a-z]{2,}$");
	}
	
	public boolean isValidIdUtente(String idUtente) {
		return idUtente.matches("[0-9]\\d+");
	}
	
	//Controllo per univocità attributi utente:
	public boolean isNomePresent(String nome, List<Utente> utentiRegistratiList) {
		for(Utente utente : utentiRegistratiList) {
			if (nome.equals(utente.getNome())) {
				return true;
			}
		}
		return false;
	}
	
	public boolean isEmailPresent(String email, List<Utente> utentiRegistratiList) {
		for(Utente utente : utentiRegistratiList) {
			if(email.equals(utente.getEmail())) {
				return true;
			}
		}
		return false;
	}
	
	public boolean isIdUtentePresent(String idUtente, List<Utente> utentiRegistratiList) {
		for(Utente utente : utentiRegistratiList) {
			if(idUtente.equals(utente.getIdUtente())) {
				return true;
			}
		}	
		return false;
	}
}
package GestioneBiblioteca;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javax.xml.bind.JAXB;

import GestioneBiblioteca.Libro.Stato;

public class Biblioteca{
	private List<Libro> catalogo;
	
	
	//Costruttore default
	public Biblioteca() {
		this(new ArrayList<Libro>());
	}
	
	public Biblioteca(List<Libro> catalogo) {
		this.catalogo = catalogo;
	}
	
	//GetCatalogo
	public List<Libro> getCatalogo(){
		return catalogo;
	}
	
	//Salva dati in un file .txt
	public static void salvaStato(String nomeFile, List<Libro> libriList) {
		try(BufferedWriter writer = new BufferedWriter(new FileWriter(nomeFile))){
			for (Libro libro : libriList) {
				writer.write(libro.getTitolo() + "," + libro.getAutore() + "," + libro.getIsbn() + "," + libro.getStato() + "\n");
			}
			
			System.out.printf("Stato salvato con successo su %s%n%n", nomeFile);
		}
		catch (IOException e) {
			System.err.println("Errore durante il salvataggio dello stato su file: " + e.getMessage());
		}
	}
	
	//Leggi dati da un file .txt
	public void leggiStato(String nomeFile) {
		try(BufferedReader reader = new BufferedReader(new FileReader(nomeFile))){
			String line;
			while((line = reader.readLine()) != null) {
				//Dividi la riga in base ai dati del libro
				String[] datiLibro = line.split(",");
				//Crea un nuovo libro e aggiungilo al catalogo
				catalogo.add(new Libro(datiLibro[0], datiLibro[1], datiLibro[2], Libro.Stato.valueOf(datiLibro[3])));
			}
		}
		catch (IOException | IllegalArgumentException e) {
			System.err.println("Errore durante il caricamento dello stato da file: " + e.getMessage());
		}
		
		for(Libro libro : catalogo) {
			System.out.println(libro);
		}
	}
	
	//Permette di scrivere oggetti:
	public static void salvaObjectOutputStream() {
		String filePath = "provaObject.ser";
		Scanner myInput = new Scanner(System.in);
		
		try(FileOutputStream fileOutputStream = new FileOutputStream(filePath)){
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
			
			String titolo, autore, isbn;
			
			do {
				System.out.printf("Inserisci il titolo: ");
				titolo = myInput.nextLine();
				
				if(Libro.isValidTitolo(titolo) == false) {
					System.err.printf("Il titolo non rispetta l'espressione regolare");
					System.out.printf("%n%n");
				}
			}
			while(Libro.isValidTitolo(titolo) == false);
			
			do {
				System.out.printf("Inserisci l'autore: ");
				autore = myInput.nextLine();
				
				if(Libro.isValidAutore(autore) == false) {
					System.err.printf("Nome dell'autore inserito non rispetta espressione regolare");
					System.out.printf("%n%n");
				}
			}
			while(Libro.isValidAutore(autore) == false);																			
											
			do{
				System.out.printf("Inserisci l'isbn: ");
				isbn = myInput.nextLine();
							
				if(Libro.isValidISBN(isbn) == false) {
					System.err.printf("L'ISBN inserito non rispetta l'espressione regolare");
					System.out.printf("%n%n");
				}
				else {
					System.out.printf("Dati oggetto inseriti correttamente%n%n");
				}
			}
			while(Libro.isValidISBN(isbn) == false);																	
						
			//Crea un oggetto da serializzare:
			Libro libro = new Libro(titolo, autore, isbn, Stato.DISPONIBILE);
			
			//Scrivi l'oggetto serializzato nello stream di output
			objectOutputStream.writeObject(libro);
			
			System.out.println("Oggetto serializzato con successo.");
			
			objectOutputStream.close();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static List<Libro> caricaObjectInputStream (String filePath, List<Libro> libList){
		try(FileInputStream fileInputStream = new FileInputStream(filePath)){
			ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
			
			while(true) {
				try {
					//Leggi l'oggetto serializzato dallo stream di input
					Object obj= objectInputStream.readObject();
					
					//Se l'oggetto è null, indica la fine del file
					if(obj == null) {
						break;
					}
					
					//Cast dell'oggetto a un tipo conosciuto
					if(obj instanceof Libro) {
						Libro libro = (Libro) obj;
						//System.out.println("Oggetto deserializzato: " + libro);
						libList.add(libro);	//Aggiungo il libro alla lista
					}
					else {
		                System.out.println("Tipo di oggetto non atteso.");
		            }
				}
				catch(EOFException e) {
					break;	//Arrivati alla fine del fine, esci
				}
				catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
			}
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		
		return libList;
	}
	
	//Controlla che la stringa inserita termini con ".txt"
	public static boolean isValidFileTxt(String nomeFile) {
		return nomeFile.matches("^\\w+\\.txt$");
	}
	
	
	public static boolean isValidNameFileObjectStream(String nomeFile) {
		return nomeFile.matches("^\\w+\\.ser$");
	}
	
	public static boolean isValidNameFileXML(String nomeFile) {
		return nomeFile.matches("^\\w+\\.xml$");
	}
}
package GestioneBiblioteca;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import GestioneBiblioteca.Libro.Stato;

public class Menu {

	public static void main(String[] args) {
		List<Utente> utentiRegistratiList = new ArrayList<>();
		List<Libro> libriList = new ArrayList<>();
		
		System.out.printf("Sistema di gestione Biblioteca%n%n");
		
		boolean isEsci = false;
		boolean isLogged = false;
		
		//Popolo la libreria con dei libri
		//Creo oggetti per popolare la libreria
		Libro lib1 = new Libro("CaccaPupu", "Freud", "978-3-16-148410-0", Stato.DISPONIBILE);
		Libro lib2 = new Libro("Ciccio", "Andre", "324-2-43-234354-5", Stato.DISPONIBILE);
		Libro lib3 = new Libro("CaccaPupu2", "Antonio", "324-2-43-234354-4", Stato.IN_PRESTITO);
		
		libriList.add(lib1);
		libriList.add(lib2);
		libriList.add(lib3);
		
		Prestito prestaLibro = new Prestito();	//Oggetto Prestito, utile per date di prestito e riconsegna
		Prestito restituisciLibroPrestito = new Prestito();
		
		//Crea oggetto biblioteca:
		Biblioteca catalogoLibri = new Biblioteca();
		
		//Creo client solo per test, levalo poi
		Utente fede = new Utente("Fede", "fede@gmail.com", "123", null);
		utentiRegistratiList.add(fede);
		
		Scanner myInt = new Scanner(System.in);	//Scanner per input utente
		String loggedEmail = "fede@gmail.com"; //Mi è utile per il prestito del libro
		
		do {
			System.out.printf("Seleziona un'opzione:%n"
					+ "1)Registra Utente%n"
					+ "2)Login Utente%n"
					+ "3)Cerca Libro%n"
					+ "4)Effetua Prestito%n"
					+ "5)Restituisci Libro%n"
					+ "6)Salva Dati%n"
					+ "7)Carica Dati%n"
					+ "8)Stampa libreria%n"
					+ "9)Esci%n");
			
			int scelta = 0;
			
			do {
				try {
					System.out.printf("Inserisci il numero dell'opzione: ");
					scelta = myInt.nextInt();
					System.out.printf("%n");
						
					if(scelta < 1 || scelta > 9) {	//Controllo che l'utente abbia inserito il giusto numero
						throw new IllegalArgumentException("Il numero deve essere comprenso tra 1 e 9");
					}
				}
				catch (InputMismatchException e) {
					myInt.nextLine();
					System.out.printf("%n");
					System.err.printf("Inserisci un umero, non una lettera!");
					System.out.printf("%n%n");
				}
				catch (IllegalArgumentException e) {
					myInt.nextLine();
					System.err.printf("%s%n%n", e.getMessage());
				}
			}
			while(scelta < 1 || scelta > 9);
			
			switch (scelta) {
				//Registra utente
				case 1:
					Utente user = new Utente();	//Creo oggetto con valori di default
					Scanner myStrings = new Scanner(System.in);
					String nome, email, idUtente;
					boolean isAlreadyPresent = false;
					
					//Inserimento nome
					do {
						isAlreadyPresent = false;
						System.out.printf("Inserisci il nome utente: ");
						nome = myStrings.nextLine();
						
						if(user.isValidNome(nome) == false) {
							System.err.printf("Il nome inserito non è un nome, prego ritenta");
							System.out.printf("%n");
						}
						else if (user.isNomePresent(nome, utentiRegistratiList)) {
							System.err.printf("Il nome inserito è gia presente, prego reinserire un altro nome");
							System.out.printf("%n");
							isAlreadyPresent = true;
						}
					}
					while(!(user.isValidNome(nome)) || isAlreadyPresent);
					user.setNome(nome);
					
					//Inserimento email
					do {
						isAlreadyPresent = false;
						System.out.printf("Inserisci l'email: ");
						email = myStrings.nextLine();
						
						if(Utente.isValidEmail(email) == false) {
							System.err.printf("L'email inserita non rispetta il formato delle mail, prego reinserire");
							System.out.printf("%n");
						}
						else if (user.isEmailPresent(email, utentiRegistratiList)) {
							System.err.printf("L'email inserita è attualmente non disponibile, prego reinserire l'email");
							System.out.printf("%n");
							isAlreadyPresent = true;
						}
					}
					while(!(Utente.isValidEmail(email)) || isAlreadyPresent);
					user.setEmail(email);
					
					//Inserimento idUtente
					do {
						isAlreadyPresent = false;
						System.out.printf("Inserisci l'idUtente: ");
						idUtente = myStrings.nextLine();
						
						//Controllo input corretto:
						if(user.isValidIdUtente(idUtente) == false) {
							System.err.printf("L'idUtente inserito non corrisponde a un codice numerico, prego reinserire");
							System.out.printf("%n");
						}
						else if(user.isIdUtentePresent(idUtente, utentiRegistratiList)){
							System.err.printf("Il codice utente risulta già registrato, prego reinserire un'altro codice");
							System.out.printf("%n");
							isAlreadyPresent = true;
						}
					} 
					while (!(user.isValidIdUtente(idUtente)) || isAlreadyPresent);
					user.setIdUtente(idUtente);
					
					utentiRegistratiList.add(user);
					System.out.printf("%nUtente registrato correttamente%n%n");
				break;
				
				//Login Utente
				case 2:
					Scanner myLogin = new Scanner(System.in);
					do {
						isLogged = false;
						System.out.printf("Per effettuare il login inserire l'email: ");
						String tmpEmail = myLogin.nextLine();
						
						if(Utente.isValidEmail(tmpEmail) == false) {
							System.err.printf("La mail inserita non rispetta il formato mail, prego reinserire email:");
							System.out.printf("%n");
						}
						
						if(utentiRegistratiList.isEmpty()) {
							System.err.printf("Registrare prima almeno un utente");
							System.out.printf("%n%n");
							isLogged = true;
							break;
						}
						
						for(Utente utente : utentiRegistratiList) {
							if(tmpEmail.equals(utente.getEmail())) {
								System.out.printf("%nLogin avvenuto!!!%nBenvenuto %s%n%n", utente.getNome());
								isLogged = true;
								loggedEmail = tmpEmail;
								break;
							}
						}
					}
					while(isLogged == false);
				break;
					
				//Cerca Libro
				case 3:
					boolean isCercato;
					Scanner mySceltaCerca = new Scanner(System.in);
					Scanner myTitolo = new Scanner(System.in);
					Scanner myIsbnInput = new Scanner(System.in);
					
					do {	//Menu richiesta inserimento opzione ricerca
						isCercato = false;
							
						int sceltaCerca = 0;
						System.out.printf("Scegli come cercare il libro:%n"
								+ "1)Inserisci titolo%n"
								+ "2)Inserisci ISBN%n"
								+ "3)Torna indietro%n");
						
						do {	
							try {	//Controllo di inserimento in input corretto
								System.out.printf("Inserisci numero dell'opzione: ");
								sceltaCerca = mySceltaCerca.nextInt();
								System.out.printf("%n");
								
								if(sceltaCerca < 1 || sceltaCerca > 3) {
									throw new IllegalArgumentException("Il numero deve essere comprenso tra 1 e 3");
								}
							}
							catch (InputMismatchException e) {		//Cattura inserimento lettera per sbaglio
								System.out.printf("%n");
								System.err.printf("Inserisci un numero, non una lettera!");
								System.out.printf("%n%n");
								mySceltaCerca.nextLine();	//Pulisce il buffer
							}
							catch (IllegalArgumentException e) {	//Cattura numero fuori dal range 1-3
								System.err.printf("%s%n%n", e.getMessage());
							}
						}
						while(scelta < 1 || scelta > 3);
						
						if(sceltaCerca == 1) {		//Cerca libro tramite titolo
							boolean isLibroTrovato;
							
							do {
								isLibroTrovato = false;
								
								for(int i = 0; i <= 2; i++) {	//L'utente ha 3 trentativi per trovare il libro
									System.out.printf("Inserisci titolo del libro: ");
									String tmpTitolo = myTitolo.nextLine();
									
									if(Libro.isValidTitolo(tmpTitolo)) {	//Se il titolo inserito è valido
										for(Libro libro : libriList) {	//Cerco nella lista libri
											if(tmpTitolo.equals(libro.getTitolo())) {	//Se trovo il libro con il titolo inserito
												System.out.printf("-Titolo: %s%n-Autore: %s%n-ISBN: %s%n-Stato: %s%n%n",	//Stampo il libro
														libro.getTitolo(), libro.getAutore(), libro.getIsbn(), libro.getStato());
												isLibroTrovato = true;
												break;
											}
										}
									}
									else {
										System.out.printf("Nessun libro trovato con il titolo %s%n", tmpTitolo);
									}
									
									if(isLibroTrovato) {
										break;
									}
									
									if(i == 2) {
										System.out.printf("%nTentativi ricerca esauriti%nTorno indietro...%n%n");
										isLibroTrovato = true;
										break;
									}
								}
							}
							while(isLibroTrovato == false);
						}
						else if (sceltaCerca == 2) {	//Cerca libro tramite ISBN
							boolean isLibroTrovato;
							
							do {
								isLibroTrovato = false;
								
								for(int i = 0; i <= 2; i++) {		//L'utente ha 3 trentativi per trovare il libro
									System.out.printf("%nInserisci l'ISBN del libro: ");
									String tmpIsbn = myIsbnInput.nextLine();
									if(Libro.isValidISBN(tmpIsbn)) {	//Se ISBN inserito è valido
										for(Libro libro : libriList) {	//Cerco nella lista dei libri
											if(tmpIsbn.equals(libro.getIsbn())) {	//Se trovo il libro con l'ISBN inserito
												System.out.printf("-Titolo: %s%n-Autore: %s%n-ISBN: %s%n-Stato: %s%n%n",	//Stampo il libro
														libro.getTitolo(), libro.getAutore(), libro.getIsbn(), libro.getStato());
												isLibroTrovato = true;
												break;
											}
										}
									}
									else {
										System.out.printf("Nessun libro trovato con l'ISBN %s%n", tmpIsbn);
									}
									
									if (isLibroTrovato) {	//Se il libro è stato trovato
										break;
									}
									
									if(i == 2) {	//Altrimenti torno nel menu di richiesta opzione ricerca
										System.out.printf("%nTentativi ricerca esauriti%nTorno indietro...%n%n");
										isLibroTrovato = true;
										break;
									}
								}
							}
							while(isLibroTrovato == false);
						}
						else if (sceltaCerca == 3) {	//Torna indietro nel menu principale
							System.out.printf("%nTorno nel menu principale...%n%n");
							isCercato = true;
						}
					}
					while(isCercato == false);
				break;
				
				//Effetua Prestito
				case 4:
					Scanner myTitoloScanner = new Scanner(System.in);
					if (isLogged == true) {	//Prima di effettuare il prestito assicurati che l'utente sia loggato
						boolean isPrestato;	//Permette di uscire dal do-while
						int tentativiTitolo = 0;	//Permette di uscire dalle iterazioni dei for-each
						
						
						do {
							isPrestato = false;

							System.out.printf("Quale libro vuoi prendere in prestito?%n");
							for(Libro libro : libriList) {
								System.out.printf("-%s\t\tStato: %s%n", libro.getTitolo(), libro.getStato());	//Stampo titolo dei libri
							}
							
							System.out.printf("Inserisci il titolo del libro che vuoi prendere: ");
							String tmpTitolo = myTitoloScanner.nextLine();
							System.out.printf("%n");
							
							if(Libro.isValidTitolo(tmpTitolo)) {	//Se l'input rispetta l'espressione regolare dei titoli
								boolean isLibroPresente = false;
								
								for (Libro libro : libriList) {	//Cerco nella libreria
						            if (tmpTitolo.equals(libro.getTitolo())) {	//Se titolo inserito equivale a libro presente
						                isLibroPresente = true;
			                        	prestaLibro.setLibro(libro);	//Assegno il libro all'oggetto prestito

						                if (prestaLibro.isLibroDisponibile()) {
						                    for (Utente utente : utentiRegistratiList) {	//Accedo agli utenti
						                        if (loggedEmail.equals(utente.getEmail())) {	//Accedo a un utente specifico
						                            prestaLibro.setUtente(utente);	//Assegno l'utente al prestito
						                            
						                            //Ottengo la data corrente
						                            LocalDate dataCorrente = LocalDate.now();	//Ottiene la data corrente
						                            prestaLibro.setDataPrestito(dataCorrente);	//Assegno la data corrente all'oggetto
						                            
						                        	utente.addLibroInPrestito(libro);	//Presto il libro all'utente
						                            libro.setStato(Stato.IN_PRESTITO);	//Aggiorno lo stato del libro
						                            isPrestato = true;
						                            break;
						                        }
						                    }
						                } else if (libro.getStato() == Stato.IN_PRESTITO) {	//Se il libro non è disponibile
						                    System.out.printf("Il libro non è attualmente disponibile!%n%n");
						                    tentativiTitolo++;
						                }
						                break; // Esci dal ciclo Libro dopo aver trattato un libro specifico
						            }
						        }
								
								if (!isLibroPresente ) {	//Se il libro non si trova nella libreria
									System.out.printf("Titolo inserito non presente nella libreria!%n%n");
									tentativiTitolo++;
								}	
								
								if(tentativiTitolo == 3) {
									System.out.printf("Hai usato troppi tentativi, ritorna in questo menu a breve%n%n");
									break;
								}
							}
						}
						while(isPrestato == false);
						
						//Stampa il libri che ha un utente
						if (isPrestato) {
    						for (Utente utente : utentiRegistratiList) {
        						if (loggedEmail.equals(utente.getEmail())) {
            						System.out.printf("-Nome: %s%n-Libri in prestito:%n", utente.getNome());
            						for (Libro libro : utente.getLibriInPrestito()) {
            							//Restituisco il nome del libro e la data del prestito
                						System.out.printf("  -%s\tData prestito: %s%n", libro.getTitolo(), prestaLibro.getDataPrestito());
            						}
            						System.out.println();
        						}
    						}
						}
					}
					else {	//Altrimenti avvisa di loggare e torna al menu principale
						System.err.printf("Devi prima fare il login per poter prendere in prestito un libro");
						System.out.printf("%n%n");
					}
				break;
				
				//Restituisci libro
				case 5:
					Scanner titRestScanner = new Scanner(System.in);
					if(isLogged == true) {
						boolean isRestituito = false;
						int tentativiTitolo = 0;	//Permette di uscire dalle iterazioni dei for-each
						
						do {
							System.out.printf("Quale libro desideri restituire?%n");
							//Accedo ai libri dell'utente:
							for(Utente utente : utentiRegistratiList) {
								if(loggedEmail.equals(utente.getEmail())) {
									if(utente.getLibriInPrestito().isEmpty()) {
										System.out.printf("L'utente non ha preso in prestito alcun libro%nTorno al menu principale...%n%n");
										isRestituito = true;
										break;
									}
									else {
										System.out.printf("-Nome: %s%n-Libri in prestito:%n", utente.getNome());
										for(Libro libro : utente.getLibriInPrestito()) {
	                						System.out.printf("  -%s\tData prestito: %s%n", libro.getTitolo(), prestaLibro.getDataPrestito());
										}
										System.out.println();
										
										//Richiesta dell'input:
										System.out.printf("Inserisci il titolo del libro da restituire: ");
										String titoloRestituisci = titRestScanner.nextLine();
										
										//Verifica se il libro è presente:
										boolean libroTrovato = false;
										for(Libro libro : utente.getLibriInPrestito()) {
											if(libro.getTitolo().equalsIgnoreCase(titoloRestituisci)) {
												System.out.printf("Libro restituito con successo!!%nTorno al menu principale...%n%n");
												
												utente.removeLibroInPrestito(libro);	//Rimuovo il libro dalla lista dell'utente
												libro.setStato(Stato.DISPONIBILE);
												
					                            LocalDate dataCorrente = LocalDate.now();	//Ottiene la data corrente
					                            restituisciLibroPrestito.setDataRiconsegna(dataCorrente);	//Assegno la data corrente all'oggetto
					                            
												libroTrovato = true;
												isRestituito = true;
												break;
											}
										}
										
										if(!libroTrovato) {
											System.out.printf("Libro non trovato. Prego ritenta%n%n");
											tentativiTitolo++;
											if(tentativiTitolo == 3) {
												System.err.printf("Hai usato troppi tentativi, ritorna in questo menu a breve");
												System.out.printf("%n%n");
												isRestituito = true;
												break;
											}
										}
										else {
											break;
										}
									}	
								}	
							}
						}
						while(isRestituito == false);
					}
					else {
						System.err.printf("Bisogna prima loggare per poter restituire un libro");
						System.out.printf("%n%n");
					}	
				break;
				
				//Salva dati
				case 6:
					Scanner mySalvataggioScelta = new Scanner(System.in);
					boolean isScelto = false;
					
					do {
						int sceltaSalva = 0;
						System.out.printf("Come desideri salvare i dati?%n"
								+ "1) File txt%n"
								+ "2) File xml%n"
								+ "3) ObjectStream%n"
								+ "4) Torna indietro%n");
						
						try {	//Controllo di inserimento in input corretto
							System.out.printf("Inserisci numero scelta: ");
							sceltaSalva = mySalvataggioScelta.nextInt();
							System.out.printf("%n");
								
							if(sceltaSalva < 1 || sceltaSalva > 4) {
								throw new IllegalArgumentException("Il numero deve essere comprenso tra 1 e 4");
							}
						}
						catch (InputMismatchException e) {		//Cattura inserimento lettera per sbaglio
							System.out.printf("%n");
							System.err.printf("Inserisci un numero, non una lettera!");
							System.out.printf("%n%n");
							mySalvataggioScelta.nextLine();	//Pulisce il buffer
						}
						catch (IllegalArgumentException e) {	//Cattura numero fuori dal range 1-4
							System.err.printf("%s%n%n", e.getMessage());
						}
						
						switch (sceltaSalva) {
							//Salva dati in file txt
							case 1: 
								Scanner insertNomeFile = new Scanner(System.in);
								boolean isNameFileInserted = false;
								int tentativiNomeFile = 0;
								
								do {
									System.out.printf("Come vuoi chiamare il file su cui salvare i dati?%n"
											+ "Inserire un nome per il file (inserisci anche estension [.txt]: ");
									String nomeFile = insertNomeFile.nextLine();
									System.out.printf("%n");
									
									if(Biblioteca.isValidFileTxt(nomeFile)) {
										Biblioteca.salvaStato(nomeFile, libriList);
										isNameFileInserted = true;
										isScelto = true;
									}
									else {
											System.err.printf("Il nome file inserito non termina con \".txt\"");
											System.out.printf("%n%n");
											tentativiNomeFile++;
									}
									
									if(tentativiNomeFile == 3) {
										System.out.printf("Troppi tentativi di input, torna qui tra poco...%n%n");
										break;
									}
								}
								while(isNameFileInserted == false);
							break;
						
							//Salva dati in file xml
							case 2:
							
							break;
						
							//Salva dati con ObjectStream
							case 3:
								Scanner anotherBook = new Scanner(System.in);
								boolean stopWriting = false;
								Biblioteca.salvaObjectOutputStream();
								
								do {
									int sceltaContinua = 0;
						
									System.out.printf("Vuoi serializzare un altro libro?%n"
											+ "1) Si%n"
											+ "2) No%n");
									
									try {	//Controllo di inserimento in input corretto
										System.out.printf("Inserisci numero opzione: ");
										sceltaContinua = anotherBook.nextInt();
										System.out.printf("%n");
											
										if(sceltaContinua < 1 || sceltaContinua> 2) {
											throw new IllegalArgumentException("Il numero deve essere comprenso tra 1 e 2");
										}
										
										if(sceltaContinua == 2) {
											stopWriting = true;
										}
										else {
											Biblioteca.salvaObjectOutputStream();
										}
									}
									catch (InputMismatchException e) {		//Cattura inserimento lettera per sbaglio
										System.out.printf("%n");
										System.err.printf("Inserisci un numero, non una lettera!");
										System.out.printf("%n%n");
										anotherBook.nextLine();	//Pulisce il buffer
									}
									catch (IllegalArgumentException e) {	//Cattura numero fuori dal range 1-2
										System.err.printf("%s%n%n", e.getMessage());
									}
								}
								while(stopWriting == false);
							break;
							
							//Torna indietro
							case 4:
								System.out.printf("Torno al menù principale...%n%n");
								isScelto = true;
							break;
						}
					}
					while(isScelto == false);
				break;
				
				//Carica dati
				case 7:
					Scanner sceltaCaricaDati = new Scanner(System.in);
					boolean isCaricato = false;
					
					do {
						int sceltaCarica = 0;
						
						System.out.printf("Da che tipo di file vuoi caricare i dati?%n"
								+ "1) txt%n"
								+ "2) xml%n"
								+ "3) ObjectStream%n"
								+ "4) Torna indietro%n");
						
						try {	//Controllo di inserimento in input corretto
							System.out.printf("Inserisci numero scelta: ");
							sceltaCarica = sceltaCaricaDati.nextInt();
							System.out.printf("%n");
								
							if(sceltaCarica < 1 || sceltaCarica > 4) {
								throw new IllegalArgumentException("Il numero deve essere comprenso tra 1 e 4");
							}
						}
						catch (InputMismatchException e) {		//Cattura inserimento lettera per sbaglio
							System.out.printf("%n");
							System.err.printf("Inserisci un numero, non una lettera!");
							System.out.printf("%n%n");
							sceltaCaricaDati.nextLine();	//Pulisce il buffer
						}
						catch (IllegalArgumentException e) {	//Cattura numero fuori dal range 1-3
							System.err.printf("%s%n%n", e.getMessage());
						}
						
						switch(sceltaCarica) {
							//Carica da file txt
							case 1:
								Scanner insertNomeFile = new Scanner(System.in);
								boolean isNameFileInserted = false;
								int tentativiNomeFile = 0;
								
								do {
									System.out.printf("Da che file vuoi prendere i dati?%n"
											+ "Inserire un nome file (inserisci anche estensione [txt]: ");
									String nomeFile = insertNomeFile.nextLine();
									System.out.printf("%n");
									
									if(Biblioteca.isValidFileTxt(nomeFile)) {
										catalogoLibri.leggiStato(nomeFile);
										System.out.printf("%nCaricamento avvenuto...%n%n");
										isNameFileInserted = true;
										isCaricato = true;
										break;
									}
									else {
											System.err.printf("Il nome file inserito non termina con \".txt\"");
											System.out.printf("%n%n");
											tentativiNomeFile++;
									}
									
									if(tentativiNomeFile == 3) {
										System.out.printf("Troppi tentativi di input, torna qui tra poco...%n%n");
										break;
									}
								}
								while(isNameFileInserted == false);
							break;
							
							//Carica da file xml
							case 2:
								
							break;
							
							//Carica usando ObjectInputStream
							case 3:
								Scanner fileNameScanner = new Scanner(System.in);
								int tentInsert = 0;
								boolean isRightFileName;
								
								do {
									isRightFileName = false;
									
									System.out.printf("Inserire nome file: ");
									String fileName = fileNameScanner.nextLine();
									
									if(Biblioteca.isValidNameFileObjectStream(fileName)) {
										Biblioteca.caricaObjectInputStream(fileName, libriList);
										System.out.printf("Oggetti caricati correttamente%n%n");
										isRightFileName = true;
									}
									else {
										System.err.printf("nome file non corretto");
										System.out.printf("%n%n");
										tentInsert++;
									}
									
									if(tentInsert == 3) {
										System.out.printf("Troppi tentativi per scrittura nome file%nTorno indietro...%n%n");
										isRightFileName = true;
									}
								}
								while(isRightFileName == false);
							break;
							
							//Torna indietro
							case 4:
								System.out.printf("Torno al menù principale...%n%n");
								isCaricato = true;
							break;
						}
					}
					while(isCaricato == false);
					
				break;
				
				//Stampa libreria:
				case 8:
					for(Libro libro : libriList) {
						System.out.println(libro + ", Stato: " + libro.getStato());
					}	
					System.out.println();
				break;
				
				//Esci
				case 9:
					isEsci = true;
					System.out.printf("TERMINO IL PROGRAMMA%n");
				break;
			}
		}
		while(isEsci == false);
		
		myInt.close();
	}
}
package esonero2test;

import java.util.Scanner;

import esonero2store.*;

public class MagazzinoTest {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Magazzino<Prodotto> magazzino = new Magazzino<>();

		//Acquisizione dei prodotto da tastiera
		Prodotto libro = acquisisciProdottoDaTastiera("Libro");
        Prodotto orologio = acquisisciProdottoDaTastiera("Orologio");
        Prodotto orologioDupl = acquisisciProdottoDaTastiera("Orologio");
        ProdottoAlimentare mela = acquisisciProdottoAlimentareDaTastiera("Mela");
        ProdottoAlimentare mela2 = acquisisciProdottoAlimentareDaTastiera("Mela");
        ProdottoAlimentare pane = acquisisciProdottoAlimentareDaTastiera("Pane");
        
        //Aggiunta dei prodotti
        magazzino.aggiungiProdotto(libro);
        magazzino.aggiungiProdotto(orologio);
        magazzino.aggiungiProdotto(orologioDupl);
        magazzino.aggiungiProdotto(mela);
        magazzino.aggiungiProdotto(mela2);
        magazzino.aggiungiProdotto(pane);
        
        // Rimozione e aggiunta dell'oggetto "mela" dal magazzino con stampa a video dell'esito
        eseguiRimozioneEAggiunta(magazzino, mela);
        
        // Esecuzione delle operazioni richieste
        System.out.println("\nOperazione 3.1: Lista di prodotti ordinata in ordine discendente per costo del prodotto");
        magazzino.listaOrdinataPerCostoDisc().forEach(System.out::println);

        System.out.println("\nOperazione 3.2: Lista di prodotti il cui costo è inferiore a un valore specificato");
        double valoreCosto = acquisisciValoreDaTastiera("Inserisci il valore del costo:");
        magazzino.listaCostoInferiore(valoreCosto).forEach(System.out::println);

        System.out.println("\nOperazione 3.3: Lista di prodotti la cui descrizione inizia con un carattere specificato");
        char carattere = acquisisciCarattereDaTastiera("Inserisci il carattere:");
        magazzino.listaDescrizioneIniziaCon(carattere).forEach(System.out::println);

        System.out.println("\nOperazione 3.4: Lista di prodotti che contiene il prodotto con il costo più elevato");
        magazzino.listConCostoElevato().forEach(System.out::println);
	}

	private static Prodotto acquisisciProdottoDaTastiera(String nomeProdotto) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Inserisci i dettagli per il prodotto " + nomeProdotto + ":");
		String codice;
		
		do {
			System.out.printf("Codice: ");
			codice = scanner.nextLine();
		}
		while(Magazzino.getCodiciPresenti().contains(codice));	//Verifica unicità del codice
		
		System.out.printf("Nome: ");
		String nome = scanner.nextLine();
		
		System.out.printf("Costo: ");
		double costo = scanner.nextDouble();
		scanner.nextLine();	//Consuma linea residua
		System.out.println();
		
		return new Prodotto(codice, nome, costo);
	}
	
	private static ProdottoAlimentare acquisisciProdottoAlimentareDaTastiera(String nomeProdotto) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Inserisci i dettagli per il prodotto alimentare " + nomeProdotto + ":");
        String codice;
		
		do {
			System.out.printf("Codice: ");
			codice = scanner.nextLine();
		}
		while(Magazzino.getCodiciPresenti().contains(codice));	//Verifica unicità del codice
                
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        
        System.out.print("Costo: ");
        double costo = scanner.nextDouble();
        scanner.nextLine();  // Consuma la nuova linea residua
        
        int energia;
        do {
        	System.out.print("Energia: ");
            energia = scanner.nextInt();
            
            if(energia < 0) {
            	System.err.printf("Valore dell'energia deve essere >= 0");
            	System.out.println();
            }
		} while (energia < 0);
        
        int tempoConservazione;
        do {
        	System.out.print("Tempo di Conservazione: ");
            tempoConservazione = scanner.nextInt();
		} while (tempoConservazione < 1);
          
        scanner.nextLine();  // Consuma la nuova linea residua
        System.out.println();
        return new ProdottoAlimentare(codice, nome, costo, energia, tempoConservazione);
    }
	
	private static double acquisisciValoreDaTastiera(String messaggio) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(messaggio + " ");
        
        return scanner.nextDouble();
    }
	
	private static char acquisisciCarattereDaTastiera(String messaggio) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(messaggio + " ");
        return scanner.next().charAt(0);
    }
	
	private static void eseguiRimozioneEAggiunta(Magazzino<Prodotto> magazzino, ProdottoAlimentare prodotto) {
        // Rimozione dell'oggetto "prodotto" dal magazzino con stampa a video dell'esito
        boolean rimozioneEffettuata = magazzino.rimuoviProdottoByCodice(prodotto.getCodice());
        System.out.println("\n\nRimozione dell'oggetto " + prodotto.getNome() + "\nEsito operazione: " + (rimozioneEffettuata ? "Successo" : "Prodotto non presente"));

        // Aggiunta dell'oggetto "prodotto" al magazzino con stampa a video dell'esito
        boolean aggiuntaEffettuata = magazzino.aggiungiProdotto(prodotto);
        System.out.println("\n\nAggiunta dell'oggetto " + prodotto.getNome() + "\nEsito operazione: " + (aggiuntaEffettuata ? "Successo" : "Prodotto già presente"));
    }
}
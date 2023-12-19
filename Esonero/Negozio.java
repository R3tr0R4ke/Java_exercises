package Esonero;

import java.util.ArrayList;

public class Negozio {
	
	private static ArrayList<Prodotto> prodotti = new ArrayList<Prodotto>();
	
	public static void aggiungiProdotto (Prodotto prodotto) {
		for (Prodotto prod : prodotti) {
			
			try {
				if (prodotto.getCodice().equals(prod.getCodice())) {
					throw new IllegalArgumentException("Il prodotto ha lo stesso codice di un altro prodotto!");
				}
			} catch (IllegalArgumentException e) {
				System.out.println(e);
			}
		}
		prodotti.add(prodotto);
	}
	
	public static double calcolaTotale() {
		double costoTot = 0.0;
		for (Prodotto prodotto : prodotti) {
			costoTot += prodotto.getPrezzoIniziale();
		}
		return costoTot;
	}
	
	public static void stampaProdotti() {
		for (Prodotto prodotto : prodotti) {
			System.out.println(prodotto);
		}
	}
}
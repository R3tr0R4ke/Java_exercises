package esonero2store;

import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Magazzino<T extends Prodotto> {
	private Map<String, T> prodotti = new HashMap<>();
	private static Set<String> codiciPresenti = new HashSet<>();
	
	public static List<String> getCodiciPresenti(){
		return codiciPresenti.stream()
				.collect(Collectors.toList());
	}
	
	public boolean aggiungiProdotto(T prodotto) {
		if(prodotti.containsKey(prodotto.getCodice())) {	//Prodotto con codice già esistente
			System.err.printf("Impossibile aggiungere prodotto con codice già presente");
			return false;
		}
		else {
			prodotti.put(prodotto.getCodice(), prodotto);	//Aggiungo alla mappa il prodotto
			codiciPresenti.add(prodotto.getCodice());
			return true;
		}
	}
	
	public boolean rimuoviProdottoByCodice(String codice) {
		boolean isRimosso = prodotti.entrySet()
				.stream()
				.filter(entry -> entry.getKey().equals(codice))
				.findFirst()
				.map(entry -> {
					prodotti.remove(entry.getKey());
					return true;
				})
				.orElseGet(() -> {
					System.err.printf("Prodotto non presente...");
					return false;
				});
				
		return isRimosso;			
	}
	
	public List<T> getLista(String descrizione, Predicate<T> filtro, Consumer<T> operazione) {
		List<T> prodottiCercati = prodotti.values()
										.stream()
										.filter(filtro)
										.peek(operazione)
										.collect(Collectors.toList());
		
		System.out.println("Operazione: " + descrizione);
		return prodottiCercati;
	}
	
	public List<T> listaOrdinataPerCostoDisc(){
		return prodotti.values()
						.stream()
						.sorted(Comparator.comparingDouble(Prodotto :: calcolaCosto).reversed())
						.collect(Collectors.toList());
	}
	
	public List<Prodotto> listaCostoInferiore(double valore){
		return prodotti.values()
				.stream()
				.filter(prodotto -> prodotto.calcolaCosto() < valore)
				.collect(Collectors.toList());
	}
	
	public List<Prodotto> listaDescrizioneIniziaCon(char carattere){
		return prodotti.values()
				.stream()
				.filter(prodotto -> prodotto.toString().charAt(0) == carattere)
				.collect(Collectors.toList());
	}
	
	public List<Prodotto> listConCostoElevato(){
		double costoElevato = 
				prodotti.values()
						.stream()
						.mapToDouble(Prodotto :: calcolaCosto)
						.max()
						.orElse(0);
		
		return prodotti.values()
				.stream()
				.filter(prodotto -> prodotto.calcolaCosto() == costoElevato)
				.collect(Collectors.toList());
	}
}

package esonero2store;

public class Prodotto {
	private String codice;
	private String nome;
	private double costo;
	
	//private String descrizione;
	//private Set<String> codiciPresenti = new HashSet();
	
	//Costruttore vuoto
	public Prodotto() {		}
	
	//Costruttore
	public Prodotto(String codice, String nome, double costo) {
		if(costo < 0.0) {
			throw new IllegalArgumentException("Costo deve essere > 0.0");
		}
		
		this.codice = codice;
		this.nome = nome;
		this.costo = costo;
	}
	
	public String getCodice() {
		return codice;
	}
	
	public String getNome() {
		return nome;
	}
	
	public double calcolaCosto() {
		return costo;
	}
	
	@Override
	public String toString() {
		return String.format("Prodotto%nCodice: %s%nNome: %s%nCosto %.2f%n", codice, nome, costo);
	}
}
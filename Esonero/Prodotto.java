package Esonero;

public abstract class Prodotto extends Negozio{
	private String codice;
	private double prezzoIniziale;
	
	public Prodotto(String codice, double prezzoIniziale) {
		try {
			if (codice == null) {
				throw new IllegalArgumentException("Codice non inserito");
			}
		}
		catch (IllegalArgumentException e) {
			System.out.println(e);
		}
		
		try {
			if (prezzoIniziale < 0.0) {
				prezzoIniziale = 0;		//Valore di default
				throw new IllegalArgumentException("Prezzo iniziale deve essere >= 0.0");
			}
		} catch (IllegalArgumentException e) {
			System.out.println(e);
		}
		
		
		this.codice = codice;
		this.prezzoIniziale = prezzoIniziale;
	}

	public String getCodice() {
		return codice;
	}

	public void setCodice(String codice) {
		try {
			if (codice == null) {
				throw new IllegalArgumentException("Codice non inserito");
			}
		}
		catch (IllegalArgumentException e) {
			System.out.println(e);
		}
		this.codice = codice;
	}

	public double getPrezzoIniziale() {
		return prezzoIniziale;
	}

	public void setPrezzoIniziale(double prezzoIniziale) {
		try {
			if (prezzoIniziale < 0.0) {
				prezzoIniziale = 0;		//Valore di default
				throw new IllegalArgumentException("Prezzo iniziale deve essere >= 0.0");
			}
		} catch (IllegalArgumentException e) {
			System.out.println(e);
		}
		this.prezzoIniziale = prezzoIniziale;
	}
	
	public abstract double calcolaCosto();
	
	@Override
	public String toString() {
		return String.format("%s : %s%n%s : %s", 
				"Codice", getCodice(),
				"Prezzo Iniziale", getPrezzoIniziale());
	}
}

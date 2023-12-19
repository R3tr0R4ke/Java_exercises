package EsCap9e10;

public class Automobile extends Veicolo{
	private int numPorte;
	private double consumoKm;
	
	//Costruttore
	public Automobile(String modello, int annoProduzione, int numPorte, double consumoKm) {
		super(modello, annoProduzione);
		
		if (numPorte < 3 || numPorte > 6) {
			throw new IllegalArgumentException("Numero porte deve essere compreso tra 3 e 6");
		}
		
		if (consumoKm < 0.2 || consumoKm > 0.9) {
			throw new IllegalArgumentException("Consumo per Km deve essere compreso tra 0.2 e 0.9");
		}
		
		this.numPorte = numPorte;
		this.consumoKm = consumoKm;
	}
	
	//Imposta il consumo per km
	public void setConsumoKm(double consumoKm) {
		if (consumoKm < 0.2 || consumoKm > 0.9) {
			throw new IllegalArgumentException("Consumo per Km deve essere compreso tra 0.2 e 0.9");
		}
		this.consumoKm = consumoKm;
	}
		
	//Restituisce il consumo per km
	public double calcolaConsumoKm() {
		if (getAnnoProduzione() < 2010) {
			return consumoKm * 1.20;	//Aumento del 20%
		}
		else {
			return consumoKm;
		}
	}
	
	//Imposta il numero di porte
	public void setNumPorte(int numPorte) {
		if (numPorte < 3 || numPorte > 6) {
			throw new IllegalArgumentException("Numero porte deve essere compreso tra 3 e 6");
		}
		this.numPorte = numPorte;
	}
	
	//Restituisce il numero di porte
	public int getNumPorte() {
		return numPorte;
	}

	@Override //Suona il clacson per l'automobile
	public String suonaClacson() {
		return String.format("%16s : %9s%n", "Suono automobile", "Beep Beep");
	}
	
	@Override
	public String toString() {
		return String.format("%s : %n%s%s : %s%n%s : %s%n%n",
				"Automobile", super.toString(), 
				"Numero porte", getNumPorte(), 
				"Consumo per Km", calcolaConsumoKm());
	}
}
package esonero2store;

public class ProdottoAlimentare extends Prodotto{
	private int energia;
	private int tempoConservazione;
	
	//Costruttore
	public ProdottoAlimentare(String codice, String nome, double costo, int energia, int tempoConservazione) {
		super(codice, nome, costo);
		
		if(energia < 0) {
			throw new IllegalArgumentException("Energia deve essere > 0");
		}
		
		if(tempoConservazione < 1) {
			this.tempoConservazione = 1;
		}
		
		this.energia = energia;
		this.tempoConservazione = tempoConservazione;
	}
	
	@Override
	public double calcolaCosto() {
		if (tempoConservazione <= 2) {
			return super.calcolaCosto() / 2.0;
		}
		else {
			return super.calcolaCosto();
		}
	}
	
	@Override
	public String toString() {
		return String.format("Prodotto%nCodice: %s%nNome: %s%nCosto %.2f%nEnergia: %d%nTempo conservazione: %d%n", 
				getCodice(), getNome(), calcolaCosto(), energia, tempoConservazione);
	}
}

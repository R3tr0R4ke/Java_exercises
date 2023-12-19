package Esonero;

public class ProdottoAlimentare extends Prodotto{
	public enum PrincipioNutritivo {CARBOIDRATI, GRASSI, PROTEINE, VITAMINE};
	private PrincipioNutritivo principioNutritivo = PrincipioNutritivo.PROTEINE;
	private int tempoConservazione;
	
	public ProdottoAlimentare(String codice, double prezzoIniziale,
			PrincipioNutritivo principioNutritivo, int tempoConservazione) {
		super(codice, prezzoIniziale);
		
		try {
			if (tempoConservazione < 1) {
				tempoConservazione = 1;	//Valore di default
				throw new IllegalArgumentException("Tempo conservazione non può essere < 0");
			}
			
		} catch (IllegalArgumentException e) {
			System.out.println(e);
		}
		
		this.principioNutritivo = principioNutritivo;
		this.tempoConservazione = tempoConservazione;
	}

	public PrincipioNutritivo getPrincipioNutritivo() {
		return principioNutritivo;
	}

	public void setPrincipioNutritivo(PrincipioNutritivo principioNutritivo) {
		this.principioNutritivo = principioNutritivo;
	}

	public int getTempoConservazione() {
		return tempoConservazione;
	}

	public void setTempoConservazione(int tempoConservazione) {
		try {
			if (tempoConservazione < 1) {
				tempoConservazione = 1;	//Valore di default
				throw new IllegalArgumentException("Tempo conservazione non può essere < 0");
			}			
		} catch (IllegalArgumentException e) {
			System.out.println(e);
		}
		
		this.tempoConservazione = tempoConservazione;
	}
	
	@Override
	public double calcolaCosto() {
		if (tempoConservazione == 1) {
			return getPrezzoIniziale() / 2;
		}
		return getPrezzoIniziale();
	}
	
	@Override
	public String toString() {
		return String.format("%s : %n%s%n%s : %s%n%s : %s%n",
				"Prodotto alimentare", super.toString(),
				"Principio nutritivo", getPrincipioNutritivo(),
				"Tempo conservazione", getTempoConservazione());
	}
}
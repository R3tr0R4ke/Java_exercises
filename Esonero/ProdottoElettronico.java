package Esonero;

public class ProdottoElettronico extends Prodotto{
	private int garanzia;
	
	public ProdottoElettronico(String codice, double prezzoIniziale, int garanzia) {
		super(codice, prezzoIniziale);
		
		try {
			if (garanzia < 2 || garanzia > 24) {
				garanzia = 2;	//Valore di default
				throw new IllegalArgumentException("Garanzia deve essere > 0");
			}
		} catch (IllegalArgumentException e) {
			System.out.println(e);
		}
		this.garanzia = garanzia;
	}

	public int getGaranzia() {
		return garanzia;
	}

	public void setGaranzia(int garanzia) {
		try {
			if (garanzia < 2 || garanzia > 24) {
				garanzia = 2;	//Valore di default
				throw new IllegalArgumentException("Garanzia deve essere > 0");
			}
		} catch (IllegalArgumentException e) {
			System.out.println(e);
		}
		this.garanzia = garanzia;
	}
	
	@Override
	public double calcolaCosto() {
		if (garanzia > 12) {
			return getPrezzoIniziale() * 1.10;
		}
		return getPrezzoIniziale();
	}

	@Override
	public String toString() {
		return String.format("%s : %n%s%n%s : %s%n",
				"Prodotto elettronico", super.toString(),
				"Garanzia", getGaranzia());
	}
}

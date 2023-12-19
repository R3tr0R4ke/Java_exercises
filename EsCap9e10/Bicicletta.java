package EsCap9e10;

import java.security.SecureRandom;

public abstract class Bicicletta extends Veicolo{
	private String tipoTelaio;
	private int numMarce;		//da 4 a 6 marce
	private int marciaAttuale;
	
	public Bicicletta (String modello, int annoProduzione, String tipoTelaio, int numMarce, int marciaAttuale) {
		super(modello, annoProduzione);
		
		if (numMarce < 4 || numMarce > 6) {
			throw new IllegalArgumentException("Numero marce deve essere compreso tra 4 e 6");
		}
		if (marciaAttuale <= 0 || marciaAttuale > numMarce) {
			throw new IllegalArgumentException("Marcia attuale deve essere nel range di 1 e numMarce");
		}
		
		this.tipoTelaio = tipoTelaio;
		this.numMarce = numMarce;
		this.marciaAttuale = marciaAttuale;
	}

	//Restituisce il tipo telaio
	public String getTipoTelaio() {
		return tipoTelaio;
	}

	//Imposta il tipo di telaio
	public void setTipoTelaio(String tipoTelaio) {
		this.tipoTelaio = tipoTelaio;
	}

	//Restituisce il numero delle marce
	public int getNumMarce() {
		return numMarce;
	}

	//Imposta il numero delle marce
	public void setNumMarce(int numMarce) {
		if (numMarce < 4 || numMarce > 6) {
			throw new IllegalArgumentException("Numero marce deve essere compreso tra 4 e 6");
		}
		this.numMarce = numMarce;
	}

	//Restituisce la marcia attuale
	public int getMarciaAttuale() {
		return marciaAttuale;
	}

	//Imposta la marcia attuale
	public void setMarciaAttuale(int marciaAttuale) {
		if (marciaAttuale <= 0 || marciaAttuale > numMarce) {
			throw new IllegalArgumentException("Marcia attuale deve essere nel range di 1 e numMarce");
		}
		this.marciaAttuale = marciaAttuale;
	}
	
	@Override
	public String suonaClacson() {
		return String.format("%s : %s%n", "Suono bicicletta", "Ding Ding");
	}
	
	@Override
	public String toString() {
		return String.format("%n%s%s : %s%n%s : %s%n%s : %s%n",
				super.toString(),
				"Tipo telaio", getTipoTelaio(),
				"Numero marce", getNumMarce(),
				"Marcia attuale", getMarciaAttuale());
	}
	
	//Metodo per cambiare la marcia
	public void cambiaMarcia() {
		SecureRandom randomNumbers = new SecureRandom();
		int casualNum = 1 + randomNumbers.nextInt(numMarce); //Genera numero casuale compres tra la prima marcia e numMarce
		setMarciaAttuale(casualNum);	//Imposto la marcia attuale
	}
}
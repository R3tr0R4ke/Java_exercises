package EsCap9e10;

public class BiciclettaElettrica extends Bicicletta{
	private double autonomiaBatteria;
	private int tensioneBatteria;
	
	//Costruttore
	public BiciclettaElettrica(String modello, int annoProduzione, String tipoTelaio, int numMarce, int marciaAttuale, double autonomiaBatteria, int tensioneBatteria) {
		super(modello, annoProduzione, tipoTelaio, numMarce, marciaAttuale);
		
		if (autonomiaBatteria < 0 || autonomiaBatteria > 100) {
			throw new IllegalArgumentException("Autonomia batteria deve essere compreso tra 0.0 e 100.0");
		}
		if (tensioneBatteria < 0) {
			throw new IllegalArgumentException("Tensione batteria deve essere > 0");
		}
		
		this.autonomiaBatteria = autonomiaBatteria;
		this.tensioneBatteria = tensioneBatteria;
	}

	//Restituisce l'autonomia batteria
	public double getAutonomiaBatteria() {
		return autonomiaBatteria;
	}

	//Imposta l'autonomia batteria
	public void setAutonomiaBatteria(double autonomiaBatteria) {
		if (autonomiaBatteria < 0 || autonomiaBatteria > 100) {
			throw new IllegalArgumentException("Autonomia batteria deve essere compreso tra 0.0 e 100.0");
		}
		this.autonomiaBatteria = autonomiaBatteria;
	}

	//Restituisce la tensione batteria
	public int getTensioneBatteria() {
		return tensioneBatteria;
	}

	//Imposta la tensione batteria
	public void setTensioneBatteria(int tensioneBatteria) {
		if (tensioneBatteria < 0) {
			throw new IllegalArgumentException("Tensione batteria deve essere > 0");
		}
		this.tensioneBatteria = tensioneBatteria;
	}

	@Override
	public String toString() {
		return String.format("%s : %s%s : %s%n%s : %s",
				"Bicicletta elettrica", super.toString(),
				"Autonomia batteria", getAutonomiaBatteria(),
				"Tensione Batteria", getTensioneBatteria());
	}
	
	//Metodo per ricaricare la batteria
	public String ricaricaBatteria () {
		autonomiaBatteria = 100.0;
		return "Batteria ricaricata";
	}
}
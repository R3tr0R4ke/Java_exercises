package EsCap9e10;

public class Motocicletta extends Veicolo{
	public enum TipoGuida{MODERATA, BRILLANTE, SPORTIVA};
	private TipoGuida tipoGuida = TipoGuida.MODERATA;	//Ricorda di dichiarare una variabile di tipo enum
	private int cilindrata;
	
	public Motocicletta(String modello, int annoProduzione,
			TipoGuida tipoGuida, int cilindrata) {
		super(modello, annoProduzione);
		
		if (cilindrata < 1000 || cilindrata > 2500) {
			throw new IllegalArgumentException("Cilindrata deve essere compreso tra 1000 e 2500");
		}
		this.tipoGuida = tipoGuida;
		this.cilindrata = cilindrata;
	}

	//Restituisce il tipo guida
	public TipoGuida getTipoGuida() {
		return tipoGuida;
	}

	//Imposta il tipo guida
	public void setTipoGuida(TipoGuida tipoGuida) {
		this.tipoGuida = tipoGuida;
	}

	//Restituisce la cilindrata
	public int getCilindrata() {
		return cilindrata;
	}

	//Imposta la cilindrata
	public void setCilindrata(int cilindrata) {
		if (cilindrata < 1000 || cilindrata > 2500) {
			throw new IllegalArgumentException("Cilindrata deve essere compreso tra 1000 e 2500");
		}
		this.cilindrata = cilindrata;
	}
	
	//Metodo per accelerare
	public String accelera() {
		return String.format("%s%n", "La moto sta accelerando!!!");
	}

	//Metodo per suonare il clacson
	@Override
	public String suonaClacson() {
		return String.format("%s : %s%n", "Suono motocicletta", "Fiuuum");
	}
	
	@Override
	public String toString() {
		return String.format("%s : %n%s%s : %s%n%s : %s%n%n", 
				"Motocicletta", super.toString(), 
				"Tipo guida", getTipoGuida(), 
				"Cilindrata", getCilindrata());
	}
}
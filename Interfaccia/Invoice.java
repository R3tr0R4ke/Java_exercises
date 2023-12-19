package Interfaccia;

//Classe Invoice che implementa Payable
public class Invoice implements Payable{
	private final String partNumber;
	private final String partDescription;
	private final int quantity;
	private final double pricePerItem;
	
	//Costruttore
	public Invoice(String partNumber, String partDescription,
			int quantity, double pricePerItem) {
		if (quantity < 0) {		//Valida la quantità
			throw new IllegalArgumentException("Quantity must be >= 0");
		}
		if (pricePerItem < 0.0) {		//Valida pricePerItem
			throw new IllegalArgumentException("Price per item must be >= 0");
		}
		this.quantity = quantity;
		this.partNumber = partNumber;
		this.partDescription = partDescription;
		this.pricePerItem = pricePerItem;
	}
	
	//Ottiene la matricola del pezzo
	public String getPartNumber() {
		return partNumber;
	}
	
	//Ottiene la descrizione
	public String getPartDescription() {
		return partDescription;
	}
	
	//Ottiene la quantita ordinata
	public int getQuantity() {
		return quantity;
	}
	
	//Ottiene il prezzo per singolo articolo
	public double getPricePerItem() {
		return pricePerItem;
	}
	
	@Override //Restituisce una rappresentazione in formato stringa
	public String toString() {
		return String.format("%s: %n%s: %s (%s) %n%s: %d %n%s: $%,.2f",
				"invoice", "part number", getPartNumber(), getPartDescription(),
				"quantity", getQuantity(), "price per item", getPricePerItem());
	}
	
	@Override //Metodo richiesto dall'interfaccia Payable
	public double getPaymentAmount() {
		return getQuantity() * getPricePerItem();	//Calcola il costo totale
	}
}

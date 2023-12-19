package GestioneCredito;

public enum MenuOption {
	//Dichiara il contenuto del tipo enum
	ZERO_BALANCE(1),
	CREDIT_BALANCE(2),
	DEBIT_BALANCE(3),
	END(4);
	
	private final int value;	//Opzione di menu corrente
	
	//Costruttore
	private MenuOption(int value) {
		this.value = value;
	}
}
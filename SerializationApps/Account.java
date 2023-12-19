package SerializationApps;

public class Account {
	private int accountNumber;
	private String firstName, lastName;
	private double balance;
	
	//Inizializza un conto con i valori di default
	public Account() {
		this(0, "", "", 0.0);
	}
	
	//Inizializza un conto con i valori forniti
	public Account(int accountNumber, String firstName, String lastName, double balance) {
		this.accountNumber = accountNumber;
		this.firstName = firstName;
		this.lastName = lastName;
		this.balance = balance;
	}
	
	//Imposta il numero del conto
	public void setAccountNumber (int accountNumber) {
		this.accountNumber = accountNumber;
	}
	
	//Imposta il nome
	public void setFirstName (String firstName) {
		this.firstName = firstName;
	}
	
	//Imposta il cognome
	public void setLastName (String lastName) {
		this.lastName = lastName;
	}
	
	//Imposta il saldo
	public void setBalance (double balance) {
		this.balance = balance;
	}
	
	//Legge il numero conto
	public int getAccountNumber () {
		return accountNumber;
	}
	
	//Legge il nome
	public String getFirstName () {
		return firstName;
	}
		
	//Legge il cognome
	public String getLastName () {
		return lastName;
	}
	
	//Legge il saldo
	public double getBalance () {
		return balance;
	}
}

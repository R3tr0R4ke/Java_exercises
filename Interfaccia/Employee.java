package Interfaccia;

//La superclasse astratta Employee implementa Payable
public abstract class Employee implements Payable{
	private final String firstName;
	private final String lastName;
	private final String socialSecurityNumber;
	
	//Costruttore
	public Employee(String firstName, String lastName, String socialSecurityNumber) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.socialSecurityNumber = socialSecurityNumber;
	}
	
	//Restituisce il nome
	public String getFirstName () {
		return firstName;
	}
	
	//Restituisce il cognome
	public String getLastName () {
		return lastName;
	}
	
	//Restituisce il numero di previdenza sociale
	public String getSocialSecurityNumber () {
		return socialSecurityNumber;
	}
	
	@Override //Restituisce un rappresentazione in formato stringa
	public String toString() {
		return String.format("%s %s%nsocial security number: %s",
				getFirstName(), getLastName(), getSocialSecurityNumber());
	}
	
	//Il metodo astratto deve essere ridefinito da sottoclassi concrete
	public abstract double earnings();	//Nessuna implementazione
	
	//Implementare qui getPaymentAmount consente l'utilizzo della
	//gerarchia della classe Employee in un'app che elabori i Payable
	public double getPaymentAmount() {
		return earnings();
	}
}

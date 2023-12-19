package PolimorfismoAbstract;

public abstract class Employee {
	private String firstName;
	private String lastName;
	private String socialSecurityNumber;
	
	//Costruttore
	public Employee (String firstName, String lastName, String socialSecurityNumber) {
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
	
	@Override //Restituisce una rappresentazione in formato stringa
	public String toString () {
		return String.format("%s %s%nsocial security number: %s",
				getFirstName(), getLastName(), getSocialSecurityNumber());
	}
	
	//Il metodo astratto sarà implementato nelle sottoclassi concrete
	public abstract double earnings();	//Nessuna implementazione qui
}

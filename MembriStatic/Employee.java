package MembriStatic;

public class Employee {
	private static int count = 0;		//Numero di employee creati
	private String firstName;
	private String lastName;
	
	//Inizializza Employee, aggiunge 1 alla variabile statica count e visualizza
	//una stringa per indicare l'invocazione del costruttore
	public Employee (String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
		
		count++;	//Incrementa conteggio statico degli impiegati
		System.out.printf("Employee constructor: %s %s; count = %d%n", firstName, lastName, count);
	}
	
	//Estrae il nome
	public String getFirstName () {
		return firstName;
	}
	
	//Estrae il cognome
	public String getLastName () {
		return lastName;
	}
	
	//Metodo static per leggere il valore del conteggio
	public static int getCount() {
		return count;
	}
}

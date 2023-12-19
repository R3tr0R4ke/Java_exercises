package ComposizioneEsempio;

public class Employee {
	private String firstName;		//Nome
	private String lastName;		//Cognome
	private Date birthDate;				//Data di nascita
	private Date hireDate;				//Data di assunzione
	
	//Costruttore per inizializzare nome, cognome, data di nascita e data assunzione
	public Employee (String firstName, String lastName, Date birthDate, Date hireDate) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthDate = birthDate;
		this.hireDate = hireDate;
	}
	
	//Converte Employee in formato Stringa
	public String toString() {
		return String.format("%s, %s Hired: %s Birthday: %s", firstName, lastName, hireDate, birthDate);
	}
}

package Ereditarieta;
//La classe CommissionEmployee rappresenta un impiegato pagato in percentuale sulle vendite
public class CommissionEmployee extends Object {
	private String firstName;
	private String lastName;
	private String socialSecurityNumber;
	private double grossSales;			//Vendite lorde settimanali
	private  double commissionRate;		//Percentuale commissione
	
	//Costruttore con cinque argomenti
	public CommissionEmployee(String firstName, String lastName, String socialSecurityNumber, double grossSales, double commissionRate) {
		//Invocazione implicita del costruttore di Object
		
		//Se grossSales non è valido viene sollevata un'eccezzione
		if(grossSales < 0.0) {
			throw new IllegalArgumentException("Gross sales must be >= 0.0");
		}
		
		//Se commissionRate non è valido viene sollevata un'eccezione
		if (commissionRate <= 0.0 || commissionRate >= 1.0) {
			throw new IllegalArgumentException("Commission rate must be > 0.0 and < 1.0");
		}
		
		this.firstName = firstName;
		this.lastName = lastName;
		this.socialSecurityNumber = socialSecurityNumber;
		this.grossSales = grossSales;
		this.commissionRate = commissionRate;
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
	
	//Restituisce le vendite lorde
	public double getGrossSales () {
		return grossSales;
	}
	
	//Imposta le vendite lorde
	public void setGrossSales (double grossSales) {
		if (grossSales < 0.0) {
			throw new IllegalArgumentException("Gross sales must be >= 0.0");
		}
		this.grossSales = grossSales;
	}
	
	//Restituisce la percentuale di commissione
	public double getCommissionRate () {
		return commissionRate;
	}
	
	//Imposta la percentuale di commissione
	public void setCommissionRate (double commissionRate) {
		if (commissionRate <= 0.0 || commissionRate >= 1.0) {
			throw new IllegalArgumentException("Commission rate must be > 0.0 and < 1.0");
		}
		this.commissionRate = commissionRate;
	}
	
	//Calcola il guadagno
	public double earnings () {
		return getCommissionRate() * getGrossSales();
	}
	
	//Restituisce rappresentazione stringa di CommissionEmployee
	@Override //Questo metodo ridefinisce quello di una superclasse
	public String toString () {
		return String.format("%s: %s %s%n%s: %s%n%s: %.2f%n%s: %.2f",
				"commission employee", getFirstName(), getLastName(),
				"social security number", getSocialSecurityNumber(),
				"gross sales", getGrossSales(),
				"commission rate", getCommissionRate());
	}
}

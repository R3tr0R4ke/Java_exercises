package Interfaccia;

public class SalariedEmployee extends Employee{
	private double weeklySalary;
	
	//Costruttore
	public SalariedEmployee (String firstName, String lastName,
			String socialSecurityNumber, double weeklySalary) {
		super(firstName, lastName, socialSecurityNumber);
		
		if (weeklySalary < 0.0) {
			throw new IllegalArgumentException("Weekly salary must be >= 0.0");
		}
		this.weeklySalary = weeklySalary;
	}
	
	//Imposta lo stipendio
	public void setWeeklySalary (double weeklySalary) {
		if (weeklySalary < 0.0) {
			throw new IllegalArgumentException("Weekly salary must be >= 0.0");
		}
		this.weeklySalary = weeklySalary;
	}
	
	//Restituisce lo stipendio
	public double getWeeklySalary () {
		return weeklySalary;
	}
	
	@Override //Calcola il guadagno ridefinendo il metodo astratto ereditato
	public double earnings() {
		return getWeeklySalary();
	}
	
	@Override //Restituisce una rappresentazione in formato stringa
	public String toString() {
		return String.format("salaried employee: %s%n%s: $%,.2f",
				super.toString(), "weekly salary", getWeeklySalary());
	}
}

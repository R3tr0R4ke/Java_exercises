package Interfaccia;

public class BasePlusCommissionEmployee extends CommissionEmployee{
	private double baseSalary;	//Stipendio base settimanale
	
	//Costruttore
	public BasePlusCommissionEmployee(String firstName, String lastName,
			String socialSecurityNumber, double grossSales,
			double commissionRate, double baseSalary) {
		super(firstName, lastName, socialSecurityNumber, grossSales, commissionRate);
		
		if (baseSalary < 0.0) {	//Valida baseSalary
			throw new IllegalArgumentException("Base salary must be >= 0.0");
		}
		this.baseSalary = baseSalary;
	}
	
	//Imposta lo stipendio base
	public void setBaseSalary(double baseSalary) {
		if (baseSalary < 0.0) {	//Valida
			throw new IllegalArgumentException("Base salary must be >= 0.0");
		}
		this.baseSalary = baseSalary;
	}
	
	//Restituisce lo stipendio base
	public double getBaseSalary() {
		return baseSalary;
	}
	
	@Override //Calcola il guadagno ridfinendo il metodo di CommissionEmployee
	public double earnings() {
		return getBaseSalary() + super.earnings();
	}

	@Override //Restituisce una rappresentazione in formato stringa
	public String toString() {
		return String.format("%s %s; %n%s: $%,.2f",
				"base-salaried", super.toString(),
				"base salary", getBaseSalary());
	}
}

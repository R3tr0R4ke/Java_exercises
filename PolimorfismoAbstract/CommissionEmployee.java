package PolimorfismoAbstract;

public class CommissionEmployee extends Employee{
	private double grossSales;	//Vendite lorde settimanali
	private double commissionRate;	//Percentuale commissione
	
	//Costruttore
	public CommissionEmployee(String firstName, String lastName, 
			String socialSecurityNumber, double grossSales, double commissionRate) {
		super(firstName, lastName, socialSecurityNumber);
		
		if (commissionRate <= 0.0 || commissionRate >= 1.0) {	//Valida commossionRate
			throw new IllegalArgumentException("Commission rate must be > 0.0 and < 1.0");
		}
		if (grossSales < 0.0) {	//Valida
			throw new IllegalArgumentException("Gross sales must be >= 0.0");
		}
		
		this.grossSales = grossSales;
		this.commissionRate = commissionRate;
	}
	
	//Restituisce le vendite lorde
	public double getGrossSales() {
		return grossSales;
	}
	
	//Imposta le vendite lorde
	public void setGrossSales(double grossSales) {
		if (commissionRate <= 0.0 || commissionRate >= 1.0) {	//Valida
			throw new IllegalArgumentException("Gross sales must be >= 0.0");
		}
		this.grossSales = grossSales;
	}
	
	//Imposta la commissione
	public void setCommissionRate(double commissionRate) {
		if (commissionRate <= 0.0 || commissionRate >= 1.0) {	//Valida
			throw new IllegalArgumentException("Commission rate must be > 0.0 and < 1.0");
		}
		this.commissionRate = commissionRate;
	}
	
	//Restituisce la commissione
	public double getCommissionRate() {
		return commissionRate;
	}

	@Override //Calcola il guadagno ridefinendo il metodo astratto ereditato
	public double earnings() {
		return getCommissionRate() * getGrossSales();
	}
	
	@Override //Restituisce una rappresentazione in formato stringa
	public String toString() {
		return String.format("%s: %s%n%s: $%,.2f; %n%s: %.2f",
				"commission employee", super.toString(),
				"gross sales", getGrossSales(),
				"commission rate", getCommissionRate());
	}
}

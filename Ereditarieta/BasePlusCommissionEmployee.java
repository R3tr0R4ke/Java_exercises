package Ereditarieta;

public class BasePlusCommissionEmployee extends CommissionEmployee{
	private double baseSalary;			//Stipendio base settimanale
	
	//Costruttore con sei argomenti
	public BasePlusCommissionEmployee(String firstName, String lastName, 
			String socialSecurityNumber, double grossSales, 
			double commissionRate, double baseSalary) {
			//	Invocazione esplicita al costruttore di CommissionEmployee
			super(firstName, lastName, socialSecurityNumber, grossSales, commissionRate);
			
			//Se baseSalary non è valido viene sollevata un'eccezione
			if (baseSalary < 0.0) {
				throw new IllegalArgumentException("Base salary must be >= 0.0");
			}
			this.baseSalary = baseSalary;
		}
		
	//Restituisce lo stipendio base
	public double getBaseSalary () {
		return baseSalary;
	}
		
	//Imposta lo stipendio base
	public void setBaseSalary (double baseSalary) {
		if (baseSalary < 0.0) {
			throw new IllegalArgumentException("Base salary must be >= 0.0");
		}
		this.baseSalary = baseSalary;
	}
		
	@Override //Calcola il guadagno
	public double earnings () {
		//Non consentito: commissionRate e grossSales sono private nella superclasse
		//Soluzione: utilizza i metodi get
		return getBaseSalary() + (super.earnings());
	}
		
	@Override
	public String toString() {
		//Non consentito: cerca di accedere a membri privati superclasse
		//Soluzione: utilizza i metodi get oppure dichiara nella superclasse le variabili
		//come membro di accesso a protected
		return String.format("%s %s%n%s: %.2f", "base-salaried", super.toString(), "base salary", getBaseSalary());
	}
}

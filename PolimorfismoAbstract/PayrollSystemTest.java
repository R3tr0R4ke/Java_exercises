package PolimorfismoAbstract;

public class PayrollSystemTest {

	public static void main(String[] args) {
		//Crea gli oggetti delle sottoclassi
		SalariedEmployee salariedEmployee = new SalariedEmployee("John", "Smith", "111-11-1111", 800.00);
		HourlyEmployee hourlyEmployee = new HourlyEmployee("Karen", "Price", "222-22-2222", 16.75, 40.0);
		CommissionEmployee commissionEmployee = new CommissionEmployee("Sue", "Jones", "333-33-3333", 10000, .06);
		BasePlusCommissionEmployee basePlusCommissionEmployee = new BasePlusCommissionEmployee("Bob", "Lewis", "444-44-4444", 5000, .04, 300);
		
		System.out.println("Employee processed individually:");
		
		System.out.printf("%n%s%n%s: $%,.2f%n%n",
				salariedEmployee, "earned", salariedEmployee.earnings());
		System.out.printf("%s%n%s: $%,.2f%n%n",
				hourlyEmployee, "earned", hourlyEmployee.earnings());
		System.out.printf("%s%n%s: $%,.2f%n%n",
				commissionEmployee, "earned", commissionEmployee.earnings());
		System.out.printf("%s%n%s: $%,.2f%n%n", basePlusCommissionEmployee,
				"earned", basePlusCommissionEmployee.earnings());

		//Crea un array con diverse tipologie di Employee
		Employee[] employees = new Employee[4];
		
		//Inizializza l'array con diverse tipologie di Employee
		employees[0] = salariedEmployee;
		employees[1] = hourlyEmployee;
		employees[2] = commissionEmployee;
		employees[3] = basePlusCommissionEmployee;
		
		System.out.printf("Employees processed polymorphically:%n%n");
		
		//Elabora in maniera generica ogni elemento dell'array
		for (Employee currentEmployee : employees) {
			System.out.println(currentEmployee);	//Invoca toString
			
			//Verifica se l'elemento è un BasePlusCommissionEmployee
			if (currentEmployee instanceof BasePlusCommissionEmployee) {
				//Downcast: converte il riferimento a Employee in un riferimento
				//a BasePlusCommissionEmployee
				BasePlusCommissionEmployee employee = (BasePlusCommissionEmployee) currentEmployee;
				
				employee.setBaseSalary(1.10 * employee.getBaseSalary());
				
				System.out.printf("new base salary with 10%% increase is: $%,.2f%n", employee.getBaseSalary());
			}
			
			System.out.printf("earned $%,.2f%n%n", currentEmployee.earnings());
		}
		
		//Legge il tipo di ogni oggetto nell'array employees
		for (int j = 0; j < employees.length; j++) {
			System.out.printf("Employee %d is a %s%n", j, employees[j].getClass().getName());
		}
	}

}

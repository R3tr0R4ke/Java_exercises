package Ereditarieta;

public class PolymorphismTest {

	public static void main(String[] args) {
		//Assegna riferimento di superclasse a variabile di superclasse
		CommissionEmployee commissionEmployee = new CommissionEmployee("Sue", "Jones", "222-22-2222", 10000, .06);
		
		//Assegna riferimento di sottoclasse a variabile di sottoclasse
		BasePlusCommissionEmployee basePlusCommissionEmployee = new BasePlusCommissionEmployee("Bob", "Lewis", "333-33-3333", 5000, .04, 300);
		
		//toString su oggetto di superclasse con variabile di superclasse
		System.out.printf("%s %s:%n%n%s%n%n",
				"Call CommissionEmployee's toString with superclass reference ",
				"to superclass object", commissionEmployee.toString());
		
		//toString su oggetto di sottoclasse con variabile di sottoclasse
		System.out.printf("%s %s:%n%n%s%n%n",
				"Call BasePlusCommissionEmployee's toString with subclass",
				"reference to subclass object",
				basePlusCommissionEmployee.toString());
		
		//toString su oggetto di sottoclasse con variabile di superclasse
		CommissionEmployee commissionEmployee2 = basePlusCommissionEmployee;
		System.out.printf("%s %s:%n%n%s%n",
				"Call BasePlusCommissionEmployee's toString with superclass",
				"reference to subclass object", commissionEmployee2.toString());
	}
}
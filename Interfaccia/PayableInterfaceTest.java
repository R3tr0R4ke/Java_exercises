package Interfaccia;

//Prova dell'interfaccia Payable che elabora in maniera polimorfica
//oggetti Employee e Invoice
public class PayableInterfaceTest {
	public static void main (String[] args) {
		
		//Crea un array di quattro elementi Payable
		Payable[] payableObjects = new Payable[] {
				new Invoice("01234", "seat", 2, 375.00),
				new Invoice("5678", "tire", 4, 79.95),
				new SalariedEmployee("John", "Smith", "111-11-1111", 800.00),
				new SalariedEmployee("Lisa", "Barnes", "888-88-8888", 1200.00)
		};
		
		System.out.println("Invoices and Employees processed polymorphically:");
		
		//Elabora genericamente gli elementi dell'array payableObjects
		for (Payable currentPayable : payableObjects) {
			//Visualizza currentPayable e il pagamento corrispondente
			System.out.printf("\"%n%s %npayment due: $%,.2f%n", 
					currentPayable.toString(), // può invocare implicitamente
					currentPayable.getPaymentAmount());
		}
	}

}

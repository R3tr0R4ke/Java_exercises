package MembriStatic;

public class EmployeeTest {
	public static void main(String[] args) {
		//Mostra che il conteggio è 0 prima di creare impiegati
		System.out.printf("Employees before instantiation: %d%n", Employee.getCount());
		
		//Crea due impiegati: il conteggio dovrebbe essere 2
		Employee e1 = new Employee("Susan", "Baker");
		Employee e2 = new Employee("Bob", "Blue");
		
		//Mostra che il conteggio è 2 dopo la creazione di due impiegati
		System.out.printf("%nEmployees after instantiation:%n");
		System.out.printf("Tramite e1.getCount(): %d%n", e1.getCount());
		System.out.printf("Tramite e2.getCount(): %d%n", e2.getCount());
		System.out.printf("Tramite Employee.getCount(): %d%n", Employee.getCount());
		
		//Leggi i nomi degli impiegati
		System.out.printf("%nEmployee 1: %s %s%nEmployee 2: %s %s%n", e1.getFirstName(), e1.getLastName(), e2.getFirstName(), e2.getLastName());
	}
}

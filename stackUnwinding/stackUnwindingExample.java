package stackUnwinding;
//Stack unwinding e recupero di informazioni da un oggetto eccezione

public class stackUnwindingExample {

	public static void main(String[] args) {
		try {
			method1();
		} 
		catch (Exception e) {
			System.err.printf("%s%n%n", e.getMessage());
			e.printStackTrace();
			
			//Ottiene le informazioni della traccia dello stack
			StackTraceElement[] traceElements = e.getStackTrace();
			
			System.out.printf("%nStack trace form getStackTrace:%n");
			System.out.println("Class\t\tFile\t\t\tLine\tMethod");
			
			//Itera su traceElements per ottenere descrizione eccezione
			for (StackTraceElement element : traceElements) {
				System.out.printf("%s\t", element.getClassName());
				System.out.printf("%s\t", element.getFileName());
				System.out.printf("%s\t", element.getLineNumber());
				System.out.printf("%s%n", element.getMethodName());
			}
		}
	}
	
	//Invoca method2: rimanda le eccezioni al main
	public static void method1() throws Exception{
		method2();
	}

	//Invoca method3: rimanda le eccezioni a method1
	public static void method2() throws Exception{
		method3();
	}
	
	//Solleva una nuova eccezione a method2
	public static void method3() throws Exception{
		throw new Exception("Exception thrown in method3");
	}
}

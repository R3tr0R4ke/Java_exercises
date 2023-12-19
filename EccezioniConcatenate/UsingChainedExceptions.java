package EccezioniConcatenate;

public class UsingChainedExceptions {

	public static void main(String[] args) {
		try {
			method1();
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//Invoca method2: rimanda le eccezioni al main
	public static void method1() throws Exception{
		try {
			method2();
		} catch (Exception e) {
			throw new Exception("Exception thrown in method1", e);
		}
	}
	
	//Invoca method3: rimanda le eccezioni al main
	public static void method2() throws Exception{
		try {
			method3();
		} catch (Exception e) {
			throw new Exception("Exception thrown in method2", e);
		}
	}
	
	public static void method3() throws Exception{
		throw new Exception("Exception thrown in method3");
	}

}

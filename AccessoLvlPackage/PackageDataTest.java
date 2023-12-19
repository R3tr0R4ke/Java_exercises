package AccessoLvlPackage;

public class PackageDataTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PackageData packageData = new PackageData();
		
		//Mostra una rappresentazione in formato stirnga di packageData
		System.out.printf("After instantiation:%n%s%n", packageData);
		
		//Modifica i dati ad accesso package nell'oggetto packageData
		packageData.number = 7;
		packageData.string = "Goodbye";
		
		//Mostra una rappresentazione in formato stirnga di packageData
		System.out.printf("%nAfter changing values:%n%s%n", packageData);
	}
}

//Classe con variabili di istanza con accesso a livello di package
class PackageData{
	int number = 0;				//Variabile di istanza ad accesso package
	String string = "Hello";	//Variabile di istanza ad accesso package
	
	//Restituisce una rappresentazione in formato stringa di PackageData
	public String toString () {
		return String.format("number: %d; string: %s", number, string);
	}
}
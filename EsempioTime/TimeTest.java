package EsempioTime;

public class TimeTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// crea e inizializza un oggetto Time1
		Time1 time = new Time1(); // invoca il costruttore di Time1

		// visualizzazione dell'orario in formato stringa
		displayTime("After time object is created", time);
		
		System.out.println();
		
		// modifica l'orario e visualizza quello aggiornato
		time.setTime(13, 27, 6);
		displayTime("After calling setTime", time);
		System.out.println();
		
		// cerca di impostare l'orario con valori non validi
		try {
			time.setTime(99, 99, 99); // tutti valori fuori dall'intervallo
		}
		catch (IllegalArgumentException e) {
			System.out.printf("Exception: %s%n%n", e.getMessage());
		}
		
		// mostra l'orario dopo il tentativo con valori non validi
		displayTime("After calling setTime with invalid values", time);
	}
	
	// visualizza un oggetto Time1 nei formati di 24 e 12 ore
	private static void displayTime(String header, Time1 t) {
		System.out.printf("%s%nUniversal time: %s%nStandard time: %s%n", header, t.toUniversalString(), t.toString());
	}

}

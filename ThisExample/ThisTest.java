package ThisExample;

public class ThisTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SimpleTime time = new SimpleTime(15, 30, 19);
		System.out.println(time.buildString());
	}
}

// la classe SimpleTime mostra il funzionamento del riferimento this.
class SimpleTime {
	private int hour;	//0-23
	private int minute; //0-59
	private int second; //0-59
		
	// se il costruttore usa nomi di parametri identici ai nomi delle variabili di istanza, 
	//per distinguerli è necessario utilizzare il riferimento "this"
	public SimpleTime (int hour, int minute, int second) {
		this.hour = hour;
		this.minute = minute;
		this.second = second;
	}
	
	// uso del "this" esplicito e implicito per invocare toUniversalString
	public String buildString() {
		return String.format("%24s: %s%n%24s: %s", "this.toUniversalString()", this.toUniversalString(), "toUniversalString()", toUniversalString());
	}
		
	// converte in stringa nel formato orario universale (HH:MM:SS)
	public String toUniversalString() {
		// qui non è richiesto "this" per accedere alle variabili
		// di istanza, dato che il metodo non ha variabili locali
		// con gli stessi nomi delle variabili di istanza
		return String.format("%02d:%02d:%02d", this.hour, this.minute, this.second);
	}
}
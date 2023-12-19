package EsempioTime;

public class MemberAccesTest {
	// I membri privati della classe Time1 non sono accessibili.
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Time1 time = new Time1(); // crea e inizializza l'oggetto Time1
			
		time.hour = 7; // errore: hour è un membro privato di Time1
		time.minute = 15; // errore: minute è un membro privato di Time1
		time.second = 30; // errore: second è un membro privato di Time1
	}
}
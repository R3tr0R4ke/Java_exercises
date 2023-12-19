package EsCap9e10;

import java.util.ArrayList;

import EsCap9e10.Motocicletta.TipoGuida;

public class TestVeicoli {

	public static void main(String[] args) {
		//Istanziare un oggetto per ciascuna classe (verificare cosa succede quando si scrive
		//un’istruzione per istanziare un oggetto Veicolo).
		Automobile automobile = new Automobile("BMW", 2006, 4, 0.5);
		Motocicletta motocicletta = new Motocicletta("Suzuki", 1967, TipoGuida.MODERATA, 1200);
		//Non posso istanziare bicicletta in quanto è una classe astratta
		//Bicicletta bicicletta = new Bicicletta("MontagnaBici", 2022, "Carbonio", 5, 2);
		BiciclettaElettrica biciclettaElettrica = new BiciclettaElettrica("UrbanBici", 2005, "Metallo", 6, 2, 58.6, 12);
		//Non posso istanziare veicolo in quanto appartiene a una classe astratta
		//Veicolo veicolo = new Veicolo();
		
		//Utilizzare un contenitore polimorfico (ad esempio, un array o una lista di Veicoli) per gestire
		//tutti i veicoli in modo generico.
		ArrayList<Veicolo> veicoliList = new ArrayList<Veicolo>();
		
		//Carico gli oggetti nell'arrayList
		veicoliList.add(automobile);
		veicoliList.add(motocicletta);
		veicoliList.add(biciclettaElettrica);
		
		//Eseguire operazioni polimorfiche, come chiamare metodi comuni su oggetti di diverse classi.
		for (Veicolo veicolo : veicoliList) {
			System.out.println(veicolo);
		}
		
		/*
		 * Mostrare come il metodo suonaClacson() produce risultati diversi a seconda della
		 * sottoclasse a cui appartiene l'oggetto.
		 * ▪ Evidenzia l'override del metodo suonaClacson() nelle classi derivate, dimostrando
		 * così la polimorficità nell'utilizzo di metodi comuni.
		 */
		System.out.println("\n"+ automobile.suonaClacson());
		System.out.println(motocicletta.suonaClacson());
		System.out.println(biciclettaElettrica.suonaClacson());
		
		/*
		 * Utilizzare un (nuovo) contenitore polimorfico specifico per le biciclette (ad esempio, un
		 * array o una lista di Biciclette) per gestire solo oggetti di questa categoria
		 */
		ArrayList<BiciclettaElettrica> biciElettricheList = new ArrayList<BiciclettaElettrica>();
		
		//Provo a passare un bici con argomenti sbagliati
		try {
			BiciclettaElettrica biciclettaElettrica2 = new BiciclettaElettrica("Pino", 1960, "Acciao", 4, 7, 99.4, 12);
			biciElettricheList.add(biciclettaElettrica2);
		}
		catch (IllegalArgumentException e) {
			System.out.println(e + "\n");
		}
		
		biciElettricheList.add(biciclettaElettrica);
		
		//Stampo la lista delle bici
		for (BiciclettaElettrica bici : biciElettricheList) {
			bici.cambiaMarcia();
			bici.ricaricaBatteria();
			System.out.println(bici + "\n");
		}
	}
}
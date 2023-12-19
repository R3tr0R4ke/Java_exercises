package Esonero;

import Esonero.ProdottoAlimentare.PrincipioNutritivo;

public class TestNegozio {

	public static void main(String[] args) {

		ProdottoAlimentare prodAlimentare1 = new ProdottoAlimentare(null, 10, PrincipioNutritivo.GRASSI, 1);
		Negozio.aggiungiProdotto(prodAlimentare1);

		ProdottoAlimentare prodAlimentare2 = new ProdottoAlimentare("2", 8, PrincipioNutritivo.GRASSI, -2);
		Negozio.aggiungiProdotto(prodAlimentare2);

		ProdottoElettronico prodElettronico1 = new ProdottoElettronico("1", 1.80, 4);
		Negozio.aggiungiProdotto(prodElettronico1);

		ProdottoElettronico prodElettronico2 = new ProdottoElettronico("3", 10, 20);
		Negozio.aggiungiProdotto(prodElettronico2);

		Negozio.stampaProdotti();

		System.out.printf("%n%s : %.2f","Costo totale prodotti: ", Negozio.calcolaTotale());
	}
}
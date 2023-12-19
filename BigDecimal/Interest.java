package BigDecimal;

//Calcolo di interessi composti con BigDecimal
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;

public class Interest {

	public static void main(String[] args) {
		BigDecimal principal = BigDecimal.valueOf(1000.0);		//Capitale iniziale prima degli interessi
		BigDecimal rate = BigDecimal.valueOf(0.05);	//Tasso interesse
		
		//Visualizza intestazioni
		System.out.printf("%s%20s%n", "Year", "Amount on deposit");
		
		//Calcola l'importo del deposito per ciascuno dei dieci anni
		for (int year = 1; year <= 10; year++) {
			//Calcola il nuovo importo per l'anno specificato
			BigDecimal amount = principal.multiply(rate.add(BigDecimal.ONE).pow(year));
			
			//Visualizza l'anno e l'importo
			System.out.printf("%4d%20s%n", year, NumberFormat.getCurrencyInstance().format(amount.setScale(2, RoundingMode.HALF_EVEN)));
		}
	}

}

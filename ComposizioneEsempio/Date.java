package ComposizioneEsempio;

public class Date {
	private int day;
	private int month;
	private int year;
	
	private static final int[] daysPerMonth = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	
	//Costruttore: conferma valore corretto per mese e giorno dato l'anno
	public Date (int month, int day, int year) {
		//controlla se il mese è nell'intervallo
		if (month <= 0 || month > 12) {
			throw new IllegalArgumentException("month (" + month + ") must be 1-12");
		}
		//controlla se il giorno è nell'intervallo corretto in base al mese
		if (day <= 0 || (day > daysPerMonth[month] && !(month == 2 && day == 29))) {
			throw new IllegalArgumentException("day (" + day + ") out-of-range for the specified month and year");
		}
		//controlla l'anno bisestile se il mese è 2 e il giorno è 29
		if (month == 2 && day == 29 && !(year % 400 == 0 || (year % 4 == 0 && year % 100 == 0))) {
			throw new IllegalArgumentException("day (" + day + ") out-of-range for the specified month and year");
		}
		
		this.month = month;
		this.day = day;
		this.year = year;
		
		System.out.printf("Date object constructor for date %s%n", this);
	}
	
	//Restituisce una stringa nel formato mese/giorno/anno
	public String toString() {
		return String.format("%d/%d/%d", month, day, year);
	}
}

package EsempioTime;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.IconifyAction;

public class Time2 {
	private int hour;		//nell'intervallo 00-23
	private int minute;		//nell'intervallo 00-59
	private int second;		//nell'intervallo 00-59
	
	//Costruttore Time2 senza argomenti
	public Time2 () {
		this (0, 0, 0);	//invoca il costruttore con tre argomenti
	}
	
	// costruttore di Time2: ora fornita, minuti e secondi a 0 per default
	public Time2(int hour) {
		this(hour, 0, 0); // invoca il costruttore con tre argomenti
	}
	
	// costruttore di Time2: ora e minuti forniti, secondi a 0 per default
	public Time2(int hour, int minute) {
		this(hour, minute, 0); // invoca il costruttore con tre argomenti
	}
	
	//costruttore di Time 2: ora, minuti e scondi forniti
	public Time2(int hour, int minute, int second) {
		if (hour < 0 || hour >= 24) {
			throw new IllegalArgumentException("hours must be 0-23");
		}
		if (minute < 0 || minute >= 60) {
			throw new IllegalArgumentException("minute must be 0-59");
		}
		if (second < 0 || second >= 60) {
			throw new IllegalArgumentException("second must be 0-59");
		}
		
		this.hour = hour;
		this.minute = minute;
		this.second = second;
	}
	
	// costruttore di Time2: un altro oggetto Time2 fornito
	public Time2(Time2 time) {
		// invoca il costruttore con tre argomenti
		this(time.hour, time.minute, time.second);
	}
	
	// Metodi set
	// imposta un nuovo valore con il formato di orario universale;
	// valida i dati
	public void setTime(int hour, int minute, int second) {
		if (hour < 0 || hour >= 24) {
			throw new IllegalArgumentException("hour must be 0-23");
		}
		if (minute < 0 || minute >= 60) {
			throw new IllegalArgumentException("minute must be 0-59");
		}
		if (second < 0 || second >= 60) {
			throw new IllegalArgumentException("second must be 0-59");
		}
		this.hour = hour;
		this.minute = minute;
		this.second = second;
	}
	
	// valida e imposta l'ora
	public void setHour(int hour) {
		if (hour < 0 || hour >= 24) {
			throw new IllegalArgumentException("hour must be 0-23");
		}
		this.hour = hour;
	}
	
	// valida e imposta i minuti
	public void setMinute(int minute) {
		if (minute < 0 || minute >= 60) {
		throw new IllegalArgumentException("minute must be 0-59");
		}
		this.minute = minute;
	}
	
	// valida e imposta i secondi
	public void setSecond(int second) {
		if (second < 0 || second >= 60) {
			throw new IllegalArgumentException("second must be 0-59");
		}
		this.second = second;
	}
	
	// Metodi get
	// estrae il valore dell'ora
	public int getHour() {
		return hour;
	}
	
	// estrae il valore dei minuti
	public int getMinute() {
		return minute;
	}
	
	// estrae il valore dei secondi
	public int getSecond() {
		return second;
	}
	
	// converte in stringa con il formato orario universale (HH:MM:SS)
	public String toUniversalString() {
		return String.format("%02d:%02d:%02d", getHour(), getMinute(), getSecond());
	}
	
	// converte in stringa con il formato orario standard (H:MM:SS AM o PM)
	public String toString() {
		return String.format("%d:%02d:%02d %s", ((getHour() == 0 || getHour() == 12) ? 12 : getHour() % 12), getMinute(), getSecond(), (getHour() < 12 ? "AM" : "PM"));
	}
}
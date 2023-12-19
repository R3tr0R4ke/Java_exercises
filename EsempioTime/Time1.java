package EsempioTime;

public class Time1 {
	private int hour;		//nell'intervallo 00-23
	private int minute;		//nell'intervallo 00-59
	private int second;		//nell'intervallo 00-59
	
	//Imposta nuova ora usando il formato orario universale
	//solleva un'eccezione se ora, minuti, secondi non sono validi
	public void setTime (int hour, int minute, int second) {
		if (hour < 0 || hour >= 24 || minute < 0 || minute >= 60 || second < 0 || second >= 60) {
			throw new IllegalArgumentException("hour, minute or second was out of range");
		}
		this.hour = hour;
		this.minute = minute;
		this.second = second;
	}
	
	// converte in una stringa in formato orario universale (HH:MM:SS)
	public String toUniversalString() {
		return String.format("%02d:%02d:%02d", hour, minute, second);
	}
	
	// converte in una stringa in formato orario standard (HH:MM:SS AM o PM)
	public String toString() {
		return String.format("%d:%02d:%02d %s", ((hour == 0 || hour == 12) ? 12 : hour % 12), minute, second, (hour < 12 ? "AM" : "PM"));
	}
	
	int cx = 5;
	
	for (int i = 0; i < cx; i++) {
		
	}
}

package tipiEnum;

public enum Book {
	//Dichiara costanti di tipo enum
	JHTP("Java how to program", "2018"),
	CHTP("C How to Program", "2016"),
	IW3HTP("Internet & World Wide Web How to Program", "2012"),
	CPPHTP("C++ How to Program", "2017"),
	VBHTP("Visual Basic How to Program", "2014"),
	CSHARPHTP("Visual C# How to Program", "2017");
	
	//Campi di istanza
	private final String title; 		//Book title
	private final String copyrightYear;	//Copyright year
	
	//Costruttore enum
	Book(String title, String copyrightYear){
		this.title = title;
		this.copyrightYear = copyrightYear;
	}
	
	//Metodo di accesso per il campo title
	public String getTitle() {
		return title;
	}
	
	//Metodo di accesso per il campo copyrightYear
	public String getCopyrightYear () {
		return copyrightYear;
	}
}

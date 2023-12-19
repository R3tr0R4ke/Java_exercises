package ClasseStringBuilder;

public class StringBuilderConstructors {

	public static void main(String[] args) {
		StringBuilder buffer1 = new StringBuilder();	//Default 16 spazi per caratteri
		StringBuilder buffer2 = new StringBuilder(10);	//Capacità caratteri 10
		StringBuilder buffer3 = new StringBuilder("hello");	//Capacità = numero caratteri stringa passata + 16 default
		
		System.out.printf("buffer1 = \"%s\"%n", buffer1);
		System.out.printf("buffer2 = \"%s\"%n", buffer2);
		System.out.printf("buffer3 = \"%s\"%n", buffer3);
	}

}

package ClasseCharacter;

import java.util.Scanner;

public class StaticCharMethods2 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		//Legge la base
		System.out.println("Please enter a radix:");
		int radix = scanner.nextInt();	//Base numerica deve essere tra 2 e 36
		
		//Legge la scelta dell'utente
		System.out.printf("Please choose one:%n1 -%s%n2 -%s%n", "Convert digit to character", "Convert character to digit");
		int choice = scanner.nextInt();
		
		//Elabora la richiesta
		switch (choice) {
			case 1:	//Converte da cifre a carattere
				System.out.println("Enter a digit:");
				int digit = scanner.nextInt();
				System.out.printf("Convert digit to character: %s%n", Character.forDigit(digit, radix));
			break;

			case 2: //Converte da carattere a cifre
				System.out.println("Enter a character:");
				char character = scanner.next().charAt(0);
				System.out.printf("Convert character to digit: %s%n", Character.digit(character, radix));
			break;
		}
		
		scanner.close();
	}
}
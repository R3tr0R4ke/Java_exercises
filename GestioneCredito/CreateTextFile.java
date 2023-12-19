package GestioneCredito;

import java.io.FileNotFoundException;
import java.util.Formatter;
import java.util.FormatterClosedException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class CreateTextFile {

	public static void main(String[] args) {
		//Apre clients.txt, scrive i dati nel file, chiude clients.txt
		try(Formatter output = new Formatter("clients.txt")){
			Scanner input = new Scanner(System.in);
			
			System.out.printf("%s%n%s%n? ",
					"Enter account number, first name, last name and balance.",
					"Enter end-of-file indicator to end input.");

			while(input.hasNext()) {	//Itera fino al terminatore di file
				try {
					//Scrive un nuovo record; presume input valido
					output.format("%d %s %s %.2f%n",  input.nextInt(), input.next(), input.next(), input.nextDouble());
				
				}
				catch (NoSuchElementException elementException) {
					System.err.println("Invalid input. Please try again.");
					input.nextLine(); //Scarta input e l'utente può ritentare
				}
				
				System.out.print("? ");
			}
		}
		catch (SecurityException | FileNotFoundException | FormatterClosedException e) {
			e.printStackTrace();
		}
	}
}
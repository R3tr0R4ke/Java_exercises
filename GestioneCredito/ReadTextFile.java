package GestioneCredito;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class ReadTextFile {

	public static void main(String[] args) {
		try (Scanner input = new Scanner(Paths.get("clients.txt"))) {
			System.out.printf("%-10s%-12s%-12s%10s%n", "Account",
					"First Name", "Last Name", "Balance");

			//Legge record da file
			while(input.hasNext()) {	//Mentre c'è altro da leggere
				//Mostra contenuto record
				System.out.printf("%-10d%-12s%-12s%10.2f%n", 
						input.nextInt(), input.next(), input.next(), input.nextDouble());
			}
		}	
		catch (IOException | NoSuchElementException | IllegalStateException e) {
			e.printStackTrace();
		}
	}
}
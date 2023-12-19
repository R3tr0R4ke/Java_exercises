package SerializationApps;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.NoSuchElementException;
import java.util.Scanner;

import javax.xml.bind.JAXB;

public class CreateSequentialFile {

	public static void main(String[] args) {
		//Apre client.xml, scrive oggetti e poi chiude il file
		try(BufferedWriter output = Files.newBufferedWriter(Paths.get("clients.xml"))){
			Scanner input = new Scanner(System.in);
			
			//Memorizza i conti prima della serializzazione XML
			Accounts accounts = new Accounts();
			
			System.out.printf("%s%n%s%n? ",
					"Enter account number, first name, last name and balance.",
					"Enter end-of-file indicator to end input.");
			
			while(input.hasNext()) {	//Itera fino al terminatore di file
				try {
					//Crea nuovo record
					Account record = new Account(input.nextInt(), input.next(), input.next(), input.nextDouble());
					
					//Aggiunge ad AccountList
					accounts.getAccounts().add(record);
				}
				catch (NoSuchElementException elementException) {
					System.err.println("Invalid input. Please try again.");
					input.nextLine(); //Scarta input, l'utente può ritentare
				}
				
				System.out.print("? ");
			}
			
			//Scrive XML di AccountList da visualizzare
			JAXB.marshal(accounts, output);
		}
		catch (IOException ioException) {
			System.err.println("Error opening file. Terminating.");
		}
	}

}

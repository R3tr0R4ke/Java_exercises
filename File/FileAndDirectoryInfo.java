package File;

import java.io.IOException;
import java.nio.file.*;
import java.util.Scanner;

public class FileAndDirectoryInfo {

	public static void main(String[] args) throws IOException {
		Scanner input = new Scanner(System.in);
		
		System.out.println("Enter file or directory name:");
		//Crea l'oggetto Path in base all'input dell'utente
		Path path = Paths.get(input.nextLine());
		
		//Se il percorso esiste, mostra info
		if(Files.exists(path)) {
			//Mostra informazioni sul file (o sulla directory)
			System.out.printf("%n%s exist%n", path.getFileName());
			System.out.printf("%s a directory%n", Files.isDirectory(path) ? "Is" : "Is not");
			System.out.printf("%s an absolute path%n", path.isAbsolute() ? "Is" : "Is not");
			System.out.printf("Last modified: %s%n", Files.getLastModifiedTime(path));
			System.out.printf("Size: %s%n", Files.size(path));
			System.out.printf("Path: %s%n", path);
			System.out.printf("Absolute path: %s%n", path.toAbsolutePath());

			//Mostra elenco directory
			if (Files.isDirectory(path)) {
				System.out.printf("%nDirectory contents:%n");
				
				//Oggetto per scorrere il contenuto di una directory
				DirectoryStream<Path> directoryStream = Files.newDirectoryStream(path);
				
				for (Path p : directoryStream) {
					System.out.println(p);
				}
			}
		}
		else {	//Né file né directory, stampa messaggio d'errore
			System.out.printf("%s does not exist%n", path);
		}
		
		input.close();
	}

}

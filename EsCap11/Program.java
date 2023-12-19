package EsCap11;

import eccezioni.DataWriteException;

public class Program {

	public static void main(String[] args) {
		System.out.println("Percorso di lavoro corrente: " + System.getProperty("user.dir"));
		
		FileProcessor processor = new FileProcessor();
		FileWriter writer = new FileWriter();
		
		try {
			String[] data = processor.readFile("src/EsCap11/input.txt");
			writer.writeData(data, "src/EsCap11/output.txt");
 		}
		catch (DataWriteException e) {
			System.err.println("Errore di scrittura: " + e.getMessage());
		}
		catch (Exception e) {
			System.err.println("Si è verificato un errore imprevisto: " + e.getMessage());
		}
	}

}
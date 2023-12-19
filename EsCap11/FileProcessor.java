package EsCap11;

import java.io.*;
import java.util.ArrayList;

import eccezioni.InvalidDataException;

public class FileProcessor {
	public String[] readFile(String filePath) throws InvalidDataException, FileNotFoundException, IOException{
		assert filePath != null : "Il percorso del file non può essere nullo";
		
		File file = new File(filePath);
		ArrayList<String> lines = new ArrayList<>();
		
		try (BufferedReader br = new BufferedReader(new FileReader(file))){
			String line;
			while ((line = br.readLine()) != null) {
				if(!line.matches("[0-9]+")) {
					throw new InvalidDataException("Formato dati non valido: " + line);
				}
				lines.add(line);
			}
		} 
		
		String[]  data = lines.toArray(new String[0]);
		assert data != null && !containsNull(data): "L'array di dati non deve contenere elementi nulli";
		return data;
	}
	
	private boolean containsNull(String[] data) {
		for(String s : data) {
			if(s == null) {
				return true;
			}
		}
		return false;
	}
}
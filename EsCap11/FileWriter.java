package EsCap11;

import java.io.*;

import eccezioni.DataWriteException;

public class FileWriter {
	public void writeData(String[] data, String filePath) throws DataWriteException{
		assert filePath != null : "Il percorso del file non può essere nullo";
		
		File file = new File(filePath);
		assert file.exists() && file.canWrite() : "Il file deve esistere ed essere scrivibile";
		
		try(BufferedWriter bw = new BufferedWriter(new java.io.FileWriter(file))){
			for(String line : data) {
				bw.write(line);
				bw.newLine();
			}
		}
		catch (IOException e) {
			throw new DataWriteException("Errore durante la scrittura dei dati: " + e.getMessage());
		}
	}
}
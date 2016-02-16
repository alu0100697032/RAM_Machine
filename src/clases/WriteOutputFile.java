/**
 * File name:WriteOutputFile.java
 * Package name: clases
 * Proyect name: daa_ramMachine
 */
package clases;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


public class WriteOutputFile {
	/**
	 * Constructor: WriteOutputFile
	 */
	public WriteOutputFile(String fileName, OutputTape outputTape) {
		try {

			String tapeContent = outputTape.getTapeContent();

			File outputFile = new File(fileName);

			if (!outputFile.exists()) {
				outputFile.createNewFile();
			}

			FileWriter fw = new FileWriter(outputFile.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(tapeContent);
			bw.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

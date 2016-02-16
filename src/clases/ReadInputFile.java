/**
 * File name:ReadInputFile.java
 * Package name: clases
 * Proyect name: daa_ramMachine
 */
package clases;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ReadInputFile {
	/** 
	 * Atributes
	 */
	private String text;
	
	/**
	 * Constructor: ReadInputFile
	 */
	public ReadInputFile(String fileName) {
		text = "";
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(fileName));

			text = br.readLine();

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				br.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}
	/**
	 * getInputTape
	 */
	public ArrayList<Integer> getInputTape(){
		ArrayList<Integer> inputTape = new ArrayList<>();
		String[] splitedText = text.split(" ");
		for(int i = 0; i < splitedText.length; i++)
			inputTape.add(Integer.parseInt(splitedText[i]));
		return inputTape;
	}
}

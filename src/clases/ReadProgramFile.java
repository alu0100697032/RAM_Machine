/**
 * File name:ReadProgramFile.java
 * Package name: clases
 * Proyect name: daa_ramMachine
 */
package clases;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;

import global.Globals;

public class ReadProgramFile {
	/** 
	 * Atributes
	 */
	private ArrayList<Instruction> program;
	private Hashtable<String, Integer> labelIndexes;
	private ArrayList<String> labels;
	private int currentInstruction;
	/**
	 * Constructor: ReadProgramFile
	 */
	public ReadProgramFile(String fileName) {
		program = new ArrayList<>();
		labelIndexes = new Hashtable<>();
		labels = new ArrayList<>();
		currentInstruction = 0;
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(fileName));
			String line;
			while((line = br.readLine()) != null)
				parseLine(line);
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
	 * parseLine
	 */
	public void parseLine(String line) {
		String text = parseComments(line);
		if(text.length() != 0) {
			text = parseLabels(text);
			text = removeInitialFinalWhites(text);
			parseInstruction(text);
			//System.out.println(text);
		}
	}
	/**
	 * parseComments
	 */
	public String parseComments(String text) {
		String[] splitText = text.split(";");
		if(splitText.length == 1) {
			if(text.startsWith(";"))
				return "";
			else
				return text;
		}
		else 
			return splitText[0];
	}
	/**
	 * parseLabels
	 */
	public String parseLabels(String text) {
		String[] splitText = text.split(":");
		if(splitText.length == 1)
			return text;
		else {
			String label = removeAllWhites(splitText[0]);
			labelIndexes.put(label, currentInstruction);
			labels.add(label);
			return splitText[1];
		}
	}
	/**
	 * removeInitialFinalWhites
	 */
	public String removeInitialFinalWhites(String text) {
		String textWOWhites = text;
		while(textWOWhites.startsWith(" ") || textWOWhites.startsWith("\t"))
			textWOWhites = textWOWhites.substring(1);
		while(textWOWhites.endsWith(" ") || textWOWhites.startsWith("\t"))
			textWOWhites = textWOWhites.substring(0, textWOWhites.length()-1);
		return textWOWhites;
	}
	/**
	 * removeWhites
	 */
	public String removeAllWhites(String text) {
		String textWOWhites = text.replaceAll("\\s", "");
		return textWOWhites;
	}
	/**
	 * parseInstruction
	 */
	public void parseInstruction(String text) {
		String[] splitText = text.split(" ");
		if(splitText.length > 1)
			checkAddressingMode(splitText[0], splitText[1]);
		else
			checkAddressingMode(splitText[0], "");
		currentInstruction++;
	}
	/**
	 * checkAddressing
	 */
	public void checkAddressingMode (String name, String address) {
		int addressingMode = 0;
		if(address.length() == 0) {
			program.add(new SequentialInstruction(name, 0, addressingMode));
		}else if(address.charAt(0) != '=' && address.charAt(0) != '*' && address.charAt(0) != '1'
				&& address.charAt(0) != '2' && address.charAt(0) != '3' && address.charAt(0) != '4'
				&& address.charAt(0) != '5' && address.charAt(0) != '6' && address.charAt(0) != '7' 
				&& address.charAt(0) != '8' && address.charAt(0) != '9' && address.charAt(0) != ' ') {
			program.add(new JumpInstruction(name, address, Globals.JUMP_ADDRESSING));
		}else {
			if(address.startsWith("=")) {
				addressingMode = Globals.IMMEDIATE_ADDRESSING;
				address = address.substring(1);
			}else if (address.startsWith("*")) {
				address = address.substring(1);
				addressingMode = Globals.INDIRECT_ADDRESSING;
			}else
				addressingMode = Globals.REFERENCE_ADDRESSING;
			program.add(new SequentialInstruction(name, Integer.parseInt(address), addressingMode));
		}
	}
	/**
	 * checkValidInstruction
	 */
	public boolean checkValidInstruction(String name) {
		boolean isValid = false;
		switch (name) {
		case "READ":
		case "read":
		case "WRITE":
		case "write":
		case "LOAD":
		case "load":
		case "STORE":
		case "store":
		case "ADD":
		case "add":
		case "SUB":
		case "sub":
		case "MULT":
		case "mult":
		case "DIV":
		case "div":
		case "JUMP":
		case "jump":
		case "JZERO":
		case "jzero":
		case "JGTZ":
		case "jgtz":
		case "HALT":
		case "halt":
			isValid = true;
			break;
		default:
			break;
		}
		return isValid;
	}

	/**
	 * @return the program
	 */
	public ArrayList<Instruction> getProgram() {
		return program;
	}
	/**
	 * @return the labelIndexs
	 */
	public Hashtable<String, Integer> getLabelIndexes() {
		return labelIndexes;
	}
	/**
	 * @return the labels
	 */
	public ArrayList<String> getLabels() {
		return labels;
	}
}

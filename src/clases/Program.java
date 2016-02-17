/**
 * File name:Program.java
 * Package name: clases
 * Proyect name: daa_ramMachine
 */
package clases;

import java.util.ArrayList;
import java.util.Hashtable;

public class Program {
	/** 
	 * Atributes
	 */
	private ArrayList<Instruction> instructions;
	private Hashtable<String, Integer> labelIndexes;
	private ArrayList<String> labels;
	private int currentInstruction;
	
	public Program(ArrayList<Instruction> instructions, Hashtable<String, Integer> labelIndexs, ArrayList<String> labels) {
		setInstructions(instructions);
		setLabelIndexes(labelIndexs);
		setLabels(labels);
		setCurrentInstruction(0);
	}
	/**
	 * showProgram
	 */
	public void showProgram() {
		int labelIndex = 0;
		for(int i = 0; i < instructions.size(); i++) {
			if(labelIndexes.contains(i)) {
				System.out.println(labels.get(labelIndex) + ":\t" + instructions.get(i).instructionToString());
				labelIndex++;
			}else {
				System.out.println("\t" + instructions.get(i).instructionToString());
			}
		}
	}
	/**
	 * @return the instructions
	 */
	public ArrayList<Instruction> getInstructions() {
		return instructions;
	}

	/**
	 * @param instructions the instructions to set
	 */
	public void setInstructions(ArrayList<Instruction> instructions) {
		this.instructions = instructions;
	}

	/**
	 * @return the actualInstruction
	 */
	public int getCurrentInstruction() {
		int aux = currentInstruction;
		return aux;
	}
	
	public void incrementCurrentInstruction(){
		currentInstruction++;
	}
	/**
	 * @param actualInstruction the actualInstruction to set
	 */
	public void setCurrentInstruction(int currentInstruction) {
		this.currentInstruction = currentInstruction;
	}
	/**
	 * @return the labelIndexs
	 */
	public int getLabelIndex(String key) {
		return labelIndexes.get(key);
	}
	/**
	 * @param labelIndexs the labelIndexs to set
	 */
	public void setLabelIndexes(Hashtable<String, Integer> labelIndexes) {
		this.labelIndexes = labelIndexes;
	}
	/**
	 * @param labels the labels to set
	 */
	public void setLabels(ArrayList<String> labels) {
		this.labels = labels;
	}
}

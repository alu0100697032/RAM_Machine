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
	
	public Program(ArrayList<Instruction> instructions, Hashtable<String, Integer> labelIndexs, ArrayList<String> labels) {
		setInstructions(instructions);
		setLabelIndexes(labelIndexs);
		setLabels(labels);
	}
	/**
	 * showProgram
	 */
	public void showProgram() {
		int labelIndex = 0;
		for(int i = 0; i < instructions.size(); i++) {
			if(labelIndexes.contains(i)) {
				System.out.println("Line " + (i+1) + ": " + labels.get(labelIndex) + ":\t" + instructions.get(i).instructionToString());
				labelIndex++;
			}else {
				System.out.println("Line " + (i+1) + ": " + "\t" + instructions.get(i).instructionToString());
			}
		}
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
	public Instruction getCurrentInstruction(int currentInstructionIndex) {
		return instructions.get(currentInstructionIndex);
	}

	/**
	 * @return the labelIndexs
	 */
	public int getLabelIndex(String key) {
		return labelIndexes.get(key);
	}
	/**
	 * checkExistLabel
	 */
	public boolean checkExistLabel(String key) {
		if(labelIndexes.containsKey(key))
			return true;
		else 
			return false;
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

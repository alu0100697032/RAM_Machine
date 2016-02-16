/**
 * File name:Instruction.java
 * Package name: clases
 * Proyect name: daa_ramMachine
 */
package clases;

public abstract class Instruction {
	/** 
	 * Atributes
	 */
	private String name;
	private int addressingMode;
	
	/**
	 * Constructor: Instruction
	 */
	public Instruction(String name, int addressingMode) {
		setName(name);
		setAddressingMode(addressingMode);
	}
	/**
	 * showInstruction
	 */
	public abstract String instructionToString();
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the addressingMode
	 */
	public int getAddressingMode() {
		return addressingMode;
	}

	/**
	 * @param addressingMode the addressingMode to set
	 */
	public void setAddressingMode(int addressingMode) {
		this.addressingMode = addressingMode;
	}
}

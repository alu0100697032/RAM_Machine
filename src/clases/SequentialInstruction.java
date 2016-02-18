/**
 * File name:SequentialInstruction.java
 * Package name: clases
 * Proyect name: daa_ramMachine
 */
package clases;

import global.Globals;

public class SequentialInstruction extends Instruction{
	/** 
	 * Atributes
	 */
	private int address;
	/** 
	 * Constructor: SequentialInstruction
	 */
	public SequentialInstruction(String name, int address, int addressingMode) {
		super(name, addressingMode);
		// TODO Auto-generated constructor stub
		setAddress(address);
	}
	/**
	 * @return the address
	 */
	public int getAddress() {
		return address;
	}
	/**
	 * @param address the address to set
	 */
	public void setAddress(int address) {
		this.address = address;
	}
	/* (non-Javadoc)
	 * @see clases.Instruction#showInstruction()
	 */
	@Override
	public String instructionToString() {
		// TODO Auto-generated method stub
		if(getName().equals("HALT") || getName().equals("halt"))
			return getName();
		else {
			String adsMode = "";
			switch (getAddressingMode()) {
			case Globals.IMMEDIATE_ADDRESSING:
				adsMode = "=";
				break;
			case Globals.INDIRECT_ADDRESSING:
				adsMode = "*";
				break;
			default:
				break;
			}
			return getName() + " " + adsMode + address;
		}
	}
	
}

/**
 * File name:MemoryRegister.java
 * Package name: clases
 * Proyect name: daa_ramMachine
 */
package clases;

import java.util.ArrayList;

public class MemoryRegister {
	/** 
	 * Atributes
	 */
	private ArrayList<Integer> registers;
	/**
	 * Constructor: MemoryRegister
	 */
	public MemoryRegister() {
		registers = new ArrayList<>();
		registers.add(0);
	}
	/**
	 * getRegister
	 */
	public int getRegister(int registerPosition) {
		return registers.get(registerPosition);
	}
	/**
	 * addRegister
	 */
	public void addRegister(int value) {
		registers.add(value);
	}
	/**
	 * getAccumulator
	 */
	public int getAccumulator() {
		return registers.get(0);
	}
	/**
	 * setAccumulator
	 */
	public void setAccumulator(int value) {
		registers.set(0, value);
	}
}

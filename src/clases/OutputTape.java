/**
 * File name:OutputTape.java
 * Package name: tests
 * Proyect name: daa_ramMachine
 */
package clases;

import java.util.ArrayList;

public class OutputTape {
	/** 
	 * Atributes
	 */
	private ArrayList<Integer> elements;
	
	/**
	 * Constructor: OutputTape
	 */
	public OutputTape() {
		elements = new ArrayList<>();
	}
	
	/**
	 * addElement
	 */
	public void addElement(int element) {
		this.elements.add(element);
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<Integer> getTape(){
		return (ArrayList<Integer>) elements.clone();
	}
}

/**
 * File name:CintaEntrada.java
 * Package name: tests
 * Proyect name: daa_ramMachine
 */
package clases;

import java.util.ArrayList;

public class InputTape {
	/**
	 * Atributes
	 */
	private ArrayList<Integer> elements;
	
	/**
	 * Constructor: InputTape
	 */
	public InputTape(ArrayList<Integer> elements) {
		setElements(elements);
	}
	
	/**
	 * getElement
	 */
	public int getElement(int position) {
		return elements.get(position);
	}

	/**
	 * @param elementosCinta the elementosCinta to set
	 */
	public void setElements(ArrayList<Integer> elements) {
		this.elements = elements;
	}
}
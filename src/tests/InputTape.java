/**
 * File name:CintaEntrada.java
 * Package name: tests
 * Proyect name: daa_ramMachine
 */
package tests;

import java.util.ArrayList;

public class InputTape {
	/**
	 * Atributos
	 */
	private ArrayList<Integer> elements;

	public InputTape(ArrayList<Integer> elements) {
		setElements(elements);
	}
	
	/**
	 * @return the elementosCinta
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

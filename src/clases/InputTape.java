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
	 * showTape
	 */
	public void showTape() {
		System.out.println("Cinta de entrada: ");
		for(int i = 0; i < elements.size(); i++)
			System.out.print(elements.get(i) + " ");
		System.out.println();
	}
	/**
	 * getSize
	 */
	public int getSize() {
		return elements.size();
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

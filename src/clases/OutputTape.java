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
	
	public String getTapeContent(){
		String content = "";
		for(int i = 0; i < elements.size(); i++)
			content += elements.get(i) + " ";
		return content;
	}
}

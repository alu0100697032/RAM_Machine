/**
 * File name:JumpInstruction.java
 * Package name: clases
 * Proyect name: daa_ramMachine
 */
package clases;

public class JumpInstruction extends Instruction{
	/** 
	 * Atributes
	 */
	private String label;
	
	/** 
	 * Constructor: JumpInstruction
	 */
	public JumpInstruction(String name, String label, int addressingMode) {
		super(name, addressingMode);
		// TODO Auto-generated constructor stub
		setLabel(label);
	}
	/**
	 * @return the label
	 */
	public String getLabel() {
		return label;
	}
	/**
	 * @param label the label to set
	 */
	public void setLabel(String label) {
		this.label = label;
	}
	/* (non-Javadoc)
	 * @see clases.Instruction#showInstruction()
	 */
	@Override
	public String instructionToString() {
		// TODO Auto-generated method stub
		return getName() + " " + label;
	}
}

/**
 * File name:Processor.java
 * Package name: clases
 * Proyect name: daa_ramMachine
 */
package clases;

import global.Globals;

public class Processor {
	/** 
	 * Atributes
	 */
	private MemoryRegister memoryRegister;
	private InputTape inputTape;
	private OutputTape outputTape;
	private Program program;
	private int currentInstructionIndex;
	private boolean stateHalt;
	
	/**
	 * Constructor: Processor
	 */
	public Processor() {
		setMemoryRegister(new MemoryRegister());
		setOutputTape(new OutputTape());
		setStateHalt(false);
	}
	/**
	 * runProgram
	 */
	public void runProgram(InputTape inputTape, Program program, OutputTape outputTape) {
		setInputTape(inputTape);
		setOutputTape(outputTape);
		loadProgram(program);
		while(!isStateHalt()) {
			runInstruction();
		}
	}
	/**
	 * runInstruction
	 */
	public void runInstruction() {
		Instruction currentInstruction = program.getCurrentInstruction(currentInstructionIndex);
		switch (currentInstruction.getName()) {
		case "READ":
		case "read":
			read((SequentialInstruction)currentInstruction);
			break;
		case "WRITE":
		case "write":
			write((SequentialInstruction)currentInstruction);
			break;
		case "LOAD":
		case "load":
			load((SequentialInstruction)currentInstruction);
			break;
		case "STORE":
		case "store":
			store((SequentialInstruction)currentInstruction);
			break;
		case "ADD":
		case "add":
			add((SequentialInstruction)currentInstruction);
			break;
		case "SUB":
		case "sub":
			sub((SequentialInstruction)currentInstruction);
			break;
		case "MULT":
		case "mult":
			mult((SequentialInstruction)currentInstruction);
			break;
		case "DIV":
		case "div":
			div((SequentialInstruction)currentInstruction);
			break;
		case "JUMP":
		case "jump":
			jump((JumpInstruction)currentInstruction);
			break;
		case "JZERO":
		case "jzero":
			jzero((JumpInstruction)currentInstruction);
			break;
		case "JGTZ":
		case "jgtz":
			jgtz((JumpInstruction)currentInstruction);
			break;
		case "HALT":
		case "halt":
			halt();
			break;
		default:
			System.out.println("Error. Invalid instruction. Line: " + currentInstructionIndex);
			break;
		}
	}
	/**
	 * read
	 */
	public void read(SequentialInstruction currentInstruction) {
		switch (currentInstruction.getAddressingMode()) {
		case Globals.IMMEDIATE_ADDRESSING:
			break;
		case Globals.REFERENCE_ADDRESSING:
			if(currentInstruction.getAddress() + 1 > memoryRegister.getSize())
				memoryRegister.addRegister(inputTape.getCurrentPointerElement());
			else
				memoryRegister.setRegister(currentInstruction.getAddress(), inputTape.getCurrentPointerElement());
			inputTape.incrementPointer();
			break;
		default:
			System.out.println("Error. Invalid addressing. Line: " + currentInstructionIndex + ". Read instruction only handle inmediate and reference addressing.");
			break;
		}
		currentInstructionIndex++;
	}
	/**
	 * write
	 */
	public void write(SequentialInstruction currentInstruction) {
		switch (currentInstruction.getAddressingMode()) {
		case Globals.IMMEDIATE_ADDRESSING:
			outputTape.addElement(currentInstruction.getAddress());
			break;
		case Globals.INDIRECT_ADDRESSING:
			break;
		case Globals.REFERENCE_ADDRESSING:
			outputTape.addElement(memoryRegister.getRegister(currentInstruction.getAddress()));
			break;
		default:
			break;
		}
		currentInstructionIndex++;
	}
	/**
	 * load
	 */
	public void load(SequentialInstruction currentInstruction) {
		switch (currentInstruction.getAddressingMode()) {
		case Globals.INDIRECT_ADDRESSING:
			break;
		case Globals.REFERENCE_ADDRESSING:
			memoryRegister.setAccumulator(memoryRegister.getRegister(currentInstruction.getAddress()));
			break;
		default:
			break;
		}
		currentInstructionIndex++;
	}
	/**
	 * store
	 */
	public void store(SequentialInstruction currentInstruction) {
			
	}
	/**
	 * add
	 */
	public void add(SequentialInstruction currentInstruction) {
		switch (currentInstruction.getAddressingMode()) {
		case Globals.IMMEDIATE_ADDRESSING:
			memoryRegister.setAccumulator(memoryRegister.getAccumulator() + currentInstruction.getAddress());
			break;
		case Globals.INDIRECT_ADDRESSING:
			memoryRegister.setAccumulator(memoryRegister.getAccumulator() + memoryRegister.getRegister(currentInstruction.getAddress()));
			break;
		case Globals.REFERENCE_ADDRESSING:
			memoryRegister.setAccumulator(memoryRegister.getRegister(currentInstruction.getAddress()) + memoryRegister.getRegister(memoryRegister.getAccumulator()));//asi o al contrario?
			break;
		default:
			break;
		}
		currentInstructionIndex++;
	}
	/**
	 * sub
	 */
	public void sub(SequentialInstruction currentInstruction) {
		switch (currentInstruction.getAddressingMode()) {
		case Globals.IMMEDIATE_ADDRESSING:
			memoryRegister.setAccumulator(memoryRegister.getAccumulator() - currentInstruction.getAddress());
			break;
		case Globals.INDIRECT_ADDRESSING:
			memoryRegister.setAccumulator(memoryRegister.getAccumulator() - memoryRegister.getRegister(currentInstruction.getAddress()));
			break;
		case Globals.REFERENCE_ADDRESSING:
			memoryRegister.setAccumulator(memoryRegister.getRegister(currentInstruction.getAddress()) - memoryRegister.getRegister(memoryRegister.getAccumulator()));//asi o al contrario?
			break;
		default:
			break;
		}
		currentInstructionIndex++;
	}
	/**
	 * mult
	 */
	public void mult(SequentialInstruction currentInstruction) {
		switch (currentInstruction.getAddressingMode()) {
		case Globals.IMMEDIATE_ADDRESSING:
			memoryRegister.setAccumulator(memoryRegister.getAccumulator() * currentInstruction.getAddress());
			break;
		case Globals.INDIRECT_ADDRESSING:
			memoryRegister.setAccumulator(memoryRegister.getAccumulator() * memoryRegister.getRegister(currentInstruction.getAddress()));
			break;
		case Globals.REFERENCE_ADDRESSING:
			memoryRegister.setAccumulator(memoryRegister.getRegister(currentInstruction.getAddress()) * memoryRegister.getRegister(memoryRegister.getAccumulator()));//asi o al contrario?
			break;
		default:
			break;
		}
		currentInstructionIndex++;
	}
	/**
	 * div
	 */
	public void div(SequentialInstruction currentInstruction) {
		switch (currentInstruction.getAddressingMode()) {
		case Globals.IMMEDIATE_ADDRESSING:
			memoryRegister.setAccumulator(memoryRegister.getAccumulator() / currentInstruction.getAddress());
			break;
		case Globals.INDIRECT_ADDRESSING:
			memoryRegister.setAccumulator(memoryRegister.getAccumulator() / memoryRegister.getRegister(currentInstruction.getAddress()));
			break;
		case Globals.REFERENCE_ADDRESSING:
			memoryRegister.setAccumulator(memoryRegister.getRegister(currentInstruction.getAddress()) / memoryRegister.getRegister(memoryRegister.getAccumulator()));//asi o al contrario?
			break;
		default:
			break;
		}
		currentInstructionIndex++;
	}
	/**
	 * jump
	 */
	public void jump(JumpInstruction currentInstruction) {
		setCurrentInstructionIndex(program.getLabelIndex(currentInstruction.getLabel()));
	}
	/**
	 * jzero
	 */
	public void jzero(JumpInstruction currentInstruction) {
		if(memoryRegister.getAccumulator() == 0)
			setCurrentInstructionIndex(program.getLabelIndex(currentInstruction.getLabel()));
		else
			currentInstructionIndex++;
	}
	/**
	 * jgtz
	 */
	public void jgtz(JumpInstruction currentInstruction) {
		if(memoryRegister.getAccumulator() > 0)
			setCurrentInstructionIndex(program.getLabelIndex(currentInstruction.getLabel()));
		else
			currentInstructionIndex++;
	}
	/**
	 * halt
	 */
	public void halt() {
		setStateHalt(true);
	}
	/**
	 * loadProgram
	 */
	public void loadProgram(Program program) {
		this.program = program;
	}
	/**
	 * @return the memoryRegister
	 */
	public MemoryRegister getMemoryRegister() {
		return memoryRegister;
	}

	/**
	 * @param memoryRegister the memoryRegister to set
	 */
	public void setMemoryRegister(MemoryRegister memoryRegister) {
		this.memoryRegister = memoryRegister;
	}

	/**
	 * @return the outputTape
	 */
	public OutputTape getOutputTape() {
		return outputTape;
	}

	/**
	 * @param outputTape the outputTape to set
	 */
	public void setOutputTape(OutputTape outputTape) {
		this.outputTape = outputTape;
	}
	/**
	 * @return the stateHalt
	 */
	public boolean isStateHalt() {
		return stateHalt;
	}
	/**
	 * @param stateHalt the stateHalt to set
	 */
	public void setStateHalt(boolean stateHalt) {
		this.stateHalt = stateHalt;
	}
	/**
	 * @param inputTape the inputTape to set
	 */
	public void setInputTape(InputTape inputTape) {
		this.inputTape = inputTape;
	}
	/**
	 * @param currentInstruction the currentInstruction to set
	 */
	public void setCurrentInstructionIndex(int currentInstructionIndex) {
		this.currentInstructionIndex = currentInstructionIndex;
	}
}

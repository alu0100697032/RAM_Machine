/**
 * File name:Main.java
 * Package name: main
 * Proyect name: daa_ramMachine
 */
package global;

import clases.InputTape;
import clases.OutputTape;
import clases.Program;
import clases.ReadInputFile;
import clases.ReadProgramFile;
import clases.WriteOutputFile;

public class Main {
	/**
	 * main
	 */
	public static void main(String[] args) {
		//Scanner readFileNames = new Scanner(System.in);
		System.out.println("Introduzca el nombre del fichero con la cinta de entrada: ");
		//ReadInputFile readInputFile = new ReadInputFile(readFileNames.next()); // final version
		ReadInputFile readInputFile = new ReadInputFile("D:\\workspacejava\\daa_ramMachine\\src\\files\\inputFile.txt"); // development version
		InputTape inputTape = new InputTape(readInputFile.getInputTape());
		inputTape.showTape();
		OutputTape outputTape = new OutputTape();
		outputTape.addElement(4);
		//WriteOutputFile writeOutputFile = new WriteOutputFile("D:\\workspacejava\\daa_ramMachine\\src\\files\\outputFile.txt", outputTape);
		ReadProgramFile readProgramFile = new ReadProgramFile("D:\\workspacejava\\daa_ramMachine\\src\\tests\\test2.ram");
		Program program = new Program(readProgramFile.getProgram(), readProgramFile.getLabelIndexes(), readProgramFile.getLabels());
		System.out.println("Secuencia de instrucciones: ");
		program.showProgram();
	}
}

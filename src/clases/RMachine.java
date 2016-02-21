/**
 * File name:RMachine.java
 * Package name: clases
 * Proyect name: daa_ramMachine
 */
package clases;

import java.util.Scanner;

public class RMachine {
	/** 
	 * Atributes
	 */
	private ReadInputFile readInputFile;
	private ReadProgramFile readProgramFile;
	private Processor processor;
	private InputTape inputTape;
	private OutputTape outputTape;
	private Program program;
	/**
	 * Constructor: RMachine
	 */
	public RMachine() {
		
	}
	/**
	 * runSimulator
	 */
	public void runSimulator() {
		boolean run = true;
		boolean reRun = true;
		Scanner userOption = new Scanner(System.in);
		Scanner readFileNames = new Scanner(System.in);
		System.out.println("\n\tSIMULADOR RAM \n");
		while(reRun) {
			System.out.println("- Pulse 'd' para cargar los ficheros por defecto: inputFile.txt, outputFile.txt y test1.ram");
			System.out.println("- Pulse cualquier otra tecla para introducir el nombre de los ficheros");
			String defatult = userOption.next();
			if(defatult.equals("d")) {
				readInputFile = new ReadInputFile("src/files/inputFile.txt");
				String outputFileName = "src/files/outputFile.txt";
				readProgramFile = new ReadProgramFile("src/tests/nn.ram");
				inputTape = new InputTape(readInputFile.getInputTape());
				outputTape = new OutputTape();
				program = new Program(readProgramFile.getProgram(), readProgramFile.getLabelIndexes(), readProgramFile.getLabels());
				processor = new Processor(outputFileName);
			}else {
				System.out.println("Introduzca el nombre del fichero con la cinta de entrada: ");
				readInputFile = new ReadInputFile(readFileNames.next());
				System.out.println("Introduzca el nombre del fichero para volcar la cinta de salida: ");
				String outputFileName = readFileNames.next();
				System.out.println("Introduzca el nombre del fichero con el programa: ");
				readProgramFile = new ReadProgramFile(readFileNames.next());
				inputTape = new InputTape(readInputFile.getInputTape());
				outputTape = new OutputTape();
				program = new Program(readProgramFile.getProgram(), readProgramFile.getLabelIndexes(), readProgramFile.getLabels());
				processor = new Processor(outputFileName);
			}
			while(run) {
				System.out.println("");
				System.out.println("Opciones: ");
				System.out.println("----------------------------------------");
				System.out.println("0: Ejecutar otra simulación/Salir.");
				System.out.println("1: Ver programa y cinta de entrada. ");
				System.out.println("2: Ejecucion completa.");
				System.out.println("3: Ejecutar traza.");
				System.out.println("4: Ver cinta de salida. ");
				System.out.println("----------------------------------------");
				String option = userOption.next();
				switch (option) {
				case "1":
					inputTape.showTape();
					program.showProgram();
					break;
				case "2":
					processor.runProgram(inputTape, program, outputTape);
					break;
				case "3": 
					processor.debugProgram(inputTape, program, outputTape);
					break;
				case "4":
					System.out.println("Cinta de salida: " + outputTape.getTapeContent());
					break;
				case "0":
					run = false;
					break;
				default:
					System.out.println("");
					System.out.println("Opcion no valida! \n");
					break;
				}
			}
			System.out.println("Desea realizar otra ejecución? s/n");
			String option = userOption.next();
			if(option.equals("n"))
				reRun = false;
			else
				run = true;
		}
		readFileNames.close();
		userOption.close();
	}
}

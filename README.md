# Diseño y Análisis de Algoritmos

## Práctica 1: Programar un simulador de una máquina RAM

## Descripción 

La práctica se divide en dos partes:
* Programar un simulador de una máquina RAM que debe permitir ejecutar diversos
programas.
* Realizar un programa RAM que sea ejecutado por el simulador: El programa a
realizar debe calcular el valor nn, donde el valor n se encuentra inicialmente en la cinta de
entrada. En el caso de que n sea un valor negativo, la salida del programa debe ser un 0

## Requisitos

* Diseñar el esquema general de la RAM utilizando un diseño orientado a objetos.
* Se puede realizar el código utilizando los lenguajes C++ o Java.
* El programa a cargar en la máquina, el contenido de la cinta de entrada y el
contenido de la cinta de salida deben ser tres ficheros diferentes. Los nombres de
los ficheros serán introducidos en tiempo de ejecución.
* Las instrucciones del programa pueden estar escritas en mayúscula o en
minúscula y se utilizará el símbolo ; (punto y coma) para introducir comentarios.
* Se comprobará que las instrucciones del programa sean legales: las instrucciones
deben ser implementadas con los direccionamientos permitidos.
* Si la máquina detecta algún error debe mostrar por pantalla un mensaje e indicar la
instrucción que lo generó.
* Cuando la máquina lea la instrucción HALT o detecte algún error pasará a un
estado “halt” y descargará el contenido de la cinta de salida en el fichero
correspondiente.
* El simulador debe ofrecer las siguientes posibilidades:
  * Ver el programa y la cinta de entrada antes de comenzar la ejecución, si el
usuario lo desea
  * Realizar una ejecución completa de todo el programa o una traza de la
ejecución mostrando en cada instrucción el contenido de los registros
utilizados
* * Ver la cinta de salida al finalizar la ejecución, si el usuario lo desea
* El simulador deberá funcionar con los ejemplos de test que se proporcionan en el
aula virtual.

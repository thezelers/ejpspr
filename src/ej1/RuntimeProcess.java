package ej1;

import java.io.IOException;

public class RuntimeProcess {
	public static void main(String[] args) {
		if (args.length <= 0) {
			System.err.println("Se necesita un programa a ejecutar");
			System.exit(-1);
		}
		Runtime runtime = Runtime.getRuntime();
		try {
			Process process = runtime.exec(args);
			//process.destroy();
		} catch (IOException ex) {
			System.err.println("Excepción de E/S!!");
			System.exit(-1);
		}
	}
}

/*
 * A) Ejecuta el programa anterior en eclipse indicando como argumento el
 * programa “notepad.exe”, ¿pasa algo? {Anotacion: Debido a que uso linux para
 * clase el comando "notepad.exe" no esta disponible para mi por lo que el
 * comando que va a ser utilizado es "gedit" que es lo mas parecido para ubuntu
 * 19.04}
 * No ocurre nada, el programam compila y no da errores pero cuando se 
 * ejecuta no se abre el comando al que se llama y no hay respuesta por 
 * terminal 
 * 
 * B) Ahora prueba a comentar la línea “process.destroy();” y vuelve a ejecutarlo.
 * Ahora el comando al que se llama si habre la aplicacion que deberia 
 */

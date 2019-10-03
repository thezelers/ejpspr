package ej1;

import java.io.*;

class JavaPing {
	public static void main(String[] args) {
		Runtime runTime = Runtime.getRuntime(); // se crea un objeto RunTime y se le 
												//da el objeto asociado con la applicacion java actual
		Process process = null; 				//Se crea un objeto proceso y se iniciliza a null
		try {
			process = runTime.exec("ping " + args[0]+" -c 4");  //Se da valor al proceso como la ejecucion de "ping " + args[0]+" -c 4"
			BufferedReader in = new BufferedReader(new InputStreamReader(process.getInputStream()));  // Se crea un bufferedReader que lee de la salida del proceso
			for (int i = 0; i < 10; i++)
				System.out.println("Saludo " + in.readLine());    // en un bucle se sacan las 10 primeras lineas de la salida del proceso 
		} catch (IOException e) {
			System.out.println("No pudimos correr el ping");  // en caso de que no se pudiera ejecutar el comando saltaria este error
			System.exit(-1); // Finaliza el programa con valor -1 lo que significa error
		}
		if (process != null)
			process.destroy();  // si el proceso no es nulo lo destruye y este termina
		try {
			process.waitFor();  //Espera hasta la finalizacion del proceso hijo para seguir con la ejecucion  
		} catch (InterruptedException e) {
			System.out.println("No pudimos esperar por témino"); // Si no llegase el final del proceso hijo salartaria estra alerta
			System.exit(-1); // Finaliza el programa con valor -1 lo que significa error
		}
		System.out.println("Estatus de témino: " + process.exitValue()); // imprime el valor de finalizacion del proceso, si es 0 todo ha ido bien
		System.exit(0); //Finaliza el programa con valor 0 lo que significa que ha sido un exito
	}
}

/*A) Trata de conseguir ejecutar el código anterior para distintas direcciones IP,
 *válidas y no válidas (diferencias entre los valores devueltos en cada ocasión)
 * 
 * {Anotacion el comando ping funciona con parametros predeterminados diferentes en linux y windows, en windows solo se lanzan
 * 4 paquetes por defecto, mientras que en linux no para hasta que lo interumpe el usuario por lo que para que el ejercicio
 * se pueda hacer igual se ha añadido un "-c 4" al final del comando que sirve para que solo se lanzen 4 paquetes como en windows
 * y el proceso pueda retornar un estatus de termino 0; si no se añadiese el ping seguiria y el proceso devuelve un estaus de
 * termino de 143}
 * 
 * Para ejecutar un comando ping hay que añadir en los argumentos una direccion IP en los arguments del run configurations
 * 
 * 1º IP: 131.0.136.66, Válida
 * 2º IP: 69.172.201,153 , No válida
 * 3º IP: 420.150.0.71, No válida 
 * 4º IP: elpain.com, Válida* [104.113.250.186] (Consulta la IP con el dns y hace el ping a esta)
 * 5º IP: 8.8.8.8, Valida
 * 
 * B) Debes comentar el código explicando lo que sucede en cada momento y
 * explicando su porqué. 
 *	
 *	
 * 
 * 
 */

/*
Práctica 3.1. Tienda
18/04/2021  
Vivar Olvera Marco Antonio
201958239
*/

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
 
public class ArchivoTextoNegocio {

	public ArchivoTextoNegocio(){

	}
	
	//este metodo recibe como parámetro la lista de ganancias
	public void crearArchivo(ArrayList<Double> lista) {
		FileWriter ganancias = null;
		try {
			//crea el flujo para escribir en el archivo
			ganancias = new FileWriter("C:\\Users\\mavo0\\Desktop\\TiendaGraf\\src\\ganancias.txt");
			//crea un buffer o flujo intermedio antes de escribir directamente en el archivo
			BufferedWriter bfwriter = new BufferedWriter(ganancias);
			for (Double ganancia : lista) {
				//escribe los datos en el archivo
				bfwriter.write(ganancia + "\n");
			}
			//cierra el buffer intermedio
			bfwriter.close();
			System.out.println("Archivo creado satisfactoriamente..");
 
		} 
		catch (IOException e) {
			e.printStackTrace();
		} 
		finally {
			if (ganancias != null) {
				try {//cierra el flujo principal
					ganancias.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}


	//escribir en el archivo mas elementos
	public void escribirArchivo(ArrayList<Double> lista) {
		FileWriter ganancias = null;
		try {//además de la ruta del archivo recibe un parámetro de tipo boolean, que le indican que se va añadir más registros 
			ganancias = new FileWriter("C:\\Users\\mavo0\\Desktop\\TiendaGraf\\src\\ganancias.txt", true);
			BufferedWriter bfwriter = new BufferedWriter(ganancias);
			for (Double ganancia : lista) {
				//escribe los datos en el archivo
				bfwriter.write(ganancia + "\n");
			}
			bfwriter.close();
			System.out.println("Archivo modificado satisfactoriamente..");
 
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (ganancias != null) {
				try {
					ganancias.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}



	//crea el archivo en disco, retorna la lista de Doubles
	public ArrayList<Double> leerArchivo() {
		// crea el flujo para leer desde el archivo
		File file = new File("C:\\Users\\mavo0\\Desktop\\TiendaGraf\\src\\ganancias.txt");
		ArrayList<Double> ganancias= new ArrayList<Double>();	
		Scanner scanner;
		try {
			//se pasa el flujo al objeto scanner
			scanner = new Scanner(file);
			while (scanner.hasNextDouble()) {
				// el objeto scanner lee linea a linea desde el archivo
				double e=scanner.nextDouble();
				ganancias.add(e);
			}
			//se cierra el ojeto scanner
			scanner.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return ganancias;
	}
	
}
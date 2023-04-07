package Modelo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LecturaDatos {

	//TODO HACER CATCH
    public static ArrayList<String> readAtributos(File fichero) throws IOException {
    	FileReader lector = new FileReader(fichero);
        BufferedReader buffer = new BufferedReader(lector);

        String linea = buffer.readLine();
        String[] aux = linea.split(",");
        List<String> aux2 = Arrays.asList(aux);
        ArrayList<String> atributos = new ArrayList<String>(aux2);
       
        buffer.close();
        lector.close();
        return atributos;
    }
    
    
    //TODO HACER CATCH
    public static ArrayList<ArrayList<String>> readEjemplos(File fichero) throws IOException {
    	FileReader lector = new FileReader(fichero);
        BufferedReader buffer = new BufferedReader(lector);
        ArrayList<ArrayList<String>> ejemplos = new ArrayList<ArrayList<String>>();
        String[] aux;
        List<String> aux2;

        String linea;
        while ((linea = buffer.readLine()) != null) {
        	aux = linea.split(",");
        	aux2 = Arrays.asList(aux);
        	ArrayList<String> aux3 = new ArrayList<String>(aux2);
        	ejemplos.add(aux3);
        }

        buffer.close();
        lector.close();
        System.out.println(ejemplos);
        return ejemplos;
    }
}



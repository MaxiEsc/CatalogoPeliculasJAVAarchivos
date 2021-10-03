package ar.com.maxsoftware.datos;

import ar.com.maxsoftware.excepciones.*;
import ar.com.maxsoftware.peliculas.*;
import java.io.*;
import java.util.*;

public class AccesoDatosImpl implements AccesoDatos {
    
    int indice = 1;
     
    @Override
    public boolean existe(String nArchivo) {
        File archivo = new File(nArchivo);
        return archivo.exists();
    }

    @Override
    public List<Peliculas> listar(String nArchivo) throws LecturaDatosExcepciones {
        File archivo = new File(nArchivo);
        List<Peliculas> peliculas = new ArrayList<>();
        try {
            //almacenamos todos los string en lectura con filereader y los acomodamos por linea con bufferreader 
            BufferedReader lectura = new BufferedReader(new FileReader(archivo));
            //variable de almacenamiento la lectura de lineas y es string le asignamos null para que este vacia
            String linea = null;
            //Con esto tenemos el titulo de la pelicula por linea y se lo asignaremos por lectura de pelicula con su respectivo titulo.
            linea = lectura.readLine();
            while (linea != null) {
                //Recorremos el String por linea gracias a "linea = lectura.readLine();" 
                Peliculas pelicula = new Peliculas(linea);
                peliculas.add(pelicula);
                linea = lectura.readLine();
            }

            lectura.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new LecturaDatosExcepciones("Excepcion!! problema al listar peliculas: " + e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
            throw new LecturaDatosExcepciones("Excepcion!! problema al realizar lectura en listado peliculas: " + e.getMessage());
        }

        return peliculas;
    }

    @Override
    public void escribir(Peliculas movie, String nArchivo, boolean anexar) throws EscrituraDatosExcepciones {
        File archivo = new File(nArchivo);
        try {
            //Se utiliza PrintWriter y FileWriter. FileWriterpara escribir el archivo como tal, PrintWriter para escribir al archivo FILE
            PrintWriter escritura = new PrintWriter(new FileWriter(nArchivo, anexar));
            //Se escribe la pelicula mediante string en el archivo
            escritura.println(movie.toString());
            escritura.close();
            System.out.println("Se ha escrito informacion al archivo, Titulo: " + movie);
        } catch (IOException e) {
            e.printStackTrace();
            throw new EscrituraDatosExcepciones("Excepcion!! Problema al escribir peliculas en el archivo: " + e.getMessage());
        }
    }

    @Override
    public String buscar(String nArchivo, String buscar) throws LecturaDatosExcepciones {
        File archivo = new File(nArchivo);
        //Se va a buscar el archivo y si no se encuentra nada regresa null
        String resultado = null;
        try {
            BufferedReader busqueda = new BufferedReader(new FileReader(archivo));
            String linea = null;
            linea = busqueda.readLine();
            int indice = 1;
            //En este ciclo while tenemos el proceso de busqueda de las peliculas. 
            while (linea != null) {
                //miestras las lineas sean distintas de null el archivo se seguira recorriendo
                if (buscar != null && buscar.equalsIgnoreCase(linea)) {
                    //En caso de encontrar alguna concidencia se devolvera los datos correspondientes
                    resultado = "Pelicula: " + linea + " Encontrada en el indice: " + indice;
                    break;
                }
                indice++;
                linea = busqueda.readLine();
            }
            busqueda.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new LecturaDatosExcepciones("Excepcion!! Problema al buscar peliculas en el archivo: " + e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
            throw new LecturaDatosExcepciones("Excepcion!! Problema al buscar peliculas por linea en el archivo: " + e.getMessage());
        }

        return resultado;
    }

    @Override
    public void crear(String nArchivo) throws AccesoDatosExcepciones {
        File archivo = new File(nArchivo);
        try {
            PrintWriter salida = new PrintWriter(new FileWriter(archivo));
            System.out.println("¡¡Se ha creado el archivo con exito!!");            
            salida.close();
        } catch (IOException e) {
            e.printStackTrace(System.out);
            throw new AccesoDatosExcepciones("Problema al crear el archivo: " + e.getMessage());
        }
    }

    @Override
    public void borrar(String nArchivo) {
        File archivo = new File(nArchivo);        
        if(archivo.exists()){
            archivo.delete();
            System.out.println("Se ha borrado el archivo");
        }
    }

}

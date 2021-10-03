package ar.com.maxsoftware.datos;

import ar.com.maxsoftware.excepciones.*;
import ar.com.maxsoftware.peliculas.Peliculas;
import java.util.*;

public interface AccesoDatos {
    boolean existe(String nArchivo) throws AccesoDatosExcepciones;
    List<Peliculas> listar(String nArchivo) throws LecturaDatosExcepciones;
    void escribir(Peliculas movie, String nArchivo, boolean anexar) throws EscrituraDatosExcepciones;
    String buscar(String nArchivo, String buscar) throws LecturaDatosExcepciones;
    void crear(String nArchivo) throws AccesoDatosExcepciones;
    void borrar(String nArchivo) throws AccesoDatosExcepciones;
}

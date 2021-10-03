package ar.com.maxsoftware.peliculas.negocio;

import ar.com.maxsoftware.datos.*;
import ar.com.maxsoftware.excepciones.AccesoDatosExcepciones;
import ar.com.maxsoftware.excepciones.LecturaDatosExcepciones;
import ar.com.maxsoftware.peliculas.Peliculas;

public class CatalogoPeliculasImpl implements CatalogoPeliculas{
    
    private final AccesoDatos datos;
    
    public CatalogoPeliculasImpl(){
        //con esta idea es para implemantar el acceso a los metodos de la interface
        //Entonces datos apunta a metodos de la clase  AccesoDatosImpl(). por lo cual se utilizaan los datos
        //para acceder a los metodos de esta clase
        //Maneja un concepto parecido a inyeccion de dependencias
        //se interconectan otra clase mediante atributos de esta clase  
        this.datos = new AccesoDatosImpl();
    }
    
    @Override
    public void agregarPelicula(String nPelicula) {
      Peliculas pelicula = new Peliculas(nPelicula);
      boolean anexar = false;
        try {
            anexar = datos.existe(NOMBRE_ARCHIVO);
            datos.escribir(pelicula, NOMBRE_ARCHIVO, anexar);
        } catch (AccesoDatosExcepciones e) {
            System.out.println("Error de acceso a los datos: ");
            e.printStackTrace();
        }
    }

    @Override
    public void listarPeliculas() {
        try {
            int cont = 0;
            var peliculas = this.datos.listar(NOMBRE_ARCHIVO);
            for (Peliculas iterar : peliculas) {
                System.out.println((++cont) + ")" + "Pelicula = " + iterar);
            }
        } catch (LecturaDatosExcepciones e) {
            System.out.println("Error de acceso a datos");
            e.printStackTrace(System.out);
        }        
    }

    @Override
    public void buscarpelicula(String buscar) {
        String resultado = null;
        try {
            resultado = this.datos.buscar(NOMBRE_ARCHIVO, buscar);
            System.out.println("Resultado: " + ((resultado == null)? "No se encuentra la pelicula" : resultado));
        } catch (LecturaDatosExcepciones e) {
           System.out.println("Error de acceso a datos");
           e.printStackTrace(System.out);
        }
    }

    @Override
    public void iniciarCatalogo() {
        try {
            if(this.datos.existe(NOMBRE_ARCHIVO)){
                datos.borrar(NOMBRE_ARCHIVO);
                datos.crear(NOMBRE_ARCHIVO);
            }else{
                datos.crear(NOMBRE_ARCHIVO);                
            }
        } catch (AccesoDatosExcepciones e) {
            System.out.println("Error al iniciar el catalogo de peliculas");
            e.printStackTrace(System.out);            
        }
    }    
}

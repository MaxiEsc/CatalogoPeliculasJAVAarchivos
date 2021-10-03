package CatalogoPeliculasPresentacion;

import ar.com.maxsoftware.peliculas.negocio.*;
import java.util.Scanner;

public class Umain {
    public static void main(String[] args) {
        
        CatalogoPeliculas servicio = new CatalogoPeliculasImpl();
        Scanner in = new Scanner(System.in);
        int opcion;
        
        do {
            System.out.println("_______________________________________________");
            mostrar();
            opcion = Integer.parseInt(in.nextLine());
            System.out.println("");
            switch(opcion) {
                case 1:       
                    System.out.println("iniciando el catalogo de Peliculas");
                    servicio.iniciarCatalogo();
                    break;
                case 2:
                    System.out.println("introdusca el nombre de la Pelicula para agregar");
                    System.out.print("Nombre a listar :");
                    String nombre = in.nextLine();
                    servicio.agregarPelicula(nombre);                    
                    System.out.println("");
                    break;
                case 3:
                    System.out.println("Listando las peliculas");
                    servicio.listarPeliculas();
                    break;
                case 4:
                    System.out.println("Ingrese el nombre de la pelicula que desea buscar");
                    System.out.print("Titulo : ");
                    String buscar = in.nextLine();
                    servicio.buscarpelicula(buscar);
                    System.out.println("");
                    break;
                case 0:
                    System.out.println("Gracias por utilizar este servicio");
                    break;
                default:
                    System.out.println("Ingrese al menos alguna opcion presente en la pantalla");
                    break;
            }
            
        } while (opcion != 0);        
    }
    
    public static void mostrar(){
        System.out.print("""
                         Elije opcion
                          Pulse 1 -> Iniciar catalogo peliculas
                          Pulse 2 -> Agregar pelicula
                          Pulse 3 -> Listar peliculas
                          Pulse 4 -> Buscar peliculas
                          Pulse 0 -> Salir
                          Opcion seleccionada: """);        
    }
    
}

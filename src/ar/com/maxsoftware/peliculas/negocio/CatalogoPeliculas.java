package ar.com.maxsoftware.peliculas.negocio;

public interface CatalogoPeliculas {
    
    String NOMBRE_ARCHIVO = "D:\\Cursos\\Java\\Programacion\\NegocioPeliculasConArchivos\\Catalogo Peliculas\\peliculas.txt";
    
    void agregarPelicula(String nPelicula);
    void listarPeliculas();
    void buscarpelicula(String buscar);
    void iniciarCatalogo();
}
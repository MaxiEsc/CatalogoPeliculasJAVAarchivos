package ar.com.maxsoftware.peliculas;

public class Peliculas {

    private String nombre;
    
    public Peliculas(){}
    
    public Peliculas(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return this.nombre;
    }
    
}

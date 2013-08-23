
package dominio;

import java.io.FileInputStream;

public class Juego {
    private int id_juego;
    private String nombre;
    private String descripcion;
    private double size;
    private double precio;
    private int id_desarrollador;
    private FileInputStream portada;
    


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
}

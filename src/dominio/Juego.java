
package dominio;

import java.io.FileInputStream;

public class Juego {
    private int id;
    private String nombre;
    private String descripcion;
    private double size;
    private double precio;
    private int id_desarrollador;
    private FileInputStream portada;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getId_desarrollador() {
        return id_desarrollador;
    }

    public void setId_desarrollador(int id_desarrollador) {
        this.id_desarrollador = id_desarrollador;
    }

    public FileInputStream getPortada() {
        return portada;
    }

    public void setPortada(FileInputStream portada) {
        this.portada = portada;
    }
    
}


package dominio;

import java.io.FileInputStream;
import java.util.ArrayList;

public class Juego {
    private int id;
    private String nombre;
    private String descripcion;
    private double size;
    private double precio;
    private Desarrollador des;

    public Desarrollador getDes() {
        return des;
    }

    public void setDes(Desarrollador des) {
        this.des = des;
    }
    
    
    private FileInputStream portada;
    
    private ArrayList categorias;
    private ArrayList compras;
    private ArrayList comentarios;

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

    

    public FileInputStream getPortada() {
        return portada;
    }

    public void setPortada(FileInputStream portada) {
        this.portada = portada;
    }

    public ArrayList getCategorias() {
        return categorias;
    }

    public void setCategorias(ArrayList categorias) {
        this.categorias = categorias;
    }

    public ArrayList getCompras() {
        return compras;
    }

    public void setCompras(ArrayList compras) {
        this.compras = compras;
    }

    public ArrayList getComentarios() {
        return comentarios;
    }

    public void setComentarios(ArrayList comentarios) {
        this.comentarios = comentarios;
    }

    @Override
    public String toString() {
        return this.nombre;
    }
    
}


package dominio;

import java.util.Date;

public class Compra {
    private int id_juego;
    private int id_cliente;
    private Date fecha;

    public Compra(int id_juego, int id_cliente, Date fecha) {
        this.id_juego = id_juego;
        this.id_cliente = id_cliente;
        this.fecha = fecha;
    }

    public int getId_juego() {
        return id_juego;
    }

    public void setId_juego(int id_juego) {
        this.id_juego = id_juego;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    
}

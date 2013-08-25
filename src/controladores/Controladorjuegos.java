
package controladores;

import baseDatos.ManejadorBD;
import dominio.Juego;
import java.util.ArrayList;

public class Controladorjuegos {
    
    private static Controladorjuegos INSTANCIA = null;
    private ManejadorBD mbd = ManejadorBD.getInstancia();
    
    public static Controladorjuegos getInstancia(){
        if (INSTANCIA == null)
             INSTANCIA = new Controladorjuegos();
         return INSTANCIA;
    }
    private ArrayList juegos;
    
    public static String SELECT_TODOS = "select * from juegos";
    public static String SELECT_POR_CATEGORIA = "select j.id_juego, j.nombre from juegos j, categorias_juegos cj"+
                                                " where j.id_juego = cj.id_juego and cj.id_categoria = ?";
    public static String INSERT_JUEGO = "insert into juegos (nombre, descripcion, size, precio, id_desarrollador)"+
                                        "values (?,?,?,?,?)";
    
    public void altaJuego(Juego j){
        
    }
}

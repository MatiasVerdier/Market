
package controladores;

import baseDatos.ManejadorBD;
import dominio.Juego;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Controladorjuegos {
    
    private static Controladorjuegos INSTANCIA = null;
    private ManejadorBD mbd = ManejadorBD.getInstancia();
    
    public static Controladorjuegos getInstancia(){
        if (INSTANCIA == null)
             INSTANCIA = new Controladorjuegos();
         return INSTANCIA;
    }
    
    public static String SELECT_TODOS = "select * from juegos";
    public static String SELECT_POR_CATEGORIA = "select j.id_juego, j.nombre from juegos j, categorias_juegos cj"+
                                                " where j.id_juego = cj.id_juego and cj.id_categoria = ?";
    public static String INSERT_JUEGO = "insert into juegos (nombre, descripcion, size, precio, id_desarrollador)"+
                                        "values (?,?,?,?,?)";
    
    public void altaJuego(Juego j){
        
    }
    
    public ArrayList listarJuegosPorCategoria(int id_cat){
        try {
            ArrayList juegos = new ArrayList();
            
            ResultSet res = mbd.selectJuegosPorCategotia(id_cat);
            while(res.next()){
                Juego j = new Juego();
                j.setNombre(res.getString("nombre"));
                j.setId(res.getInt("id_juego"));
                juegos.add(j);
            }
            
            return juegos;
        } catch (SQLException ex) {
            System.out.println(ex.toString());
            return null;
        }
    }
}


package controladores;

import baseDatos.ManejadorBD;
import dominio.Categoria;
import dominio.Cliente;
import dominio.Juego;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

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
    
    public Juego verInfoJuego(int id){
        try {
            Juego j = new Juego();
            
            ResultSet res = mbd.selectInfoBasicaJuego(id);
            res.next();
            
            j.setId(res.getInt("id_juego"));
            j.setNombre(res.getString("nombre"));
            j.setDescripcion(res.getString("descripcion"));
            j.setPrecio(res.getDouble("precio"));
            j.setSize(res.getDouble("size"));
            j.setNick_des(res.getString("nick"));
            
            return j;
        } catch (SQLException ex) {
            System.out.println(ex.toString());
            return null;
        }
    }
    
    public ArrayList verCategoriasPorJuego(int id){
        try {
            ArrayList cats = new ArrayList();
            
            ResultSet res = mbd.selectCategoriasPorJuego(id);
            
            while(res.next()){
                Categoria c = new Categoria();
                c.setId(res.getInt("id_categoria"));
                c.setNombre(res.getString("nombre"));
                cats.add(c);
            }
            
            return cats;
        } catch (SQLException ex) {
            System.out.println(ex.toString());
            return null;
        }
    }
    
    public ArrayList verComprasPorJuego(int id){
        try {
            ArrayList compras = new ArrayList();
            
            ResultSet res = mbd.selectComprasPorJuego(id);
            
            while(res.next()){
                Cliente c = new Cliente();
                c.setNick(res.getString("nick"));
                compras.add(c);
            }
            
            return compras;
        } catch (SQLException ex) {
            System.out.println(ex.toString());
            return null;
        }
    }
}

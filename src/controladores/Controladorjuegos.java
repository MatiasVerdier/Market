
package controladores;

import baseDatos.ManejadorBD;
import dominio.Categoria;
import dominio.Comentario;
import dominio.Desarrollador;
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

    private Controladorjuegos() {
        //mbd.conectar();
    }
    
    public Juego buscarJuegoPorID(int id){
        try {
            ResultSet res = mbd.SELECT("select id_juego, nombre from juegos where id_juego = "+id);
            Juego j = new Juego();
            while (res.next()){
                j.setId(res.getInt("id_juego"));
                j.setNombre(res.getString("nombre"));
            }
            return j;
        } catch (SQLException ex) {
            System.out.println("buscar juego por id "+ex.toString());
            return null;
        }
    }
    
    public int altaJuego(Juego juego, ArrayList cats) {
        int res = 0;
        int i=0;
        try {
            String sql ="insert into juegos (nombre, descripcion, size, precio, id_desarrollador) values (?,?,?,?,?)";
            int idj = mbd.insertJuego(juego, sql);
            while(i< cats.size()){
             Categoria c = (Categoria)cats.get(i);
             res = mbd.insertCatJuego(idj, c.getId());
             i++;
            }
            return res;
        } catch (Exception ex) {
            System.out.println("alta juego "+ex.toString());
            return -1;
        }
        
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
            System.out.println("listar juegos por ategoria "+ex.toString());
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
            Desarrollador des = new Desarrollador();
            des.setNick(res.getString("nick"));
            j.setDes(des);
            
            return j;
        } catch (SQLException ex) {
            System.out.println("ver info juego "+ex.toString());
            return null;
        }
    }
    
    public ArrayList verComentariosJuego(int id){
        try {
            ArrayList coments = new ArrayList();
            
            ResultSet res = mbd.selectComentariosJuego(id);
            while(res.next()){
                Comentario com = new Comentario();
                com.setId(res.getInt("id_comentario"));
                com.setTexto(res.getString("texto"));
                com.setId_juego(res.getInt("id_juego"));
                com.setFecha(res.getDate("fecha"));
                com.setId_usu(res.getInt("id_usuario"));
                com.setId_padre(res.getInt("id_padre"));
                coments.add(com);
                //System.out.println(com.getTexto());
            }
            
            return coments;
        } catch (SQLException ex) {
            System.out.println("ver comentarios juego "+ex.toString());
            return null;
        }
    }
    
    public ArrayList selectRespuestas(int id){
        try {
            ArrayList respuestas = new ArrayList();
            
            ResultSet res = mbd.selectRespuestas(id);
            while(res.next()){
                Comentario com = new Comentario();
                com.setId(res.getInt("id_comentario"));
                com.setTexto(res.getString("texto"));
                com.setId_juego(res.getInt("id_juego"));
                com.setFecha(res.getDate("fecha"));
                com.setId_usu(res.getInt("id_usuario"));
                com.setId_padre(res.getInt("id_padre"));
                respuestas.add(com);
                System.out.println(com.getTexto());
            }
            
            return respuestas;
        } catch (SQLException ex) {
            System.out.println("select respuestas "+ex.toString());
            return null;
        }
    }
    
    public ArrayList listarJuegos(){
        try {
            ArrayList juegos = new ArrayList();
            
            ResultSet res = mbd.selectJuegos();
            while(res.next()){
                Juego j = new Juego();
                j.setId(res.getInt("id_juego"));
                j.setNombre(res.getString("nombre"));
                juegos.add(j);
            }
            
            return juegos;
        } catch (SQLException ex) {
            System.out.println("listar juegos "+ex.toString());
            return null;
        }
    }
    
        public ArrayList listarJuegosConCompras(){
        try {
            ArrayList juegos = new ArrayList();
            
            String sql = "select id_juego, nombre from juegos where id_juego in "+
                         "(select id_juego from compras)";
            
            ResultSet res = mbd.SELECT(sql);
            while(res.next()){
                Juego j = new Juego();
                j.setId(res.getInt("id_juego"));
                j.setNombre(res.getString("nombre"));
                juegos.add(j);
            }
            
            return juegos;
        } catch (SQLException ex) {
            System.out.println("listar juegos "+ex.toString());
            return null;
        }
    } 
    
    public int altaComentario(Comentario c){
        int res;
        try{
            res = mbd.insertComentario(c);
        }
        catch(Exception ex){
            System.out.println("alta comentario "+ex.toString());
            res = -1;
        }
        return res;
    }
    
}


package controladores;

import baseDatos.ManejadorBD;
import dominio.Cliente;
import dominio.Usuario;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class ControladorUsuarios {
    
    private static ControladorUsuarios INSTANCIA = null;
    private ManejadorBD mbd = ManejadorBD.getInstancia();
    
    public static ControladorUsuarios getInstancia(){
        if (INSTANCIA == null)
             INSTANCIA = new ControladorUsuarios();
         return INSTANCIA;
    }
   
    //Modificado 25/8 Matias R
    //se da de alta un cliente
    public void altaCliente(dominio.Cliente user) throws Exception{
        try {
            String sql = "insert into usuarios (nombre, apellido, nick, fecha_nacimiento, email, tipo) values (?,?,?,?,?,?)";
            mbd.insertCliente(user, sql);
        } catch (Exception ex) {
            throw new Exception(ex);
        }
    }
    //Da de alta un desarrollador
    public void altaDesarrollador(dominio.Desarrollador user) throws Exception{
        try {
            String sql = "insert into usuarios (nombre, apellido, nick, fecha_nacimiento, email, sitio_web, tipo) values (?,?,?,?,?,?,?)";
             mbd.insertDesarrollador(user, sql);
        } catch (Exception ex) {
            //Logger.getLogger(ControladorUsuarios.class.getName()).log(Level.SEVERE, null, ex);
            throw new Exception(ex);
        }
    }
    
     
    public ArrayList listarClientes(){
        try {
            ArrayList usuarios = new ArrayList();
            
            ResultSet res = mbd.selectTodosClientes();
            while(res.next()){
                Cliente c = new Cliente();
                c.setNick(res.getString("nick"));
                c.setId(res.getInt("id_usuario"));
                usuarios.add(c);
            }
            
            return usuarios;
        } catch (SQLException ex) {
            System.out.println(ex.toString());
            return null;
        }
    }
     
    public ArrayList listarUsuarios(){
        try {
            ArrayList usuarios = new ArrayList();
            
            ResultSet res = mbd.selectTodosUsuarios();
            while(res.next()){
                Usuario u = new Usuario();
                u.setNick(res.getString("nick"));
                u.setId(res.getInt("id_usuario"));
                usuarios.add(u);
            }
            
            return usuarios;
        } catch (SQLException ex) {
            System.out.println(ex.toString());
            return null;
        }
    }
    
    public Usuario verInfoUsuario(int id){
        try{
            ResultSet res = mbd.selectInfoUsuario(id);
            Usuario u = null;
            while(res.next()){
                if (res.getString("tipo").equals("d")){
                    Desarrollador d = new Desarrollador();
                    d.setWeb(res.getString("sitio_web"));
                    u = d;
                }
                else{
                    Cliente c = new Cliente();
                    u = c;
                }
                u.setId(res.getInt("id_usuario"));
                u.setNombre(res.getString("nombre"));
                u.setApellido(res.getString("apellido"));
                u.setEmail(res.getString("email"));
                u.setNick(res.getString("nick"));
                u.setFecha_nac(res.getDate("fecha_nacimiento"));
                
                InputStream is = res.getBinaryStream("foto");
                FileInputStream fis;
                BufferedImage bi;
                try {
                    bi = ImageIO.read(is);
                    ImageIcon ci = new ImageIcon(bi);
                } catch (IOException ex) {
                    System.out.println(ex.toString());
                }
                
                //u.setFoto();
            }
            return u;
        }catch(SQLException ex){
            System.out.println("ver info usuario "+ex.toString());
            return null;
        }
    }
}

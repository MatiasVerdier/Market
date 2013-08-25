
package controladores;

import baseDatos.ManejadorBD;
import dominio.Usuario;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ControladorUsuarios {
    
    private static ControladorUsuarios INSTANCIA = null;
    private ManejadorBD mbd = ManejadorBD.getInstancia();
    
    public static ControladorUsuarios getInstancia(){
        if (INSTANCIA == null)
             INSTANCIA = new ControladorUsuarios();
         return INSTANCIA;
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
}

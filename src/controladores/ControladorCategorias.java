
package controladores;
import baseDatos.ManejadorBD;
import dominio.Categoria;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ControladorCategorias {
    private static ControladorCategorias INSTANCIA = null;
    private ManejadorBD mbd = ManejadorBD.getInstancia();
    public static ControladorCategorias getInstancia(){
        if (INSTANCIA == null)
             INSTANCIA = new ControladorCategorias();
         return INSTANCIA;
    }
    
    public int altaCategoria(Categoria c){
        String sql = "insert into categorias (nombre) values (?)";
        return mbd.insertCategorias(c, sql);
    }
    
    public ArrayList listarCategorias(){
        try {
            ArrayList categorias = new ArrayList();
            
            ResultSet res = mbd.selectTodasCategorias();
            while(res.next()){
                Categoria cat = new Categoria();
                cat.setNombre(res.getString("nombre"));
                cat.setId(res.getInt("id_categoria"));
                categorias.add(cat);
            }
            
            return categorias;
        } catch (SQLException ex) {
            System.out.println(ex.toString());
            return null;
        }
        
        
    }
}


package controladores;
import baseDatos.ManejadorBD;
import dominio.Categoria;

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
}

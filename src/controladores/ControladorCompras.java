
package controladores;

import baseDatos.ManejadorBD;
import dominio.Cliente;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;



public class ControladorCompras {
    private static ControladorCompras INSTANCIA = null;
    private ManejadorBD mbd = ManejadorBD.getInstancia();
      
    public int altaCompra(dominio.Compra c){
        String sql = "insert into compras values (?,?,?)";
        return mbd.insertCompra(c, sql);
    }
    
    public static ControladorCompras getInstancia(){
        if (INSTANCIA == null)
             INSTANCIA = new ControladorCompras();
         return INSTANCIA;
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


package controladores;

import baseDatos.ManejadorBD;



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
    
    
}

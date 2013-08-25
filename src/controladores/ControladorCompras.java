
package controladores;

import baseDatos.ManejadorBD;


public class ControladorCompras {
    private static ControladorCompras INSTANCIA = null;
    private ManejadorBD mbd = ManejadorBD.getInstancia();
    
    public static ControladorCompras getInstancia(){
        if (INSTANCIA == null)
             INSTANCIA = new ControladorCompras();
         return INSTANCIA;
    }
    
    
}

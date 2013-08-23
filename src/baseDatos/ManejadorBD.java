package baseDatos;
import dominio.Categoria;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ManejadorBD {
    
    private final static String driver = "com.mysql.jdbc.Driver";
    private final static String bd = "jdbc:mysql://localhost:3306/Market";
    private final static String usuario = "root";
    private final static String password = "root";
    
    private Connection conexion;
    private java.sql.Statement st;
    private java.sql.PreparedStatement ps;
    
    private static ManejadorBD instancia = null;
    
    public static ManejadorBD getInstancia(){
        if(instancia == null){
            instancia = new ManejadorBD();
        }
        return instancia;
    }
    ////////////////////////////// se establece la conexion ///////////////////////////
    private ManejadorBD() {
        try{
            Class.forName(driver);
            conexion = DriverManager.getConnection(bd, usuario, password);
            st = conexion.createStatement();
            System.out.println("Conexion exitosa");
        }
        catch(Exception ex){
            System.out.println(ex.toString());
        }
    }
    ////////////////////////////////////////////////////////////////////////////////////
    public java.sql.Statement getStatement(){
        return st;
    }
    
    public int insertCategorias(Categoria c, String sql){
        int res = 0;
        try {
            ps = conexion.prepareStatement(sql);
            ps.setString(1, c.getNombre());
            res = ps.executeUpdate();
            
        } catch (SQLException ex) {
            System.out.println("Error: "+ex.toString());
        }
        return res;
    }
    
}

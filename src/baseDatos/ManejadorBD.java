package baseDatos;
import dominio.Categoria;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
    private Statement st;
    private PreparedStatement ps;
    
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
            ps.close();
            
        } catch (SQLException ex) {
            res = ex.getErrorCode();
        }
        return res;
    }
    
    
    public ResultSet selectTodosUsuarios(){
         ResultSet res;
        try {
            String sql = "select id_usuario, nick from usuarios";
             res = st.executeQuery(sql);
        } catch (SQLException ex) {
            Logger.getLogger(ManejadorBD.class.getName()).log(Level.SEVERE, null, ex);
            res = null;
        }
        return res;
    }
}

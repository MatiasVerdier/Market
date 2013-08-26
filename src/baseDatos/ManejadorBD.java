package baseDatos;
import dominio.Categoria;
import dominio.Usuario;
import java.sql.Connection;
import java.sql.Date;
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
    private final static String bd = "jdbc:mysql://localhost:3306/market";
    private final static String usuario = "root";
    private final static String password = "admin";
    
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
    
    public java.sql.Statement getStatement(){
        return st;
    }
    /******************* METODOS DE CATEGORIAS  *****************/
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
    
    public ResultSet selectTodasCategorias(){
        ResultSet res;
        try {
            String sql = "select id_categoria, nombre from categorias";
            res = st.executeQuery(sql);
        } catch (SQLException ex) {
            System.out.println(ex.toString());
            res = null;
        }
        return res;
    }
    
    /********************* METODOS USUARIOS *********************/
    public ResultSet selectTodosUsuarios(){
        ResultSet res;
        try {
            String sql = "select id_usuario, nick from usuarios";
             res = st.executeQuery(sql);
        } catch (SQLException ex) {
            System.out.println(ex.toString());
            res = null;
        }
        return res;
    }
    
    public ResultSet selectJuego(int id){
        ResultSet res;
        try {
            String sql = "select * from juegos where id_juego = "+id;
            res = st.executeQuery(sql);
        } catch (SQLException ex) {
            System.out.println(ex.toString());
            res = null;
        }
        return res;
    }

    //---------- Insertar nuevo Usuario------------- //Modificado 25/8 Matias R
    public int insertCliente(dominio.Cliente user, String sql) {
       int res = 0;
        try {
            java.sql.Date fec = new java.sql.Date(user.getFecha_nac().getTime());
            
            ps = conexion.prepareStatement(sql);
            ps.setString(1, user.getNombre());
            ps.setString(2, user.getApellido());
            ps.setString(3, user.getNick()); 
            ps.setDate(4, fec);
            ps.setString(5, user.getEmail());
            ps.setString(6, "c");
            res = ps.executeUpdate();
            ps.close();
            
        } catch (SQLException ex) {
            res = ex.getErrorCode();
        }
        return res;
    }
    

 //---------- Insertar nuevo Desarrollador------------- //Modificado 25/8 Matias R
    public int insertDesarrollador(dominio.Desarrollador user, String sql) throws Exception {
       int res = 0;
        try {
            java.sql.Date fec = new java.sql.Date(user.getFecha_nac().getTime());
            ps = conexion.prepareStatement(sql);
            ps.setString(1, user.getNombre());
            ps.setString(2, user.getApellido());
            ps.setString(3, user.getNick()); 
            ps.setDate(4, fec);
            ps.setString(5, user.getEmail());
            ps.setString(6, user.getWeb());
            ps.setString(7, "d");
            res = ps.executeUpdate();
            ps.close();
            
        } catch (SQLException ex) {
            //res = ex.getErrorCode();
            throw new SQLException(ex);
            
        }
        return res;
    }
}



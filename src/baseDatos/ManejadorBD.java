package baseDatos;
import dominio.Categoria;
import dominio.Comentario;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ManejadorBD {
    
    private final static String driver = "com.mysql.jdbc.Driver";
    private final static String bd = "jdbc:mysql://localhost:3306/market";
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
    /*--------------------- se establece la conexion -------------------*/
    private ManejadorBD() {
        try{
            Class.forName(driver);
            conexion = DriverManager.getConnection(bd, usuario, password);
            st = conexion.createStatement();
            System.out.println("Conexion exitosa");
        }
        catch(ClassNotFoundException | SQLException ex){
            System.out.println(ex.toString());
        }
    }
    
    public java.sql.Statement getStatement(){
        return st;
    }
    /******************* INSERTAR CATEGORIA *****************/
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
    /*---------------------- INSERTAR COMPRA -----------------------*/
    public void insertCompra(dominio.Compra c, String sql) throws SQLException{
      try {
            ps = conexion.prepareStatement(sql);
            ps.setInt(1, c.getJuego().getId());
            ps.setInt(2, c.getCliente().getId());
            java.sql.Date fec = new java.sql.Date(c.getFecha().getTime());
            ps.setDate(3, fec);
            ps.executeUpdate();
            ps.close();

        } catch (SQLException ex) {
            throw ex;
        }
    }
    
    /*----------------- LISTAR CATEGORIAS ------------------------*/
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
    
    /*-------------------- LISTAR USUARIOS -------------------------*/
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
    
    /*------------- RETORNA INFORMACION DEL USUARIO -------------------*/
    public ResultSet selectInfoUsuario(int id){
        ResultSet res;
        try {
            String sql = "select * from usuarios where id_usuario = "+id;
            res = st.executeQuery(sql);
        } catch (SQLException ex) {
            System.out.println(ex.toString());
            res = null;
        }
        return res;
    }
    
    
    /*------------------- SELECCIONAR CLIENTES ----------------------*/
    public ResultSet selectTodosClientes(){
        ResultSet res;
        try {
            String sql = "select id_usuario, nick from usuarios where tipo = 'c'";
             res = st.executeQuery(sql);
        } catch (SQLException ex) {
            System.out.println(ex.toString());
            res = null;
        }
        return res;
    }
    
     /*------------------- SELECCIONAR DESARROLLADORES ----------------------*/
    public ResultSet selectDevelopers(){
        ResultSet res;
        try {
            String sql = "select id_usuario, nick from usuarios where tipo = 'd'";
             res = st.executeQuery(sql);
        } catch (SQLException ex) {
            System.out.println(ex.toString());
            res = null;
        }
        return res;
    }
    
    /*------------------- SELECCIONAR POR FILTRO DE BUSQUEDA ----------------------*/
    public ResultSet selectBuscar(String bs){
        ResultSet res;
        try {
            String sql = "select id_usuario, nick from usuarios where nick like '%" + bs + "%'";
             res = st.executeQuery(sql);
        } catch (SQLException ex) {
            System.out.println(ex.toString());
            res = null;
        }
        return res;
    }
    
    /*------------- MUESTRA LOS JUEGOS DE UNA DETERMINADA CATEGORIA --------------*/
    public ResultSet selectJuegosPorCategotia(int id_cat){
        ResultSet res;
        try {
            String sql = "select j.id_juego, j.nombre from juegos j, categorias_juegos cj "+
                    "where cj.id_categoria = "+id_cat+
                    " and cj.id_juego = j.id_juego";
            res = st.executeQuery(sql);
        } catch (SQLException ex) {
            System.out.println(ex.toString());
            res = null;
        }
        return res;
    }
    
    
    /*------------ RETORNA INFORMACION BASICA DEL JUEGO -------------------*/
    public ResultSet selectInfoBasicaJuego(int id){
        ResultSet res;
        try {
            String sql = "select j.*, u.nick from juegos j, usuarios u where j.id_desarrollador = u.id_usuario and j.id_juego ="+id;
            res = st.executeQuery(sql);
        } catch (SQLException ex) {
            System.out.println(ex.toString());
            res = null;
        }
        return res;
    }
    
    /*------------ RETORNA LAS COMPRAS DE UN JUEGO ------------*/
    public ResultSet selectComprasPorJuego(int id){
        ResultSet res;
        try {
            String sql = "select u.nick from usuarios u, compras c "+
                    "where c.id_juego = "+id+" and c.id_usuario = u.id_usuario";
            res = st.executeQuery(sql);
        } catch (SQLException ex) {
            System.out.println(ex.toString());
            res = null;
        }
        return res;
    }

    //---------- Insertar nuevo Usuario------------- //Modificado 25/8 Matias R
    public void insertCliente(dominio.Cliente user, String sql) throws SQLException, IOException{
     
        try {
            java.sql.Date fec = new java.sql.Date(user.getFecha_nac().getTime());
            
            ps = conexion.prepareStatement(sql);
            ps.setString(1, user.getNombre());
            ps.setString(2, user.getApellido());
            ps.setString(3, user.getNick()); 
            ps.setDate(4, fec);
            ps.setString(5, user.getEmail());
            ps.setString(6, "c");
            ps.setBinaryStream(7, user.getFotoFi());
            ps.executeUpdate();
            ps.close();
            
        } catch (SQLException ex) {
            throw ex;
        }
       
    }
    
        public void actualizarCliente(dominio.Cliente user, String sql) throws SQLException, IOException{
     
        try {
            java.sql.Date fec = new java.sql.Date(user.getFecha_nac().getTime());
            
            ps = conexion.prepareStatement(sql);
            ps.setString(1, user.getNombre());
            ps.setString(2, user.getApellido());
            ps.setString(3, user.getNick()); 
            ps.setDate(4, fec);
            ps.setString(5, user.getEmail());
            ps.setBinaryStream(6, user.getFotoFi());
            ps.setInt(7, user.getId());
            ps.execute();
            
            ps.close();
            
        } catch (SQLException ex) {
            throw ex;
        }
       
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
            throw ex;
            
        }
        return res;
    }
  /*-------- RETORNA LAS CATEGORIAS A LAS QUE PERTENECE UN JUEGO ------*/
    public ResultSet selectCategoriasPorJuego(int id){
        ResultSet res;
        try{
            String sql = "select c.id_categoria, c.nombre from categorias c, categorias_juegos cj "+
                        "where cj.id_juego = ? and c.id_categoria = cj.id_categoria";
            
            ps = conexion.prepareStatement(sql);
            ps.setInt(1, id);
            res = ps.executeQuery();
            return res;
            
        }catch(SQLException ex){
            System.out.println("select categorias por juego "+ex.toString());
            return null;
        }

    }
    /*---------------- seleccionar todos los comentarios de un juego ----------------------*/
    public ResultSet selectComentariosJuego(int id){
        ResultSet res;
        try{
            String sql = "select * from comentarios where id_juego = "+id;
            res = st.executeQuery(sql);
            return res;
        }catch(SQLException ex){
            System.out.println("select comentarios juego "+ex.toString());
            return null;
        } 
    }
    
    public ResultSet selectRespuestas(int id){
        ResultSet res;
        try{
            String sql = "select c.* from comentarios c, respuestas r where r.id_padre = "+id+
                         " and c.id_comentario = r.id_com";
            res = st.executeQuery(sql);
            return res;
        }catch(SQLException ex){
            System.out.println("select respuestas"+ex.toString());
            return null;
        }
    }
    
    public ResultSet selectJuegos(){
        ResultSet res;
        try{
            String sql = "select id_juego, nombre from juegos";
            res = st.executeQuery(sql);
            return res;
        }catch(SQLException ex){
            System.out.println("listar juegos"+ex.toString());
            return null;
        }
    }
    
    public int insertComentario(Comentario c){
        int res;
        java.sql.Date fnac = new java.sql.Date(c.getFecha().getTime());
        try{
            String sql = "insert into comentarios (id_juego, texto, fecha, id_usuario, id_padre) "+
                         " values (?,?,?,?)";
            ps = conexion.prepareStatement(sql);
            ps.setInt(1, c.getId_juego());
            ps.setString(2, c.getTexto());
            ps.setDate(3, fnac);
            ps.setInt(4, c.getId_usu());
            ps.setInt(5, c.getId_padre());
            
            res = ps.executeUpdate();
            return res;
        }catch(SQLException ex){
            System.out.println("insert comentario "+ex.toString());
            return -1;
        }
    }
}



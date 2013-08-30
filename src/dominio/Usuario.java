
package dominio;

import clases.CustomImageIcon;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class Usuario {
    private int id;
    private String nombre;
    private String apellido;
    private String tipo;
    //private Calendar fecha_nac;
    private Date fecha_nac;
    private int edad;
    private String nick;
    private String email;
    private FileInputStream foto;
    //private FileInputStream fotofis;
    private CustomImageIcon imagen;

    public CustomImageIcon getImagen() {
        return imagen;
    }

    public void setImagen(CustomImageIcon imagen) {
        this.imagen = imagen;
    }
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

//    public Calendar getFecha_nac() {
//        return fecha_nac;
//    }
//
//    public void setFecha_nac(Calendar fecha_nac) {
//        this.fecha_nac = fecha_nac;
//    }

    public Date getFecha_nac() {
        return fecha_nac;
    }

    public void setFecha_nac(Date fecha_nac) {
        this.fecha_nac = fecha_nac;
    }

    public int getEdad() {
        return edad;
    }

    private void calcular() {
        Calendar hoy = Calendar.getInstance();
        //int dif_y = hoy.get(Calendar.YEAR) - this.fecha_nac.get(Calendar.YEAR);
        //int dif_m = hoy.get(Calendar.MONTH) - this.fecha_nac.get(Calendar.MONTH);
        //int dif_d = hoy.get(Calendar.DAY_OF_MONTH) - this.fecha_nac.get(Calendar.DAY_OF_MONTH); 
        
        //if(dif_m<0 || (dif_m==0 && dif_d<0))
            //dif_y = dif_y – 1;
        
        //this.edad = dif_y;
        }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

       public FileInputStream getFotoFi() throws IOException {
        return foto;
    }
    
    public CustomImageIcon getFoto() throws IOException {
        CustomImageIcon ii = null;
        try {
            
            InputStream is = foto;
           
            BufferedImage bi = ImageIO.read(is);
            ii = new CustomImageIcon(bi);
            
        } catch (IOException ex) {
            throw ex;
        }
        return ii;
    }

    public void setFoto(FileInputStream foto) {
       
        this.foto = foto;
    }

//    public void setFoto(FileInputStream fis) {
//        this.fotofis = fotofis; //To change body of generated methods, choose Tools | Templates.
//    }
    
//    public FileInputStream getFoto2(){
//        return fotofis;
//    }

    
}

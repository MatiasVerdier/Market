package ventanas;

import controladores.ControladorUsuarios;
import dominio.Cliente;
import javax.swing.ImageIcon;
import dominio.Desarrollador;
import dominio.Usuario;
import java.awt.Color;
import java.awt.Image;
import static java.awt.image.ImageObserver.WIDTH;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

public class InformacionPerfil extends javax.swing.JDialog {
    private boolean alta = true;
    private final String servidor = "http://progapli2013.comule.com/";
    private final String carpeta = "imagenes/perfiles/";
    private String path_imagen = "";
    private ControladorUsuarios cu = ControladorUsuarios.getInstancia();
    Usuario u;
    
    public InformacionPerfil(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        
        initComponents();
        this.setLocationRelativeTo(null);
        txtEdad.setText("");
    }
    
    public void cargarInfoPerfil(int id){
        try {   
            this.btn_aceptar.setVisible(false);
            this.btn_cancelar.setText("Salir");
            this.cambiarColor(Color.WHITE);
            
            u = cu.verInfoUsuario(id);
            u.setId(id);
            if (u.getTipo().equals("d")){
                Desarrollador d = (Desarrollador)u;
                this.radio_des.setSelected(true);
                this.txt_web.setText(d.getWeb());
            }
            else{
                this.radio_cli.setSelected(true);
                this.txt_web.setVisible(false);
                this.label_web.setVisible(false);
            }
                
                
            this.txt_nombre.setText(u.getNombre());
            this.txt_ape.setText(u.getApellido());
            this.txt_nick.setText(u.getNick());
            this.txt_email.setText(u.getEmail());
            this.calendarNacimiento.setDateFormatString("dd/MM/yyyy");
            this.calendarNacimiento.setDate(u.getFecha_nac());
            txtEdad.setText(String.valueOf(u.getEdad()));
            this.txt_contraseña.setText(u.getPass());
            
            if (! u.getImg().equals("")){
                int ancho = this.label_imagen.getWidth();
                int alto = this.label_imagen.getHeight();
                
                try{
                    System.out.println(servidor+carpeta+u.getImg());
                    ImageIcon img = new ImageIcon(new URL(servidor+carpeta+u.getImg()));
                    if (img.getIconHeight() > alto || img.getIconWidth() > ancho){
                        ImageIcon img_reducida = new ImageIcon(img.getImage().getScaledInstance(ancho, alto, Image.SCALE_DEFAULT));
                        label_imagen.setIcon(img_reducida);
                    }
                    else{
                        label_imagen.setIcon(img);
                    }
                }
                catch(MalformedURLException ex){
                    JOptionPane.showMessageDialog(this, "Error: "+ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            
            }
            else {
                label_imagen.setIcon( new ImageIcon(getClass().getResource("/recursos/user-icon.png")));
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error: "+ex.getErrorCode(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void cambiarEstado(boolean nom, boolean ape, boolean fnac, boolean nick, boolean email, boolean web, boolean radio, boolean pass){
        this.txt_nombre.setEditable(nom);
        this.txt_ape.setEditable(ape);
        this.calendarNacimiento.setEnabled(fnac);
        this.txt_nick.setEditable(nick);
        this.txt_email.setEditable(email);
        this.txt_web.setEditable(web);
        this.txt_contraseña.setEditable(pass);
        this.radio_cli.setEnabled(radio);
        this.radio_des.setEnabled(radio);
    }
    
    public void cambiarBotones(){
        this.btn_aceptar.setVisible(true);
        this.btn_cancelar.setText("Cancelar");
    }
    
    public void limpiarCampos(){
        this.txt_nombre.setText("");
        this.txt_ape.setText("");
        this.calendarNacimiento.setDate(null);
        this.txt_nick.setText("");
        this.txt_email.setText("");
        this.label_edad.setText("");
        this.txt_web.setText("");
        this.txt_contraseña.setText("");
        this.radio_cli.setSelected(false);
        this.radio_des.setSelected(false);
        this.cambiarBotones();
        this.label_imagen.setIcon(new ImageIcon(getClass().getResource("/recursos/user-icon.png")));
    }
    
    public void cambiarColor(Color c){
        this.txt_nombre.setBackground(c);
        this.txt_ape.setBackground(c);
        this.calendarNacimiento.setBackground(c);
        this.txt_nick.setBackground(c);
        this.txt_email.setBackground(c);
        this.txt_web.setBackground(c);
        this.txt_contraseña.setBackground(c);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tipo_perfil = new javax.swing.ButtonGroup();
        txt_nick = new javax.swing.JTextField();
        txt_email = new javax.swing.JTextField();
        txt_nombre = new javax.swing.JTextField();
        txt_ape = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        btn_cancelar = new javax.swing.JButton();
        btn_aceptar = new javax.swing.JButton();
        label_edad = new javax.swing.JLabel();
        radio_cli = new javax.swing.JRadioButton();
        radio_des = new javax.swing.JRadioButton();
        panel_imagen = new javax.swing.JPanel();
        label_imagen = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btn_new = new javax.swing.JButton();
        perfiles_edit = new javax.swing.JButton();
        txt_web = new javax.swing.JTextField();
        label_web = new javax.swing.JLabel();
        calendarNacimiento = new com.toedter.calendar.JDateChooser();
        jLabel8 = new javax.swing.JLabel();
        txtEdad = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txt_contraseña = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        txt_nick.setEditable(false);
        txt_nick.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        txt_email.setEditable(false);
        txt_email.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        txt_nombre.setEditable(false);
        txt_nombre.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        txt_nombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_nombreActionPerformed(evt);
            }
        });

        txt_ape.setEditable(false);
        txt_ape.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel6.setText("Email");

        jLabel7.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel7.setText("Tipo de Perfil");

        btn_cancelar.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        btn_cancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/close_16.png"))); // NOI18N
        btn_cancelar.setText("Cancelar");
        btn_cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelar(evt);
            }
        });

        btn_aceptar.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        btn_aceptar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/Apply.png"))); // NOI18N
        btn_aceptar.setText("Aceptar");
        btn_aceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_aceptarconsulta(evt);
            }
        });

        label_edad.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N

        tipo_perfil.add(radio_cli);
        radio_cli.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        radio_cli.setText("cliente");
        radio_cli.setEnabled(false);
        radio_cli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radio_cliActionPerformed(evt);
            }
        });

        tipo_perfil.add(radio_des);
        radio_des.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        radio_des.setText("desarrollador");
        radio_des.setEnabled(false);
        radio_des.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radio_desActionPerformed(evt);
            }
        });

        panel_imagen.setBackground(new java.awt.Color(255, 255, 255));

        label_imagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/user-icon.png"))); // NOI18N
        label_imagen.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cargarImagen(evt);
            }
        });

        javax.swing.GroupLayout panel_imagenLayout = new javax.swing.GroupLayout(panel_imagen);
        panel_imagen.setLayout(panel_imagenLayout);
        panel_imagenLayout.setHorizontalGroup(
            panel_imagenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(label_imagen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panel_imagenLayout.setVerticalGroup(
            panel_imagenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(label_imagen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jLabel5.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel5.setText("Nick");

        jLabel2.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel2.setText("Apellido");

        jLabel1.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel1.setText("Nombre");

        jLabel4.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel4.setText("Edad");

        jLabel3.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel3.setText("Fecha de Nacimiento");

        btn_new.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        btn_new.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/user_add_16.png"))); // NOI18N
        btn_new.setToolTipText("Nuevo Usuario");
        btn_new.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                altaPerfil(evt);
            }
        });

        perfiles_edit.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        perfiles_edit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/edit16.png"))); // NOI18N
        perfiles_edit.setToolTipText("Modificar Usuario");
        perfiles_edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modificarInfo(evt);
            }
        });

        txt_web.setEditable(false);
        txt_web.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        txt_web.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_webActionPerformed(evt);
            }
        });

        label_web.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        label_web.setText("Sitio Web");

        calendarNacimiento.setEnabled(false);
        calendarNacimiento.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        calendarNacimiento.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                calendarNacimientoInputMethodTextChanged(evt);
            }
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
        });

        jLabel8.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N

        txtEdad.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        txtEdad.setText("Edad");

        jLabel9.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel9.setText("Contraseña");

        txt_contraseña.setEditable(false);
        txt_contraseña.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panel_imagen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btn_new, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(perfiles_edit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btn_aceptar)
                        .addGap(10, 10, 10)
                        .addComponent(btn_cancelar)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(label_edad, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(306, 306, 306))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel2)
                                            .addComponent(jLabel3))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(calendarNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txt_ape, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtEdad, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txt_contraseña, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(35, 35, 35)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel7)
                                    .addComponent(label_web))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 4, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txt_email, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txt_nick, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(txt_web, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(radio_cli, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(radio_des))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap())))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel1, jLabel2, jLabel3, jLabel4});

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel5, jLabel6, jLabel7, label_web});

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btn_new, perfiles_edit});

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {calendarNacimiento, txt_ape, txt_nombre});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(panel_imagen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(btn_aceptar)
                                .addComponent(btn_cancelar))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(perfiles_edit)
                                .addComponent(btn_new))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txt_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_nick, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_ape, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel2)
                                .addComponent(txt_email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel6)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel7)
                            .addComponent(radio_cli)
                            .addComponent(radio_des)
                            .addComponent(calendarNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel4)
                                .addComponent(label_edad))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txt_web, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(label_web)
                                .addComponent(jLabel8)
                                .addComponent(txtEdad)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_contraseña, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

     private void btn_aceptarconsulta(java.awt.event.ActionEvent evt) {                                     
        try{
            Usuario user = new Usuario();
            if(this.radio_des.isSelected()){
                Desarrollador des = new Desarrollador();
                des.setTipo("d");
                des.setWeb(this.txt_web.getText());
                user = des;
            }
            else if (this.radio_cli.isSelected())
                user.setTipo("c");
                
            user.setNombre(this.txt_nombre.getText());
            user.setApellido(this.txt_ape.getText());
            user.setNick(this.txt_nick.getText());
            user.setFecha_nac(calendarNacimiento.getDate());
            user.setEmail(this.txt_email.getText());
            user.setPass(this.txt_contraseña.getText());
            if (alta == true){
                controladores.ControladorUsuarios.getInstancia().altaUsuario(user);
                JOptionPane.showMessageDialog(null, "El usuario se ha agregado correctamente" , null, WIDTH, null);
            }
            else{
                controladores.ControladorUsuarios.getInstancia().actualizarUsuario(user);
                JOptionPane.showMessageDialog(null, "El usuario se ha actualizado correctamente" , null, WIDTH, null);
            }
        }
        catch(Exception ex){
            JOptionPane.showMessageDialog(this, "Error: "+ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }                                    

    private void radio_cliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radio_cliActionPerformed
        if(radio_cli.isSelected()){
          this.label_web.setVisible(false);
          this.txt_web.setEditable(false);
          this.txt_web.setVisible(false);
        }
    }//GEN-LAST:event_radio_cliActionPerformed

    private void cancelar(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelar
        this.dispose();
    }//GEN-LAST:event_cancelar

    private void cargarImagen(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cargarImagen
        JFileChooser se = new JFileChooser();
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("jpg, png, gif","png", "jpg", "gif");
        se.setFileFilter(filtro);
        se.setFileSelectionMode(JFileChooser.FILES_ONLY);
        int ancho = label_imagen.getHeight();
        int alto = label_imagen.getWidth();
        
        int estado = se.showOpenDialog(null);
        if(estado == JFileChooser.APPROVE_OPTION){
            path_imagen = se.getSelectedFile().getPath();
            ImageIcon img_original = new ImageIcon(se.getSelectedFile().getPath());
            if(img_original.getIconHeight() > ancho || img_original.getIconWidth() > alto){
                ImageIcon img_reducida = new ImageIcon(img_original.getImage().getScaledInstance(ancho, alto, Image.SCALE_DEFAULT));
                label_imagen.setIcon(img_reducida);
            }
            else{
                label_imagen.setIcon(img_original);
            }
        }
    }//GEN-LAST:event_cargarImagen

//    public int edad(String fecha_nac) {     //fecha_nac debe tener el formato dd/MM/yyyy
//   
//    Date fechaActual = new Date();
//    SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
//    String hoy = formato.format(fechaActual);
//    String[] dat1 = fecha_nac.split("/");
//    String[] dat2 = hoy.split("/");
//    int years = Integer.parseInt(dat2[2]) - Integer.parseInt(dat1[2]);
//    int mes = Integer.parseInt(dat2[1]) - Integer.parseInt(dat1[1]);
//    if (mes < 0) {
//      years = years - 1;
//    } else if (mes == 0) {
//      int dia = Integer.parseInt(dat2[0]) - Integer.parseInt(dat1[0]);
//      if (dia > 0) {
//        years = years - 1;
//      }
//    }
//    return years;
//  }
    
    private void altaPerfil(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_altaPerfil
        this.cambiarEstado(true, true,true, true, true, true, true, true);
        this.limpiarCampos();
        this.perfiles_edit.setEnabled(false);
        alta = true;
    }//GEN-LAST:event_altaPerfil

    private void modificarInfo(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modificarInfo
        this.cambiarEstado(true, true, true, true, true, true, true, false);
        this.btn_new.setEnabled(false);
        this.alta = false;
        this.cambiarBotones();
    }//GEN-LAST:event_modificarInfo

    private void radio_desActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radio_desActionPerformed
        if(radio_des.isSelected()){
            this.label_web.setVisible(true);
            this.txt_web.setEditable(true);
            this.txt_web.setVisible(true);
        } 
    }//GEN-LAST:event_radio_desActionPerformed

    private void calendarNacimientoInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_calendarNacimientoInputMethodTextChanged
   
    }//GEN-LAST:event_calendarNacimientoInputMethodTextChanged

    private void txt_nombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_nombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_nombreActionPerformed

    private void txt_webActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_webActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_webActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_aceptar;
    private javax.swing.JButton btn_cancelar;
    private javax.swing.JButton btn_new;
    private com.toedter.calendar.JDateChooser calendarNacimiento;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel label_edad;
    private javax.swing.JLabel label_imagen;
    private javax.swing.JLabel label_web;
    private javax.swing.JPanel panel_imagen;
    private javax.swing.JButton perfiles_edit;
    private javax.swing.JRadioButton radio_cli;
    private javax.swing.JRadioButton radio_des;
    private javax.swing.ButtonGroup tipo_perfil;
    private javax.swing.JLabel txtEdad;
    private javax.swing.JTextField txt_ape;
    private javax.swing.JTextField txt_contraseña;
    private javax.swing.JTextField txt_email;
    private javax.swing.JTextField txt_nick;
    private javax.swing.JTextField txt_nombre;
    private javax.swing.JTextField txt_web;
    // End of variables declaration//GEN-END:variables
}

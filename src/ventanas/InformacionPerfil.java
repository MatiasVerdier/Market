
package ventanas;

import dominio.Cliente;
import dominio.Desarrollador;
import dominio.Usuario;
import static java.awt.image.ImageObserver.WIDTH;
import javax.swing.*;
public class InformacionPerfil extends javax.swing.JDialog {

    public InformacionPerfil(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }
    
    public void cambiarEstado(boolean nom, boolean ape, boolean fnac, boolean nick, boolean email, boolean radio){
        this.txt_nombre.setEditable(nom);
        this.txt_ape.setEditable(ape);
        this.calendarNacimiento.setEnabled(fnac);
        this.txt_nick.setEditable(nick);
        this.txt_email.setEditable(email);
        this.radio_cli.setEnabled(radio);
        this.radio_des.setEnabled(radio);
    }
    
    public void limpiarCampos(){
        this.txt_nombre.setText("");
        this.txt_ape.setText("");
        this.calendarNacimiento.setDate(null);
        this.txt_nick.setText("");
        this.txt_email.setText("");
        this.label_edad.setText("");
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
        jLabel8 = new javax.swing.JLabel();
        calendarNacimiento = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        txt_nick.setEditable(false);
        txt_nick.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N

        txt_email.setEditable(false);
        txt_email.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N

        txt_nombre.setEditable(false);
        txt_nombre.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N

        txt_ape.setEditable(false);
        txt_ape.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N

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
        radio_cli.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        radio_cli.setText("cliente");
        radio_cli.setEnabled(false);
        radio_cli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radio_cliActionPerformed(evt);
            }
        });

        tipo_perfil.add(radio_des);
        radio_des.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        radio_des.setSelected(true);
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
                btn_newActionPerformed(evt);
            }
        });

        perfiles_edit.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        perfiles_edit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/edit16.png"))); // NOI18N
        perfiles_edit.setToolTipText("Modificar Usuario");
        perfiles_edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                perfiles_editActionPerformed(evt);
            }
        });

        txt_web.setEditable(false);
        txt_web.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        txt_web.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_webActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel8.setText("Sitio Web");

        calendarNacimiento.setEnabled(false);
        calendarNacimiento.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N

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
                        .addComponent(btn_aceptar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_cancelar))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(calendarNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_ape))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel6)
                                        .addComponent(jLabel5))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGap(24, 24, 24)
                                            .addComponent(txt_nick, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(txt_email, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addComponent(txt_web, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel8)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel7)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(radio_cli)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(radio_des)))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_nombre)
                        .addGap(286, 286, 286))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(label_edad, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(292, 292, 292)))
                .addGap(2, 2, 2))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel1, jLabel2, jLabel3, jLabel4});

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel5, jLabel6, jLabel7});

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btn_new, perfiles_edit});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(panel_imagen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
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
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txt_email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)
                            .addComponent(txt_ape, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                                .addComponent(jLabel8)))))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //Modificado 25/8 Matias R
    private void btn_aceptarconsulta(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_aceptarconsulta
        Usuario user;
        
        if (this.radio_cli.isSelected()){
            user = new Cliente();
    }else{
            user= new Desarrollador();
            Desarrollador des = (Desarrollador) user;
            des.setWeb(this.txt_web.getText());
        }
        
        user.setNombre(this.txt_nombre.getText());
        user.setApellido(this.txt_ape.getText());
        user.setNick(this.txt_nick.getText());
        user.setFecha_nac(calendarNacimiento.getDate());
        user.setEmail(this.txt_email.getText());
        if(radio_cli.isSelected()){
        try {
            controladores.ControladorUsuarios.getInstancia().altaCliente((Cliente)user);
        } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage() , null, WIDTH, null);
            }
        }else{
            try {
                controladores.ControladorUsuarios.getInstancia().altaDesarrollador((Desarrollador)user);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage() , null, WIDTH, null);
            }
        }
        
    }//GEN-LAST:event_btn_aceptarconsulta

    private void radio_cliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radio_cliActionPerformed
      if(radio_cli.isSelected()){
      txt_web.setEditable(false);
      }
    }//GEN-LAST:event_radio_cliActionPerformed

    private void cancelar(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelar
        this.dispose();
    }//GEN-LAST:event_cancelar

    private void cargarImagen(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cargarImagen
        
    }//GEN-LAST:event_cargarImagen

    private void btn_newActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_newActionPerformed
        this.cambiarEstado(true, true, true, true, true, true);
        this.limpiarCampos();
    }//GEN-LAST:event_btn_newActionPerformed

    private void perfiles_editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_perfiles_editActionPerformed
        // TODO add your handling code here:
        this.cambiarEstado(rootPaneCheckingEnabled, rootPaneCheckingEnabled, rootPaneCheckingEnabled, rootPaneCheckingEnabled, rootPaneCheckingEnabled, false);
        
    }//GEN-LAST:event_perfiles_editActionPerformed

    private void txt_webActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_webActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_webActionPerformed

    private void radio_desActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radio_desActionPerformed
        if(radio_des.isSelected()){
            txt_web.setEditable(true);
        } 
    }//GEN-LAST:event_radio_desActionPerformed

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
    private javax.swing.JLabel label_edad;
    private javax.swing.JLabel label_imagen;
    private javax.swing.JPanel panel_imagen;
    private javax.swing.JButton perfiles_edit;
    private javax.swing.JRadioButton radio_cli;
    private javax.swing.JRadioButton radio_des;
    private javax.swing.ButtonGroup tipo_perfil;
    private javax.swing.JTextField txt_ape;
    private javax.swing.JTextField txt_email;
    private javax.swing.JTextField txt_nick;
    private javax.swing.JTextField txt_nombre;
    private javax.swing.JTextField txt_web;
    // End of variables declaration//GEN-END:variables
}

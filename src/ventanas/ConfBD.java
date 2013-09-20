package ventanas;

import baseDatos.ManejadorBD;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;


public class ConfBD extends javax.swing.JFrame {
    
    private DefaultComboBoxModel modelo_conf = new DefaultComboBoxModel();
    private int ancho = 410, alto = 110;
    
    public ConfBD() {
        initComponents();
        this.combo_conf.setModel(modelo_conf);
        this.setLocationRelativeTo(null);
        this.setSize(ancho, alto);
        
        File carpeta = new File("src/baseDatos/confBD");
        if (!carpeta.exists()){
            carpeta.mkdir();
        }
        cargarConfiguraciones();
    }
    
    
    private void cargarConfiguraciones(){
        modelo_conf.removeAllElements();
        File dir = new File("src/baseDatos/confBD");
        String []archivos = dir.list();
        if (archivos.length != 0){
            for (int i = 0; i<archivos.length; i++){
                String nom_conf = archivos[i];
                nom_conf = nom_conf.substring(0, nom_conf.lastIndexOf("."));

                modelo_conf.addElement(nom_conf);
            }
        }
        else
            modelo_conf.addElement("Vacio");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pass = new javax.swing.JPasswordField();
        nueva = new javax.swing.JButton();
        conectar = new javax.swing.JButton();
        guardar = new javax.swing.JButton();
        cancelar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        user = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        host = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        base = new javax.swing.JTextField();
        puerto = new javax.swing.JTextField();
        combo_conf = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Conectarse a Base de Datos");
        setResizable(false);

        nueva.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        nueva.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/add_16.png"))); // NOI18N
        nueva.setText("Nueva");
        nueva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nuevaActionPerformed(evt);
            }
        });

        conectar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        conectar.setText("Conectar");
        conectar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                conectarActionPerformed(evt);
            }
        });

        guardar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        guardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/04_Save_16x16.png"))); // NOI18N
        guardar.setText("Guardar");
        guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardar_conf(evt);
            }
        });

        cancelar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/close_16.png"))); // NOI18N
        cancelar.setText("Cancelar");
        cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelar(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Usuario");
        jLabel4.setRequestFocusEnabled(false);

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Contraseña");
        jLabel5.setRequestFocusEnabled(false);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Host");
        jLabel2.setRequestFocusEnabled(false);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Nombre BD");
        jLabel3.setRequestFocusEnabled(false);

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Puerto");
        jLabel6.setRequestFocusEnabled(false);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Configuraciones Guardadas");

        combo_conf.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(base))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(user))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pass))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(guardar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cancelar))
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(host, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel6))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(combo_conf, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(conectar)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(nueva)
                            .addComponent(puerto, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel2, jLabel3, jLabel4, jLabel5});

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {conectar, nueva});

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {cancelar, guardar});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(combo_conf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(conectar)
                    .addComponent(nueva))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(host, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(puerto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(base, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(user, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(pass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(guardar)
                    .addComponent(cancelar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void nuevaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nuevaActionPerformed
        this.setSize(ancho, alto+160);
    }//GEN-LAST:event_nuevaActionPerformed

    private void conectarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_conectarActionPerformed
        Properties conf = new Properties();
        String sel = modelo_conf.getSelectedItem().toString()+".properties";
        try {
            FileInputStream fis = new FileInputStream("src/baseDatos/confBD/"+sel);
            conf.load(fis);

            ManejadorBD mbd = ManejadorBD.getInstancia();
            
//            System.out.println("pass "+conf.getProperty("pass"));
//            System.out.println("bd "+conf.getProperty("bd"));
//            System.out.println("host "+conf.getProperty("host"));
//            System.out.println("puerto "+conf.getProperty("puerto"));
//            System.out.println("user "+conf.getProperty("user"));
            
            mbd.setBd(conf.getProperty("bd").toString());
            mbd.setHost(conf.getProperty("host").toString());
            mbd.setPuerto(conf.getProperty("puerto").toString());
            mbd.setUsuario(conf.getProperty("user").toString());
            mbd.setPassword(conf.getProperty("pass").toString());
            try {
                mbd.conectar();
            } catch (SQLException ex) {
                System.err.println(ex.toString());
            }
            Main main = new Main();
            this.setVisible(false);
            main.setVisible(true);
            

        } catch (FileNotFoundException ex) {
            System.err.println(ex.toString());
        } catch (IOException ex) {
            System.err.println(ex.toString());
        }
    }//GEN-LAST:event_conectarActionPerformed

    private void guardar_conf(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardar_conf
        String nom = JOptionPane.showInputDialog("Ingrese el nombre de la nueva configuracion");

        if (nom != null){
            try {
                String n = "src/baseDatos/confBD/"+nom+".properties";
                FileWriter archivo_conf = new FileWriter(n);
                FileInputStream fis = new FileInputStream(n);
                Properties conf = new Properties();
                conf.load(fis);

                conf.put("nombre", nom);
                conf.put("host", this.host.getText());
                conf.put("puerto", this.puerto.getText());
                conf.put("bd", this.base.getText());
                conf.put("user", this.user.getText());
                conf.put("pass", this.pass.getText());

                conf.store(new FileOutputStream(n), "archivo configuracion");
                archivo_conf.close();
                this.cargarConfiguraciones();
                this.setSize(ancho, alto);
            } catch (IOException ex) {
                System.err.println(ex.toString());
            }
        }

    }//GEN-LAST:event_guardar_conf

    private void cancelar(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelar
        this.setSize(ancho, alto);
    }//GEN-LAST:event_cancelar

 
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField base;
    private javax.swing.JButton cancelar;
    private javax.swing.JComboBox combo_conf;
    private javax.swing.JButton conectar;
    private javax.swing.JButton guardar;
    private javax.swing.JTextField host;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JButton nueva;
    private javax.swing.JPasswordField pass;
    private javax.swing.JTextField puerto;
    private javax.swing.JTextField user;
    // End of variables declaration//GEN-END:variables
}

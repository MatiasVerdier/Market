package ventanas;

import baseDatos.ManejadorBD;
import java.awt.GridLayout;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;


public class Main extends javax.swing.JFrame {

    public Main() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        menu_comp = new javax.swing.JButton();
        menu_login = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        carga_datos = new javax.swing.JMenu();
        jMenuItem7 = new javax.swing.JMenuItem();
        arch_salir = new javax.swing.JMenuItem();
        menu_perfil = new javax.swing.JMenu();
        menu_admin_p = new javax.swing.JMenuItem();
        menu_alta_p = new javax.swing.JMenuItem();
        menu_juego = new javax.swing.JMenu();
        menu_admin_j = new javax.swing.JMenuItem();
        menu_alta_j = new javax.swing.JMenuItem();
        menu_categoria = new javax.swing.JMenu();
        menu_alta_c = new javax.swing.JMenuItem();
        menu_acerca = new javax.swing.JMenu();
        jMenuItem6 = new javax.swing.JMenuItem();

        jButton1.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Market");
        setBounds(new java.awt.Rectangle(0, 0, 640, 480));

        jButton2.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/19_Games_48x48.png"))); // NOI18N
        jButton2.setToolTipText("Administrar Juegos");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Perfiles");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AdministrarPerfiles(evt);
            }
        });

        jButton4.setText("Categorias");

        menu_comp.setText("Compra");
        menu_comp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_compActionPerformed(evt);
            }
        });

        menu_login.setText("LogIn");

        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/exit.png"))); // NOI18N
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        carga_datos.setText("Archivo");

        jMenuItem7.setText("Cargar Datos de Prueba");
        carga_datos.add(jMenuItem7);

        arch_salir.setText("Salir");
        arch_salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                arch_salirActionPerformed(evt);
            }
        });
        carga_datos.add(arch_salir);

        jMenuBar1.add(carga_datos);

        menu_perfil.setText("Perfiles");

        menu_admin_p.setText("Administrar Perfiles");
        menu_admin_p.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_admin_pActionPerformed(evt);
            }
        });
        menu_perfil.add(menu_admin_p);

        menu_alta_p.setText("Alta de Perfil");
        menu_alta_p.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_alta_pActionPerformed(evt);
            }
        });
        menu_perfil.add(menu_alta_p);

        jMenuBar1.add(menu_perfil);

        menu_juego.setText("Juegos");

        menu_admin_j.setText("Administrar Juegos");
        menu_admin_j.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_admin_jActionPerformed(evt);
            }
        });
        menu_juego.add(menu_admin_j);

        menu_alta_j.setText("Alta Juego");
        menu_alta_j.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_alta_jActionPerformed(evt);
            }
        });
        menu_juego.add(menu_alta_j);

        jMenuBar1.add(menu_juego);

        menu_categoria.setText("Categorias");

        menu_alta_c.setText("Alta Categoria");
        menu_alta_c.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_alta_cActionPerformed(evt);
            }
        });
        menu_categoria.add(menu_alta_c);

        jMenuBar1.add(menu_categoria);

        menu_acerca.setText("Ayuda");

        jMenuItem6.setText("Acerca de");
        menu_acerca.add(jMenuItem6);

        jMenuBar1.add(menu_acerca);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton4))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(menu_comp)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(menu_login)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton7)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jButton2, jButton3, jButton4, jButton7, menu_comp, menu_login});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(menu_comp)
                    .addComponent(menu_login)
                    .addComponent(jButton7))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jButton2, jButton3, jButton4, jButton7, menu_comp, menu_login});

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void AdministrarPerfiles(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AdministrarPerfiles
        Perfiles p = new Perfiles(this, true);
        p.setVisible(true);
        p.setLocation(300, 200);
    }//GEN-LAST:event_AdministrarPerfiles

    private void menu_admin_pActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_admin_pActionPerformed
        Perfiles p = new Perfiles(this, true);
        p.setVisible(true);
        p.setLocation(300, 200);
    }//GEN-LAST:event_menu_admin_pActionPerformed

    private void menu_alta_pActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_alta_pActionPerformed
        InformacionPerfil ip = new InformacionPerfil(this, true);
        ip.limpiarCampos();
        ip.cambiarEstado(rootPaneCheckingEnabled, rootPaneCheckingEnabled, rootPaneCheckingEnabled, rootPaneCheckingEnabled, rootPaneCheckingEnabled, rootPaneCheckingEnabled);
        ip.setVisible(true);
        
    }//GEN-LAST:event_menu_alta_pActionPerformed

    private void menu_admin_jActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_admin_jActionPerformed
        Juegos j = new Juegos(this, true);
        j.setLocation(300, 200);
        j.setVisible(true);
    }//GEN-LAST:event_menu_admin_jActionPerformed

    private void menu_alta_jActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_alta_jActionPerformed
        AltaJuego aj = new AltaJuego(null, true);
        aj.setLocation(300, 200);
        aj.setVisible(true);
    }//GEN-LAST:event_menu_alta_jActionPerformed

    private void menu_alta_cActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_alta_cActionPerformed
        NuevaCategoria ac = new NuevaCategoria(null, true);
        ac.setVisible(true);
    }//GEN-LAST:event_menu_alta_cActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        Juegos j = new Juegos(this, true);
        j.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jButton7ActionPerformed

    private void arch_salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_arch_salirActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_arch_salirActionPerformed

    private void menu_compActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_compActionPerformed
        // TODO add your handling code here:
        NuevaCompra nc = new NuevaCompra(null,true);
        nc.setVisible(true);
    }//GEN-LAST:event_menu_compActionPerformed


    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Main app = new Main();
                app.setLayout(new GridLayout(3,2));
                app.setLocation(500, 300);
                app.setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem arch_salir;
    private javax.swing.JMenu carga_datos;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton7;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenu menu_acerca;
    private javax.swing.JMenuItem menu_admin_j;
    private javax.swing.JMenuItem menu_admin_p;
    private javax.swing.JMenuItem menu_alta_c;
    private javax.swing.JMenuItem menu_alta_j;
    private javax.swing.JMenuItem menu_alta_p;
    private javax.swing.JMenu menu_categoria;
    private javax.swing.JButton menu_comp;
    private javax.swing.JMenu menu_juego;
    private javax.swing.JButton menu_login;
    private javax.swing.JMenu menu_perfil;
    // End of variables declaration//GEN-END:variables
}

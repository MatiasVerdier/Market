package ventanas;

import controladores.ControladorVersiones;
import dominio.Version;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;



public class Versiones extends javax.swing.JDialog {
ControladorVersiones cv = ControladorVersiones.getInstancia();
ArrayList versiones= new ArrayList();    
    

    public Versiones(java.awt.Frame parent, boolean modal) 
    {
      super (parent, modal);
      initComponents();
      this.setLocationRelativeTo(null);
      this.cargarTabla();
      this.cargaCampos();
     
    }
    
   private void cargaCampos(){
   
       tabla_vers.addMouseListener(new MouseAdapter() 
        {
         public void mouseClicked(MouseEvent e) 
            {
            DefaultTableModel modelo = (DefaultTableModel)tabla_vers.getModel();
            int fila = tabla_vers.rowAtPoint(e.getPoint());
            //int columna = tabla_vers.columnAtPoint(e.getPoint());
            if ((fila > -1))
                {
                 num_vers.setText(modelo.getValueAt(fila,1).toString());
                }
                //estaba aca
                 int i=fila;
                    Version v= (Version)versiones.get(i);
                        num_vers.setText(v.getNro_version().toString());
                        size_vers.setText(String.valueOf(v.getJuego().getSize()));
                        fecha_vers.setText(v.getFecha_alta().toString());
                  
                
            }
        });
   }
    
    private void cargarTabla(){
        DefaultTableModel modelo = (DefaultTableModel)tabla_vers.getModel();
        modelo.setRowCount(0);
        
        try {        
            versiones = cv.verInfoVer();
            int i = 0;
            while (i < versiones.size()){
                Version v = (Version)versiones.get(i);
                String [] fila = {v.getJuego().getNombre(), v.getNro_version(), v.getJuego().getDes().getNick()};
                modelo.addRow(fila);
                i++;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Versiones.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
  
   /*private void cargarCampos(){
       int row = tabla_vers.getSelectedRow();
       String vers = tabla_vers.getValueAt(row, 2).toString();
       num_vers.setText(vers);
   }*/
  
  
  
  
  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        estado = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla_vers = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        num_vers = new javax.swing.JTextField();
        link_vers = new javax.swing.JTextField();
        fecha_vers = new javax.swing.JTextField();
        size_vers = new javax.swing.JTextField();
        rechazada = new javax.swing.JRadioButton();
        aprobada = new javax.swing.JRadioButton();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        motivo = new javax.swing.JTextArea();
        jLabel6 = new javax.swing.JLabel();
        aceptar = new javax.swing.JButton();
        salir = new javax.swing.JButton();

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane2.setViewportView(jTextArea1);

        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Versiones", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        tabla_vers.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Juego", "Version", "Desarrollador"
            }
        ));
        tabla_vers.setColumnSelectionAllowed(true);
        tabla_vers.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(tabla_vers);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Informacion de Version", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Numero Version");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Link Descarga (Jar)");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Fecha de subida");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Tamaño (KB)");

        estado.add(rechazada);
        rechazada.setText("Rechazada");
        rechazada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rechazadaActionPerformed(evt);
            }
        });

        estado.add(aprobada);
        aprobada.setText("Aprobada");
        aprobada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aprobadaActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Establecer Estado");

        motivo.setColumns(20);
        motivo.setRows(5);
        jScrollPane3.setViewportView(motivo);

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Motivo Rechazo");

        aceptar.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        aceptar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/04_Save_16x16.png"))); // NOI18N
        aceptar.setText("Aceptar");
        aceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aceptarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(num_vers, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(link_vers, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(fecha_vers, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(size_vers, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(aprobada)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(rechazada))
                            .addComponent(jLabel6))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(136, 136, 136)
                .addComponent(aceptar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel1, jLabel2, jLabel3, jLabel4, jLabel5});

        jPanel2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {fecha_vers, link_vers, num_vers, size_vers});

        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(num_vers, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(link_vers, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(fecha_vers, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(size_vers, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(aprobada)
                    .addComponent(rechazada))
                .addGap(4, 4, 4)
                .addComponent(jLabel6)
                .addGap(7, 7, 7)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addComponent(aceptar))
        );

        salir.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        salir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/close_16.png"))); // NOI18N
        salir.setText("Salir");
        salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(salir)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(salir)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        // TODO add your handling code here:
        
    }//GEN-LAST:event_formWindowActivated

    private void salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salirActionPerformed
        this.dispose();
    }//GEN-LAST:event_salirActionPerformed

    private void aprobadaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aprobadaActionPerformed
        motivo.enable(false);
    }//GEN-LAST:event_aprobadaActionPerformed

    private void rechazadaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rechazadaActionPerformed
        // TODO add your handling code here:
        motivo.enable(true);
    }//GEN-LAST:event_rechazadaActionPerformed

    private void aceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aceptarActionPerformed
        // TODO add your handling code here:
        Version v =(Version)versiones.get(tabla_vers.getSelectedRow());
        String motivo = null;
                if(!this.motivo.getText().equals("")){
                    motivo = this.motivo.getText();
                }
        if(aprobada.isSelected())
        { 
            try {
                
                cv.CambiarEstado("aprobada", v.getJuego().getId(), v.getOrden_alta(),motivo);
                JOptionPane.showMessageDialog(this, "Operacion Exitosa", "Exito", JOptionPane.INFORMATION_MESSAGE);
                this.cargarTabla();
            } catch (SQLException ex) {
                Logger.getLogger(Versiones.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else if(rechazada.isSelected())
        {
            try {
                cv.CambiarEstado("rechazada", v.getJuego().getId(), v.getOrden_alta(),motivo);
                JOptionPane.showMessageDialog(this, "Operacion Exitosa", "Exito", JOptionPane.INFORMATION_MESSAGE);
                this.cargarTabla();
                
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "Operacion Fallida", "Error", JOptionPane.ERROR_MESSAGE);
                Logger.getLogger(Versiones.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_aceptarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton aceptar;
    private javax.swing.JRadioButton aprobada;
    private javax.swing.ButtonGroup estado;
    private javax.swing.JTextField fecha_vers;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField link_vers;
    private javax.swing.JTextArea motivo;
    private javax.swing.JTextField num_vers;
    private javax.swing.JRadioButton rechazada;
    private javax.swing.JButton salir;
    private javax.swing.JTextField size_vers;
    private javax.swing.JTable tabla_vers;
    // End of variables declaration//GEN-END:variables
}

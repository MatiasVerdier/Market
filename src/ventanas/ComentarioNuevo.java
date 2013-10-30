package ventanas;

import controladores.ControladorComentarios;
import controladores.ControladorCompras;
//import controladores.ControladorUsuarios;
import controladores.Controladorjuegos;
import dominio.Cliente;
import dominio.Comentario;
import dominio.Juego;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

public class ComentarioNuevo extends javax.swing.JDialog {
    
    private Controladorjuegos cj = Controladorjuegos.getInstancia();
    //private ControladorUsuarios cu = ControladorUsuarios.getInstancia();
    
    /* no se si respeta el diseño tener el controlador de compras aca  -Matias */
    private ControladorCompras cc = ControladorCompras.getInstancia();
    
    private ControladorComentarios ccom = ControladorComentarios.getInstancia();
    /*-------------------------------------------------------------------------*/
    
    private ArrayList ids_juegos;
    private ArrayList ids_clientes;
    
    DefaultComboBoxModel modelo_juegos = new DefaultComboBoxModel();
    
    
    private int id_juego;
    private int id_cli;
    private int id_com_padre = 0;

    public ComentarioNuevo(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.combo_juegos.setModel(modelo_juegos);
        ids_juegos = new ArrayList();
        ids_clientes = new ArrayList();
        this.setLocationRelativeTo(null);
    }
    
    public void setCom_padre(int id_com){
        this.id_com_padre = id_com;
    }
    
    public void cargarJuegos(int id){
        System.out.println("paso por aca");
        this.ids_juegos.clear();
        //this.combo_juegos.removeAllItems();
        if (id != 0){
            try {
                Juego j = cj.buscarJuegoPorID(id);
                //this.combo_juegos.addItem(j.getNombre());
                this.modelo_juegos.addElement(j);
                this.ids_juegos.add(j.getId());
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "Error: "+ex.getErrorCode(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        else{
            try {
                ArrayList jug = cj.listarJuegosConCompras();
                int i = 0;
                while (i < jug.size()){
                    Juego j = (Juego) jug.get(i);
                    //this.combo_juegos.addItem(j.getNombre());
                    this.modelo_juegos.addElement(j);
                    this.ids_juegos.add(j.getId());
                    i++; 
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "Error: "+ex.getErrorCode(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        
    }
    
    public void cargarClientes(){
        this.ids_clientes.clear();
        this.combo_clientes.removeAllItems();
        ArrayList cli = cc.verComprasPorJuego(id_juego);
        int i = 0;
        while (i < cli.size()){
            Cliente c = (Cliente)cli.get(i);
            combo_clientes.addItem(c.getNick());
            ids_clientes.add(c.getId());
            i++;
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        combo_juegos = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        texto = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        combo_clientes = new javax.swing.JComboBox();
        fecha = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel1.setText("Juego");

        combo_juegos.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        combo_juegos.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                seleccinarJuego(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel2.setText("Texto");

        jLabel3.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel3.setText("Cliente");

        jLabel4.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel4.setText("Fecha");

        texto.setColumns(20);
        texto.setRows(5);
        jScrollPane1.setViewportView(texto);

        jButton1.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/Apply.png"))); // NOI18N
        jButton1.setText("Aceptar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                altaComentario(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/close_16.png"))); // NOI18N
        jButton2.setText("Cancelar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelar(evt);
            }
        });

        combo_clientes.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(fecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(combo_juegos, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(combo_clientes, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel2))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton2))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 14, Short.MAX_VALUE))))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel1, jLabel2, jLabel3, jLabel4});

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {combo_clientes, combo_juegos});

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jButton1, jButton2});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(combo_juegos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(combo_clientes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(fecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 76, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton1))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cancelar(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelar
        this.dispose();
    }//GEN-LAST:event_cancelar

    private void altaComentario(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_altaComentario
        try {
            Comentario nuevo = new Comentario();
            id_juego = (int)ids_juegos.get(this.combo_juegos.getSelectedIndex());
            id_cli = (int)ids_clientes.get(this.combo_clientes.getSelectedIndex());
            nuevo.setId_usu(id_cli);
            nuevo.setId_juego(id_juego);
            nuevo.setTexto(this.texto.getText());
            nuevo.setFecha(this.fecha.getDate());
            nuevo.setId_padre(id_com_padre);
            //nuevo.setId_padre(Integer.parseInt(this.com_padre.getText()));
            int res = ccom.altaComentario(nuevo);
            JOptionPane.showMessageDialog(this, "Se dio de alta el comentario", "Exito", JOptionPane.INFORMATION_MESSAGE);
            this.dispose();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error: "+ex.getErrorCode(), "Error", JOptionPane.ERROR_MESSAGE);
            System.err.println(ex.toString());
        }
    }//GEN-LAST:event_altaComentario

    private void seleccinarJuego(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_seleccinarJuego
            Juego j = (Juego)this.modelo_juegos.getSelectedItem();
            id_juego = j.getId();
            this.cargarClientes();
    }//GEN-LAST:event_seleccinarJuego

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox combo_clientes;
    private javax.swing.JComboBox combo_juegos;
    private com.toedter.calendar.JDateChooser fecha;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea texto;
    // End of variables declaration//GEN-END:variables
}

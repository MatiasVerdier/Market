
package ventanas;

import controladores.ControladorCategorias;
import controladores.Controladorjuegos;
import dominio.Categoria;
import dominio.Juego;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

public class Juegos extends javax.swing.JDialog {
    
    ControladorCategorias cc = ControladorCategorias.getInstancia();
    Controladorjuegos cj = Controladorjuegos.getInstancia();
    
    ArrayList ids_cat = new ArrayList();
    ArrayList ids_j = new ArrayList();
    
    DefaultListModel modelo_cat = new DefaultListModel();
    DefaultListModel modelo_juego = new DefaultListModel();
    
    private boolean click_new_cat = false;
    private boolean clic_new_juego = false;
    
    private int id_cat;
    private int id_juego;

    public Juegos(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);
        this.lista_categorias.setModel(modelo_cat);
        this.lista_juegos.setModel(modelo_juego);
        
        this.cargarCategorias();
    }

    private Juegos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void cargarCategorias(){
        ArrayList categorias = cc.listarCategorias();
       
        if (categorias != null){
            int i = 0;
            while (i < categorias.size()){
                Categoria cat;
                cat = (Categoria)categorias.get(i);
                modelo_cat.addElement(cat.getNombre());
                ids_cat.add(cat.getId());
                i++;
            }
        }
    }
    
    private void CargarJuegos(int id_cat){
        try {
            ids_j.clear();
            modelo_juego.clear();
            ArrayList juegos = cj.listarJuegosPorCategoria(id_cat);
            if (juegos != null){
                int i = 0;
                while (i < juegos.size()){
                    Juego j;
                    j = (Juego)juegos.get(i);
                    modelo_juego.addElement(j.getNombre());
                    ids_j.add(j.getId());
                    i++;
                }
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error: "+ex.getErrorCode(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btn_compra = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btn_salir = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        lista_juegos = new javax.swing.JList();
        jScrollPane1 = new javax.swing.JScrollPane();
        lista_categorias = new javax.swing.JList();
        btn_new_juego = new javax.swing.JButton();
        btn_new_categ = new javax.swing.JButton();
        btn_eliminar_juego = new javax.swing.JButton();
        btn_del_categ = new javax.swing.JButton();
        btn_infoJuego = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        addWindowFocusListener(new java.awt.event.WindowFocusListener() {
            public void windowGainedFocus(java.awt.event.WindowEvent evt) {
                actualizarDatos(evt);
            }
            public void windowLostFocus(java.awt.event.WindowEvent evt) {
            }
        });

        btn_compra.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        btn_compra.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/shop-cart-add-icon16.png"))); // NOI18N
        btn_compra.setText("Ingresar Compra");
        btn_compra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IngresarCompra(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel1.setText("Categorias");

        btn_salir.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        btn_salir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/close_16.png"))); // NOI18N
        btn_salir.setText("Salir");
        btn_salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salir(evt);
            }
        });

        lista_juegos.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        lista_juegos.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "1", "2", "3", "4", "5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        lista_juegos.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        lista_juegos.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                seleccionarJuego(evt);
            }
        });
        jScrollPane2.setViewportView(lista_juegos);

        lista_categorias.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        lista_categorias.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "1", "2", "3", "4", "5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        lista_categorias.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        lista_categorias.setVerifyInputWhenFocusTarget(false);
        lista_categorias.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                seleccionarCategoria(evt);
            }
        });
        jScrollPane1.setViewportView(lista_categorias);

        btn_new_juego.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        btn_new_juego.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/add_16.png"))); // NOI18N
        btn_new_juego.setToolTipText("Nuevo Juego");
        btn_new_juego.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NuevoJuego(evt);
            }
        });

        btn_new_categ.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        btn_new_categ.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/add_16.png"))); // NOI18N
        btn_new_categ.setToolTipText("Nueva Categoria");
        btn_new_categ.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nuevaCategoria(evt);
            }
        });

        btn_eliminar_juego.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        btn_eliminar_juego.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/delete_16.png"))); // NOI18N
        btn_eliminar_juego.setToolTipText("Eliminar Juego");

        btn_del_categ.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        btn_del_categ.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/delete_16.png"))); // NOI18N
        btn_del_categ.setToolTipText("Eliminar Categoria");

        btn_infoJuego.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        btn_infoJuego.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/Info.png"))); // NOI18N
        btn_infoJuego.setText("Ver Informacion");
        btn_infoJuego.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                verInfoJuego(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel2.setText("Juegos");

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
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btn_new_categ)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_del_categ)
                                .addGap(18, 18, 18))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, Short.MAX_VALUE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(btn_infoJuego)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_compra))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btn_new_juego)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_eliminar_juego))
                            .addComponent(jScrollPane2)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btn_salir)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(btn_new_juego)
                                .addComponent(btn_eliminar_juego)))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(btn_new_categ)))
                    .addComponent(btn_del_categ))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1)
                    .addComponent(jScrollPane2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_infoJuego)
                    .addComponent(btn_compra))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_salir)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void nuevaCategoria(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nuevaCategoria
        NuevaCategoria nc = new NuevaCategoria(null, true);
        this.click_new_cat = true;
        nc.setVisible(true);
        nc.setLocation(300, 200);
    }//GEN-LAST:event_nuevaCategoria

    private void salir(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salir
        this.dispose();
    }//GEN-LAST:event_salir

    private void seleccionarCategoria(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_seleccionarCategoria
        if (!evt.getValueIsAdjusting()){
            try{
                int fila_sel = this.lista_categorias.getSelectedIndex();
                id_cat = (int)ids_cat.get(fila_sel);
                this.CargarJuegos(id_cat);
            }
            catch(Exception ex){
                System.out.println("error cat"+ex.toString());
            }
            System.out.println("id categoria: "+id_cat);
        }
    }//GEN-LAST:event_seleccionarCategoria

    private void verInfoJuego(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_verInfoJuego
        int sel = this.lista_juegos.getSelectedIndex();
        if(sel != -1){
            InformacionJuego info_juego = new InformacionJuego(null, true);
            this.setVisible(false);
            info_juego.cargarInfoJuego(id_juego);
            info_juego.setVisible(true);
            this.setVisible(true);
        }
        else{
            JOptionPane.showMessageDialog(this, "Debe seleccionar un juego", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_verInfoJuego

    private void IngresarCompra(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IngresarCompra
        int sel = this.lista_juegos.getSelectedIndex();
        if(sel != -1){
            try {
                NuevaCompra c = new NuevaCompra(null, true);
                c.txtJuego.setText(this.lista_juegos.getSelectedValue().toString());
                c.setJuegoComprar(cj.verInfoJuego(id_juego));
                c.setVisible(true);
            } catch (SQLException ex) {
                Logger.getLogger(Juegos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else{
            JOptionPane.showMessageDialog(this, "Debe seleccionar un juego", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_IngresarCompra

    private void NuevoJuego(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NuevoJuego
        AltaJuego j = new AltaJuego(null, true);
        this.clic_new_juego = true;
        j.setVisible(true);
        j.setLocation(300, 200);
    }//GEN-LAST:event_NuevoJuego

    private void seleccionarJuego(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_seleccionarJuego
        if (!evt.getValueIsAdjusting()){
            try{
                int fila_sel = this.lista_juegos.getSelectedIndex();
                if (fila_sel != -1){
                    id_juego = (int)ids_j.get(fila_sel);
                }
            }
            catch(Exception ex){
                System.out.println("error juego"+ex.toString());
            }
        }
    }//GEN-LAST:event_seleccionarJuego

    private void actualizarDatos(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_actualizarDatos
        if(this.click_new_cat){
            this.cargarCategorias();
            this.click_new_cat = false;
        }
        if(this.clic_new_juego){
            this.CargarJuegos(id_cat);
            this.clic_new_juego = false;
        }
    }//GEN-LAST:event_actualizarDatos


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_compra;
    private javax.swing.JButton btn_del_categ;
    private javax.swing.JButton btn_eliminar_juego;
    private javax.swing.JButton btn_infoJuego;
    private javax.swing.JButton btn_new_categ;
    private javax.swing.JButton btn_new_juego;
    private javax.swing.JButton btn_salir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JList lista_categorias;
    private javax.swing.JList lista_juegos;
    // End of variables declaration//GEN-END:variables
}

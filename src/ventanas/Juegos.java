
package ventanas;

import controladores.ControladorCategorias;
import dominio.Categoria;
import java.util.ArrayList;
import javax.swing.DefaultListModel;

public class Juegos extends javax.swing.JDialog {
    
    ControladorCategorias cc = ControladorCategorias.getInstancia();
    ArrayList ids = new ArrayList();
    private int id_cat;
    private int id_juego;

    public Juegos(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.cargarCategorias();
    }

    private void cargarCategorias(){
        ArrayList categorias = cc.listarCategorias();
       
        if (categorias != null){
            DefaultListModel modelo_cat = new DefaultListModel();
            this.lista_categorias.setModel(modelo_cat);
            int i = 0;
            while (i < categorias.size()){
                Categoria cat;
                cat = (Categoria)categorias.get(i);
                i++;
                modelo_cat.addElement(cat.getNombre());
                ids.add(cat.getId());
            }
        }
    }
    
    private void CargarJuegos(int id_cat){
        
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
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

        jButton2.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/shop-cart-add-icon16.png"))); // NOI18N
        jButton2.setText("Ingresar Compra");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IngresarCompra(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel1.setText("Categorias");

        jButton3.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jButton3.setText("Salir");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salir(evt);
            }
        });

        lista_juegos.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        lista_juegos.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        lista_juegos.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane2.setViewportView(lista_juegos);

        lista_categorias.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        lista_categorias.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        lista_categorias.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
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
                                .addComponent(jButton2))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btn_new_juego)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_eliminar_juego))
                            .addComponent(jScrollPane2)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton3)))
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_infoJuego)
                    .addComponent(jButton2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton3)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void nuevaCategoria(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nuevaCategoria
        NuevaCategoria nc = new NuevaCategoria(null, true);
    }//GEN-LAST:event_nuevaCategoria

    private void salir(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salir
        this.dispose();
    }//GEN-LAST:event_salir

    private void seleccionarCategoria(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_seleccionarCategoria
        int fila_sel = this.lista_categorias.getSelectedIndex();
        id_cat = (int)ids.get(fila_sel);
        this.CargarJuegos(id_cat);
    }//GEN-LAST:event_seleccionarCategoria

    private void verInfoJuego(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_verInfoJuego
        InformacionJuego info_juego = new InformacionJuego(null, true);
    }//GEN-LAST:event_verInfoJuego

    private void IngresarCompra(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IngresarCompra
        
    }//GEN-LAST:event_IngresarCompra

    private void NuevoJuego(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NuevoJuego
        
    }//GEN-LAST:event_NuevoJuego


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_del_categ;
    private javax.swing.JButton btn_eliminar_juego;
    private javax.swing.JButton btn_infoJuego;
    private javax.swing.JButton btn_new_categ;
    private javax.swing.JButton btn_new_juego;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JList lista_categorias;
    private javax.swing.JList lista_juegos;
    // End of variables declaration//GEN-END:variables
}

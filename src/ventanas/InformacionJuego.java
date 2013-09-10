package ventanas;

import controladores.ControladorCategorias;
import controladores.ControladorCompras;
import controladores.Controladorjuegos;
import dominio.Categoria;
import dominio.Cliente;
import dominio.Comentario;
import dominio.Juego;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;

public class InformacionJuego extends javax.swing.JDialog {

    private Juego juego;
    private Controladorjuegos cj = Controladorjuegos.getInstancia();
    private ControladorCategorias cc = ControladorCategorias.getInstancia();
    private ControladorCompras ccomp = ControladorCompras.getInstancia();
    private DefaultListModel modelo_cats = new DefaultListModel();
    private DefaultListModel modelo_compras = new DefaultListModel();
    private DefaultTreeModel modelo_coments = new DefaultTreeModel(null, true);
    private DefaultComboBoxModel modelo_des = new DefaultComboBoxModel();
    DefaultMutableTreeNode root;
    
    private boolean click_comentario = false;
    private boolean click_compra = false;
    
    public InformacionJuego(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);
        this.categorias.setModel(modelo_cats);
        this.compradores.setModel(modelo_compras);
        this.comentarios.setModel(modelo_coments);
    }
    
    public void cargarComentarios(int id){
        ArrayList coments = cj.verComentariosJuego(id);
        root = new DefaultMutableTreeNode(juego);
        modelo_coments.setRoot(root);
        
        int i = 0;
        while (i < coments.size()){
            Comentario c = (Comentario)coments.get(i);
            c.setRespuestas(cj.selectRespuestas(c.getId()));
            asignarHijos(c);
            modelo_coments.reload();
            i++;
        }
    }
    
    public void asignarHijos(Comentario c){
        ArrayList resp;
        resp = c.getRespuestas();
        DefaultMutableTreeNode n = new DefaultMutableTreeNode(c);
        int i = 0;
        while (i < resp.size()){
            Comentario com = (Comentario)resp.get(i);
            System.out.println(c.getId()+"hijo"+com.getId());
            DefaultMutableTreeNode h = new DefaultMutableTreeNode(com);
            n.add(h);
            modelo_coments.reload();
            asignarHijos(com);
            i++;
        }
        if (c.getId_padre() == 0){
            root.add(n);
        }
    }
    
    void cargarCategorias(int id){
        modelo_cats.clear();
        int i = 0;
        ArrayList cats = cc.verCategoriasPorJuego(id);

        if (!cats.isEmpty()){
            while (i < cats.size()){
                Categoria c;
                c = (Categoria)cats.get(i);
                modelo_cats.addElement(c.getNombre());
                i++;
            }
        }
    }
    
    void cargarCompras(int id){
        modelo_compras.clear();
        ArrayList compras = ccomp.verComprasPorJuego(id);
        int i = 0;
        if (!compras.isEmpty()){
            while(i < compras.size()){
                Cliente c;
                c = (Cliente)compras.get(i);
                modelo_compras.addElement(c.getNick());
                i++;
            }
        }
        else
            modelo_compras.addElement("El Juego no tiene compras");
    }
    
    public void cargarFoto(int id){
 
    }

    public void cargarInfoJuego(int id){
        juego = cj.verInfoJuego(id);
        this.nombre.setText(juego.getNombre());
        this.tam.setText(String.valueOf(juego.getSize()) + " KB");
        this.precio.setText("U$S " + String.valueOf(juego.getPrecio()));
        this.desa.setModel(modelo_des);
        modelo_des.addElement(juego.getDes().getNick());
        this.desc.setText(juego.getDescripcion());
        this.cargarCategorias(juego.getId());
        this.cargarCompras(juego.getId());
        this.cargarComentarios(juego.getId());
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        precio = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        tam = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        nombre = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        desc = new javax.swing.JTextArea();
        desa = new javax.swing.JComboBox();
        jPanel1 = new javax.swing.JPanel();
        foto = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        categorias = new javax.swing.JList();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        compradores = new javax.swing.JList();
        btn_compra = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        comentarios = new javax.swing.JTree();
        btn_comentario = new javax.swing.JButton();
        btn_salir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowFocusListener(new java.awt.event.WindowFocusListener() {
            public void windowGainedFocus(java.awt.event.WindowEvent evt) {
                actualizarDatos(evt);
            }
            public void windowLostFocus(java.awt.event.WindowEvent evt) {
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Informacion Basica", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        precio.setEditable(false);
        precio.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel3.setText("Precio:");

        jLabel4.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel4.setText("Desarrollador:");

        jLabel2.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel2.setText("Tamaño:");

        tam.setEditable(false);
        tam.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel1.setText("Nombre:");

        nombre.setEditable(false);
        nombre.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        desc.setColumns(20);
        desc.setLineWrap(true);
        desc.setRows(5);
        desc.setWrapStyleWord(true);
        jScrollPane1.setViewportView(desc);

        desa.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        desa.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(foto, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(foto, javax.swing.GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE)
        );

        jLabel5.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel5.setText("Descripcion:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(tam))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(precio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(desa, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel1, jLabel2, jLabel3, jLabel4});

        jPanel2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {desa, nombre, precio, tam});

        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(tam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(precio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(desa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(15, 15, 15)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Categorias", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        categorias.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        categorias.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(categorias);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 79, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Compradores", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        compradores.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        compradores.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane3.setViewportView(compradores);

        btn_compra.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        btn_compra.setText("Ingresar Compra");
        btn_compra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ingresarCompra(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(btn_compra)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_compra)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Comentarios", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        comentarios.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        comentarios.setToolTipText("");
        comentarios.setAutoscrolls(true);
        comentarios.addTreeExpansionListener(new javax.swing.event.TreeExpansionListener() {
            public void treeCollapsed(javax.swing.event.TreeExpansionEvent evt) {
            }
            public void treeExpanded(javax.swing.event.TreeExpansionEvent evt) {
                comentariosTreeExpanded(evt);
            }
        });
        comentarios.addTreeSelectionListener(new javax.swing.event.TreeSelectionListener() {
            public void valueChanged(javax.swing.event.TreeSelectionEvent evt) {
                comentariosValueChanged(evt);
            }
        });
        jScrollPane4.setViewportView(comentarios);

        btn_comentario.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        btn_comentario.setText("Nuevo Comentario");
        btn_comentario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nuevoComentario(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(btn_comentario)
                        .addGap(0, 162, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_comentario)
                .addGap(0, 11, Short.MAX_VALUE))
        );

        btn_salir.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        btn_salir.setText("Salir");
        btn_salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salir(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btn_salir)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(btn_salir)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void salir(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salir
        this.dispose();
    }//GEN-LAST:event_salir

    private void ingresarCompra(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ingresarCompra
        NuevaCompra c = new NuevaCompra(null, true);
        this.click_compra = true;
        c.txtJuego.setText(this.nombre.getText());
        c.setJuegoComprar(juego);
        c.setVisible(true);
    }//GEN-LAST:event_ingresarCompra

    private void nuevoComentario(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nuevoComentario
        
        ComentarioNuevo cn = new ComentarioNuevo(null, true);
        cn.setCom_padre(0);
        
        TreePath path = this.comentarios.getSelectionPath();
        DefaultMutableTreeNode n_root = (DefaultMutableTreeNode)modelo_coments.getRoot();
        if (path != null){
            DefaultMutableTreeNode n =  (DefaultMutableTreeNode) path.getLastPathComponent();
            if (! n.getUserObject().equals(n_root.getUserObject())){
                Comentario com = (Comentario) n.getUserObject();
                int id_com = com.getId();
                cn.setCom_padre(id_com);
                System.out.println("id comnetario "+id_com);
            }
        }
        
        this.click_comentario = true;
        
        cn.cargarJuegos(juego.getId());
        //cn.cargarClientes();
        cn.setVisible(true);
    }//GEN-LAST:event_nuevoComentario

    private void actualizarDatos(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_actualizarDatos
        if(this.click_compra){
            this.cargarCompras(juego.getId());
            this.click_compra = false;
            //System.out.println("actualizar compras");
        }
        if(this.click_comentario){
            this.cargarComentarios(juego.getId());
            this.click_comentario = false;
            //System.out.println("actualizar comentarios");
        }
        
    }//GEN-LAST:event_actualizarDatos

    private void comentariosValueChanged(javax.swing.event.TreeSelectionEvent evt) {//GEN-FIRST:event_comentariosValueChanged
        
    }//GEN-LAST:event_comentariosValueChanged

    private void comentariosTreeExpanded(javax.swing.event.TreeExpansionEvent evt) {//GEN-FIRST:event_comentariosTreeExpanded
//        TreePath path = this.comentarios.getSelectionPath();
//        DefaultMutableTreeNode nodo = (DefaultMutableTreeNode) path.getLastPathComponent();
//        Comentario c = (Comentario) nodo.getUserObject();
//        System.out.println(c);
    }//GEN-LAST:event_comentariosTreeExpanded


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_comentario;
    private javax.swing.JButton btn_compra;
    private javax.swing.JButton btn_salir;
    private javax.swing.JList categorias;
    private javax.swing.JTree comentarios;
    private javax.swing.JList compradores;
    private javax.swing.JComboBox desa;
    private javax.swing.JTextArea desc;
    private javax.swing.JLabel foto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTextField nombre;
    private javax.swing.JTextField precio;
    private javax.swing.JTextField tam;
    // End of variables declaration//GEN-END:variables
}

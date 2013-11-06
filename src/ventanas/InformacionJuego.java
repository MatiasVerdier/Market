package ventanas;

import controladores.ControladorCategorias;
import controladores.ControladorComentarios;
import controladores.ControladorCompras;
import controladores.Controladorjuegos;
import dominio.Categoria;
import dominio.Cliente;
import dominio.Comentario;
import dominio.Juego;
import dominio.Version;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
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
    DefaultTableModel modelo_vers;
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
        this.modelo_vers = (DefaultTableModel)this.tabla_vers.getModel();
    }
    
    public void cargarComentarios(int id){
        try{
            ArrayList coments = ControladorComentarios.getInstancia().verComentariosJuego(id);
            root = new DefaultMutableTreeNode(juego);
            modelo_coments.setRoot(root);
            
            int i = 0;
            while (i < coments.size()){
                Comentario c = (Comentario)coments.get(i);
                c.setRespuestas(ControladorComentarios.getInstancia().obtenerHijos(c.getId()));
                asignarHijos(c);
                modelo_coments.reload();
                i++;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error: "+ex.getErrorCode(), "Error", JOptionPane.ERROR_MESSAGE);
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
        try {
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
            
            int i = 0;
            ArrayList<Version> versiones= controladores.ControladorVersiones.getInstancia().listarVersiones(juego.getId(), ' ');
            while (i < versiones.size()){
                Version v = versiones.get(i);
                this.modelo_vers.setValueAt(v.getNro_version(), i, 0);
                this.modelo_vers.setValueAt(v.getSize(), i, 1);
                i++;
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error: "+ex.getErrorCode(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel_info_basica = new javax.swing.JPanel();
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
        panel_categorias = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        categorias = new javax.swing.JList();
        panel_compradores = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        compradores = new javax.swing.JList();
        btn_compra = new javax.swing.JButton();
        panel_comentarios = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        comentarios = new javax.swing.JTree();
        btn_comentario = new javax.swing.JButton();
        btn_salir = new javax.swing.JButton();
        panel_versiones = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        tabla_vers = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });
        addWindowFocusListener(new java.awt.event.WindowFocusListener() {
            public void windowGainedFocus(java.awt.event.WindowEvent evt) {
                actualizarDatos(evt);
            }
            public void windowLostFocus(java.awt.event.WindowEvent evt) {
            }
        });

        panel_info_basica.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Informacion Basica", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

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

        javax.swing.GroupLayout panel_info_basicaLayout = new javax.swing.GroupLayout(panel_info_basica);
        panel_info_basica.setLayout(panel_info_basicaLayout);
        panel_info_basicaLayout.setHorizontalGroup(
            panel_info_basicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_info_basicaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel_info_basicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_info_basicaLayout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(panel_info_basicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panel_info_basicaLayout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(tam))
                            .addGroup(panel_info_basicaLayout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(precio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panel_info_basicaLayout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(desa, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panel_info_basicaLayout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(panel_info_basicaLayout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );

        panel_info_basicaLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel1, jLabel2, jLabel3, jLabel4});

        panel_info_basicaLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {desa, nombre, precio, tam});

        panel_info_basicaLayout.setVerticalGroup(
            panel_info_basicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_info_basicaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel_info_basicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panel_info_basicaLayout.createSequentialGroup()
                        .addGroup(panel_info_basicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panel_info_basicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(tam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panel_info_basicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(precio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panel_info_basicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(desa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(15, 15, 15)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        panel_categorias.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Categorias", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        categorias.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        categorias.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(categorias);

        javax.swing.GroupLayout panel_categoriasLayout = new javax.swing.GroupLayout(panel_categorias);
        panel_categorias.setLayout(panel_categoriasLayout);
        panel_categoriasLayout.setHorizontalGroup(
            panel_categoriasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_categoriasLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
                .addContainerGap())
        );
        panel_categoriasLayout.setVerticalGroup(
            panel_categoriasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_categoriasLayout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 79, Short.MAX_VALUE)
                .addContainerGap())
        );

        panel_compradores.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Compradores", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        compradores.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        compradores.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane3.setViewportView(compradores);

        btn_compra.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        btn_compra.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/shop-cart-add-icon16.png"))); // NOI18N
        btn_compra.setText("Ingresar Compra");
        btn_compra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ingresarCompra(evt);
            }
        });

        javax.swing.GroupLayout panel_compradoresLayout = new javax.swing.GroupLayout(panel_compradores);
        panel_compradores.setLayout(panel_compradoresLayout);
        panel_compradoresLayout.setHorizontalGroup(
            panel_compradoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_compradoresLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel_compradoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3)
                    .addGroup(panel_compradoresLayout.createSequentialGroup()
                        .addComponent(btn_compra)
                        .addGap(0, 138, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panel_compradoresLayout.setVerticalGroup(
            panel_compradoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_compradoresLayout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_compra))
        );

        panel_comentarios.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Comentarios", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

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
        btn_comentario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/coment16.png"))); // NOI18N
        btn_comentario.setText("Nuevo Comentario");
        btn_comentario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nuevoComentario(evt);
            }
        });

        javax.swing.GroupLayout panel_comentariosLayout = new javax.swing.GroupLayout(panel_comentarios);
        panel_comentarios.setLayout(panel_comentariosLayout);
        panel_comentariosLayout.setHorizontalGroup(
            panel_comentariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_comentariosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel_comentariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4)
                    .addGroup(panel_comentariosLayout.createSequentialGroup()
                        .addComponent(btn_comentario)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panel_comentariosLayout.setVerticalGroup(
            panel_comentariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_comentariosLayout.createSequentialGroup()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_comentario))
        );

        btn_salir.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        btn_salir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/close_16.png"))); // NOI18N
        btn_salir.setText("Salir");
        btn_salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salir(evt);
            }
        });

        panel_versiones.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Versiones", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP));

        tabla_vers.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Numero", "Tamaño"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane6.setViewportView(tabla_vers);

        javax.swing.GroupLayout panel_versionesLayout = new javax.swing.GroupLayout(panel_versiones);
        panel_versiones.setLayout(panel_versionesLayout);
        panel_versionesLayout.setHorizontalGroup(
            panel_versionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_versionesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );
        panel_versionesLayout.setVerticalGroup(
            panel_versionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_versionesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btn_salir))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(panel_comentarios, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(panel_info_basica, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(13, 13, 13)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(panel_versiones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(panel_compradores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(panel_categorias, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(panel_compradores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panel_categorias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(panel_info_basica, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panel_comentarios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panel_versiones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_salir)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        System.out.println("ancho: "+this.getWidth()+"alto: "+this.getHeight());
    }//GEN-LAST:event_formMouseClicked


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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTextField nombre;
    private javax.swing.JPanel panel_categorias;
    private javax.swing.JPanel panel_comentarios;
    private javax.swing.JPanel panel_compradores;
    private javax.swing.JPanel panel_info_basica;
    private javax.swing.JPanel panel_versiones;
    private javax.swing.JTextField precio;
    private javax.swing.JTable tabla_vers;
    private javax.swing.JTextField tam;
    // End of variables declaration//GEN-END:variables
}

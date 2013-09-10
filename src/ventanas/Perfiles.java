package ventanas;

import controladores.ControladorUsuarios;
import dominio.Cliente;
import dominio.Usuario;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

public class Perfiles extends javax.swing.JDialog {
    
    ControladorUsuarios cu = ControladorUsuarios.getInstancia();
    ArrayList ids = new ArrayList();
    private int id_usu;
    DefaultListModel modelo_usuarios = new DefaultListModel();
    

    public Perfiles(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);
        this.cargarUsuarios();
        if (this.lista_perfiles.getSelectedIndex() == -1){
            this.btn_info_perfil.setEnabled(false);
            this.btn_modificar.setEnabled(false);
        }
    }
ArrayList usuarios = new ArrayList();    

    private void cargarUsuarios(){
        this.lista_perfiles.setModel(modelo_usuarios);
         usuarios.clear();
        
      
        if(radio_todos.isSelected()){
        
            usuarios.clear();
            usuarios = cu.listarUsuarios();
       
        if (usuarios != null){
            
            int i = 0;
            modelo_usuarios.clear();
            while (i < usuarios.size()){
                Usuario user;
                user = (Usuario)usuarios.get(i);
                i++;
                modelo_usuarios.addElement(user.getNick());
                ids.add(user.getId());
            }
        }
    }
}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        filtros = new javax.swing.ButtonGroup();
        radio_todos = new javax.swing.JRadioButton();
        radio_clientes = new javax.swing.JRadioButton();
        radio_des = new javax.swing.JRadioButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        lista_perfiles = new javax.swing.JList();
        btn_salir = new javax.swing.JButton();
        btn_info_perfil = new javax.swing.JButton();
        btn_buscar = new javax.swing.JButton();
        campo_busqueda = new javax.swing.JTextField();
        btn_modificar = new javax.swing.JButton();
        btn_nuevo = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Administrar Perfiles");
        setResizable(false);

        filtros.add(radio_todos);
        radio_todos.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        radio_todos.setSelected(true);
        radio_todos.setText("Todos");
        radio_todos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                radio_todosMouseClicked(evt);
            }
        });
        radio_todos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radio_todosActionPerformed(evt);
            }
        });

        filtros.add(radio_clientes);
        radio_clientes.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        radio_clientes.setText("Clientes");
        radio_clientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                radio_clientesMouseClicked(evt);
            }
        });

        filtros.add(radio_des);
        radio_des.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        radio_des.setText("Desarrolladores");
        radio_des.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                radio_desMouseClicked(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel8.setText("Usuarios del Sistema");

        jLabel10.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel10.setText("Filtrar Por:");

        lista_perfiles.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        lista_perfiles.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        lista_perfiles.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        lista_perfiles.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                seleccionarUsuario(evt);
            }
        });
        jScrollPane1.setViewportView(lista_perfiles);

        btn_salir.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        btn_salir.setText("Salir");
        btn_salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salir(evt);
            }
        });

        btn_info_perfil.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        btn_info_perfil.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/user_info_16.png"))); // NOI18N
        btn_info_perfil.setText("Ver Informacion");
        btn_info_perfil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                verInformacion(evt);
            }
        });

        btn_buscar.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        btn_buscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/search_button_green_16.png"))); // NOI18N
        btn_buscar.setText("Buscar");
        btn_buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_buscarActionPerformed(evt);
            }
        });

        campo_busqueda.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        campo_busqueda.setToolTipText("Buscar");

        btn_modificar.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        btn_modificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/edit16.png"))); // NOI18N
        btn_modificar.setToolTipText("Modificar Usuario");
        btn_modificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modificarUsuario(evt);
            }
        });

        btn_nuevo.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        btn_nuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/user_add_16.png"))); // NOI18N
        btn_nuevo.setToolTipText("Nuevo Usuario");
        btn_nuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nuevousuario(evt);
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
                        .addComponent(btn_info_perfil)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_salir))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btn_nuevo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_modificar))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(campo_busqueda)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_buscar))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(radio_clientes)
                                    .addComponent(radio_todos)
                                    .addComponent(radio_des))
                                .addGap(0, 82, Short.MAX_VALUE)))))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {radio_clientes, radio_des, radio_todos});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(btn_modificar)
                    .addComponent(btn_nuevo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(campo_busqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_buscar))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(radio_todos))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(radio_clientes)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(radio_des)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_info_perfil)
                    .addComponent(btn_salir))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void salir(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salir
        this.dispose();
    }//GEN-LAST:event_salir

    private void verInformacion(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_verInformacion
        InformacionPerfil ip = new InformacionPerfil(null, true);
        this.setVisible(false);
        ip.cargarInfoPerfil(id_usu);
        ip.setVisible(true);
        cargarUsuarios();
        this.setVisible(true);
    }//GEN-LAST:event_verInformacion

    private void nuevousuario(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nuevousuario
        InformacionPerfil ip = new InformacionPerfil(null, true);
        this.setVisible(false);
        ip.limpiarCampos();
        ip.cambiarEstado(true, true, true, true, true, true, true);
        ip.setVisible(true);
        this.setVisible(true);
    }//GEN-LAST:event_nuevousuario

    private void modificarUsuario(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modificarUsuario
        InformacionPerfil ip = new InformacionPerfil(null, true);
        this.setVisible(false);
        ip.cargarInfoPerfil(id_usu);
        ip.cambiarEstado(true, true, true, true, true, true, false);
        ip.setVisible(true);
        this.setVisible(true);
    }//GEN-LAST:event_modificarUsuario

    private void seleccionarUsuario(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_seleccionarUsuario
        int lugar;
        lugar = this.lista_perfiles.getSelectedIndex();
        if (lugar != -1){
            id_usu = (int)ids.get(lugar);
            this.btn_info_perfil.setEnabled(true);
            this.btn_modificar.setEnabled(true); 
        }
        else{
            this.btn_info_perfil.setEnabled(false);
            this.btn_modificar.setEnabled(false);
        }
    }//GEN-LAST:event_seleccionarUsuario

    private void btn_buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_buscarActionPerformed

        String bs = this.campo_busqueda.getText();
            usuarios.clear();
            usuarios = cu.listarbusqueda(bs);
       
        if (!usuarios.isEmpty()){
            
            int i = 0;
            modelo_usuarios.clear();
            ids.clear();
            while (i < usuarios.size()){
                Usuario user;
                user = (Usuario)usuarios.get(i);
                i++;
                modelo_usuarios.addElement(user.getNick());
                ids.add(user.getId());
            }
        } else{
            modelo_usuarios.clear();
            ids.clear();
            JOptionPane.showMessageDialog(this, "No se encontro ningun usuario.", "Error", JOptionPane.ERROR_MESSAGE);
        }  
    }//GEN-LAST:event_btn_buscarActionPerformed

    private void radio_clientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_radio_clientesMouseClicked
        
        usuarios.clear();
        usuarios = cu.listarClientes();
       
        if (usuarios != null){
            int i = 0;
            modelo_usuarios.clear();
            ids.clear();
            while (i < usuarios.size()){
             
                Usuario user;
                user = (Usuario)usuarios.get(i);
                i++;
                modelo_usuarios.addElement(user.getNick());
                ids.add(user.getId());
              
            }
        } 
    }//GEN-LAST:event_radio_clientesMouseClicked

    private void radio_todosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radio_todosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_radio_todosActionPerformed

    private void radio_todosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_radio_todosMouseClicked

            usuarios.clear();
            usuarios = cu.listarUsuarios();
       
        if (usuarios != null){
            
            int i = 0;
            modelo_usuarios.clear();
            ids.clear();
            while (i < usuarios.size()){
                Usuario user;
                user = (Usuario)usuarios.get(i);
                i++;
                modelo_usuarios.addElement(user.getNick());
                ids.add(user.getId());
            }
        }
      
    }//GEN-LAST:event_radio_todosMouseClicked

    private void radio_desMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_radio_desMouseClicked
            usuarios.clear();
            usuarios = cu.listarDevelopers();
       
        if (usuarios != null){
            
            int i = 0;
            modelo_usuarios.clear();
            ids.clear();
            while (i < usuarios.size()){
                Usuario user;
                user = (Usuario)usuarios.get(i);
                i++;
                modelo_usuarios.addElement(user.getNick());
                ids.add(user.getId());
            }
        }  
        
        
    }//GEN-LAST:event_radio_desMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_buscar;
    private javax.swing.JButton btn_info_perfil;
    private javax.swing.JButton btn_modificar;
    private javax.swing.JButton btn_nuevo;
    private javax.swing.JButton btn_salir;
    private javax.swing.JTextField campo_busqueda;
    private javax.swing.ButtonGroup filtros;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList lista_perfiles;
    private javax.swing.JRadioButton radio_clientes;
    private javax.swing.JRadioButton radio_des;
    private javax.swing.JRadioButton radio_todos;
    // End of variables declaration//GEN-END:variables
}

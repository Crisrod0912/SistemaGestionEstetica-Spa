package UI;

import DAO.ClienteDAO;
import java.awt.HeadlessException;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import Model.Cliente;

public class Clientes extends JFrame {

    public Clientes(Principal principal) throws SQLException {
        initComponents();
        actualizarTabla();
        setLocationRelativeTo(null);
        txtCodigo.setEnabled(false);
        this.principal = principal;

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                volverPrincipal();
            }

        });
    }

    public void volverPrincipal() {
        this.principal.setVisible(true);
        dispose();
    }

    private void limpiar() {
        txtCodigo.setText("");
        txtNombre.setText("");
        txtApellido.setText("");
        txtFecha.setText("");
        txtDireccion.setText("");
        txtNumero.setText("");
        txtCorreo.setText("");
        txtIdentificacion.setText("");
        txtAreaHistorialServ.setText("");
        btnEditar.setEnabled(false);
        btnEliminar.setEnabled(false);
        btnAgregar.setEnabled(true);
    }

    private void actualizarTabla() throws SQLException {
        DefaultTableModel modelTable = new DefaultTableModel();
        modelTable.addColumn("Código");
        modelTable.addColumn("Nombre");
        modelTable.addColumn("Apellido");
        modelTable.addColumn("Fecha Nacimiento");
        modelTable.addColumn("Dirección");
        modelTable.addColumn("Teléfono");
        modelTable.addColumn("Correo");
        modelTable.addColumn("Identificación");
        modelTable.addColumn("Historial Servicio");

        ArrayList<Cliente> clientesTemp = new ArrayList<>();
        if (ClienteDAO.consultar(clientesTemp)) {
            listaClientes.clear();
            for (Cliente c : clientesTemp) {
                listaClientes.add(c);

                Object[] fila = new Object[]{
                    c.getCodigoCliente(),
                    c.getNombre(),
                    c.getApellido(),
                    c.getFechaNacimiento(),
                    c.getDireccion(),
                    c.getTelefono(),
                    c.getCorreo(),
                    c.getIdentificacion(),
                    c.getHistorialServicio()
                };
                modelTable.addRow(fila);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Error al cargar los clientes. ", "Error", JOptionPane.ERROR_MESSAGE);
        }

        tablaClientes.setModel(modelTable);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        labelNombre = new javax.swing.JLabel();
        labelApellido = new javax.swing.JLabel();
        labelFecha = new javax.swing.JLabel();
        labelDireccion = new javax.swing.JLabel();
        labelNumero = new javax.swing.JLabel();
        labelCorreo = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        btnSalir = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnAgregar = new javax.swing.JButton();
        txtApellido = new javax.swing.JTextField();
        txtFecha = new javax.swing.JTextField();
        txtDireccion = new javax.swing.JTextField();
        txtNumero = new javax.swing.JTextField();
        txtCorreo = new javax.swing.JTextField();
        txtCodigo = new javax.swing.JTextField();
        labelCodigo = new javax.swing.JLabel();
        labelCorreo1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtAreaHistorialServ = new javax.swing.JTextArea();
        labelCorreo2 = new javax.swing.JLabel();
        txtIdentificacion = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaClientes = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(102, 204, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 51, 153), 3, true), "Gestion de Pacientes", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 18), new java.awt.Color(0, 51, 153))); // NOI18N
        jPanel1.setToolTipText("");

        labelNombre.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        labelNombre.setText("Nombre:");

        labelApellido.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        labelApellido.setText("Apellidos:");

        labelFecha.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        labelFecha.setText("Fecha de nacimiento:");

        labelDireccion.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        labelDireccion.setText("Dirección:");

        labelNumero.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        labelNumero.setText("Numero de teléfono:");

        labelCorreo.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        labelCorreo.setText("Correo electrónico:");

        btnSalir.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnSalir.setForeground(new java.awt.Color(0, 51, 153));
        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        btnLimpiar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnLimpiar.setForeground(new java.awt.Color(0, 51, 153));
        btnLimpiar.setText("Limpiar");
        btnLimpiar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 51, 153), 2, true));
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

        btnEliminar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnEliminar.setForeground(new java.awt.Color(0, 51, 153));
        btnEliminar.setText("Eliminar");
        btnEliminar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 51, 153), 2, true));
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnEditar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnEditar.setForeground(new java.awt.Color(0, 51, 153));
        btnEditar.setText("Editar");
        btnEditar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 51, 153), 2, true));
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnAgregar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnAgregar.setForeground(new java.awt.Color(0, 51, 153));
        btnAgregar.setText("Agregar");
        btnAgregar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 51, 153), 2, true));
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        labelCodigo.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        labelCodigo.setText("Código:");

        labelCorreo1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        labelCorreo1.setText("Historial de Servicio:");

        txtAreaHistorialServ.setColumns(20);
        txtAreaHistorialServ.setRows(5);
        jScrollPane1.setViewportView(txtAreaHistorialServ);

        labelCorreo2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        labelCorreo2.setText("Identificación:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelApellido)
                    .addComponent(labelNombre)
                    .addComponent(labelDireccion)
                    .addComponent(labelFecha)
                    .addComponent(labelCorreo)
                    .addComponent(labelNumero)
                    .addComponent(labelCodigo)
                    .addComponent(labelCorreo1)
                    .addComponent(labelCorreo2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 64, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtCodigo, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
                    .addComponent(txtNombre, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtApellido, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtFecha, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtDireccion, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtNumero, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtCorreo, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1)
                    .addComponent(txtIdentificacion))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(249, 249, 249)
                        .addComponent(btnSalir))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(75, 75, 75)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(btnSalir)
                .addContainerGap(484, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelCodigo)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 3, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelNombre)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 3, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelApellido)
                            .addComponent(txtApellido))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelFecha)
                            .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelDireccion)
                            .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelNumero)
                            .addComponent(txtNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelCorreo)
                            .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelCorreo2)
                            .addComponent(txtIdentificacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(15, 15, 15)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelCorreo1)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(42, 42, 42)
                        .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(46, 46, 46)
                        .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41)
                        .addComponent(btnLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        labelCorreo1.getAccessibleContext().setAccessibleName("Historial Servicio:");

        tablaClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6", "Title 7"
            }
        ));
        tablaClientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaClientesMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tablaClientes);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 993, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel1.getAccessibleContext().setAccessibleName("Gestion de Clientes");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        try {
            String nombre = txtNombre.getText();
            String apellido = txtApellido.getText();
            String fechaNacimiento = txtFecha.getText();
            String direccion = txtDireccion.getText();
            String telefono = txtNumero.getText();
            String correo = txtCorreo.getText();
            String historial = txtAreaHistorialServ.getText();
            String identificacion = txtIdentificacion.getText();

            Cliente cliente = new Cliente(
                    apellido,
                    fechaNacimiento,
                    direccion,
                    telefono,
                    correo,
                    historial,
                    nombre,
                    identificacion
            );
            cliente.verificarCampos();

            if (ClienteDAO.agregar(cliente)) {
                JOptionPane.showMessageDialog(this, "Cliente agregado correctamente. ");
                limpiar();
                actualizarTabla();
            } else {
                JOptionPane.showMessageDialog(this, "No se pudo agregar el cliente. ");
            }

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Edad inválida. Ingresá un número. ");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
        }
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        volverPrincipal();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        limpiar();
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        int btn = JOptionPane.showConfirmDialog(this,
                "¿Desea eliminar el cliente: " + txtNombre.getText() + "?",
                "Eliminar Cliente",
                JOptionPane.YES_NO_OPTION);

        if (btn == 0) {
            try {
                if (ClienteDAO.eliminar(clienteSeleccionado)) {
                    JOptionPane.showMessageDialog(this, "Cliente eliminado correctamente. ");
                    limpiar();
                    actualizarTabla();
                    clienteSeleccionado = null;
                } else {
                    JOptionPane.showMessageDialog(this, "Error al eliminar el cliente. ");
                }
            } catch (SQLException ex) {
                Logger.getLogger(Clientes.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void tablaClientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaClientesMouseClicked
        int fila = tablaClientes.getSelectedRow();
        if (fila >= 0) {
            clienteSeleccionado = listaClientes.get(fila);

            txtCodigo.setText(String.valueOf(clienteSeleccionado.getCodigoCliente()));
            txtNombre.setText(clienteSeleccionado.getNombre());
            txtApellido.setText(clienteSeleccionado.getApellido());
            txtFecha.setText(clienteSeleccionado.getFechaNacimiento());
            txtDireccion.setText(clienteSeleccionado.getDireccion());
            txtNumero.setText(clienteSeleccionado.getTelefono());
            txtCorreo.setText(clienteSeleccionado.getCorreo());
            txtIdentificacion.setText(clienteSeleccionado.getIdentificacion());
            txtAreaHistorialServ.setText(clienteSeleccionado.getHistorialServicio());

            tablaClientes.setDefaultEditor(Object.class, null);

            btnEditar.setEnabled(true);
            btnEliminar.setEnabled(true);
            btnAgregar.setEnabled(false);
        }
    }//GEN-LAST:event_tablaClientesMouseClicked

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        try {
            clienteSeleccionado.setNombre(txtNombre.getText());
            clienteSeleccionado.setApellido(txtApellido.getText());
            clienteSeleccionado.setFechaNacimiento(txtFecha.getText());
            clienteSeleccionado.setDireccion(txtDireccion.getText());
            clienteSeleccionado.setTelefono(txtNumero.getText());
            clienteSeleccionado.setCorreo(txtCorreo.getText());
            clienteSeleccionado.setIdentificacion(txtIdentificacion.getText());
            clienteSeleccionado.setHistorialServicio(txtAreaHistorialServ.getText());
            clienteSeleccionado.verificarCampos();
            if (ClienteDAO.editar(clienteSeleccionado)) {
                JOptionPane.showMessageDialog(this, "Cliente editado correctamente. ");
                limpiar();
                actualizarTabla();
                clienteSeleccionado = null;
            } else {
                JOptionPane.showMessageDialog(this, "Error al editar el cliente. ");
            }

        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
        } catch (Exception ex) {
            System.getLogger(Clientes.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    private final Principal principal;
    private Cliente clienteSeleccionado;
    private final ArrayList<Cliente> listaClientes = new ArrayList<>();
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnAgregar;
    public javax.swing.JButton btnEditar;
    public javax.swing.JButton btnEliminar;
    public javax.swing.JButton btnLimpiar;
    public javax.swing.JButton btnSalir;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel labelApellido;
    private javax.swing.JLabel labelCodigo;
    private javax.swing.JLabel labelCorreo;
    private javax.swing.JLabel labelCorreo1;
    private javax.swing.JLabel labelCorreo2;
    private javax.swing.JLabel labelDireccion;
    private javax.swing.JLabel labelFecha;
    private javax.swing.JLabel labelNombre;
    private javax.swing.JLabel labelNumero;
    private javax.swing.JTable tablaClientes;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JTextArea txtAreaHistorialServ;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtFecha;
    private javax.swing.JTextField txtIdentificacion;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtNumero;
    // End of variables declaration//GEN-END:variables
}

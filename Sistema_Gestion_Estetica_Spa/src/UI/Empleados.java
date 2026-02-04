package UI;

import DAO.EmpleadoDAO;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import Model.Empleado;

public class Empleados extends JFrame {

    public Empleados(Principal principal) throws SQLException {
        initComponents();
        actualizarTabla();
        txtCodigo.setEnabled(false);
        setLocationRelativeTo(null);
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

    private void limpiar() throws SQLException {
        txtCodigo.setEditable(true);
        empleadoSeleccionado = null;
        txtCodigo.setText("");

        txtNombre.setText("");
        txtApellido.setText("");
        txtFecha.setText("");
        txtSalario.setText("");
        txtIdentificacion.setText("");
        boxEspecialidad.setSelectedIndex(0);
        boxDisponibilidad.setSelectedIndex(0);

        btnAgregar.setEnabled(true);
        btnEditar.setEnabled(false);
        btnEliminar.setEnabled(false);
        actualizarTabla();
    }

    private void actualizarTabla() throws SQLException {
        ArrayList<Empleado> empleadosTemp = new ArrayList<>();

        DefaultTableModel modelTable = new DefaultTableModel();
        modelTable.addColumn("Código");
        modelTable.addColumn("Nombre");
        modelTable.addColumn("Apellidos");
        modelTable.addColumn("Fecha Nacimiento");
        modelTable.addColumn("Identificación");
        modelTable.addColumn("Salario");
        modelTable.addColumn("Especialidad");
        modelTable.addColumn("Disponibilidad");

        if (EmpleadoDAO.consultar(empleadosTemp)) {
            listaEmpleados.clear();
            for (Empleado e : empleadosTemp) {
                listaEmpleados.add(e);

                Object[] fila = new Object[]{
                    e.getCodigoEmpleado(),
                    e.getNombre(),
                    e.getApellido(),
                    e.getFechaNacimiento(),
                    e.getIdentificacion(),
                    e.getSalario(),
                    e.getEspecialidad(),
                    e.getDisponible()
                };
                modelTable.addRow(fila);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Error al cargar los empleados. ", "Error", JOptionPane.ERROR_MESSAGE);
        }

        tablaEmpleados.setModel(modelTable);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        labelCodigo = new javax.swing.JLabel();
        labelApellido = new javax.swing.JLabel();
        labelFecha = new javax.swing.JLabel();
        labelEspecialidad = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        btnSalir = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnAgregar = new javax.swing.JButton();
        txtApellido = new javax.swing.JTextField();
        txtFecha = new javax.swing.JTextField();
        labelDispo = new javax.swing.JLabel();
        labelNombre = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        boxDisponibilidad = new javax.swing.JComboBox<>();
        boxEspecialidad = new javax.swing.JComboBox<>();
        labelFecha1 = new javax.swing.JLabel();
        txtSalario = new javax.swing.JTextField();
        labelFecha3 = new javax.swing.JLabel();
        txtIdentificacion = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaEmpleados = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(102, 204, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 51, 153), 3, true), "Gestion de Medicos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 18), new java.awt.Color(0, 51, 153))); // NOI18N
        jPanel1.setToolTipText("");

        labelCodigo.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        labelCodigo.setText("Código:");

        labelApellido.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        labelApellido.setText("Apellidos:");

        labelFecha.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        labelFecha.setText("Fecha de nacimiento:");

        labelEspecialidad.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        labelEspecialidad.setText("Especialidad:");

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

        labelDispo.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        labelDispo.setText("Disponibilidad:");

        labelNombre.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        labelNombre.setText("Nombre:");

        boxDisponibilidad.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar", "Tiempo Completo", "Tiempo Parcial" }));

        boxEspecialidad.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar", "Limpieza facial", "Masajes relajantes", "Terapia eléctrica", "Masaje deportivo", "Tratamientos corporales", "Limpieza profunda" }));
        boxEspecialidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boxEspecialidadActionPerformed(evt);
            }
        });

        labelFecha1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        labelFecha1.setText("Salario:");

        labelFecha3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        labelFecha3.setText("Identificación:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(labelCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)
                        .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(labelFecha1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(labelFecha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(labelNombre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(labelApellido, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(labelEspecialidad, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(labelDispo, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(labelFecha3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(38, 38, 38)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(boxDisponibilidad, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(boxEspecialidad, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtSalario, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtIdentificacion, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSalir)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(106, 106, 106)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(161, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(btnSalir)
                .addContainerGap(332, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(btnLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelCodigo)
                    .addComponent(txtCodigo))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelNombre)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelApellido)
                    .addComponent(txtApellido))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelFecha)
                    .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelEspecialidad)
                    .addComponent(boxEspecialidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelDispo)
                    .addComponent(boxDisponibilidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelFecha1)
                    .addComponent(txtSalario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelFecha3)
                    .addComponent(txtIdentificacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20))
        );

        tablaEmpleados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6"
            }
        ));
        tablaEmpleados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaEmpleadosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaEmpleados);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 374, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel1.getAccessibleContext().setAccessibleName("Gestión de Empleados");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        volverPrincipal();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        try {
            limpiar();
        } catch (SQLException ex) {
            Logger.getLogger(Empleados.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        try {
            String nombre = txtNombre.getText();
            String apellido = txtApellido.getText();
            String fechaNacimiento = txtFecha.getText();
            String identificacion = txtIdentificacion.getText();
            double salario = Double.parseDouble(txtSalario.getText());
            String especialidad = boxEspecialidad.getSelectedItem().toString();
            String disponibilidad = boxDisponibilidad.getSelectedItem().toString();

            Empleado empleado = new Empleado(nombre, apellido, fechaNacimiento, identificacion, salario, especialidad, disponibilidad);

            empleado.verificarCampos();

            if (EmpleadoDAO.agregar(empleado)) {
                JOptionPane.showMessageDialog(this, "Empleado agregado correctamente. ");
                limpiar();
                actualizarTabla();
            } else {
                JOptionPane.showMessageDialog(this, "No se pudo agregar el empleado. ");
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Salario inválido.");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error al agregar empleado: " + ex.getMessage());
        }
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void tablaEmpleadosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaEmpleadosMouseClicked
        int fila = tablaEmpleados.getSelectedRow();
        if (fila >= 0) {
            empleadoSeleccionado = listaEmpleados.get(fila);

            txtCodigo.setText(String.valueOf(empleadoSeleccionado.getCodigoEmpleado()));
            txtNombre.setText(empleadoSeleccionado.getNombre());
            txtApellido.setText(empleadoSeleccionado.getApellido());
            txtFecha.setText(empleadoSeleccionado.getFechaNacimiento());
            txtSalario.setText(String.valueOf(empleadoSeleccionado.getSalario()));
            txtIdentificacion.setText(empleadoSeleccionado.getIdentificacion());
            boxEspecialidad.setSelectedItem(empleadoSeleccionado.getEspecialidad());
            boxDisponibilidad.setSelectedItem(empleadoSeleccionado.getDisponible());

            tablaEmpleados.setDefaultEditor(Object.class, null);

            txtCodigo.setEditable(false);
            btnEditar.setEnabled(true);
            btnEliminar.setEnabled(true);
            btnAgregar.setEnabled(false);
        }

    }//GEN-LAST:event_tablaEmpleadosMouseClicked

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        int btn = JOptionPane.showConfirmDialog(this,
                "¿Desea eliminar al empleado: " + txtNombre.getText() + "?",
                "Eliminar Empleado",
                JOptionPane.YES_NO_OPTION);

        if (btn == JOptionPane.YES_OPTION) {
            try {
                if (EmpleadoDAO.eliminar(empleadoSeleccionado)) {
                    JOptionPane.showMessageDialog(this, "Empleado eliminado correctamente. ");
                    limpiar();
                    actualizarTabla();
                    empleadoSeleccionado = null;
                } else {
                    JOptionPane.showMessageDialog(this, "Error al eliminar el empleado. ");
                }
            } catch (SQLException ex) {
                Logger.getLogger(Empleados.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        try {
            empleadoSeleccionado.setNombre(txtNombre.getText());
            empleadoSeleccionado.setFechaNacimiento(txtFecha.getText());
            empleadoSeleccionado.setIdentificacion(txtIdentificacion.getText());
            empleadoSeleccionado.setSalario(Double.parseDouble(txtSalario.getText()));
            empleadoSeleccionado.setEspecialidad(boxEspecialidad.getSelectedItem().toString());
            empleadoSeleccionado.setDisponible(boxDisponibilidad.getSelectedItem().toString());

            empleadoSeleccionado.verificarCampos();

            if (EmpleadoDAO.editar(empleadoSeleccionado)) {
                JOptionPane.showMessageDialog(this, "Empleado editado correctamente. ");
                limpiar();
                actualizarTabla();
                empleadoSeleccionado = null;
            } else {
                JOptionPane.showMessageDialog(this, "Error al editar el empleado. ");
            }

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Salario inválido. ");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void boxEspecialidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boxEspecialidadActionPerformed

    }//GEN-LAST:event_boxEspecialidadActionPerformed

    private final ArrayList<Empleado> listaEmpleados = new ArrayList<>();
    private Empleado empleadoSeleccionado;
    private final Principal principal;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> boxDisponibilidad;
    private javax.swing.JComboBox<String> boxEspecialidad;
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnSalir;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelApellido;
    private javax.swing.JLabel labelCodigo;
    private javax.swing.JLabel labelDispo;
    private javax.swing.JLabel labelEspecialidad;
    private javax.swing.JLabel labelFecha;
    private javax.swing.JLabel labelFecha1;
    private javax.swing.JLabel labelFecha3;
    private javax.swing.JLabel labelNombre;
    private javax.swing.JTable tablaEmpleados;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtFecha;
    private javax.swing.JTextField txtIdentificacion;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtSalario;
    // End of variables declaration//GEN-END:variables
}

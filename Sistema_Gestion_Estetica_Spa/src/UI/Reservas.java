package UI;

import DAO.ClienteDAO;
import DAO.EmpleadoDAO;
import DAO.ReservaDAO;
import IO.ClienteIO;
import IO.ClienteNotificacionIO;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoField;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import Model.Cliente;
import Model.Empleado;
import Model.Reserva;

public class Reservas extends JFrame {

    public Reservas(Principal principal) throws SQLException {
        initComponents();
        btnValidarFecha.setVisible(false);
        boxClientes.setModel(new DefaultComboBoxModel<Cliente>());
        boxEmpleados.setModel(new DefaultComboBoxModel<Empleado>());
        actualizarTabla();
        cargarCombos();
        setLocationRelativeTo(null);
        this.principal = principal;
    }

    private void limpiar() {
        if (boxClientes.getItemCount() > 0) {
            boxClientes.setSelectedIndex(0);
        }
        if (boxEmpleados.getItemCount() > 0) {
            boxEmpleados.setSelectedIndex(0);
        }
        txtFecha.setText("");
        txtHora.setText("");

        btnAgregar.setEnabled(true);
        btnEditar.setEnabled(false);
        btnEliminar.setEnabled(false);

        reservaSeleccionada = null;

        btnValidarFecha.setVisible(false);
    }

    private void cargarCombos() throws SQLException {
        boxEmpleados.removeAllItems();
        boxClientes.removeAllItems();
        mapaEmpleados.clear();
        mapaClientes.clear();

        listaEmpleados.clear();
        if (EmpleadoDAO.consultar(listaEmpleados)) {
            for (Empleado e : listaEmpleados) {
                String etiqueta = e.getCodigoEmpleado() + " - " + e.nombre_completo();
                boxEmpleados.addItem(etiqueta);
                mapaEmpleados.put(etiqueta, e);
            }
        }

        listaClientes.clear();
        if (ClienteDAO.consultar(listaClientes)) {
            for (Cliente c : listaClientes) {
                String etiqueta = c.getCodigoCliente() + " - " + c.nombreCompleto();
                boxClientes.addItem(etiqueta);
                mapaClientes.put(etiqueta, c);
            }
        }
    }

    private boolean validarFecha(String fecha) {
        try {
            DateTimeFormatter formatter = new DateTimeFormatterBuilder()
                    .appendValue(ChronoField.DAY_OF_MONTH)
                    .appendLiteral('/')
                    .appendValue(ChronoField.MONTH_OF_YEAR)
                    .appendLiteral('/')
                    .appendValue(ChronoField.YEAR)
                    .toFormatter();

            LocalDate fechaIngresada = LocalDate.parse(fecha, formatter);
            LocalDate hoy = LocalDate.now();

            if (!fechaIngresada.isAfter(hoy)) {
                JOptionPane.showMessageDialog(this, "La fecha debe ser futura. ");
                return false;
            }
            return true;
        } catch (DateTimeParseException e) {
            JOptionPane.showMessageDialog(this, "El formato de la fecha es inválido. Usa dd/MM/yyyy, por ejemplo 08/04/2025. ");
            return false;
        }
    }

    private void actualizarTabla() throws SQLException {
        listaReservas.clear();

        DefaultTableModel modelTable = new DefaultTableModel();

        modelTable.addColumn("Código");
        modelTable.addColumn("Empleado");
        modelTable.addColumn("Cliente");
        modelTable.addColumn("Fecha");
        modelTable.addColumn("Hora");

        ArrayList<Reserva> reservasTemp = new ArrayList<>();

        if (ReservaDAO.consultar(reservasTemp)) {
            for (Reserva r : reservasTemp) {
                listaReservas.add(r);

                Object[] fila = new Object[]{
                    r.getCodigoReserva(),
                    r.getEmpleado().nombre_completo(),
                    r.getCliente().nombreCompleto(),
                    r.getFecha(),
                    r.getHora()
                };
                modelTable.addRow(fila);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Error al cargar las reservas. ", "Error", JOptionPane.ERROR_MESSAGE);
        }

        tablaReservas.setModel(modelTable);
    }

    public void volverPrincipal() {
        this.principal.setVisible(true);
        dispose();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        labelCodigoPaciente = new javax.swing.JLabel();
        labelFecha = new javax.swing.JLabel();
        btnSalir = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnAgregar = new javax.swing.JButton();
        txtFecha = new javax.swing.JTextField();
        labelHora = new javax.swing.JLabel();
        txtHora = new javax.swing.JTextField();
        labelCodigoMedico = new javax.swing.JLabel();
        boxClientes = new javax.swing.JComboBox();
        boxEmpleados = new javax.swing.JComboBox();
        btnReporte = new javax.swing.JButton();
        btnValidarFecha = new javax.swing.JButton();
        btnHistorialReservas = new javax.swing.JButton();
        btnRecordatorio = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaReservas = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(102, 204, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 51, 153), 3, true), "Gestion de Citas", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 18), new java.awt.Color(0, 51, 153))); // NOI18N
        jPanel1.setToolTipText("");

        labelCodigoPaciente.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        labelCodigoPaciente.setText("Codigo del Cliente:");

        labelFecha.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        labelFecha.setText("Fecha:");

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

        txtFecha.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtFechaKeyReleased(evt);
            }
        });

        labelHora.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        labelHora.setText("Hora:");

        txtHora.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtHoraKeyReleased(evt);
            }
        });

        labelCodigoMedico.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        labelCodigoMedico.setText("Codigo del Empleado:");

        boxClientes.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        boxEmpleados.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnReporte.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnReporte.setForeground(new java.awt.Color(0, 51, 153));
        btnReporte.setText("Generar Reporte");
        btnReporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReporteActionPerformed(evt);
            }
        });

        btnValidarFecha.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnValidarFecha.setForeground(new java.awt.Color(0, 51, 153));
        btnValidarFecha.setText("Validar Disponibilidad");
        btnValidarFecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnValidarFechaActionPerformed(evt);
            }
        });

        btnHistorialReservas.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnHistorialReservas.setForeground(new java.awt.Color(0, 51, 153));
        btnHistorialReservas.setText("Historial de Reservas");
        btnHistorialReservas.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 51, 153), 2, true));
        btnHistorialReservas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHistorialReservasActionPerformed(evt);
            }
        });

        btnRecordatorio.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnRecordatorio.setForeground(new java.awt.Color(0, 51, 153));
        btnRecordatorio.setText("Enviar Recordatorio");
        btnRecordatorio.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 51, 153), 2, true));
        btnRecordatorio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRecordatorioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelFecha)
                            .addComponent(labelCodigoPaciente)
                            .addComponent(labelHora)
                            .addComponent(labelCodigoMedico))
                        .addGap(35, 35, 35)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtHora, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(boxClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(boxEmpleados, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnReporte)
                        .addGap(152, 152, 152)
                        .addComponent(btnValidarFecha)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 85, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(109, 109, 109)
                        .addComponent(btnSalir))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnRecordatorio, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
                            .addComponent(btnHistorialReservas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnRecordatorio, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(11, 11, 11)
                        .addComponent(btnLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(35, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelCodigoPaciente)
                            .addComponent(boxClientes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(boxEmpleados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelCodigoMedico))
                        .addGap(30, 30, 30)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelFecha)
                            .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelHora)
                            .addComponent(txtHora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnReporte)
                            .addComponent(btnValidarFecha))
                        .addGap(15, 15, 15))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(btnSalir)
                .addGap(26, 26, 26)
                .addComponent(btnHistorialReservas, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        tablaReservas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5"
            }
        ));
        tablaReservas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaReservasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaReservas);

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
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 395, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel1.getAccessibleContext().setAccessibleName("Gestion de Reservas");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        volverPrincipal();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        try {
            String fecha = txtFecha.getText().trim();
            String hora = txtHora.getText().trim();

            String keyEmpleado = (String) boxEmpleados.getSelectedItem();
            String keyCliente = (String) boxClientes.getSelectedItem();

            boolean fechaValida = validarFecha(fecha);
            if (!fechaValida) {
                return;
            }

            Empleado empleado = mapaEmpleados.get(keyEmpleado);
            Cliente cliente = mapaClientes.get(keyCliente);

            if (empleado == null || cliente == null) {
                JOptionPane.showMessageDialog(this, "Empleado o cliente inválido. ");
                return;
            }

            Reserva reserva = new Reserva(0, empleado, cliente, fecha, hora);

            reserva.verificarCampos();

            if (ReservaDAO.agregar(reserva)) {
                JOptionPane.showMessageDialog(this, "Reserva agregada correctamente. ");
                limpiar();
                actualizarTabla();
            } else {
                JOptionPane.showMessageDialog(this, "No se pudo agregar la reserva. ");
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error al agregar reserva: " + ex.getMessage());
        }
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void tablaReservasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaReservasMouseClicked
        int fila = tablaReservas.getSelectedRow();
        btnValidarFecha.setVisible(true);

        if (fila >= 0) {
            reservaSeleccionada = listaReservas.get(fila);

            txtFecha.setText(reservaSeleccionada.getFecha());
            txtHora.setText(reservaSeleccionada.getHora());

            String empleadoNombre = reservaSeleccionada.getEmpleado().getCodigoEmpleado() + " - " + reservaSeleccionada.getEmpleado().getNombre();
            for (int i = 0; i < boxEmpleados.getItemCount(); i++) {
                if (((String) boxEmpleados.getItemAt(i)).startsWith(empleadoNombre)) {
                    boxEmpleados.setSelectedIndex(i);
                    break;
                }
            }

            String clienteNombre = reservaSeleccionada.getCliente().getCodigoCliente() + " - " + reservaSeleccionada.getCliente().getNombre();
            for (int i = 0; i < boxClientes.getItemCount(); i++) {
                if (((String) boxClientes.getItemAt(i)).startsWith(clienteNombre)) {
                    boxClientes.setSelectedIndex(i);
                    break;
                }
            }

            tablaReservas.setDefaultEditor(Object.class, null);

            btnEditar.setEnabled(true);
            btnEliminar.setEnabled(true);
            btnAgregar.setEnabled(false);
        }
    }//GEN-LAST:event_tablaReservasMouseClicked

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        try {
            if (reservaSeleccionada == null) {
                JOptionPane.showMessageDialog(this, "Debe seleccionar una reserva para editar. ");
                return;
            }

            String nuevaFecha = txtFecha.getText().trim();
            String nuevaHora = txtHora.getText().trim();
            String keyEmpleado = (String) boxEmpleados.getSelectedItem();
            String keyCliente = (String) boxClientes.getSelectedItem();

            boolean fechaValida = validarFecha(nuevaFecha);
            if (!fechaValida) {
                return;
            }

            Empleado nuevoEmpleado = mapaEmpleados.get(keyEmpleado);
            Cliente nuevoCliente = mapaClientes.get(keyCliente);

            if (nuevoEmpleado == null || nuevoEmpleado == null) {
                JOptionPane.showMessageDialog(this, "Empleado o cliente inválido. ");
                return;
            }

            reservaSeleccionada.setEmpleado(nuevoEmpleado);
            reservaSeleccionada.setCliente(nuevoCliente);
            reservaSeleccionada.setFecha(nuevaFecha);
            reservaSeleccionada.setHora(nuevaHora);

            reservaSeleccionada.verificarCampos();

            if (ReservaDAO.editar(reservaSeleccionada)) {
                JOptionPane.showMessageDialog(this, "Reserva actualizada correctamente. ");
                limpiar();
                actualizarTabla();
                reservaSeleccionada = null;
            } else {
                JOptionPane.showMessageDialog(this, "No se pudo actualizar la reserva. ");
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error al editar reserva: " + ex.getMessage());
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        int confirm = JOptionPane.showConfirmDialog(this,
                "¿Desea eliminar la reserva del cliente: " + reservaSeleccionada.getCliente().getNombre() + "?",
                "Confirmar eliminación",
                JOptionPane.YES_NO_OPTION);

        if (confirm == JOptionPane.YES_OPTION) {
            try {
                if (ReservaDAO.eliminar(reservaSeleccionada)) {
                    JOptionPane.showMessageDialog(this, "Reserva eliminada correctamente. ");
                    limpiar();
                    actualizarTabla();
                    reservaSeleccionada = null;
                } else {
                    JOptionPane.showMessageDialog(this, "No se pudo eliminar la reserva. ");
                }
            } catch (SQLException ex) {
                Logger.getLogger(Reservas.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        limpiar();
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void btnReporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReporteActionPerformed
        Reportes reportesFrame = new Reportes(this, listaReservas);
        reportesFrame.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnReporteActionPerformed

    private void btnValidarFechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnValidarFechaActionPerformed
        String keyEmpleado = (String) boxEmpleados.getSelectedItem();
        String fecha = txtFecha.getText();
        String hora = txtHora.getText();
        Empleado empleado = mapaEmpleados.get(keyEmpleado);
        int codigoEmpleado = empleado.getCodigoEmpleado();

        boolean fechaValida = validarFecha(fecha);
        if (!fechaValida) {
            return;
        }
        try {
            DateTimeFormatter horaFormatter = DateTimeFormatter.ofPattern("HH:mm");
            LocalTime.parse(hora, horaFormatter);
        } catch (DateTimeParseException e) {
            JOptionPane.showMessageDialog(this, "El formato de la hora es inválido. Usa HH:mm en formato 24 horas, por ejemplo 14:30. ");
            return;
        }

        String resultado = ClienteIO.verificar(fecha, hora, codigoEmpleado);
        JOptionPane.showMessageDialog(this, "Resultado: " + resultado);
    }//GEN-LAST:event_btnValidarFechaActionPerformed

    private void txtFechaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFechaKeyReleased
        if (!txtFecha.getText().trim().isEmpty() && !txtHora.getText().trim().isEmpty()) {
            btnValidarFecha.setVisible(true);
        } else {
            btnValidarFecha.setVisible(false);
        }
    }//GEN-LAST:event_txtFechaKeyReleased

    private void txtHoraKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtHoraKeyReleased
        if (!txtFecha.getText().trim().isEmpty() && !txtHora.getText().trim().isEmpty()) {
            btnValidarFecha.setVisible(true);
        } else {
            btnValidarFecha.setVisible(false);
        }
    }//GEN-LAST:event_txtHoraKeyReleased

    private void btnHistorialReservasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHistorialReservasActionPerformed
        try {
            HistorialReservas historial;
            historial = new HistorialReservas(this);
            historial.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosed(WindowEvent e) {
                    try {
                        actualizarTabla();
                    } catch (SQLException ex) {
                        System.out.println("ERROR AL ACTUALIZAR TABLA: " + ex.getMessage());
                    }
                }
            });
            historial.setVisible(true);
            setVisible(false);
        } catch (SQLException ex) {
            System.out.println("ERROR AL BUSCAR HISTORIAL RESERVAS: " + ex.getMessage());
        }

    }//GEN-LAST:event_btnHistorialReservasActionPerformed

    private void btnRecordatorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRecordatorioActionPerformed
        if (reservaSeleccionada == null) {
            JOptionPane.showMessageDialog(null,
                    "Debe seleccionar una reserva",
                    "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        ClienteNotificacionIO.enviar(reservaSeleccionada.getCliente().getNombre(), reservaSeleccionada.getFecha(), reservaSeleccionada.getHora());
    }//GEN-LAST:event_btnRecordatorioActionPerformed

    private final Principal principal;
    private Reserva reservaSeleccionada;
    private final ArrayList<Reserva> listaReservas = new ArrayList<>();
    private final ArrayList<Empleado> listaEmpleados = new ArrayList<>();
    private final ArrayList<Cliente> listaClientes = new ArrayList<>();
    private final Map<String, Empleado> mapaEmpleados = new HashMap<>();
    private final Map<String, Cliente> mapaClientes = new HashMap<>();

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox boxClientes;
    private javax.swing.JComboBox boxEmpleados;
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnHistorialReservas;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnRecordatorio;
    private javax.swing.JButton btnReporte;
    private javax.swing.JButton btnSalir;
    private javax.swing.JButton btnValidarFecha;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelCodigoMedico;
    private javax.swing.JLabel labelCodigoPaciente;
    private javax.swing.JLabel labelFecha;
    private javax.swing.JLabel labelHora;
    private javax.swing.JTable tablaReservas;
    private javax.swing.JTextField txtFecha;
    private javax.swing.JTextField txtHora;
    // End of variables declaration//GEN-END:variables
}

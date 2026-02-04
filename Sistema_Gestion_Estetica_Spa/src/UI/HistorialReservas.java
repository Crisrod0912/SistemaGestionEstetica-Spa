package UI;

import DAO.ClienteDAO;
import DAO.ReservaDAO;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import Model.Empleado;
import Model.Cliente;
import Model.Reserva;

public class HistorialReservas extends JFrame {

    public HistorialReservas(Reservas reservas) throws SQLException {
        initComponents();
        boxClientes.setModel(new DefaultComboBoxModel<Cliente>());
        cargarCombos();
        setLocationRelativeTo(null);
        this.reservas = reservas;
    }

    private void limpiar() {
        if (boxClientes.getItemCount() > 0) {
            boxClientes.setSelectedIndex(0);
        }
        DefaultTableModel modelTable = new DefaultTableModel();

        modelTable.addColumn("Código");
        modelTable.addColumn("Empleado");
        modelTable.addColumn("Cliente");
        modelTable.addColumn("Fecha");
        modelTable.addColumn("Hora");

        tablaReservas.setModel(modelTable);
        listaReservas.clear();
    }

    private void cargarCombos() throws SQLException {
        boxClientes.removeAllItems();
        mapaEmpleados.clear();
        mapaClientes.clear();

        listaClientes.clear();
        if (ClienteDAO.consultar(listaClientes)) {
            for (Cliente c : listaClientes) {
                String etiqueta = c.getCodigoCliente() + " - " + c.nombreCompleto();
                boxClientes.addItem(etiqueta);
                mapaClientes.put(etiqueta, c);
            }
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

        String keyCliente = (String) boxClientes.getSelectedItem();

        if (ReservaDAO.consultarHistorial(reservasTemp, keyCliente)) {
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
        this.reservas.setVisible(true);
        dispose();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        labelCodigoCliente = new javax.swing.JLabel();
        btnSalir = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        btnAgregar = new javax.swing.JButton();
        boxClientes = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaReservas = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(102, 204, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 51, 153), 3, true), "Historial de Citas", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 18), new java.awt.Color(0, 51, 153))); // NOI18N
        jPanel1.setToolTipText("");

        labelCodigoCliente.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        labelCodigoCliente.setText("Codigo del Cliente:");

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

        btnAgregar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnAgregar.setForeground(new java.awt.Color(0, 51, 153));
        btnAgregar.setText("Buscar");
        btnAgregar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 51, 153), 2, true));
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        boxClientes.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(labelCodigoCliente)
                .addGap(35, 35, 35)
                .addComponent(boxClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 85, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(109, 109, 109)
                .addComponent(btnSalir)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(btnLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(labelCodigoCliente)
                        .addComponent(boxClientes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(18, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(btnSalir)
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
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 525, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel1.getAccessibleContext().setAccessibleName("Historial de Reservas");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        limpiar();
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        volverPrincipal();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        try {
            actualizarTabla();
        } catch (SQLException ex) {
            System.out.println("ERROR: " + ex.getMessage());
        }
    }//GEN-LAST:event_btnAgregarActionPerformed

    private final Reservas reservas;
    private final ArrayList<Reserva> listaReservas = new ArrayList<>();
    private final ArrayList<Cliente> listaClientes = new ArrayList<>();
    private final Map<String, Empleado> mapaEmpleados = new HashMap<>();
    private final Map<String, Cliente> mapaClientes = new HashMap<>();

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox boxClientes;
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelCodigoCliente;
    private javax.swing.JTable tablaReservas;
    // End of variables declaration//GEN-END:variables
}
